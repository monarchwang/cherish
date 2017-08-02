package com.monarchwang.website.service;

import com.monarchwang.website.dao.model.Tag;
import com.monarchwang.website.utils.response.ListResult;
import com.monarchwang.website.rest.dto.TagDto;

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
