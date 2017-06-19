package com.monarchwang.website.mapper;

import com.monarchwang.website.model.UserTagRelation;

/**
 * @mbggenerated-mdx
 */
public interface UserTagRelationMapper {
    /**
     * This method corresponds to the database table t_user_tag_relation
     *
     * @mbggenerated-mdx
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method corresponds to the database table t_user_tag_relation
     *
     * @mbggenerated-mdx
     */
    int insert(UserTagRelation record);

    /**
     * This method corresponds to the database table t_user_tag_relation
     *
     * @mbggenerated-mdx
     */
    int insertSelective(UserTagRelation record);

    /**
     * This method corresponds to the database table t_user_tag_relation
     *
     * @mbggenerated-mdx
     */
    UserTagRelation selectByPrimaryKey(String id);

    /**
     * This method corresponds to the database table t_user_tag_relation
     *
     * @mbggenerated-mdx
     */
    int updateByPrimaryKeySelective(UserTagRelation record);

    /**
     * This method corresponds to the database table t_user_tag_relation
     *
     * @mbggenerated-mdx
     */
    int updateByPrimaryKey(UserTagRelation record);
}