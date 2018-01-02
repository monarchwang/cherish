package com.monarchwang.website.controller;

import com.alibaba.fastjson.JSONObject;
import com.monarchwang.website.common.RedisService;
import com.monarchwang.website.service.UserService;
import com.monarchwang.website.utils.response.RespStatus;
import com.monarchwang.website.utils.response.ResponseData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by wanggl on 2017/6/19.
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private RedisService<String, String> redisService;

    private static final Integer DEFAULT_EXPIRE_MINUTES = 15;

    @PostMapping("login")
    public ResponseData<String> checkUser(@RequestBody JSONObject params) {
        ResponseData<String> responseData = new ResponseData<>();

        String password = params.getString("password");
        String username = params.getString("username");
        if (StringUtils.isAnyEmpty(password, username)) {
            responseData.setStatus(RespStatus.FAIL);
            responseData.setMsg("用户名或密码不能为空");
        } else {
            boolean exist = userService.checkUserPwd(username, password);
            if (exist) {
                String token = UUID.randomUUID().toString();
                redisService.set(token, token, DEFAULT_EXPIRE_MINUTES, TimeUnit.MINUTES);
                responseData.setData(token);
            } else {
                responseData.setStatus(RespStatus.FAIL);
                responseData.setMsg("用户名或密码错误");
            }

        }
        return responseData;
    }
}
