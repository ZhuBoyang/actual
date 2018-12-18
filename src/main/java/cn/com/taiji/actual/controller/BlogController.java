package cn.com.taiji.actual.controller;

import cn.com.taiji.actual.domain.Blog;
import cn.com.taiji.actual.domain.UserInfo;
import cn.com.taiji.actual.service.BlogService;
import cn.com.taiji.actual.service.UserInfoService;
import cn.com.taiji.actual.service.impl.BlogServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private UserInfoService userInfoServiceImpl;

    @Autowired
    public BlogController(BlogService blogServiceImpl,
                          UserInfoService userInfoServiceImpl) {
        this.blogServiceImpl = blogServiceImpl;
        this.userInfoServiceImpl = userInfoServiceImpl;
    }

    @GetMapping("/addBlog")
    public String addBlog() {
        return "public/blog";
    }

    @GetMapping("/blogContent")
    @ResponseBody
    public String releaseBlog(Blog blog) {
        logger.info("blog's info is {}", blog);
        blogServiceImpl.addBlog(blog);
        return "str";
    }

    @GetMapping("/showBlog")
    public String showBlog(Blog blog, Model model) {
        Blog blogInfo = blogServiceImpl.findBlogByBName(blog);
        model.addAttribute("blogInfo", blogInfo);
        model.addAttribute("blogAuthor", "ceshi");
        return "public/blog-content";
    }
}
