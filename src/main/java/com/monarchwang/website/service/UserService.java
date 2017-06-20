package com.monarchwang.website.service;

import com.monarchwang.website.model.User;

import java.util.List;

/**
 *
 * Created by wanggl on 2017/6/19.
 */
public interface UserService {

	List<User> list(Integer page);
}
