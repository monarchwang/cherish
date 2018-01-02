package com.monarchwang.website.service.impl;

import com.monarchwang.website.dao.mybatis.mapper.UserMapper;
import com.monarchwang.website.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户service
 * Created by wanggl on 2017/6/19.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean checkUserPwd(String account, String password) {
        return userMapper.checkUserPwd(account, password);
    }

}
