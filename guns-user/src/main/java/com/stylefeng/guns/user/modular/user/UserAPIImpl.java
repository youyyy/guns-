package com.stylefeng.guns.user.modular.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.api.user.UserAPI;
import com.stylefeng.guns.api.user.UserInfoModel;
import com.stylefeng.guns.api.user.UserModel;
import org.springframework.stereotype.Component;

/**
 * 测试dubbo是否打通user和api
 */
@Component
@Service(interfaceClass = UserAPI.class)
public class UserAPIImpl implements UserAPI {
    @Override
    public int login(String username, String password) {
        System.out.println("this is user service!!"+username+","+password);
        return 1;
    }

    @Override
    public boolean registory(UserModel userModel) {
        return false;
    }

    @Override
    public boolean checkUsername(String username) {
        return false;
    }

    @Override
    public UserInfoModel getUserInfo(int uuid) {
        return null;
    }

    @Override
    public UserInfoModel updateUserInfo(UserInfoModel userInfoModel) {
        return null;
    }
}
