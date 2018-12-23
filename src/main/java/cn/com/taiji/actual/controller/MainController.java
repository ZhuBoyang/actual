package cn.com.taiji.actual.controller;

import cn.com.taiji.actual.domain.Article;
import cn.com.taiji.actual.domain.Blog;
import cn.com.taiji.actual.domain.DiscussionGroup;
import cn.com.taiji.actual.service.ArticleService;
import cn.com.taiji.actual.service.BlogService;
import cn.com.taiji.actual.service.DiscussionGroupService;
import cn.com.taiji.actual.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 * @author zxx
 * @date 2018/12/14 11:38
 * @version 1.0
 */
@Controller
public class MainController {
    @Autowired
    private DiscussionGroupService discussionGroupService;
    @Autowired
    private BlogService blogService;
    @Autowired
     private  ArticleService articleService;


    Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 加载用户数据并跳转到首页
     * @author lqf
     * @return
     */
    @GetMapping("index")
    public String index( Integer num, Model model, Integer bid){
        Map pagination = articleService.findPagination(num,bid);
        int pageSize =(int)pagination.get("total");
        List<DiscussionGroup> discussionGroupList = discussionGroupService.findShow();
        discussionGroupList=discussionGroupList.subList(0,6);
        List<Blog> blogInfo =blogService.findAll();
        blogInfo =blogInfo.subList(0,4);
        model.addAttribute("groupList",discussionGroupList);
        model.addAttribute("blogList",blogInfo);
        model.addAttribute("pageSize",pageSize);

        model.addAttribute("bid",bid);
        return "index";
    }
    @GetMapping("/beforeBlog")
    public String blog(Model model) {
        List<DiscussionGroup> discussionGroupList = discussionGroupService.findShow();
        List<Blog> blogInfo =blogService.findAll();
        model.addAttribute("groupList",discussionGroupList);
        model.addAttribute("blogList",blogInfo);
        return "blog";
    }

    /**
     * 跳转到登录页
     * @author zxx
     * @return 登录页
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/group")
    public String group( Model model){
        List<DiscussionGroup> discussionGroupList = discussionGroupService.findShow();
        model.addAttribute("groupList",discussionGroupList);
        return "group";
    }

    /**
     * 跳转到403页面
     * @author zxx
     * @return  403页面
     */
    @GetMapping("/403")
    public String page403(){
        return "403";
    }

    @GetMapping("/jgroup/{num}")
    public String jgroup(@PathVariable("num") Integer num, Model model, Integer disId){
        logger.info(disId.toString());

        Map pagination = articleService.findPagination(num,disId);
        int pageSize =(int)pagination.get("total");
        List<DiscussionGroup> discussionGroupList = discussionGroupService.findShow();
        List<Article> article = (List<Article>)pagination.get("article");
        model.addAttribute("groupList",discussionGroupList);
        model.addAttribute("articList",article);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("page",num);
        model.addAttribute("disId",disId);
        return "jgroup";
    }
}
