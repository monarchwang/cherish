package com.monarchwang.website.utils.system;

import com.alibaba.fastjson.JSON;
import com.monarchwang.website.common.ApiRegisterConfig;
import com.monarchwang.website.common.WebMvcConfigurer;
import com.monarchwang.website.utils.http.HttpClientTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ApiServerRegisterUtils {
    private static final Logger LOG = LoggerFactory.getLogger(ApiServerRegisterUtils.class);

    public static void register(ApiRegisterConfig apiRegisterConfig, HttpClientTemplate httpClientTemplate) {
        try {
            apiRegisterConfig.setIp(InetAddress.getLocalHost().getHostAddress());
            String result = httpClientTemplate.executePost(apiRegisterConfig.getRegisterUrl(), JSON.toJSONString(apiRegisterConfig));
            LOG.info("--------APISERVER接口返回值：{}-------", result);

        } catch (UnknownHostException e) {
            e.printStackTrace();
            LOG.error("获取本机ip失败，", e);
        } catch (IOException e) {
            e.printStackTrace();
            LOG.error("注册失败，", e);
        }
    }

}
