package com.cn.springbootredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author gh
 * @date 2022/2/22 16:03
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping
    public Object getFromRedis(){
        redisTemplate.watch("");
        redisTemplate.multi();

        redisTemplate.opsForValue().set("name","zhangsan");
        Object name = redisTemplate.opsForValue().get("name");

        return name;
    }

}
