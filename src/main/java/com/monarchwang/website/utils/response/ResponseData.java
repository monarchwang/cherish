package com.monarchwang.website.utils.response;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 */
@Data
public class ResponseData<T> implements Serializable {

	/**
	 * 错误码.
	 */
	private int status;

	/**
	 * 提示信息.
	 */
	private String msg;

	/**
	 * 具体的内容.
	 */
	private T data;

	public ResponseData() {
		data = null;
		status = RespStatus.SUCCESS;
		msg = "操作成功";
	}
}
