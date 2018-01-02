package com.monarchwang.website.dao.mybatis.mapper;

import com.monarchwang.website.dao.mybatis.model.User;
import com.monarchwang.website.utils.system.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends MyMapper<User> {

    boolean checkUserPwd(@Param("account") String account, @Param("pwd") String password);
}