package com.monarchwang.website.service;

import com.monarchwang.website.dao.model.Tag;
import com.monarchwang.website.rest.dto.out.ListData;
import com.monarchwang.website.rest.dto.out.TagDto;

/**
 * Created by liang on 2017/8/1.
 */
public interface TagService {

    int saveTag(Tag tag);

    Tag queryByName(String name);

    int updateTag(Tag tag);

    void deleteTagById(int id);

    ListData<TagDto> queryTagByPage(int pageNum, int pageSize);

}
