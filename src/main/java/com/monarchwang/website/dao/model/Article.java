package com.monarchwang.website.dao.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Article implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章简介
     */
    private String brief;

    /**
     * 文章内容id，具体内容保存在mongo中
     */
    @Column(name = "content_id")
    private String contentId;

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
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取文章标题
     *
     * @return title - 文章标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置文章标题
     *
     * @param title 文章标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取文章简介
     *
     * @return brief - 文章简介
     */
    public String getBrief() {
        return brief;
    }

    /**
     * 设置文章简介
     *
     * @param brief 文章简介
     */
    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    /**
     * 获取文章内容id，具体内容保存在mongo中
     *
     * @return content_id - 文章内容id，具体内容保存在mongo中
     */
    public String getContentId() {
        return contentId;
    }

    /**
     * 设置文章内容id，具体内容保存在mongo中
     *
     * @param contentId 文章内容id，具体内容保存在mongo中
     */
    public void setContentId(String contentId) {
        this.contentId = contentId == null ? null : contentId.trim();
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