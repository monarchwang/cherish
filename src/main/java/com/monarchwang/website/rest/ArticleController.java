package com.monarchwang.website.rest;

import com.monarchwang.website.rest.dto.ArticleDto;
import com.monarchwang.website.service.ArticleService;
import com.monarchwang.website.utils.response.ResponseData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by liang on 2017/8/2.
 */
@RestController
@RequestMapping("/blog/")
public class ArticleController {

    @Resource
    private ArticleService articleService;


    @PostMapping("saveOrUpdate")
    public ResponseData<Integer> saveOrUpdate(ArticleDto articleDto) {

        ResponseData<Integer> responseData = new ResponseData<>();

        int articleId = articleService.saveOrUpdate(articleDto);
        responseData.setData(articleId);

        return responseData;
    }


}
