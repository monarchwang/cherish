package com.monarchwang.website.dao.mongo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wanggl on 2017/8/3.
 */
@Data
public class Comment implements Serializable {

	private String id;

	private String form;

	private String to;

	private String parentId;

	private String content;

	private Date createTime;
}
