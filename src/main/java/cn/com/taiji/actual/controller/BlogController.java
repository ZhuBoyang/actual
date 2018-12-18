package cn.com.taiji.actual.controller;

import cn.com.taiji.actual.domain.Blog;
import cn.com.taiji.actual.service.BlogService;
import cn.com.taiji.actual.service.impl.BlogServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author Barry
 * @version v1.0
 * @description
 * @date created on 2018/12/17 11:29
 */

@Controller
public class BlogController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private BlogService blogServiceImpl;

    @Autowired
    public BlogController(BlogService blogServiceImpl) {
        this.blogServiceImpl = blogServiceImpl;
    }

    @GetMapping("/md")
    public String markdown() {
        return "public/blog";
    }

    @GetMapping("/releaseBlog")
    @ResponseBody
    public String releaseBlog(Blog blog) {
        logger.info("blog's info is {}", blog);
        blogServiceImpl.addBlog(blog);
        return "str";
    }
}
