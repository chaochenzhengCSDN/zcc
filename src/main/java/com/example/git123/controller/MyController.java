package com.example.git123.controller;

import com.example.git123.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zcc
 * @date 2019/8/19
 */
@RestController
@RequestMapping("/web")
public class MyController {
    @RequestMapping("/login")
    public String login(User user){
        /**
         * @author zcc
         * 修改 加入判断登录条件
         * @date 2019/8/19
         */
        String msg="登录成功";
        if("zcc".equals(user.getUsername())&&"1234".equals(user.getPwd())){
            return msg;
        }else{
            msg="登录失败";
        }
        return msg;
    }
}
