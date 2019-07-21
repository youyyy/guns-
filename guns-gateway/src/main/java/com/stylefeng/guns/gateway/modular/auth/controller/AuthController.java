package com.stylefeng.guns.gateway.modular.auth.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.user.UserAPI;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.gateway.common.exception.BizExceptionEnum;
import com.stylefeng.guns.gateway.modular.auth.controller.dto.AuthRequest;
import com.stylefeng.guns.gateway.modular.auth.controller.dto.AuthResponse;
import com.stylefeng.guns.gateway.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.gateway.modular.auth.validator.IReqValidator;
import com.stylefeng.guns.gateway.modular.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 请求验证的
 *
 * @author fengshuonan
 * @Date 2017/8/24 14:22
 */
@RestController
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

//    @Resource(name = "simpleValidator")
//    private IReqValidator reqValidator;

    /**
     * 测试gateway->user->api
     */
    @Reference(interfaceClass = UserAPI.class)
    private UserAPI userAPI;

    @RequestMapping(value = "${jwt.auth-path}")
    public ResponseVO createAuthenticationToken(AuthRequest authRequest) {
        /**
         * 去掉guns自带的用户密码验证机制，自己写能否登陆即可
         */
//        boolean validate = reqValidator.validate(authRequest);
        /**
         * 验证用户是否通过
         */
        boolean validate = true;
        int userId = userAPI.login(authRequest.getUserName(),authRequest.getPassword());
//        int userId = 3;//测试
        if(userId == 0){
            validate = false;
        }

        if (validate) {
            final String randomKey = jwtTokenUtil.getRandomKey();
            /**
             * 用uuid生成token
             */
            final String token = jwtTokenUtil.generateToken(""+userId, randomKey);

            return ResponseVO.success(new AuthResponse(token,randomKey));
        } else {
            return ResponseVO.serviceFail("用户名或密码错误");
        }
    }
}
