package com.monarchwang.website.dao.mybatis.mapper;

import com.monarchwang.website.dao.mybatis.model.ArticleComment;
import com.monarchwang.website.utils.system.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleCommentMapper extends MyMapper<ArticleComment> {

    List<ArticleComment> findCommentsByArticleId(@Param("articleId") Integer articleId);

    Integer getMaxFloorByArticleId(@Param("articleId") Integer articleId);
}