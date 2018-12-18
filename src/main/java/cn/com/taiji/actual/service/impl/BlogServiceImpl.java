package cn.com.taiji.actual.service.impl;

import cn.com.taiji.actual.domain.Blog;
import cn.com.taiji.actual.domain.UserInfo;
import cn.com.taiji.actual.repository.BlogRepository;
import cn.com.taiji.actual.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Barry
 * @version v1.0
 * @description
 * @date created on 2018/12/18 15:29
 */

@Service
public class BlogServiceImpl implements BlogService {

    private BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public void addBlog(Blog blog) {
        blog.setCreateDate(new Date());
        blog.setState("1");
        UserInfo userInfo = new UserInfo();
        userInfo.setUid(1);
        blog.setUserInfo(userInfo);
        blogRepository.saveAndFlush(blog);
    }

}
