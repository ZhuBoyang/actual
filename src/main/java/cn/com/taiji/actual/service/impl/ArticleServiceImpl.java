package cn.com.taiji.actual.service.impl;
import cn.com.taiji.actual.domain.Article;
import cn.com.taiji.actual.domain.DiscussionGroup;
import cn.com.taiji.actual.domain.UserInfo;
import cn.com.taiji.actual.repository.ArticleRepository;
import cn.com.taiji.actual.service.ArticleService;
import cn.com.taiji.actual.untils.PaginationUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.*;

/**
 * @author Barry
 * @version v1.0
 * @description
 * @date created on 2018/12/20 9:19
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void addArticle(Article article, String content) {
        logger.info("article's name is {} and content is {}", article.getAName(), content);
        article.setAContent(content.getBytes());
        article.setCreateDate(new Date());
        article.setState("1");

        DiscussionGroup group = new DiscussionGroup();
        group.setDid(1);
        article.setDisGroup(group);

        UserInfo userInfo = new UserInfo();
        userInfo.setUid(1);
        article.setUserInfo(userInfo);

        articleRepository.saveAndFlush(article);
    }

    @Override
    public Article findArticleByAName(String articleName) {
        return articleRepository.findArticleByAName(articleName);
    }



    @Override
    public Map findPagination(Integer page,Integer disId) {
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
                Join<DiscussionGroup,Article> joins = root.join("DisGroup");
                // 查询出未删除的
                predicates.add(cb.equal(joins.get("did"), disId));
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
