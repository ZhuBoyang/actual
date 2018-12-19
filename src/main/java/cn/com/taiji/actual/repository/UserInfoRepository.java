package cn.com.taiji.actual.repository;

import cn.com.taiji.actual.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author zxx
 * @date 2018/12/14 11:39
 * @version 1.0
 */
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer>, JpaSpecificationExecutor<UserInfo> {
    /**
     * 根据id删除(操作状态state=0)
     * @param uid
     * @param state
     */
    @Modifying
    @Query("update UserInfo set state=:state where uid=:uid")
    void deleteById(@Param("uid") Integer uid, @Param("state") String state);

    /**
     * 根据用户名查找
     * @param username
     * @return
     */
    UserInfo findByUsername(String username);

}
