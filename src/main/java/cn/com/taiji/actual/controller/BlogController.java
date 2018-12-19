package cn.com.taiji.actual.controller;

import cn.com.taiji.actual.domain.Blog;
import cn.com.taiji.actual.domain.UserInfo;
import cn.com.taiji.actual.domain.Permission;
import cn.com.taiji.actual.service.BlogService;
import cn.com.taiji.actual.service.UserInfoService;
import cn.com.taiji.actual.service.impl.BlogServiceImpl;
import cn.com.taiji.actual.untils.Result;
import cn.com.taiji.actual.untils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Barry
 * @version v1.0
 * @description
 * @date created on 2018/12/17 11:29
 */

@Controller
@RequestMapping("blog")
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

    @GetMapping("/showBlog")
    public String showBlog(Blog blog, Model model) {
        Blog blogInfo = blogServiceImpl.findBlogByBName(blog);
        model.addAttribute("blogInfo", blogInfo);
        model.addAttribute("blogAuthor", "ceshi");
        return "public/blog-content";
    }

    /**
     * 分页
     * @param num
     * @param model
     * @return
     */
    @GetMapping("page/{num}")
    public String getPage(@PathVariable("num") Integer num, Model model){
        Map pagination = blogServiceImpl.findPagination(num);
        int pageSize =(int)pagination.get("total");
        List<Blog> permissionList = (List<Blog>)pagination.get("blogs");
        model.addAttribute("blogList",permissionList);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("page",num);
        return "/blog/index";
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @GetMapping("delete")
    @ResponseBody
    public Result deleteById(Integer id){
        blogServiceImpl.deleteById(id);
        return ResultUtils.Success("删除成功");
    }
    /**
     * 跳转查看页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("contentPage/{id}")
    public String editUser(@PathVariable("id")Integer id,Model model){
        Blog blog= blogServiceImpl.findById(id);
        model.addAttribute("blog",blog);
        return "/blog/edit";
    }
}
