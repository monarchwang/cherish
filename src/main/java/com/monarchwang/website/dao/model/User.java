package com.monarchwang.website.dao.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class User implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 姓名
     */
    private String username;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像
     */
    @Column(name = "head_img")
    private String headImg;

    /**
     * 当前记录是否有效@0:有效@1:无效
     */
    @Column(name = "delete_flag")
    private Byte deleteFlag;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 记录最后更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 最后一次修改者id
     */
    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取姓名
     *
     * @return username - 姓名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置姓名
     *
     * @param username 姓名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取昵称
     *
     * @return nick_name - 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取头像
     *
     * @return head_img - 头像
     */
    public String getHeadImg() {
        return headImg;
    }

    /**
     * 设置头像
     *
     * @param headImg 头像
     */
    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    /**
     * 获取当前记录是否有效@0:有效@1:无效
     *
     * @return delete_flag - 当前记录是否有效@0:有效@1:无效
     */
    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置当前记录是否有效@0:有效@1:无效
     *
     * @param deleteFlag 当前记录是否有效@0:有效@1:无效
     */
    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取记录最后更新时间
     *
     * @return update_time - 记录最后更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置记录最后更新时间
     *
     * @param updateTime 记录最后更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取最后一次修改者id
     *
     * @return last_modified_by - 最后一次修改者id
     */
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * 设置最后一次修改者id
     *
     * @param lastModifiedBy 最后一次修改者id
     */
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy == null ? null : lastModifiedBy.trim();
    }
}