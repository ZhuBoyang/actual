package cn.com.taiji.actual.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zxx
 * @date 2018/12/14 11:38
 * @version 1.0
 */
@Controller
public class MainController {
    /**
     * 跳转到首页
     * @return
     */
    @GetMapping("index")
    public String index(){
        return "index";
    }
}
