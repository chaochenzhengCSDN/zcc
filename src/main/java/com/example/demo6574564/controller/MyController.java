package com.example.demo6574564.controller;

import com.example.demo6574564.entity.userInfo;
import com.example.demo6574564.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 * @date 2019-10-10 14:16
 */
@RestController
@Api(description = "查询",value = "查询")
public class MyController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value = "查询缓存")
    @RequestMapping(value = "/findUser", method = RequestMethod.POST)
    @ResponseBody
    public userInfo findUser(@RequestParam("id") int id) {
        return userInfoService.findById(id);
    }
    @ApiOperation(value = "更新用户")
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public userInfo updateUser(@RequestParam("") userInfo user) {
        return userInfoService.updateUser(user);
    }
}