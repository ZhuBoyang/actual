package cn.com.taiji.actual.service.Impl;

import cn.com.taiji.actual.domain.UserInfo;
import cn.com.taiji.actual.repository.UserInfoRepository;
import cn.com.taiji.actual.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zxx
 * @version 1.0
 * @date 2018/12/16 20:35
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public List<UserInfo> findAll() {
        return userInfoRepository.findAll();
    }
}
