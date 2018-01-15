package com.monarchwang.website.controller.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String fromUser;

    /**
     * 评论对象
     */
    private String toUser;

    /**
     * 赞同数
     */
    private Integer agreeNumber;

    /**
     * 反对数
     */
    private Integer disagreeNumber;

    /**
     * 评论所在楼层
     */
    private Integer floorNumber;

    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 修改时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 评论内容
     */
    private String content;

    private Integer parentId;


    private List<ArticleCommentDto> replies;

}
