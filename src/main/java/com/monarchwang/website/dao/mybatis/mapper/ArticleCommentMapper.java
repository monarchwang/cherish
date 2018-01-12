package com.monarchwang.website.dao.mybatis.mapper;

import com.monarchwang.website.dao.mybatis.model.ArticleComment;
import com.monarchwang.website.utils.system.MyMapper;

import java.util.List;

public interface ArticleCommentMapper extends MyMapper<ArticleComment> {

    List<ArticleComment> findCommentsByArticleId(Integer articleId);

}