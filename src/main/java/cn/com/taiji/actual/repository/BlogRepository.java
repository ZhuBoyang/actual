package cn.com.taiji.actual.repository;

import cn.com.taiji.actual.domain.Blog;
import cn.com.taiji.actual.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Barry
 * @version v1.0
 * @description 操作博客数据的接口
 * @date created on 2018/12/18 15:37
 */

public interface BlogRepository extends JpaRepository<Blog, Integer>, JpaSpecificationExecutor<Blog> {

    /**
     * 根据用户ID查询用户所有发布的博客
     *
     * @return 该用户下所有的博客
     */
    List<Blog> findByUserInfo(UserInfo userInfo);

    /**
     * 根据id删除(操作状态state=0)
     * @param bid
     * @param state
     */
    @Modifying
    @Query("update Blog set state=:state where bid=:bid")
    void deleteById(@Param("bid") Integer bid, @Param("state") String state);
}
