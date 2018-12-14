package cn.com.taiji.actual.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: zxx
 * @Date: 2018/12/14 11:38
 * @Version 1.0
 */
@Controller
public class MainController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
