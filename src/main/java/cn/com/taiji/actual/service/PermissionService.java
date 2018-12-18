package cn.com.taiji.actual.service;

import cn.com.taiji.actual.domain.Permission;
import cn.com.taiji.actual.domain.Role;

import java.util.List;
import java.util.Map;

/**
 * @author zxx
 * @version 1.0
 * @date 2018/12/18 10:21
 */
public interface PermissionService {
    /**
     * 查所有
     * @return
     */
    List<Permission> findAll();
    /**
     * 根据id查询单个
     * @param id
     * @return
     */
    Permission findById(Integer id);
    /**
     * 分页显示权限
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
     * 新增权限
     * @param permission
     */
    void addPermission(Permission permission);

    /**
     * 更新权限
     * @param permission
     */
    void updatePermission(Permission permission);
}
