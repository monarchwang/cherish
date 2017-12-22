package com.monarchwang.website.service;

import com.monarchwang.website.dao.mybatis.model.Tag;
import com.monarchwang.website.utils.response.ListResult;
import com.monarchwang.website.controller.dto.TagDto;

/**
 * Created by liang on 2017/8/1.
 */
public interface TagService {

	int saveTag(Tag tag);

	Tag queryByName(String name);

	int updateTagStatus(int id, int status);

	void deleteTagById(int id);

	ListResult<TagDto> queryTagByPage(Integer pageNum, Integer pageSize,Integer status);

    void update(Tag tag);
}
