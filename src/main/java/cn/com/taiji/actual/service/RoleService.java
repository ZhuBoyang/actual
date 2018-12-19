package cn.com.taiji.actual.service;

import cn.com.taiji.actual.domain.Permission;
import cn.com.taiji.actual.domain.Role;
import cn.com.taiji.actual.domain.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 角色相关操作的Service
 * @author zxx
 * @version 1.0
 * @date 2018/12/17 15:37
 */
public interface RoleService {
    /**
     * 查所有未删除的
     * @param state
     * @return
     */
    List<Role> findByState(String state);


    /**
     * 根据id查询单个
     * @param id
     * @return
     */
    Role findById(Integer id);
    /**
     * 分页显示角色
     * @param page
     * @return
     */
    Map findPagination(Integer page);

    /**
     * 删除角色
     * @param id
     */

    void deleteById(Integer id);

    /**
     * 新增角色
     * @param role
     */
    void addRole(Role role);

    /**
     * 更新角色
     * @param role
     */
    void updateRole(Role role);

    /**
     * 更新角色权限
     * @param role
     */
    void updateRolePermission(Role role);
}
