package com.example.demo6574564.config;

import com.example.demo6574564.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Administrator
 * @author Administrator
 * @date 2019-10-11 14:44
 */
@Component
// 1.开启定时任务
@EnableScheduling
//  2.开启多线程
@EnableAsync
public class MultithreadScheduleTask {
    @Autowired
    private UserInfoService userInfoService;
    @Async
    //间隔1秒
    @Scheduled(fixedDelay = 100000)
    public void first() throws InterruptedException {
        System.out.println("第一个定时任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
        System.out.println();
        Thread.sleep(1000 * 10);
    }

    @Async
    @Scheduled(fixedDelay = 200000)
    public void second() {
        System.out.println("第二个定时任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
        System.out.println();
    }
//    @Async
//    @Scheduled(fixedDelay = 10000)
//    public void three(){
//        try{
//            userInfoService.findById(id);
//            System.out.println("定时任务:"+id+Thread.currentThread().getName());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
