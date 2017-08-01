package com.monarchwang.website.rest;

import com.monarchwang.website.dao.model.Tag;
import com.monarchwang.website.rest.dto.out.ListData;
import com.monarchwang.website.rest.dto.out.TagDto;
import com.monarchwang.website.service.TagService;
import com.monarchwang.website.utils.ResponseData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 标签Controller
 * Created by liang on 2017/8/1.
 */
@RestController
@RequestMapping("/tag/")
public class TagController {

    @Resource
    private TagService tagService;

    @PostMapping("create")
    public ResponseData<String> create(String tagName) {
        ResponseData<String> responseData = new ResponseData<>();

        if (StringUtils.isNotEmpty(tagName)) {
            Tag tag = tagService.queryByName(tagName);
            if (null != tag) {
                responseData.setCode(1);
                responseData.setMsg("标签名称不能为空");
            } else {
                tag = new Tag();
                tag.setName(tagName);
                tag.setStatus((byte) 1);
                tagService.saveTag(tag);
            }
        }
        return responseData;
    }

    @GetMapping("query")
    public ResponseData<ListData<TagDto>> queryTag(Integer pageNum, Integer pageSize) {

        ResponseData<ListData<TagDto>> responseData = new ResponseData<>();

        responseData.setData(tagService.queryTagByPage(pageNum, pageSize));

        return responseData;
    }

}
