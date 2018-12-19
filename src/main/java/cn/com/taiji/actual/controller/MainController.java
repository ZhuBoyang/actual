package cn.com.taiji.actual.controller;

import cn.com.taiji.actual.domain.Blog;
import cn.com.taiji.actual.domain.UserInfo;
import cn.com.taiji.actual.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    private UserInfoService userInfoService;

    Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 加载用户数据并跳转到首页
     * @return
     */
    @GetMapping("index")
    public String index(Model model){
        Map pagination = userInfoService.findPagination(1);
        int pageSize =(int)pagination.get("total");
        List<UserInfo> userList = (List<UserInfo>)pagination.get("users");
        model.addAttribute("userList",userList);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("page",1);
        return "index";
    }
    @GetMapping("Mblog")
    public String Mblog(){
        return "public/Mblog";
    }
//    @RequestMapping("/findblog.do")
//    public Map findblog() {
//        List<Blog> blogList = blogService.findblog();
//        List blogName = new BlogInfot();
//        List blogContent = new BlogInfot();
//        List blogcreateDate = new BlogInfot();
//        for (Blog blog : blogList) {
//            blogName.add(blog.getbName());
//            blogContent.add(blog.getbContent());
//            blogcreateDate.add(blog.getCreateDate());
//        }
//        Map map = new HashMap();
//        map.put("blogName", blogName);
//        map.put("blogContent", blogContent);
//        map.put("blogcreateDate", blogcreateDate);
//        System.out.println(JSON.toJSONString(map));
//        return map;
//    }


}
