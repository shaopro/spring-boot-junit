package com.github.spring.boot.junit.controller;

import com.github.spring.boot.junit.pojo.UserDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
public class JunitController {

    @GetMapping("/user")
    public UserDTO get() {
        return UserDTO.builder().username("TestName").date(new Date()).build();
    }

    @PostMapping("/user")
    public UserDTO post(@RequestBody UserDTO user) {
        return user;
    }

    @PutMapping("/user")
    public UserDTO put(@RequestBody UserDTO user) {
        return user;
    }

    @DeleteMapping("/user/{username}")
    public String delete(@PathVariable String username) {
        return username;
    }


}
