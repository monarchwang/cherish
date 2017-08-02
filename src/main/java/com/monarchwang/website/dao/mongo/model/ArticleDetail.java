package com.monarchwang.website.dao.mongo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by wanggl on 2017/8/2.
 */
@Data
public class ArticleDetail implements Serializable {

	private String id;

	private String title;

	private String brief;

	private List<String> tags;

	private String content;

	private Date createTime;

	private Date updateTime;

}
