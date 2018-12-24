package cn.com.taiji.actual.controller;

import cn.com.taiji.actual.domain.UserInfo;
import cn.com.taiji.actual.service.impl.UserInfoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String findName(@RequestParam("username") String username, Model model){

        UserInfo user = userInfoServiceImpl.findByUsername(username);

        model.addAttribute("DisGroupList",user.getDisGroupList());
        model.addAttribute("BlogList",user.getBlogList());
        return "home/home";
    }
}
