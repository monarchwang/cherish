package com.monarchwang.website.rest;

import com.monarchwang.website.common.RedisService;
import com.monarchwang.website.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by wanggl on 2017/6/19.
 */
@RestController
@RequestMapping("/paper")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private RedisService<String, String> redisService;



}
