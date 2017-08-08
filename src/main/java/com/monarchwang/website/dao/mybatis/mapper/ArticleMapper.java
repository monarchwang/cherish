package com.monarchwang.website.dao.mybatis.mapper;

import com.monarchwang.website.dao.mybatis.model.Article;
import com.monarchwang.website.utils.system.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper extends MyMapper<Article> {
    List<Article> findByPage(@Param("status") Integer status);

    void increaseViewNumber(@Param("id") Integer id);

    void softDelete(@Param("id") int id);

	void release(@Param("id") int id);
}