package com.monarchwang.website.service.impl;

import com.github.pagehelper.PageHelper;
import com.monarchwang.website.mapper.UserMapper;
import com.monarchwang.website.model.User;
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


	@Override
	public List<User> list(Integer page) {

		PageHelper.startPage(page,5);

		return userMapper.selectAll();
	}
}
