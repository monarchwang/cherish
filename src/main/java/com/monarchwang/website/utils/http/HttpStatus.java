package com.monarchwang.website.utils.http;

public enum HttpStatus {
	OK(200, "成功"),
	VOID(204, "没有返回"),
	FAIL(500, "调用失败");

	private int code;

	private String desc;

	private HttpStatus(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
