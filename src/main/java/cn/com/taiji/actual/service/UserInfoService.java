package cn.com.taiji.actual.service;

import cn.com.taiji.actual.domain.UserInfo;

import java.util.List;

/**
 * @author zxx
 * @version 1.0
 * @date 2018/12/14 16:40
 */
public interface UserInfoService {
    /**
     * 查询所有用户
     * @return
     */
    List<UserInfo> findAll();
}
