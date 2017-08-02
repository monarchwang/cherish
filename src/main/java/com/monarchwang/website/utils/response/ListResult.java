package com.monarchwang.website.utils.response;

import lombok.Data;

import java.util.List;

/**
 * Created by liang on 2017/8/1.
 */
@Data
public class ListResult<T> {

    private long total;

    private List<T> rows;

}
