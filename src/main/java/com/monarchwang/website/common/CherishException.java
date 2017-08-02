package com.monarchwang.website.common;

import com.monarchwang.website.utils.ExceptionEnum;

/**
 * 异常封装
 * Created by wanggl on 2017/8/2.
 */
public class CherishException extends RuntimeException {

	private int status;

	public CherishException(ExceptionEnum exceptionEnum) {
		super(exceptionEnum.getMessage());
		this.status = exceptionEnum.getStatus();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
