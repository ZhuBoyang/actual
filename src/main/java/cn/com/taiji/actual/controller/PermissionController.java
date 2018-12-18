package cn.com.taiji.actual.controller;

import cn.com.taiji.actual.domain.Permission;
import cn.com.taiji.actual.domain.Role;
import cn.com.taiji.actual.service.PermissionService;
import cn.com.taiji.actual.untils.Result;
import cn.com.taiji.actual.untils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.soap.Addressing;
import java.util.List;
import java.util.Map;

/**
 * @author zxx
 * @version 1.0
 * @date 2018/12/18 10:30
 */
@Controller
@RequestMapping("permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;
    /**
     * 分页
     * @param num
     * @param model
     * @return
     */
    @GetMapping("page/{num}")
    public String getPage(@PathVariable("num") Integer num, Model model){
        Map pagination = permissionService.findPagination(num);
        int pageSize =(int)pagination.get("total");
        List<Permission> permissionList = (List<Permission>)pagination.get("permissions");
        model.addAttribute("permissionList",permissionList);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("page",num);
        return "/permission/index";
    }
    /**
     * 根据id删除
     * @param id
     * @return
     */
    @GetMapping("delete")
    @ResponseBody
    public Result deleteById(Integer id){
        permissionService.deleteById(id);
        return ResultUtils.Success("删除成功");
    }

    /**
     * 跳转添加页面
     * @param model
     * @return
     */
    @GetMapping("addPage")
    public String addUser(Model model){
        Permission permission = new Permission();
        model.addAttribute("permission",permission);
        return "/permission/edit";
    }
    /**
     * 跳转编辑页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("editPage/{id}")
    public String editUser(@PathVariable("id")Integer id,Model model){
        Permission  permission = permissionService.findById(id);
        model.addAttribute("permission",permission);
        return "/permission/edit";
    }

    /**
     * 新增操作
     * @param permission
     * @return
     */
    @PostMapping("add")
    public String addUser(Permission permission){
        permissionService.addPermission(permission);
        return "redirect:/permission/page/1";
    }

    /**
     * 更新操作
     * @param permission
     * @return
     */
    @PostMapping("edit")
    public String editUser(Permission permission){
        permissionService.updatePermission(permission);
        return "redirect:/permission/page/1";
    }

}
