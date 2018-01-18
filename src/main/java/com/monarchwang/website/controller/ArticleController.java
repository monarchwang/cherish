package com.monarchwang.website.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.monarchwang.website.common.CherishException;
import com.monarchwang.website.config.OssProperties;
import com.monarchwang.website.controller.dto.ArticleCommentDto;
import com.monarchwang.website.controller.dto.ArticleDto;
import com.monarchwang.website.controller.dto.ArticleSummaryDto;
import com.monarchwang.website.dao.mybatis.model.ArticleComment;
import com.monarchwang.website.service.ArticleService;
import com.monarchwang.website.utils.system.ExceptionEnum;
import com.monarchwang.website.utils.aliyun.OSSClientUtil;
import com.monarchwang.website.utils.response.ListResult;
import com.monarchwang.website.utils.response.ResponseData;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
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
@CrossOrigin
public class ArticleController {

    @Resource
    private ArticleService articleService;
    @Resource
    private OSSClientUtil ossClientUtil;
    @Resource
    private OssProperties ossProperties;

    private SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy/MM/dd/");

    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH_mm_ss_");


    @GetMapping("query")
    public ResponseData<ListResult<ArticleDto>> queryDataList(Integer pageNum, Integer pageSize, String tagName) {
        ResponseData<ListResult<ArticleDto>> responseData = new ResponseData<>();

        ListResult<ArticleDto> articleDtos = articleService.findByPage(pageNum, pageSize, null, tagName);
        responseData.setData(articleDtos);

        return responseData;
    }


    @GetMapping("release")
    public ResponseData<String> release(int articleId) {
        ResponseData<String> responseData = new ResponseData<>();

        articleService.release(articleId);

        return responseData;
    }


    @GetMapping("detail")
    public ResponseData<ArticleDto> queryArticleDetail(int articleId) {
        ResponseData<ArticleDto> responseData = new ResponseData<>();

        ArticleDto articleDto = articleService.findArticleById(articleId);
        responseData.setData(articleDto);

        return responseData;
    }


    @GetMapping("delete")
    public ResponseData<String> deleteArticle(int articleId) {
        articleService.deleteArticleById(articleId);
        return new ResponseData<>();
    }


    /**
     * 新增或修改文章
     *
     * @param articleDto
     * @return
     */
    @PostMapping(value = "saveOrUpdate", produces = {"application/json"})
    public ResponseData<Integer> saveOrUpdate(@RequestBody ArticleDto articleDto) {
        //返回文章id
        ResponseData<Integer> responseData = new ResponseData<>();

        int articleId = articleService.saveOrUpdate(articleDto);
        responseData.setData(articleId);

        return responseData;
    }


    /**
     * 新增评论
     *
     * @param articleCommentDto
     * @return
     */
    @PostMapping(value = "saveComment")
    public ResponseData<Integer> saveComment(@RequestBody ArticleCommentDto articleCommentDto) {

        ResponseData<Integer> responseData = new ResponseData<>();
        ArticleComment comment = new ArticleComment();
        BeanUtils.copyProperties(articleCommentDto, comment);
        responseData.setData(articleService.saveComment(comment));

        return responseData;
    }

    /**
     * 获取评论
     *
     * @param blogId
     * @return
     */
    @GetMapping(value = "getComments")
    public ResponseData<List<ArticleCommentDto>> getComments(Integer blogId) {

        ResponseData<List<ArticleCommentDto>> responseData = new ResponseData<>();
        responseData.setData(articleService.findCommentsByArticleId(blogId));

        return responseData;
    }


    /**
     * 文章点赞
     *
     * @param blogId
     * @param num
     * @return
     */
    @GetMapping(value = "praise")
    public ResponseData<Integer> praise(Integer blogId, Integer num) {
        ResponseData<Integer> responseData = new ResponseData<>();
        responseData.setData(articleService.praise(blogId, num));
        return responseData;
    }

    @GetMapping(value = "getSummary")
    public ResponseData<ArticleSummaryDto> findArticleSummary() {
        ResponseData<ArticleSummaryDto> responseData = new ResponseData<>();

        responseData.setData(articleService.findArticleSummary());

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

        String version = request.getParameter("version");
        JSONObject jsonObject = new JSONObject();
        JSONArray urlArray = new JSONArray();
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
                urlArray.add(fileurl);
            }
        }
        jsonObject.put("errno", 0);
        jsonObject.put("data", urlArray);
        if (StringUtils.isEmpty(version)) {
            response.getWriter().write(fileurl);
        } else if ("V3".equals(version)) {
            response.getWriter().write(jsonObject.toJSONString());
        }
    }

}
