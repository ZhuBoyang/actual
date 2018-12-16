package cn.com.taiji.actual;

import cn.com.taiji.actual.repository.UserInfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActualApplicationTests {
    @Autowired
    UserInfoRepository userInfoRepository;

    @Test
    public void contextLoads() {
        userInfoRepository.findAll();
    }

}

