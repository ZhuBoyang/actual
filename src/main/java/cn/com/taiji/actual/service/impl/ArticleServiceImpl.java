package cn.com.taiji.actual.service.Impl;

import cn.com.taiji.actual.domain.Article;
import cn.com.taiji.actual.domain.DiscussionGroup;
import cn.com.taiji.actual.repository.ArticleRepository;
import cn.com.taiji.actual.service.ArticleService;
import cn.com.taiji.actual.untils.PaginationUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LWL
 * @version 1.0
 * @description
 * @date 2018/12/20 10:57
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Override
    public List<Article> findById() {
        return null;
    }

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public Map findPagination(Integer page) {
        //生成pageable
        Map map = new HashMap();
        map.put("page",page);
        map.put("pageSize",10);
        Pageable pageable = PaginationUntil.getPage(map);
        //构建查询条件
        Specification<Article> specification = new Specification<Article>() {
            @Override
            public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                // 查询出未删除的
                predicates.add(cb.equal(root.<Integer>get("state"), 1));
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
        Page<Article> pageList = articleRepository.findAll(specification, pageable);
        Map result = new HashMap();
        int pageSize = (int)pageList.getTotalElements();
        if(pageSize%10==0){
            result.put("total",pageSize/10);
        }else{
            result.put("total",(pageSize/10)+1);
        }
        result.put("page", pageList.getNumber()+1);
        List<Article> list = pageList.getContent();
        result.put("article",list);
        return result;
    }



}
