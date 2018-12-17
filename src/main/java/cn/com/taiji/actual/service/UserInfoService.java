package cn.com.taiji.actual.service;

import cn.com.taiji.actual.domain.UserInfo;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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

    /**
     * 分页显示用户
     * @param page
     * @return
     */
    Map findPagination(Integer page);

    /**
     * 删除用户
     * @param id
     */

    void deleteById(Integer id);

}
