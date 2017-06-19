package com.monarchwang.website.mapper;

import com.monarchwang.website.model.Tag;

/**
 * @mbggenerated-mdx
 */
public interface TagMapper {
    /**
     * This method corresponds to the database table t_tag
     *
     * @mbggenerated-mdx
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method corresponds to the database table t_tag
     *
     * @mbggenerated-mdx
     */
    int insert(Tag record);

    /**
     * This method corresponds to the database table t_tag
     *
     * @mbggenerated-mdx
     */
    int insertSelective(Tag record);

    /**
     * This method corresponds to the database table t_tag
     *
     * @mbggenerated-mdx
     */
    Tag selectByPrimaryKey(String id);

    /**
     * This method corresponds to the database table t_tag
     *
     * @mbggenerated-mdx
     */
    int updateByPrimaryKeySelective(Tag record);

    /**
     * This method corresponds to the database table t_tag
     *
     * @mbggenerated-mdx
     */
    int updateByPrimaryKey(Tag record);
}