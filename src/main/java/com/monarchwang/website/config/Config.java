package com.monarchwang.website.config;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 数据源相关配置
 * Created by wanggl on 2017/6/19.
 */
@Configuration
@ComponentScan(basePackages = {"com.monarchwang.website"})
@MapperScan("com.monarchwang.website.dao.mapper")
public class Config {

	private static final Logger LOG = LoggerFactory.getLogger(Config.class);




}
