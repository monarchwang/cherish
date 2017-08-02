package com.monarchwang.website.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.monarchwang.website.dao.mapper.TagMapper;
import com.monarchwang.website.dao.model.Tag;
import com.monarchwang.website.utils.response.ListResult;
import com.monarchwang.website.rest.dto.TagDto;
import com.monarchwang.website.service.TagService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 标签Service 实现类
 * Created by liang on 2017/8/1.
 */
@Service
public class TagServiceImpl implements TagService {

    @Resource
    private TagMapper tagMapper;

    @Override
    public int saveTag(Tag tag) {
        return tagMapper.insertSelective(tag);
    }

    @Override
    public Tag queryByName(String name) {
        return tagMapper.queryByName(name);
    }

    @Override
    public int updateTagStatus(int id,int status) {
        return tagMapper.updateTagStatus(id,status);
    }

    @Override
    public void deleteTagById(int id) {
        tagMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ListResult<TagDto> queryTagByPage(int pageNum, int pageSize) {

        ListResult<TagDto> listResult = new ListResult<>();

        PageHelper.startPage(pageNum, pageSize);
        Page<TagDto> tagPage = (Page<TagDto>) tagMapper.selectTagsByPage();


        List<TagDto> tagDtos = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(tagPage.getResult())) {
            tagPage.getResult().stream().forEach(dto -> {
                if (dto != null)
                    tagDtos.add(dto);
            });
        }

        listResult.setTotal(tagPage.getTotal());


        listResult.setRows(tagDtos);

        return listResult;
    }
}
