package com.stylefeng.guns.user.modular.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.api.user.UserAPI;
import org.springframework.stereotype.Component;

/**
 * 测试dubbo是否打通user和api
 */
@Component
@Service(interfaceClass = UserAPI.class)
public class UserAPIImpl implements UserAPI {
    @Override
    public boolean login(String username, String password) {
        System.out.println("this is user service!!"+username+","+password);
        return false;
    }
}
