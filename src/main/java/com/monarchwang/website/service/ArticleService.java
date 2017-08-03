package com.monarchwang.website.service;

import com.monarchwang.website.dao.mybatis.model.Article;
import com.monarchwang.website.rest.dto.ArticleDto;
import com.monarchwang.website.utils.Page;
import com.monarchwang.website.utils.response.ListResult;

import java.util.List;

/**
 * Created by wanggl on 2017/8/2.
 */
public interface ArticleService {

	int saveOrUpdate(ArticleDto articleDto);


	ListResult<ArticleDto> findByPage(Integer pageNum, Integer pageSize,Integer status);

	ArticleDto findArticleById(int id);

	void deleteArticleById(int id);
}
