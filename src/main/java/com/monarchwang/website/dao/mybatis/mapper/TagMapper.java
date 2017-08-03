package com.monarchwang.website.dao.mybatis.mapper;

import com.monarchwang.website.dao.mybatis.model.Tag;
import com.monarchwang.website.rest.dto.TagDto;
import com.monarchwang.website.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagMapper extends MyMapper<Tag> {

    Tag queryByName(String name);

    List<TagDto> selectTagsByStatus(@Param("status") Integer status);

    int updateTagStatus(@Param("id") int id, @Param("status") int status);

    void deleteTagById(@Param("id") int id);

    List<String> queryTagNameByArticleId(@Param("articleId") int articleId);
}