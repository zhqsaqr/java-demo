package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class TestProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;


    @RequestMapping("/insert")
    public String insertDate(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 15; i < 30; i++) {
            String str="测试消息======="+sdf.format(new Date())+"=="+i;
            kafkaTemplate.send("test-001", str);
        }
        return "OK";
    }

}
