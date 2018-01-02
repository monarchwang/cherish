package com.monarchwang.website.handler;

import com.monarchwang.website.common.CherishException;
import com.monarchwang.website.common.RedisService;
import com.monarchwang.website.utils.system.ExceptionEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Token拦截器
 */
public class TokenHandler implements HandlerInterceptor {

	private RedisService<String, String> redisService;

	public TokenHandler(RedisService redisService) {
		this.redisService = redisService;
	}

	public TokenHandler() {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		//获取url(类似work/login)
		String path = request.getRequestURL().toString();
		if (path.contains("/login")) {

			return true;
		}

		String token = request.getHeader("token");

		if (StringUtils.isEmpty(token) || redisService.get(token) == null) {
			//没有token  或者token失效,抛出自定义异常
			throw new CherishException(ExceptionEnum.INVALID_TOKEN);
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}
}
