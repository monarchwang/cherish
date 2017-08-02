package com.monarchwang.website.utils;

/**
 * Created by wanggl on 2017/8/2.
 */
public enum ExceptionEnum {
	UNKONW_ERROR(-1, "未知错误"),

	SUCCESS(0, "请求成功"),

	INVALID_TOKEN(1001, "token失效");

	ExceptionEnum(int status, String message) {
		this.status = status;
		this.message = message;
	}

	private int status;

	private String message;

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}
}
