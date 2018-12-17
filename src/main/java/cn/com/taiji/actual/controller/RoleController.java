package cn.com.taiji.actual.controller;

import cn.com.taiji.actual.domain.Role;
import cn.com.taiji.actual.domain.UserInfo;
import cn.com.taiji.actual.service.RoleService;
import cn.com.taiji.actual.untils.Result;
import cn.com.taiji.actual.untils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author zxx
 * @version 1.0
 * @date 2018/12/17 15:40
 */
@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    /**
     * 分页
     * @param num
     * @param model
     * @return
     */
    @GetMapping("page/{num}")
    public String getPage(@PathVariable("num") Integer num, Model model){
        Map pagination = roleService.findPagination(num);
        int pageSize =(int)pagination.get("total");
        List<Role> roleList = (List<Role>)pagination.get("roles");
        model.addAttribute("roleList",roleList);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("page",num);
        return "/role/index";
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @GetMapping("delete")
    @ResponseBody
    public Result deleteById(Integer id){
        roleService.deleteById(id);
        return ResultUtils.Success("删除成功");
    }

    /**
     * 跳转添加页面
     * @param model
     * @return
     */
    @GetMapping("addPage")
    public String addUser(Model model){
        Role role = new Role();
        model.addAttribute("role",role);
        return "/role/edit";
    }

    /**
     * 跳转编辑页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("editPage/{id}")
    public String editUser(@PathVariable("id")Integer id,Model model){
        Role role = roleService.findById(id);
        model.addAttribute("role",role);
        return "/role/edit";
    }
    /**
     * 新增操作
     * @param role
     * @return
     */
    @PostMapping("add")
    public String addUser(Role role){
        roleService.addRole(role);
        return "redirect:/role/page/1";
    }

    /**
     * 更新操作
     * @param role
     * @return
     */
    @PostMapping("edit")
    public String editUser(Role role){
        roleService.updateRole(role);
        return "redirect:/role/page/1";
    }
}