package cn.com.taiji.actual.service.impl;

import cn.com.taiji.actual.domain.UserInfo;
import cn.com.taiji.actual.repository.UserInfoRepository;
import cn.com.taiji.actual.service.UserInfoService;
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
 * 用户相关操作Service的实现类
 * @author zxx
 * @version 1.0
 * @date 2018/12/16 20:35
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findById(Integer id) {
        return userInfoRepository.findOne(id);
    }

    @Override
    public List<UserInfo> findAll() {
        return userInfoRepository.findAll();
    }

    @Override
    public Map findPagination(Integer page) {
        Integer pageNum = 10;
        //生成pageable
        Map map = new HashMap(16);
        map.put("page",page);
        map.put("pageSize",10);
        Pageable pageable = PaginationUntil.getPage(map);
        //构建查询条件
        Specification<UserInfo> specification = new Specification<UserInfo>() {
            @Override
            public Predicate toPredicate(Root<UserInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                // 查询出未删除的
                predicates.add(cb.equal(root.<Integer>get("state"), 1));
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
        Page<UserInfo> pageList = userInfoRepository.findAll(specification, pageable);
        Map result = new HashMap(16);
        int pageSize = (int)pageList.getTotalElements();
        if(pageSize%pageNum==0){
            result.put("total",pageSize/pageNum);
        }else{
            result.put("total",(pageSize/pageNum)+1);
        }
        result.put("page", pageList.getNumber()+1);
        List<UserInfo> list = pageList.getContent();
        result.put("users",list);
        return result;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void deleteById(Integer id) {
        userInfoRepository.deleteById(id,"0");
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfo.setCreateDate(new Date());
        userInfo.setPassword("123456");
        userInfo.setState("1");
        userInfoRepository.saveAndFlush(userInfo);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        UserInfo user = userInfoRepository.findOne(userInfo.getUid());
        user.setUsername(userInfo.getUsername());
        user.setEmail(userInfo.getEmail());
        user.setPhoneNumber(userInfo.getPhoneNumber());
        userInfoRepository.saveAndFlush(user);
    }
}