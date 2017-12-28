package com.monarchwang.website.common;

import com.alibaba.fastjson.JSON;
import com.monarchwang.website.handler.TokenHandler;
import com.monarchwang.website.utils.http.HttpClientTemplate;
import com.monarchwang.website.utils.system.ApiServerRegisterUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * token拦截器 CROS 配置
 */
@Configuration
@EnableScheduling
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(WebMvcConfigurer.class);

    @Resource
    private ApiRegisterConfig apiRegisterConfig;

    @Resource
    private HttpClientTemplate httpClientTemplate;

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


    @PostConstruct
    public void registerApi() {
        LOG.info("--------开始向APISERVER注册-------");
        ApiServerRegisterUtils.register(apiRegisterConfig, httpClientTemplate);

    }

    @Scheduled(cron = "*/10 * * * * ?")
    public void heartBeatMonitor(){
        LOG.info("========发送心跳检测包========");
        ApiServerRegisterUtils.register(apiRegisterConfig, httpClientTemplate);
    }

}
