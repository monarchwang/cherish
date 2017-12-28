package com.monarchwang.website.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "apiserver")
@Data
public class ApiRegisterConfig {

    private String registerUrl;

    private String appCode;

    private String appName;

    private Integer port;

    private String ip;

}
