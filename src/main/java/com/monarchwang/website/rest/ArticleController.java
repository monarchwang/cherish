package com.monarchwang.website.rest;

import com.monarchwang.website.common.CherishException;
import com.monarchwang.website.config.OssProperties;
import com.monarchwang.website.rest.dto.ArticleDto;
import com.monarchwang.website.service.ArticleService;
import com.monarchwang.website.utils.ExceptionEnum;
import com.monarchwang.website.utils.aliyun.OSSClientUtil;
import com.monarchwang.website.utils.response.ListResult;
import com.monarchwang.website.utils.response.ResponseData;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by liang on 2017/8/2.
 */
@RestController
@RequestMapping("/blog/")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private OSSClientUtil ossClientUtil;
	@Autowired
	private OssProperties ossProperties;

	private SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy/MM/dd/");

	private SimpleDateFormat timeFormat = new SimpleDateFormat("HH_mm_ss_");


	@GetMapping("query")
	public ResponseData<ListResult<ArticleDto>> queryDataList(Integer pageNum, Integer pageSize) {
		ResponseData<ListResult<ArticleDto>> responseData = new ResponseData<>();


		return responseData;
	}


	/**
	 * 新增或修改文章
	 *
	 * @param articleDto
	 * @return
	 */
	@PostMapping(value = "saveOrUpdate", produces = {"application/json"})
	public ResponseData<Integer> saveOrUpdate(ArticleDto articleDto) {
		//返回文章id
		ResponseData<Integer> responseData = new ResponseData<>();

		int articleId = articleService.saveOrUpdate(articleDto);
		responseData.setData(articleId);

		return responseData;
	}


	/**
	 * 上传图片
	 *
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@PostMapping("upload")
	public void upload(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException {
		String fileurl = "error|服务器端错误";
		List<MultipartFile> imgFileList = request.getFiles("file");
		if (CollectionUtils.isNotEmpty(imgFileList)) {
			for (MultipartFile multipartFile : imgFileList) {
				String fileName = "myblog/" + dayFormat.format(new Date()) + timeFormat.format(new Date()) + multipartFile.getOriginalFilename();
				String result = ossClientUtil.uploadFile2OSS(multipartFile.getInputStream(), fileName, multipartFile.getContentType());
				if (StringUtils.isEmpty(result)) {
					throw new CherishException(ExceptionEnum.UPLOAD_FILE_FAILED);
				}
				fileurl = ossProperties.getFileUrl() + "/" + fileName;
				response.getWriter().write(fileurl);
			}
		}
	}

}
