package cn.com.taiji.actual.service.impl;

import cn.com.taiji.actual.domain.Article;
import cn.com.taiji.actual.domain.DiscussionGroup;
import cn.com.taiji.actual.domain.UserInfo;
import cn.com.taiji.actual.repository.ArticleRepository;
import cn.com.taiji.actual.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Barry
 * @version v1.0
 * @description
 * @date created on 2018/12/20 9:19
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void addArticle(Article article, String content) {
        logger.info("article's name is {} and content is {}", article.getAName(), content);
        article.setAContent(content.getBytes());
        article.setCreateDate(new Date());
        article.setState("1");

        DiscussionGroup group = new DiscussionGroup();
        group.setDid(1);
        article.setDisGroup(group);

        UserInfo userInfo = new UserInfo();
        userInfo.setUid(1);
        article.setUserInfo(userInfo);

        articleRepository.saveAndFlush(article);
    }

    @Override
    public Article findArticleByAName(String articleName) {
        return articleRepository.findArticleByAName(articleName);
    }

}
