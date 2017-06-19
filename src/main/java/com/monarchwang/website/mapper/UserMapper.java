package com.monarchwang.website.mapper;

import com.monarchwang.website.model.User;

/**
 * @mbggenerated-mdx
 */
public interface UserMapper {
    /**
     * This method corresponds to the database table t_user
     *
     * @mbggenerated-mdx
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method corresponds to the database table t_user
     *
     * @mbggenerated-mdx
     */
    int insert(User record);

    /**
     * This method corresponds to the database table t_user
     *
     * @mbggenerated-mdx
     */
    int insertSelective(User record);

    /**
     * This method corresponds to the database table t_user
     *
     * @mbggenerated-mdx
     */
    User selectByPrimaryKey(String id);

    /**
     * This method corresponds to the database table t_user
     *
     * @mbggenerated-mdx
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method corresponds to the database table t_user
     *
     * @mbggenerated-mdx
     */
    int updateByPrimaryKey(User record);
}