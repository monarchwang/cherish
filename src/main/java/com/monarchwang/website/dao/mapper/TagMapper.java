package com.monarchwang.website.dao.mapper;

import com.monarchwang.website.dao.model.Tag;
import com.monarchwang.website.rest.dto.out.TagDto;
import com.monarchwang.website.utils.MyMapper;

import java.util.List;

public interface TagMapper extends MyMapper<Tag> {

    Tag queryByName(String name);

    List<TagDto> selectTagsByPage();
}