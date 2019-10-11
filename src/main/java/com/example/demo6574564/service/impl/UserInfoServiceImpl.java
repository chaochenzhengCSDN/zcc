package com.example.demo6574564.service.impl;

import com.example.demo6574564.dto.UserDao;
import com.example.demo6574564.entity.userInfo;
import com.example.demo6574564.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @date 2019-10-11 15:02
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisTemplate redisTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Override
    @Cacheable(value = "userCache", key = "#id")
    public userInfo findById(int id) {
        // 从 DB 中获取用户信息
        userInfo user = userDao.finduserById(id);
        return user;
    }
    @Override
    @Cacheable(value = "userCache1", key = "#user")
    public userInfo updateUser(userInfo user) {
        // 从 DB 中获取用户信息
        userInfo user1 = userDao.updateUser(user);
        return user1;
    }

}


