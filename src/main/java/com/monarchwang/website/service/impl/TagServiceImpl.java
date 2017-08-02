package com.monarchwang.website.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.monarchwang.website.dao.mapper.ArticleTagRelationMapper;
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
    public int updateTagStatus(int id, int status) {
        return tagMapper.updateTagStatus(id, status);
    }

    @Override
    public void deleteTagById(int id) {

        tagMapper.deleteTagById(id);
    }

    @Override
    public ListResult<TagDto> queryTagByPage(Integer pageNum, Integer pageSize, Integer status) {

        ListResult<TagDto> listResult = new ListResult<>();
        List<TagDto> tagDtos = Lists.newArrayList();


        if (pageNum != null && pageSize != null) {
            //需要分页
            PageHelper.startPage(pageNum, pageSize);
            Page<TagDto> tagPage = (Page<TagDto>) tagMapper.selectTagsByStatus(status);
            if (CollectionUtils.isNotEmpty(tagPage.getResult())) {
                List<TagDto> finalTagDtos = tagDtos;
                tagPage.getResult().stream().forEach(dto -> {
                    if (dto != null)
                        finalTagDtos.add(dto);
                });
            }
            listResult.setTotal(tagPage.getTotal());
        } else {
            //不需要分页
            tagDtos = tagMapper.selectTagsByStatus(status);
        }


        listResult.setRows(tagDtos);

        return listResult;
    }

    @Override
    public void update(Tag tag) {
        tagMapper.updateByPrimaryKeySelective(tag);
    }
}
