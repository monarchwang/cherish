package com.monarchwang.website.dao.mongo;

import com.monarchwang.website.utils.Page;
import org.springframework.data.mongodb.core.query.Query;
import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * 通用Mongo dao接口
 * Created by wanggl on 2017/8/2.
 */
 public interface BaseMongoDao<T> {
	/**
	 * 插入   
	 */
	 T save(T entity);

	/**
	 * 根据ID查询   
	 */
	 T findById(String id);

	/**
	 * 通过ID获取记录,并且指定了集合名
	 */
	 T findById(String id, String collectionName);

	/**
	 * 获得所有该类型记录   
	 */
	 List<T> findAll();

	/**
	 * 获得所有该类型记录,并且指定了集合名
	 */
	 List<T> findAll(String collectionName);

	/**
	 * 根据条件查询   
	 */
	 List<T> find(Query query);

	/**
	 * 根据条件查询一个   
	 */
	 T findOne(Query query);

	/**
	 * 分页查询   
	 */
	 Page<T> findPage(Page<T> page, Query query);

	/**
	 * 根据条件 获得总数   
	 */
	 long count(Query query);

	/**
	 * 根据条件 更新   
	 */
	 T update(Query query, Update update);



	/**
	 * 根据条件 删除   
	 *
	 * @param query
	 */
	 void remove(Query query);

}
