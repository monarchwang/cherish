/**
 * Copyright (C), monarchwang
 */
package com.monarchwang.website.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @mbggenerated-mdx
 */
public class User implements Serializable {

    /**
     *
     * This field corresponds to the database column t_user.id
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    private String id;

    /**
     *
     * This field corresponds to the database column t_user.username
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    private String username;

    /**
     *
     * This field corresponds to the database column t_user.nick_name
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    private String nickName;

    /**
     *
     * This field corresponds to the database column t_user.phone
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    private String phone;

    /**
     *
     * This field corresponds to the database column t_user.email
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    private String email;

    /**
     *
     * This field corresponds to the database column t_user.password
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    private String password;

    /**
     *
     * This field corresponds to the database column t_user.head_img
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    private String headImg;

    /**
     *
     * This field corresponds to the database column t_user.delete_flag
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    private Byte deleteFlag;

    /**
     *
     * This field corresponds to the database column t_user.create_time
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    private Date createTime;

    /**
     *
     * This field corresponds to the database column t_user.update_time
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    private Date updateTime;

    /**
     *
     * This field corresponds to the database column t_user.last_modified_by
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    private String lastModifiedBy;

    /**
     * This field corresponds to the database table t_user
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column t_user.id
     *
     * @return the value of t_user.id
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method sets the value of the database column t_user.id
     *
     * @param id the value for t_user.id
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method returns the value of the database column t_user.username
     *
     * @return the value of t_user.username
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method sets the value of the database column t_user.username
     *
     * @param username the value for t_user.username
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method returns the value of the database column t_user.nick_name
     *
     * @return the value of t_user.nick_name
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method sets the value of the database column t_user.nick_name
     *
     * @param nickName the value for t_user.nick_name
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * This method returns the value of the database column t_user.phone
     *
     * @return the value of t_user.phone
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method sets the value of the database column t_user.phone
     *
     * @param phone the value for t_user.phone
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method returns the value of the database column t_user.email
     *
     * @return the value of t_user.email
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method sets the value of the database column t_user.email
     *
     * @param email the value for t_user.email
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method returns the value of the database column t_user.password
     *
     * @return the value of t_user.password
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method sets the value of the database column t_user.password
     *
     * @param password the value for t_user.password
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method returns the value of the database column t_user.head_img
     *
     * @return the value of t_user.head_img
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public String getHeadImg() {
        return headImg;
    }

    /**
     * This method sets the value of the database column t_user.head_img
     *
     * @param headImg the value for t_user.head_img
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    /**
     * This method returns the value of the database column t_user.delete_flag
     *
     * @return the value of t_user.delete_flag
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * This method sets the value of the database column t_user.delete_flag
     *
     * @param deleteFlag the value for t_user.delete_flag
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * This method returns the value of the database column t_user.create_time
     *
     * @return the value of t_user.create_time
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column t_user.create_time
     *
     * @param createTime the value for t_user.create_time
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column t_user.update_time
     *
     * @return the value of t_user.update_time
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column t_user.update_time
     *
     * @param updateTime the value for t_user.update_time
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column t_user.last_modified_by
     *
     * @return the value of t_user.last_modified_by
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * This method sets the value of the database column t_user.last_modified_by
     *
     * @param lastModifiedBy the value for t_user.last_modified_by
     *
     * @mbggenerated-mdx Tue Jun 20 11:13:58 CST 2017
     */
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy == null ? null : lastModifiedBy.trim();
    }
}