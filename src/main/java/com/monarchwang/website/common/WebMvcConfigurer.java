package com.monarchwang.website.common;

import com.monarchwang.website.handler.TokenHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * token拦截器 CROS 配置
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Resource
    private RedisService<String, String> redisService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new TokenHandler(redisService)).addPathPatterns("/admin/**");
        super.addInterceptors(registry);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600);
        super.addCorsMappings(registry);
    }
}
