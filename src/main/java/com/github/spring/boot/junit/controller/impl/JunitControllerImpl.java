package com.github.spring.boot.junit.controller.impl;

import com.github.spring.boot.junit.controller.IJunitController;
import com.github.spring.boot.junit.pojo.UserDTO;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 创建时间为 上午10:46 2020/3/31
 * 项目名称 spring-boot-junit
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class JunitControllerImpl implements IJunitController {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/user/{key}")
    @Override
    public String get(@PathVariable String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
