package com.monarchwang.website.dao.mapper;

import com.monarchwang.website.dao.model.ArticleTagRelation;
import com.monarchwang.website.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleTagRelationMapper extends MyMapper<ArticleTagRelation> {

    List<ArticleTagRelation> queryByTagId(@Param("tagId") int tagId);

    void deleteByArticleId(@Param("articleId") int articleId);
}