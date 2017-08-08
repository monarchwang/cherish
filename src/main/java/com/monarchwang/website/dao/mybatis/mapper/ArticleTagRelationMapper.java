package com.monarchwang.website.dao.mybatis.mapper;

import com.monarchwang.website.dao.mybatis.model.ArticleTagRelation;
import com.monarchwang.website.utils.system.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleTagRelationMapper extends MyMapper<ArticleTagRelation> {

    List<ArticleTagRelation> queryByTagId(@Param("tagId") int tagId);

    void deleteByArticleId(@Param("articleId") int articleId);
}