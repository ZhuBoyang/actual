package cn.com.taiji.actual.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.taiji.actual.domain.UserInfo;
import cn.com.taiji.actual.service.UserInfoService;



@Controller
public class MyHomeController {
	   @Autowired
	    private UserInfoService userInfoService;

	    Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@GetMapping("/home")
	public String home() {
//		 Map pagination = userInfoService.findPagination(1);
//	        int pageSize =(int)pagination.get("total");
//	        List<UserInfo> userList = (List<UserInfo>)pagination.get("users");
//	        model.addAttribute("userList",userList);
//	        model.addAttribute("pageSize",pageSize);
//	        model.addAttribute("page",1);
//		
		
		return "home/home";

}
	
	@RequestMapping("/newhome")
	public String newhome(@PathVariable("num") Model model) {
//		@Query(value = "select name,color from Fruit f where f.name like %:name%")
//		List<> findByNameMatch(@Param("name") String name);
//		
		
		
		
		return "newhome";

}
	
}
