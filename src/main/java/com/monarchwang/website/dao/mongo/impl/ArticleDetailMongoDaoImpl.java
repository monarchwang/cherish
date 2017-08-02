package com.monarchwang.website.dao.mongo.impl;

import com.monarchwang.website.dao.mongo.ArticleDetailMongoDao;
import com.monarchwang.website.dao.mongo.model.ArticleDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by wanggl on 2017/8/2.
 */
@Repository
public class ArticleDetailMongoDaoImpl extends BaseMongoDaoImpl<ArticleDetail> implements ArticleDetailMongoDao {


	@Autowired
	@Override
	protected void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
}
