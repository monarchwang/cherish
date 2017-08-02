package com.monarchwang.website.dao.mapper;

import com.monarchwang.website.dao.model.Tag;
import com.monarchwang.website.rest.dto.TagDto;
import com.monarchwang.website.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagMapper extends MyMapper<Tag> {

    Tag queryByName(String name);

    List<TagDto> selectTagsByPage();

	int updateTagStatus(@Param("id") int id, @Param("status") int status);

}