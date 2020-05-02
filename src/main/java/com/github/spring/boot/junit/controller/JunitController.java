package com.github.spring.boot.junit.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 * 创建时间为 下午2:31 2020/4/27
 * 项目名称 spring-boot-junit
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@RestController
public class JunitController {

    @GetMapping("ping")
    public String ping() {
        String date = new Date().toString();
        log.info(date);
        return date;
    }

}
