package com.monarchwang.website.rest.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by wanggl on 2017/8/2.
 */
@Data
public class ArticleDto {

    private int id;

    private String brief;

    private int userId;

    private String title;

    private List<String> tags;

    private List<Integer> tagIds;

    private String content;

    private Date createTime;

    private Date updateTime;

    //0:保存，1发布
    private int type;
}
