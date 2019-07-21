package com.stylefeng.guns.gateway.modular;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.user.UserAPI;
import org.springframework.stereotype.Component;

/**
 * 废弃
 * 测试gateway能否dubbo打通user,再->api
 */
@Component
public class Client {
    @Reference(interfaceClass = UserAPI.class)
    private UserAPI userAPI;

    public void run(){
        userAPI.login("admin","admin");
    }
}
