package com.monarchwang.website.rest.dto;

import com.alibaba.fastjson.annotation.JSONField;
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

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	//浏览数
	private int viewNum;

	//评论数
	private int commentNum;

	//0：草稿 ，1：已发布
	private int status;

	//0:保存，1发布
	private int type;
}
