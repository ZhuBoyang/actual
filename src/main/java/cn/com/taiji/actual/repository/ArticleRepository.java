package cn.com.taiji.actual.repository;

import cn.com.taiji.actual.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author LWL
 * @version 1.0
 * @description
 * @date 2018/12/20 10:51
 */
public interface ArticleRepository extends JpaRepository<Article,Integer>,JpaSpecificationExecutor<Article> {

    @Query("select Article from Article where disGroup=:disGroup")
    List<Article> selectById(@Param("disGroup") Integer disGroup);



}
