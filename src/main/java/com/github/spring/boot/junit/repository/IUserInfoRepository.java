package com.github.spring.boot.junit.repository;

import com.github.spring.boot.junit.pojo.UserInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 石少东
 * @date create in 2020/12/25 11:25 上午
 */
public interface IUserInfoRepository extends JpaRepository<UserInfoDO, Long> {


}
