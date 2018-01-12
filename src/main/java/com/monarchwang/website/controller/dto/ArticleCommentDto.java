package com.monarchwang.website.controller.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ArticleCommentDto {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 文章id
     */
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
    private Integer agreeNum;

    /**
     * 反对数
     */
    private Integer disagreeNum;

    /**
     * 评论所在楼层
     */
    private Integer floor;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 评论内容
     */
    private String content;

    private Integer parentId;


    private List<ArticleCommentDto> replies;

}
