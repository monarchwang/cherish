package com.monarchwang.website.dao.mongo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wanggl on 2017/8/3.
 */
@Data
public class ArticleComments implements Serializable{

	private String id;

	private String articleId;

	private List<Comment> comments;


}
