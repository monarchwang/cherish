package com.monarchwang.website.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.monarchwang.website.common.RedisService;
import com.monarchwang.website.dao.mapper.UserMapper;
import com.monarchwang.website.dao.model.User;
import com.monarchwang.website.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户service
 * Created by wanggl on 2017/6/19.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisService<String, List<User>> redisService;


    @Override
    public PageInfo<User> list(Integer page) {

        PageHelper.startPage(page, 5);

        PageInfo<User> pageInfo = new PageInfo<>(userMapper.selectAll());
        return pageInfo;

    }
}
