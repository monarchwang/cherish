package com.monarchwang.website.service.impl;

import com.monarchwang.website.common.CherishException;
import com.monarchwang.website.dao.mapper.ArticleMapper;
import com.monarchwang.website.dao.mapper.ArticleTagRelationMapper;
import com.monarchwang.website.dao.model.Article;
import com.monarchwang.website.dao.model.ArticleTagRelation;
import com.monarchwang.website.dao.mongo.ArticleDetailMongoDao;
import com.monarchwang.website.dao.mongo.model.ArticleDetail;
import com.monarchwang.website.rest.dto.ArticleDto;
import com.monarchwang.website.service.ArticleService;
import com.monarchwang.website.utils.ExceptionEnum;
import com.monarchwang.website.utils.Page;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;

/**
 * 文章Service
 * Created by wanggl on 2017/8/2.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleDetailMongoDao articleDetailMongoDao;

    @Autowired
    private ArticleTagRelationMapper articleTagRelationMapper;


    @Override
    @Transactional
    public int saveOrUpdate(ArticleDto articleDto) {

        int sum = 0;

        if (articleDto.getId() != -1 && articleDto.getId() != 0) {
            //更新文章
            Article article = articleMapper.selectByPrimaryKey(articleDto.getId());
            if (null == article) {
                throw new CherishException(ExceptionEnum.CANNOT_FIND_ARTICLE);
            }

            if (StringUtils.isNotEmpty(articleDto.getBrief())) {
                article.setBrief(articleDto.getBrief());
            }
            if (StringUtils.isNotEmpty(articleDto.getTitle())) {
                article.setTitle(articleDto.getTitle());
            }
            //更新标签与文章的关联关系
            List<Integer> tagIds = articleDto.getTagIds();
            if (CollectionUtils.isNotEmpty(tagIds)) {
                //首先删除原有的标签和文章的关联关系，再保存新的关联关系
                articleTagRelationMapper.deleteByArticleId(articleDto.getId());
                tagIds.stream().forEach(tagId -> {
                    ArticleTagRelation relation = new ArticleTagRelation();
                    relation.setArticleId(articleDto.getId());
                    relation.setTagId(tagId);
                    articleTagRelationMapper.insertSelective(relation);
                });
            }
            //更新保存在mongodb中的文章内容
            articleDetailMongoDao.update(query(where("id").is(article.getContentId())),
                    update("age", 35).set("brief", articleDto.getBrief())
                            .set("content", articleDto.getContent())
                            .set("tags", articleDto.getTags())
                            .set("title", articleDto.getTitle())
                            .set("updateTime", new Date()));

            //更新mysql中文章数据
            articleMapper.updateByPrimaryKeySelective(article);
            sum = article.getId();

        } else {
            //新增文章

            //首先新增文章详情至mongodb
            ArticleDetail detail = new ArticleDetail();
            detail.setId(UUID.randomUUID().toString());
            detail.setTitle(articleDto.getTitle());
            detail.setTags(articleDto.getTags());
            detail.setContent(articleDto.getContent());
            detail.setBrief(articleDto.getBrief());
            detail.setCreateTime(new Date());
            detail.setUpdateTime(new Date());
            articleDetailMongoDao.save(detail);

            //新增mysql中文章数据
            Article article = new Article();
            article.setTitle(articleDto.getTitle());
            article.setBrief(articleDto.getBrief());
            article.setContentId(detail.getId());
            article.setUserId(0);
            article.setDeleteFlag((byte) 0);
            article.setLastModifiedBy("admin");
            article.setStatus((byte) articleDto.getType());
            article.setCreateTime(new Date());
            article.setUpdateTime(new Date());
            articleMapper.insertUseGeneratedKeys(article);

            sum = article.getId();

            //新增标签与文章的关联关系
            List<Integer> tagIds = articleDto.getTagIds();
            if (CollectionUtils.isNotEmpty(tagIds)) {
                tagIds.stream().forEach(tagId -> {
                    ArticleTagRelation relation = new ArticleTagRelation();
                    relation.setArticleId(articleDto.getId());
                    relation.setTagId(article.getId());
                    articleTagRelationMapper.insertSelective(relation);
                });
            }

        }
        return sum;
    }


    @Override
    public Page<Article> findByPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public ArticleDto findArticleById(int id) {
        return null;
    }

    @Override
    public void deleteArticleById(int id) {

    }
}
