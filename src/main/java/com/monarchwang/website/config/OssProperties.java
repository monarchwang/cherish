package com.monarchwang.website.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by libin on 2017/1/22.
 */
@Data
@Component
public class OssProperties {
	@Value("${aliyun.oss.Endpoint}")
	private String endpoint;
	@Value("${aliyun.oss.AccessId}")
	private String accessId;
	@Value("${aliyun.oss.AccessKey}")
	private String accessKey;
	@Value("${aliyun.oss.Bucket}")
	private String bucket;
	@Value("${aliyun.oss.FileUrl}")
	private String fileUrl;
}
