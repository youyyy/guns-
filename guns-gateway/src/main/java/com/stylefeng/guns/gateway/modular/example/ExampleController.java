package com.stylefeng.guns.gateway.modular.example;

import com.stylefeng.guns.gateway.common.CurrentUser;
import com.stylefeng.guns.gateway.common.SimpleObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 常规控制器
 *
 * @author fengshuonan
 * @date 2017-08-23 16:02
 */
@Controller
@RequestMapping("/hello")
public class ExampleController {

//    @RequestMapping("")
//    public ResponseEntity hello(@RequestBody SimpleObject simpleObject) {
//        System.out.println(simpleObject.getUser());
//        return ResponseEntity.ok("请求成功!");
//    }

    /**
     * 测试jwt，和ThreadLocal保存用户信息
     * @return
     */
    @RequestMapping("")
    public ResponseEntity hello() {
        System.out.println(CurrentUser.getCurrentUser());


        //userId->key->redis[userInfo]->30min

        //userId->mysql

        return ResponseEntity.ok("请求成功!");
    }
}
