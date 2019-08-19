package com.example.git123.controller;

import com.example.git123.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zcc
 * @date 2019/8/19
 */
@RestController
@RequestMapping("/web")
public class MyController {
    /**
     * get请求参数处理 2019/8/19
     * @param username
     * @param pwd
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(@RequestParam(value = "username",defaultValue = "zcc",required = false)String username,
                        @RequestParam(value = "pwd",required = true)String pwd){
        /**
         * @author zcc
         * 修改 加入判断登录条件
         * @date 2019/8/19
         */
        String msg="登录成功";
        if("zcc".equals(username)&&"1234".equals(pwd)){
            return msg;
        }else{
            msg="登录失败";
        }
        return msg;
    }
}
