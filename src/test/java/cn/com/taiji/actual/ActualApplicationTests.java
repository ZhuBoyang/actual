package cn.com.taiji.actual;

import cn.com.taiji.actual.domain.UserInfo;
import cn.com.taiji.actual.repository.UserInfoRepository;
import cn.com.taiji.actual.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ActualApplicationTests {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserInfoRepository userInfoRepository;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {
        userInfoService.deleteById(5);
    }

}

