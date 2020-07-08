package com.github.spring.boot.junit.controller;

import com.github.spring.boot.junit.annotation.Scanner;
import com.github.spring.boot.junit.pojo.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 石少东
 * @date 2020-06-12 17:37
 */

public interface IJunitController {

    @Scanner("123")
    @GetMapping("/user")
    UserDTO get();

    UserDTO post(@RequestBody UserDTO user);

    UserDTO put(@RequestBody UserDTO user);

    String delete(@PathVariable String username);
}
