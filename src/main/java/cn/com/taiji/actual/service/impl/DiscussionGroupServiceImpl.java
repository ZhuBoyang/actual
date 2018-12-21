package cn.com.taiji.actual.service.impl;
import cn.com.taiji.actual.domain.DiscussionGroup;
import cn.com.taiji.actual.repository.DiscussionGroupRepository;
import cn.com.taiji.actual.service.DiscussionGroupService;
import cn.com.taiji.actual.untils.PaginationUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

/**
 * @author LWL
 * @version 1.0
 * @description
 * @date 2018/12/17 11:18
 */
@Service
public class DiscussionGroupServiceImpl implements DiscussionGroupService {

    @Autowired
    DiscussionGroupRepository discussionGroupRepository;

    @Override
    public List<DiscussionGroup> findAll() {
        return discussionGroupRepository.findAll();
    }


    @Override
    public Map findPagination(Integer page) {
        //生成pageable
        Map map = new HashMap();
        map.put("page",page);
        map.put("pageSize",10);
        Pageable pageable = PaginationUntil.getPage(map);
        //构建查询条件
        Specification<DiscussionGroup> specification = new Specification<DiscussionGroup>() {
            @Override
            public Predicate toPredicate(Root<DiscussionGroup> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                // 查询出未删除的
                predicates.add(cb.equal(root.<Integer>get("state"), 1));
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
        Page<DiscussionGroup> pageList = discussionGroupRepository.findAll(specification, pageable);
        Map result = new HashMap();
        int pageSize = (int)pageList.getTotalElements();
        if(pageSize%10==0){
            result.put("total",pageSize/10);
        }else{
            result.put("total",(pageSize/10)+1);
        }
        result.put("page", pageList.getNumber()+1);
        List<DiscussionGroup> list = pageList.getContent();
        result.put("discussions",list);
        return result;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void deleteById(Integer id) {
        discussionGroupRepository.deleteById(id,"0");

    }

    @Override
    public void addDiscussion(DiscussionGroup discussionGroup) {
        discussionGroup.setCreateDate(new Date());
        discussionGroup.setState("1");
        discussionGroupRepository.saveAndFlush(discussionGroup);
    }

    @Override
    public void updateDiscussion(DiscussionGroup discussionGroup) {
        DiscussionGroup discussionGroup1 = discussionGroupRepository.findOne(discussionGroup.getDid());
            discussionGroup1.setDiscussionName(discussionGroup.getDiscussionName());
        discussionGroupRepository.saveAndFlush(discussionGroup1);
        }

    @Override
    public DiscussionGroup findById(Integer id) {
        return discussionGroupRepository.findOne(id);
    }

    @Override
    public List <DiscussionGroup> findShow(){
        List <DiscussionGroup> discussionGroups=discussionGroupRepository.findByStateOrderByCreateDateDesc("1");
        List<DiscussionGroup> result =discussionGroups.subList(0,6);
        return result;
    }

    @Override
    @javax.transaction.Transactional
    public void deleteArticleById(Integer id) {
        discussionGroupRepository.deleteArticleById(id,"0");

        }
    }



