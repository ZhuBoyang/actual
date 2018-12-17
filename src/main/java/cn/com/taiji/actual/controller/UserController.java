package cn.com.taiji.actual.controller;

import cn.com.taiji.actual.domain.UserInfo;
import cn.com.taiji.actual.service.UserInfoService;
import cn.com.taiji.actual.untils.Result;
import cn.com.taiji.actual.untils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author zxx
 * @version 1.0
 * @date 2018/12/16 23:13
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 分页
     * @param num
     * @param model
     * @return
     */
    @GetMapping("page/{num}")
    public String getPage(@PathVariable("num") Integer num, Model model){
        Map pagination = userInfoService.findPagination(num);
        int pageSize =(int)pagination.get("total");
        List<UserInfo> userList = (List<UserInfo>)pagination.get("users");
        model.addAttribute("userList",userList);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("page",num);
        return "index";
    }
    @GetMapping("delete")
    @ResponseBody
    public Result deleteById(Integer id){
        userInfoService.deleteById(id);
        return ResultUtils.Success("删除成功");
    }
    @GetMapping("addPage")
    public String addUser(Model model){
        UserInfo userInfo = new UserInfo();
        model.addAttribute("userInfo",userInfo);
        return "/user/edit";
    }
    @GetMapping("editPage/{id}")
    public String editUser(@PathVariable("id")Integer id,Model model){
        UserInfo userInfo = userInfoService.findById(id);
        model.addAttribute("userInfo",userInfo);
        return "/user/edit";
    }


    @PostMapping("add")
    public String addUser(UserInfo userInfo){
        userInfoService.addUser(userInfo);
        return "redirect:/user/page/1";
    }

    @PostMapping("edit")
    public String editUser(UserInfo userInfo){
        userInfoService.updateUser(userInfo);
        return "redirect:/user/page/1";
    }

}
