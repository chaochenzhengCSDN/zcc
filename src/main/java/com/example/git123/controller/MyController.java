package com.example.git123.controller;

import com.example.git123.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author zcc
 * @date 2019/8/19
 */
@RestController
@RequestMapping("/web")
public class MyController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    /**
     * get请求参数处理 2019/8/19
     * @param username
     * @param pwd
     * @return
     */
    @PostMapping(value = "/loginIn")
    public String loginIn(@RequestParam(value = "username",required = false)String username,
                        @RequestParam(value = "pwd",required = true)String pwd,
                        Model model){
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
        model.addAttribute("username",username);
        model.addAttribute("pwd",pwd);
        model.addAttribute("msg",msg);
        return "model";
    }
    /**
     * 注册操作
     *
     */
    @PostMapping("/register")
    private String register(@RequestParam(value = "username",required = false)String username,
                            @RequestParam(value = "pwd",required = true)String pwd,
                            @RequestParam(value = "nickname",required = true)String nickname,
                            Model model){
        String registerMsg=null;
        if(username.length()>6|| !StringUtils.isEmpty(username)){
            registerMsg="名字长度过长，请小于6个字符，也不能为空";
        }else if(pwd.length()==4|| !StringUtils.isEmpty(pwd)){
            registerMsg="密码长度限制，填写4个字符，也不能为空";
        }else{
            registerMsg="注册成功";
        }
        return registerMsg;
    }
}
