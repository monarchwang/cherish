package com.monarchwang.website.utils.aliyun;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.monarchwang.website.config.OssProperties;
import com.monarchwang.website.utils.http.HttpHandler;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Calendar;

/**
 * 阿里云 OSS文件类
 *
 */
@Component
public class OSSClientUtil {

	@Autowired
	private OssProperties ossProperties;

	private static volatile OSSClient ossClient = null;
	private static volatile OSSClient uploadOSSClient = null;

	private static final Logger LOG = LoggerFactory.getLogger(HttpHandler.class);

	public OSSClientUtil() {
	}

	private OSSClient getOSSClient() {
		String ossEndpoint = ossProperties.getEndpoint();
		String ossAccessId = ossProperties.getAccessId();
		String ossAccessKey = ossProperties.getAccessKey();

		if (ossClient == null) {
			synchronized (this) {
				if (ossClient == null) {
					ossClient = new OSSClient(ossEndpoint, ossAccessId, ossAccessKey);
					LOG.info("初始化OSSClient");
				}
			}
		}

		return ossClient;
	}

	private OSSClient getUploadOSSClient() {
		String ossEndpoint = ossProperties.getEndpoint();
		String ossAccessId = ossProperties.getAccessId();
		String ossAccessKey = ossProperties.getAccessKey();

		ClientConfiguration config = new ClientConfiguration();
		config.setConnectionTimeout(300000);
		config.setSocketTimeout(300000);

		if (uploadOSSClient == null) {
			synchronized (this) {
				if (uploadOSSClient == null) {
					uploadOSSClient = new OSSClient(ossEndpoint, ossAccessId, ossAccessKey, config);
					LOG.info("初始化UploadOSSClient");
				}
			}
		}

		return uploadOSSClient;
	}

	/**
	 * 上传到OSS服务器 如果同名文件会覆盖服务器上的
	 *
	 * @param instream 文件流
	 * @param key      文件名称 包括后缀名
	 * @return 出错返回"" ,唯一MD5数字签名
	 */
	public String uploadFile2OSS(InputStream instream, String key, String contentType) {
		OSSClient ossClient;

		String ret = StringUtils.EMPTY;
		try {
			String bucketName = ossProperties.getBucket();
			ossClient = getUploadOSSClient();

			// 创建上传Object的Metadata
			ObjectMetadata objectMetadata = new ObjectMetadata();
			objectMetadata.setContentLength(instream.available());
			objectMetadata.setContentType(contentType);
			// 上传文件
			PutObjectResult putResult =
					ossClient.putObject(bucketName, key, instream, objectMetadata);
			ret = putResult.getETag();
		} catch (IOException e) {
			LOG.error("uploadFile2OSS ERROR", e);
		} finally {
			try {
				if (null != instream) {
					instream.close();
				}
			} catch (IOException e) {
				LOG.warn("instream.close() failed.", e);
			}

//			if (null != ossClient) {
//				ossClient.shutdown();
//			}
		}
		return ret;
	}

	/**
	 * 根据key来返回流输出
	 *
	 * @param key
	 * @return
	 * @author liang
	 */
	public OSSObject get(String key) {
		if (StringUtils.isBlank(key)) {
			LOG.warn("key is empty.");
			return null;
		}

		String bucketName = ossProperties.getBucket();

		OSSClient ossClient;
		OSSObject ossObject = null;
		try {
			ossClient = getOSSClient();
			ossObject = ossClient.getObject(bucketName, key);
		} catch (Exception e) {
			LOG.warn("GET OSS OBJECT ERROR", e);
		} finally {
//			if (null != ossClient) {
//				ossClient.shutdown();//关闭后外层方法对流的读取会中断
//			}
		}

		return ossObject;
	}

	/**
	 * Description: 判断OSS服务文件上传时文件的contentType
	 *
	 * @param FilenameExtension 文件后缀
	 * @return String
	 */
	public static String getcontentType(String FilenameExtension) {
		if (FilenameExtension.equalsIgnoreCase("bmp")) {
			return "image/bmp";
		}
		if (FilenameExtension.equalsIgnoreCase("gif")) {
			return "image/gif";
		}
		if (FilenameExtension.equalsIgnoreCase("jpeg") || FilenameExtension.equalsIgnoreCase("jpg")
				|| FilenameExtension.equalsIgnoreCase("png")) {
			return "image/jpeg";
		}
		if (FilenameExtension.equalsIgnoreCase("html")) {
			return "text/html";
		}
		if (FilenameExtension.equalsIgnoreCase("txt")) {
			return "text/plain";
		}
		if (FilenameExtension.equalsIgnoreCase("vsd")) {
			return "application/vnd.visio";
		}
		if (FilenameExtension.equalsIgnoreCase("pptx")
				|| FilenameExtension.equalsIgnoreCase("ppt")) {
			return "application/vnd.ms-powerpoint";
		}
		if (FilenameExtension.equalsIgnoreCase("docx")
				|| FilenameExtension.equalsIgnoreCase("doc")) {
			return "application/msword";
		}
		if (FilenameExtension.equalsIgnoreCase("xml")) {
			return "text/xml";
		}
		return "image/jpeg";
	}

	/**
	 * 根据Key来获取url，返回给客户端
	 *
	 * @param key
	 * @param minutesAfterNow
	 * @return
	 * @author liang
	 */
	public String getUrl(String key, int minutesAfterNow) {
		OSSClient ossClient;

		String urlStr = StringUtils.EMPTY;
		try {
			String bucketName = ossProperties.getBucket();
			ossClient = getOSSClient();

			Calendar cal = Calendar.getInstance();
			cal.add(12, (int) minutesAfterNow);
			URL url = ossClient.generatePresignedUrl(bucketName, key, cal.getTime());

			if (null != url) {
				urlStr = url.toString().replace("-internal", "");
			}
		} catch (Exception e) {
			LOG.warn("GET OSS URL ERROR", e);
		} finally {
//			if (null != ossClient) {
//				ossClient.shutdown();
//			}
		}

		return urlStr;
	}
}
