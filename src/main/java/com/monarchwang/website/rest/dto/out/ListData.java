package com.monarchwang.website.rest.dto.out;

import lombok.Data;

import java.util.List;

/**
 * Created by liang on 2017/8/1.
 */
@Data
public class ListData<T> {

    private long sum;

    private List<T> data;

}
