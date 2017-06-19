package com.monarchwang.website.mapper;

import com.monarchwang.website.model.Article;

/**
 * @mbggenerated-mdx
 */
public interface ArticleMapper {
    /**
     * This method corresponds to the database table t_article
     *
     * @mbggenerated-mdx
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method corresponds to the database table t_article
     *
     * @mbggenerated-mdx
     */
    int insert(Article record);

    /**
     * This method corresponds to the database table t_article
     *
     * @mbggenerated-mdx
     */
    int insertSelective(Article record);

    /**
     * This method corresponds to the database table t_article
     *
     * @mbggenerated-mdx
     */
    Article selectByPrimaryKey(String id);

    /**
     * This method corresponds to the database table t_article
     *
     * @mbggenerated-mdx
     */
    int updateByPrimaryKeySelective(Article record);

    /**
     * This method corresponds to the database table t_article
     *
     * @mbggenerated-mdx
     */
    int updateByPrimaryKey(Article record);
}