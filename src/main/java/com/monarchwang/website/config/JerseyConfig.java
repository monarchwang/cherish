package com.monarchwang.website.config;

import com.monarchwang.website.rest.UserResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
/**

 * Jersey 配置类
 * Created by wanggl on 2017/6/20.
 */
@Component
public class JerseyConfig extends ResourceConfig {

	/**
	 * 扫描com.monarchwang.website.rest包，使其识别JAX-RS注解
	 */
	public JerseyConfig(){
//		packages("com.monarchwang.website.rest");
		register(UserResource.class);
	}
}
