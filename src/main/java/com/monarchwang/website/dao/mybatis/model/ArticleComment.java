package com.monarchwang.website.dao.mybatis.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "article_comment")
public class ArticleComment implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 文章id
     */
    @Column(name = "article_id")
    private Integer articleId;

    /**
     * 评论发起者
     */
    @Column(name = "from_user")
    private String fromUser;

    /**
     * 评论对象
     */
    @Column(name = "to_user")
    private String toUser;

    /**
     * 赞同数
     */
    @Column(name = "agree_number")
    private Integer agreeNumber;

    /**
     * 反对数
     */
    @Column(name = "disagree_number")
    private Integer disagreeNumber;

    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 评论所在楼层
     */
    @Column(name = "floor_number")
    private Integer floorNumber;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 评论内容
     */
    private String content;


    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public Integer getAgreeNumber() {
        return agreeNumber;
    }

    public void setAgreeNumber(Integer agreeNumber) {
        this.agreeNumber = agreeNumber;
    }

    public Integer getDisagreeNumber() {
        return disagreeNumber;
    }

    public void setDisagreeNumber(Integer disagreeNumber) {
        this.disagreeNumber = disagreeNumber;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}