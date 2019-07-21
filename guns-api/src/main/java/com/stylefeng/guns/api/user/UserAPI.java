package com.stylefeng.guns.api.user;

public interface UserAPI {

    /**
     *
     * @param username
     * @param password
     * @return uuid
     */
    int login(String username, String password);

    boolean registory(UserModel userModel);

    boolean checkUsername(String username);

    UserInfoModel getUserInfo(int uuid);

    UserInfoModel updateUserInfo(UserInfoModel userInfoModel);
}
