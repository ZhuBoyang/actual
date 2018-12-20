package cn.com.taiji.actual.controller;

import cn.com.taiji.actual.domain.Blog;
import cn.com.taiji.actual.domain.DiscussionGroup;
import cn.com.taiji.actual.service.BlogService;
import cn.com.taiji.actual.service.DiscussionGroupService;
import cn.com.taiji.actual.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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


    Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 加载用户数据并跳转到首页
     * @return
     */
    @GetMapping("index")
    public String index(Model model){
        List<DiscussionGroup> discussionGroupList = discussionGroupService.findShow();
        List<Blog> blogInfo =blogService.findAll();
        model.addAttribute("groupList",discussionGroupList);
        model.addAttribute("blogList",blogInfo);
        return "index";
    }
    @GetMapping("/blog")
    public String blog(Model model) {
        List<DiscussionGroup> discussionGroupList = discussionGroupService.findShow();
        List<Blog> blogInfo =blogService.findAll();
        model.addAttribute("groupList",discussionGroupList);
        model.addAttribute("blogList",blogInfo);
        return "blog";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/group")
    public String group(Model model){
        List<DiscussionGroup> discussionGroupList = discussionGroupService.findShow();
        List<Blog> blogInfo =blogService.findAll();
        model.addAttribute("groupList",discussionGroupList);
        model.addAttribute("blogList",blogInfo);
        return "group";
    }

    @GetMapping("/403")
    public String page403(){
        return "403";
    }
}
