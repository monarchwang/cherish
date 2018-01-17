package com.monarchwang.website.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.monarchwang.website.dao.mybatis.mapper.ArticleMapper;
import com.monarchwang.website.dao.mybatis.mapper.TagMapper;
import com.monarchwang.website.dao.mybatis.model.Tag;
import com.monarchwang.website.utils.response.ListResult;
import com.monarchwang.website.controller.dto.TagDto;
import com.monarchwang.website.service.TagService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 标签Service 实现类
 * Created by liang on 2017/8/1.
 */
@Service
public class TagServiceImpl implements TagService {

    @Resource
    private TagMapper tagMapper;
    @Resource
    private ArticleMapper articleMapper;

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
            listResult.setPages(tagPage.getPages());
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

    @Override
    public ListResult<TagDto> getAllTags(String tagName) {
        ListResult<TagDto> listResult = new ListResult<>();

        List<Tag> tags = null;
        if (StringUtils.isNotEmpty(tagName)) {
            Tag example = new Tag();
            example.setName(tagName);
            tags = tagMapper.selectByExample(example);
        } else {
            tags = tagMapper.selectAll();
        }
        List<TagDto> tagDtos = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(tags)) {
            tags.forEach(t -> {
                if (t.getDeleteFlag() != 1) {
                    TagDto dto = new TagDto();
                    BeanUtils.copyProperties(t, dto);
                    tagDtos.add(dto);
                }
            });
        }

        Integer articleCount = articleMapper.getArticleCount();
        listResult.setRows(tagDtos);
        listResult.setTotal(articleCount);
        return listResult;
    }
}
