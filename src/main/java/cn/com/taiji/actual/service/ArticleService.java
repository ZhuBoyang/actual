package cn.com.taiji.actual.service;

import cn.com.taiji.actual.domain.Article;

/**
 * @author Barry
 * @version v1.0
 * @description
 * @date created on 2018/12/20 9:18
 */

public interface ArticleService {

    /**
     * 发布一个新的帖子
     *
     * @param article 帖子的标题
     * @param content 帖子的内容
     */
    void addArticle(Article article, String content);

    /**
     * 根据帖子标题查询帖子
     *
     * @param articleName 帖子名
     * @return 帖子的所有内容
     */
    Article findArticleByAName(String articleName);
}
