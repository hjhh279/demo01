package com.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.utils.HttpUtils;
import com.demo.utils.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private RedisCache redisCache;
    @GetMapping("/get")
    public String test(){
        String sendGet;
        //获取redis token
        sendGet = redisCache.getCacheObject("name");
        if(sendGet != null){
            return sendGet;
        }else {
            //存储token到redis
            redisCache.setCacheObject("name", "yyk", 120, TimeUnit.SECONDS);
            return "yyk";
        }
    }
}
