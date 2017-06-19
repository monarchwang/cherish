package com.monarchwang.website.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @mbggenerated-mdx
 */
public class Tag implements Serializable {

    /**
     *
     * This field corresponds to the database column t_tag.id
     *
     * @mbggenerated-mdx
     */
    private String id;

    /**
     *
     * This field corresponds to the database column t_tag.name
     *
     * @mbggenerated-mdx
     */
    private String name;

    /**
     *
     * This field corresponds to the database column t_tag.delete_flag
     *
     * @mbggenerated-mdx
     */
    private Byte deleteFlag;

    /**
     *
     * This field corresponds to the database column t_tag.create_time
     *
     * @mbggenerated-mdx
     */
    private Date createTime;

    /**
     *
     * This field corresponds to the database column t_tag.update_time
     *
     * @mbggenerated-mdx
     */
    private Date updateTime;

    /**
     *
     * This field corresponds to the database column t_tag.last_modified_by
     *
     * @mbggenerated-mdx
     */
    private String lastModifiedBy;

    /**
     * This field corresponds to the database table t_tag
     *
     * @mbggenerated-mdx
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column t_tag.id
     *
     * @return the value of t_tag.id
     *
     * @mbggenerated-mdx
     */
    public String getId() {
        return id;
    }

    /**
     * This method sets the value of the database column t_tag.id
     *
     * @param id the value for t_tag.id
     *
     * @mbggenerated-mdx
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method returns the value of the database column t_tag.name
     *
     * @return the value of t_tag.name
     *
     * @mbggenerated-mdx
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the value of the database column t_tag.name
     *
     * @param name the value for t_tag.name
     *
     * @mbggenerated-mdx
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method returns the value of the database column t_tag.delete_flag
     *
     * @return the value of t_tag.delete_flag
     *
     * @mbggenerated-mdx
     */
    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * This method sets the value of the database column t_tag.delete_flag
     *
     * @param deleteFlag the value for t_tag.delete_flag
     *
     * @mbggenerated-mdx
     */
    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * This method returns the value of the database column t_tag.create_time
     *
     * @return the value of t_tag.create_time
     *
     * @mbggenerated-mdx
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column t_tag.create_time
     *
     * @param createTime the value for t_tag.create_time
     *
     * @mbggenerated-mdx
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column t_tag.update_time
     *
     * @return the value of t_tag.update_time
     *
     * @mbggenerated-mdx
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column t_tag.update_time
     *
     * @param updateTime the value for t_tag.update_time
     *
     * @mbggenerated-mdx
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column t_tag.last_modified_by
     *
     * @return the value of t_tag.last_modified_by
     *
     * @mbggenerated-mdx
     */
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * This method sets the value of the database column t_tag.last_modified_by
     *
     * @param lastModifiedBy the value for t_tag.last_modified_by
     *
     * @mbggenerated-mdx
     */
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy == null ? null : lastModifiedBy.trim();
    }
}