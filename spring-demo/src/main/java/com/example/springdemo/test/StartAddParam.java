package com.example.springdemo.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 启动时加载配置文件中的参数
 * 异步执行定时任务 EnableAsync Async
 */
@Component
@EnableScheduling
@EnableAsync
public class StartAddParam {

    private static String test;

    @Value("${test.aa}")
    public  void setTest(String test) {
        StartAddParam.test = test;
    }



//    @Async
//    @Scheduled(fixedDelayString  = "1000")
    public void serverMonitor() {
        System.out.println("test=========="+test+"=====" + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());

    }


}
