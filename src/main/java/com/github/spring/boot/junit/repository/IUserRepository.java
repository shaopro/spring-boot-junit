package com.github.spring.boot.junit.repository;

import com.github.spring.boot.junit.pojo.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * 创建时间为 下午12:17 2020/3/31
 * 项目名称 spring-boot-junit
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IUserRepository extends JpaRepository<UserDO, Long> {

}

