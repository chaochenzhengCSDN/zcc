package com.example.demo6574564.dto;

import com.example.demo6574564.entity.userInfo;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 * @date 2019-10-11 15:01
 */
@Repository
public interface UserDao {

   userInfo finduserById(int id);
   userInfo updateUser(userInfo user);
}
