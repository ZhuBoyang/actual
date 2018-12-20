package cn.com.taiji.actual.untils;

import cn.com.taiji.actual.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author zxx
 * @version 1.0
 * @date 2018/12/19 19:33
 */
@Component
public class initRunner implements CommandLineRunner {
    @Autowired
    private UserInfoService userInfoService;
    @Override
    public void run(String... args) throws Exception {
        userInfoService.findAll();
    }
}
