package cn.com.taiji.actual.repository;

import cn.com.taiji.actual.domain.DiscussionGroup;
import cn.com.taiji.actual.domain.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author LWL
 * @version 1.0
 * @description
 * @date 2018/12/17 11:20
 */
public interface DiscussionGroupRepository extends JpaRepository<DiscussionGroup,Integer>,JpaSpecificationExecutor<DiscussionGroup> {

    /**
     * 根据id删除
     * @param did
     * @param state
     */
    @Modifying
    @Query("update DiscussionGroup set state=:state where did=:did")
    void deleteById(@Param("did") Integer did, @Param("state") String state);


}
