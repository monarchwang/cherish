package com.monarchwang.website.dao.mongo.impl;

import com.monarchwang.website.dao.mongo.ArticleCommentsMongoDao;
import com.monarchwang.website.dao.mongo.model.ArticleComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * 文章评论mongo dao
 * Created by wanggl on 2017/8/3.
 */
@Repository
public class ArticleCommentsMongoDaoImpl extends BaseMongoDaoImpl<ArticleComments> implements ArticleCommentsMongoDao {


	@Autowired
	@Override
	protected void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
}
