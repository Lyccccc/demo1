package net.coderchen.demo1.service.impl;

import net.coderchen.demo1.dao.BlogArticleMapper;
import net.coderchen.demo1.model.BlogArticle;
import net.coderchen.demo1.service.BlogArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Liuyuchen on 2018/01/22.
 */
@Service
public class BlogArticleServiceImpl implements BlogArticleService{
    @Autowired
    private BlogArticleMapper blogArticleMapper;

    @Override
    public void add(BlogArticle blogArticle) {
        blogArticleMapper.insertSelective(blogArticle);
    }
}
