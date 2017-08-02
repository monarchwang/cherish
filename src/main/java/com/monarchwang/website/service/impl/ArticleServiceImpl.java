package com.monarchwang.website.service.impl;

import com.monarchwang.website.dao.mapper.ArticleMapper;
import com.monarchwang.website.dao.model.Article;
import com.monarchwang.website.dao.mongo.ArticleDetailMongoDao;
import com.monarchwang.website.dao.mongo.model.ArticleDetail;
import com.monarchwang.website.rest.dto.ArticleDto;
import com.monarchwang.website.service.ArticleService;
import com.monarchwang.website.utils.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 文章Service
 * Created by wanggl on 2017/8/2.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleMapper articleMapper;

	@Autowired
	private ArticleDetailMongoDao articleDetailMongoDao;


	@Override
	@Transactional
	public int save(ArticleDto articleDto) {
		Article article = new Article();
		BeanUtils.copyProperties(articleDto, article);
		int num = articleMapper.insertSelective(article);
		if (num == 1) {
			ArticleDetail articleDetail = new ArticleDetail();
			BeanUtils.copyProperties(articleDto, articleDetail);
			articleDetail.setCreateTime(new Date());
			articleDetail.setUpdateTime(new Date());

			articleDetailMongoDao.save(articleDetail);
		}
		return num;
	}

	@Override
	public void update(ArticleDto articleDto) {

	}

	@Override
	public Page<Article> findByPage(int pageNum, int pageSize) {
		return null;
	}

	@Override
	public ArticleDto findArticleById(int id) {
		return null;
	}

	@Override
	public void deleteArticleById(int id) {

	}
}
