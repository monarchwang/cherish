package com.monarchwang.website.dao.mongo.impl;

import com.monarchwang.website.dao.mongo.BaseMongoDao;
import com.monarchwang.website.utils.Page;
import com.monarchwang.website.utils.ReflectionUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * 基础Mongo操作封装
 * Created by wanggl on 2017/8/2.
 */
public abstract class BaseMongoDaoImpl<T> implements BaseMongoDao<T> {


	MongoTemplate mongoTemplate;

	@Override
	public T save(T entity) {
		mongoTemplate.save(entity);
		return entity;
	}

	@Override
	public T findById(String id) {
		return mongoTemplate.findById(id, getEntityClass());
	}

	@Override
	public T findById(String id, String collectionName) {
		return mongoTemplate.findById(id, getEntityClass(), collectionName);
	}

	@Override
	public List<T> findAll() {
		return mongoTemplate.findAll(getEntityClass());
	}

	@Override
	public List<T> findAll(String collectionName) {
		return mongoTemplate.findAll(getEntityClass(), collectionName);
	}

	@Override
	public List<T> find(Query query) {
		return mongoTemplate.find(query, getEntityClass());
	}

	@Override
	public T findOne(Query query) {
		return mongoTemplate.findOne(query, getEntityClass());
	}

	@Override
	public Page<T> findPage(Page<T> page, Query query) {

		long count = this.count(query);
		page.setTotal(count);
		int pageNumber = page.getPageNumber();
		int pageSize = page.getPageSize();
		query.skip((pageNumber - 1) * pageSize).limit(pageSize);
		List<T> list = this.find(query);
		page.setRows(list);

		return page;
	}

	@Override
	public long count(Query query) {
		return mongoTemplate.count(query, getEntityClass());
	}

	@Override
	public T update(Query query, Update update) {
		return mongoTemplate.findAndModify(query, update, this.getEntityClass());
	}


	@Override
	public void remove(Query query) {
		mongoTemplate.remove(query, getEntityClass());
	}


	private Class<T> getEntityClass() {
		return ReflectionUtils.getSuperClassGenricType(getClass());
	}

	protected abstract void setMongoTemplate(MongoTemplate mongoTemplate);
}
