package com.example.git123.controller;

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
    public String login(){
        String msg="登录成功";
        return msg;
    }
}
