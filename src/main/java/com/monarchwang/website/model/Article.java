/**
 * Copyright (C), monarchwang
 */
package com.monarchwang.website.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @mbggenerated-mdx
 */
public class Article implements Serializable {

    /**
     *
     * This field corresponds to the database column t_article.id
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    private String id;

    /**
     *
     * This field corresponds to the database column t_article.user_id
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    private String userId;

    /**
     *
     * This field corresponds to the database column t_article.info_id
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    private String infoId;

    /**
     *
     * This field corresponds to the database column t_article.delete_flag
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    private Byte deleteFlag;

    /**
     *
     * This field corresponds to the database column t_article.create_time
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    private Date createTime;

    /**
     *
     * This field corresponds to the database column t_article.update_time
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    private Date updateTime;

    /**
     *
     * This field corresponds to the database column t_article.last_modified_by
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    private String lastModifiedBy;

    /**
     * This field corresponds to the database table t_article
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column t_article.id
     *
     * @return the value of t_article.id
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method sets the value of the database column t_article.id
     *
     * @param id the value for t_article.id
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method returns the value of the database column t_article.user_id
     *
     * @return the value of t_article.user_id
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method sets the value of the database column t_article.user_id
     *
     * @param userId the value for t_article.user_id
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method returns the value of the database column t_article.info_id
     *
     * @return the value of t_article.info_id
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public String getInfoId() {
        return infoId;
    }

    /**
     * This method sets the value of the database column t_article.info_id
     *
     * @param infoId the value for t_article.info_id
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public void setInfoId(String infoId) {
        this.infoId = infoId == null ? null : infoId.trim();
    }

    /**
     * This method returns the value of the database column t_article.delete_flag
     *
     * @return the value of t_article.delete_flag
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * This method sets the value of the database column t_article.delete_flag
     *
     * @param deleteFlag the value for t_article.delete_flag
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * This method returns the value of the database column t_article.create_time
     *
     * @return the value of t_article.create_time
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column t_article.create_time
     *
     * @param createTime the value for t_article.create_time
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column t_article.update_time
     *
     * @return the value of t_article.update_time
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column t_article.update_time
     *
     * @param updateTime the value for t_article.update_time
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column t_article.last_modified_by
     *
     * @return the value of t_article.last_modified_by
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * This method sets the value of the database column t_article.last_modified_by
     *
     * @param lastModifiedBy the value for t_article.last_modified_by
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy == null ? null : lastModifiedBy.trim();
    }
}