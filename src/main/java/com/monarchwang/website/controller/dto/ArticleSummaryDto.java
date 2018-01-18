package com.monarchwang.website.controller.dto;

import lombok.Data;

import java.util.List;

@Data
public class ArticleSummaryDto {

    private List<ArticleDto> articleDtos;

    private List<String> tags;

}
