package com.monarchwang.website.service;

import com.monarchwang.website.controller.dto.ArticleCommentDto;
import com.monarchwang.website.controller.dto.ArticleDto;
import com.monarchwang.website.dao.mybatis.model.ArticleComment;
import com.monarchwang.website.utils.response.ListResult;

import java.util.List;

/**
 * Created by wanggl on 2017/8/2.
 */
public interface ArticleService {

    int saveOrUpdate(ArticleDto articleDto);


    ListResult<ArticleDto> findByPage(Integer pageNum, Integer pageSize, Integer status);

    ArticleDto findArticleById(int id);

    void deleteArticleById(int id);

    void release(int articleId);

    void agreeArticle(int articleId);

    Integer saveComment(ArticleComment comment);

    List<ArticleCommentDto> findCommentsByArticleId(Integer articleId);
}
