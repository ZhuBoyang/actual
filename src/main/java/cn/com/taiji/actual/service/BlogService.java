package cn.com.taiji.actual.service;

import cn.com.taiji.actual.domain.Blog;

/**
 * @author Barry
 * @version v1.0
 * @description
 * @date created on 2018/12/18 15:29
 */

public interface BlogService {

    /**
     * 发布一条新的博客
     *
     * @param blog 博客的标题和内容
     */
    void addBlog(Blog blog);
}
