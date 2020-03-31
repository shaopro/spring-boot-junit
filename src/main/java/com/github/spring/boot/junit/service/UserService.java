package com.github.spring.boot.junit.service;

import com.github.spring.boot.junit.pojo.UserDO;
import com.github.spring.boot.junit.repository.IUserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 下午12:18 2020/3/31
 * 项目名称 spring-boot-junit
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class UserService {

    @Resource
    private IUserRepository repository;

    public UserDO findUserById(long id) {
        return repository.findById(id).orElseGet(UserDO::new);
    }

}
