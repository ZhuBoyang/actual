package cn.com.taiji.actual.repository;

import cn.com.taiji.actual.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

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
    List<Blog> findByUserInfo();
}
