package com.monarchwang.website.utils.system;

import lombok.Data;

import java.util.List;

/**
 * Created by wanggl on 2017/8/2.
 */
@Data
public class Page<T> {

	private long total;

	private int pageNumber;

	private int pageSize;

	private List<T> rows;

}
