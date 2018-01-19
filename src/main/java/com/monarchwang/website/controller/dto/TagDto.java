package com.monarchwang.website.controller.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * Created by liang on 2017/8/1.
 */
@Data
public class TagDto {

    private int id;

    private String name;

    private int status;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private int articleNum;

}
