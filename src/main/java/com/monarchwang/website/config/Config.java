package com.monarchwang.website.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * mapper相关配置
 * Created by wanggl on 2017/6/19.
 */
@Configuration
@ComponentScan(basePackages = {"com.monarchwang.website"})
@MapperScan("com.monarchwang.website.dao")
public class Config {

	private static final Logger LOG = LoggerFactory.getLogger(Config.class);


	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters(){
		//1.需要定义一个convert转换消息的对象;
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		//2:添加fastJson的配置信息;
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		//3处理中文乱码问题
		List<MediaType> fastMediaTypes = new ArrayList<>();
		fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		//4.在convert中添加配置信息.
		fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
		return new HttpMessageConverters(converter);

	}
}
