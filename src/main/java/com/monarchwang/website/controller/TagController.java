package com.monarchwang.website.controller;

import com.monarchwang.website.dao.mybatis.model.Tag;
import com.monarchwang.website.controller.dto.TagDto;
import com.monarchwang.website.service.TagService;
import com.monarchwang.website.utils.response.ListResult;
import com.monarchwang.website.utils.response.RespStatus;
import com.monarchwang.website.utils.response.ResponseData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 标签Controller
 * Created by liang on 2017/8/1.
 */
@RestController
@RequestMapping("/tag/")
@CrossOrigin
public class TagController {

    @Resource
    private TagService tagService;

    @PostMapping("create")
    public ResponseData<String> create(String tagName) {
        ResponseData<String> responseData = new ResponseData<>();

        if (StringUtils.isNotEmpty(tagName)) {
            Tag tag = tagService.queryByName(tagName);
            if (null != tag) {
                //判断标签是否被软删除
                if (tag.getDeleteFlag() == 0) {
                    responseData.setStatus(RespStatus.FAIL);
                    responseData.setMsg("标签名称已存在");
                } else {
                    tag.setDeleteFlag((byte) 0);
                    tagService.update(tag);
                }
            } else {
                tag = new Tag();
                tag.setName(tagName);
                tag.setStatus((byte) 1);
                tagService.saveTag(tag);
            }
        } else {
            responseData.setStatus(RespStatus.FAIL);
            responseData.setMsg("标签名称不能为空");
        }
        return responseData;
    }

    @GetMapping("query")
    public ResponseData<ListResult<TagDto>> queryTag(Integer pageNum, Integer pageSize, Integer status) {

        ResponseData<ListResult<TagDto>> responseData = new ResponseData<>();

        responseData.setData(tagService.queryTagByPage(pageNum, pageSize, status));

        return responseData;
    }


    @PostMapping("update")
    public ResponseData<String> update(Integer id, Integer status) {
        ResponseData<String> responseData = new ResponseData<>();

        if (id == null) {
            responseData.setStatus(RespStatus.FAIL);
            responseData.setMsg("id不能为空");
        } else {
            tagService.updateTagStatus(id, status);
        }

        return responseData;
    }

    @GetMapping("delete")
    public ResponseData<String> delete(Integer id) {
        ResponseData<String> responseData = new ResponseData<>();

        if (id == null) {
            responseData.setStatus(RespStatus.FAIL);
            responseData.setMsg("id不能为空");
        } else {
            tagService.deleteTagById(id);
        }

        return responseData;
    }

}
