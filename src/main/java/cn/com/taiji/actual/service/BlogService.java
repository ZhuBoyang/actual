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

    /**
     * 根据博客名查询博客的详细信息
     *
     * @param blog 博客名
     * @return 博客的详细信息
     */
    Blog findBlogByBName(Blog blog);
}
