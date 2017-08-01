package com.monarchwang.website.rest.dto.out;

import lombok.Data;

import java.util.Date;

/**
 * Created by liang on 2017/8/1.
 */
@Data
public class TagDto {

    private int id;

    private String name;

    private Byte status;

    private Date createTime;

    private int articleNum;

}
