package com.example.springdemo.controller;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestController {

//    http://127.0.0.1:8080/test1
    @GetMapping("/test1")
    public String test1(){
        return "OK";
    }

//    http://127.0.0.1:8080/test2?name=111
    @GetMapping("/test2")
    public String test2(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request.getParameter("name"));
        return "OK";
    }

//    http://127.0.0.1:8080/test3?key=111&value=222
    @GetMapping("/test3")
    public String test3(String key,String value){
        System.out.println(key);
        System.out.println(value);
        return "OK";
    }



//    http://127.0.0.1:8080/test4/123
    @RequestMapping("/test4/{id}")
    public String test4(@PathVariable("id")int id){
        System.out.println(id);
        return "OK";
    }


//    http://127.0.0.1:8080/test5
//    {"id":"321"}
    @ResponseBody
    @RequestMapping("/test5")
    public String test4(@RequestBody JSONObject json){
        System.out.println(json.toJSONString());
        return json.toJSONString();
    }


}
