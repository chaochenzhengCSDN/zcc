package com.example.demo6574564.service;

import com.example.demo6574564.entity.userInfo;

/**
 * @author Administrator
 * @date 2019-10-11 15:04
 */

public interface UserInfoService {
    userInfo findById(int id);
    userInfo updateUser(userInfo user);
}
