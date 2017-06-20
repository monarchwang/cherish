package com.monarchwang.website.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 继承自己的MyMapper
 * Created by wanggl on 2017/6/20.
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
	//TODO
	//FIXME 特别注意，该接口不能被扫描到，否则会出错
}