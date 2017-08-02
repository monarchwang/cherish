package com.monarchwang.website.service;

import com.monarchwang.website.dao.model.Article;
import com.monarchwang.website.rest.dto.ArticleDto;
import com.monarchwang.website.utils.Page;

/**
 * Created by wanggl on 2017/8/2.
 */
public interface ArticleService {

	int saveOrUpdate(ArticleDto articleDto);


	Page<Article> findByPage(int pageNum, int pageSize);

	ArticleDto findArticleById(int id);

	void deleteArticleById(int id);
}
