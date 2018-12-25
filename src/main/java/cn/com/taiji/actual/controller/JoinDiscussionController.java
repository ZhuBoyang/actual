package cn.com.taiji.actual.controller;

import cn.com.taiji.actual.domain.UserInfo;
import cn.com.taiji.actual.service.impl.UserInfoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author LWL
 * @version 1.0
 * @description
 * @date 2018/12/24 10:11
 */
@Controller
public class JoinDiscussionController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserInfoServiceImpl userInfoServiceImpl;

    @RequestMapping("/home")
    public String findName(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserInfo userInfo = userInfoServiceImpl.findByUsername(user.getUsername());
        model.addAttribute("DisGroupList", userInfo.getDisGroupList());
        model.addAttribute("BlogList", userInfo.getBlogList());
        return "home/home";
    }
}
