package com.monarchwang.website.handler;

import com.monarchwang.website.common.CherishException;
import com.monarchwang.website.utils.response.RespStatus;
import com.monarchwang.website.utils.response.ResponseData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常捕获
 * Created by wanggl on 2017/8/2.
 */
@ControllerAdvice
public class ExceptionHandle {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResponseData<String> handle(Exception e) {
		ResponseData<String> responseData = new ResponseData<>();

		if (e instanceof CherishException) {
			CherishException cherishException = (CherishException) e;
			responseData.setStatus(cherishException.getStatus());
			responseData.setMsg(cherishException.getMessage());
		} else {
			e.printStackTrace();
			responseData.setStatus(RespStatus.FAIL);
			responseData.setMsg("系统发生异常: " + e.getMessage());
		}
		return responseData;
	}

}
