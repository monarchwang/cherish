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
    private String from;

    /**
     * 评论对象
     */
    private String to;

    /**
     * 赞同数
     */
    @Column(name = "agree_num")
    private Integer agreeNum;

    /**
     * 反对数
     */
    @Column(name = "disagree_num")
    private Integer disagreeNum;

    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 评论所在楼层
     */
    private Integer floor;

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


    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

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
     * 获取文章id
     *
     * @return article_id - 文章id
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * 设置文章id
     *
     * @param articleId 文章id
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * 获取评论发起者
     *
     * @return from - 评论发起者
     */
    public String getFrom() {
        return from;
    }

    /**
     * 设置评论发起者
     *
     * @param from 评论发起者
     */
    public void setFrom(String from) {
        this.from = from == null ? null : from.trim();
    }

    /**
     * 获取评论对象
     *
     * @return to - 评论对象
     */
    public String getTo() {
        return to;
    }

    /**
     * 设置评论对象
     *
     * @param to 评论对象
     */
    public void setTo(String to) {
        this.to = to == null ? null : to.trim();
    }

    /**
     * 获取赞同数
     *
     * @return agree_num - 赞同数
     */
    public Integer getAgreeNum() {
        return agreeNum;
    }

    /**
     * 设置赞同数
     *
     * @param agreeNum 赞同数
     */
    public void setAgreeNum(Integer agreeNum) {
        this.agreeNum = agreeNum;
    }

    /**
     * 获取反对数
     *
     * @return disagree_num - 反对数
     */
    public Integer getDisagreeNum() {
        return disagreeNum;
    }

    /**
     * 设置反对数
     *
     * @param disagreeNum 反对数
     */
    public void setDisagreeNum(Integer disagreeNum) {
        this.disagreeNum = disagreeNum;
    }

    /**
     * 获取评论所在楼层
     *
     * @return floor - 评论所在楼层
     */
    public Integer getFloor() {
        return floor;
    }

    /**
     * 设置评论所在楼层
     *
     * @param floor 评论所在楼层
     */
    public void setFloor(Integer floor) {
        this.floor = floor;
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
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取评论内容
     *
     * @return content - 评论内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评论内容
     *
     * @param content 评论内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}