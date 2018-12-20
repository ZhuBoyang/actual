package cn.com.taiji.actual.service;

import cn.com.taiji.actual.domain.Article;

import java.util.List;
import java.util.Map;

/**
 * @author LWL
 * @version 1.0
 * @description
 * @date 2018/12/20 10:56
 */

public interface ArticleService {

    /**
     * @author LWL
     * 分页查询所有帖子
     * @return
     */
    Map findPagination(Integer page);

    List<Article> findById();
}
