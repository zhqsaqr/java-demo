package com.example.redisdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class RedisDemoApplicationTests {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("test","123456");
        String s= (String) redisTemplate.opsForValue().get("test");
        System.out.println(s);
        redisTemplate.delete("test");
        s= (String) redisTemplate.opsForValue().get("test");
        System.out.println(s);
    }

}
