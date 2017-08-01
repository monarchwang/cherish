package com.monarchwang.website.common;

import com.google.gson.Gson;
import com.monarchwang.website.utils.ResponseData;
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

    TokenHandler(RedisService redisService) {
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

        Cookie[] cookies = request.getCookies();
        String token = null;
        if (cookies != null)
            for (Cookie cookie : cookies) {
                if (cookie != null && cookie.getName().equals("token")) {
                    token = cookie.getValue();
                }
            }

        if (StringUtils.isEmpty(token) || redisService.get(token) == null) {
            //没有token  或者token失效
            ResponseData responseData = new ResponseData();
            responseData.setCode(1001);
            responseData.setMsg("请先登录");
            response.setHeader("content-type", "application/json;charset=utf-8");
            //通过输出流的形式发给浏览器，然后浏览器转成json对象
            response.getWriter().write(new Gson().toJson(responseData));
            return false;
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
