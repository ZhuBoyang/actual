package cn.com.taiji.actual.controller;

import cn.com.taiji.actual.domain.UserInfo;
import cn.com.taiji.actual.service.UserInfoService;
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
    private UserInfoService userInfoService;
    /**
     * 加载用户数据并跳转到首页
     * @return
     */
    @GetMapping("index")
    public String index(Model model){
        List<UserInfo> userList = userInfoService.findAll();
        model.addAttribute("userList",userList);
        return "index";
    }
}
