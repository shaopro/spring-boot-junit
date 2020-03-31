package com.github.spring.boot.junit.manager;

import com.github.spring.boot.junit.pojo.ResultDTO;
import com.github.spring.boot.junit.pojo.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.net.URISyntaxException;
import java.util.Date;

/**
 * <p>
 * 创建时间为 上午11:13 2020/3/31
 * 项目名称 spring-boot-junit
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@SpringBootTest
@DirtiesContext
@ActiveProfiles("junit")
@RunWith(SpringRunner.class)
@AutoConfigureWireMock(stubs = "classpath:/stubs", port = 8088)
public class UserManagerTest {

    @Resource
    private UserManager userManager;

    @Test
    public void getUserByUsername() {
        UserDTO result = userManager.getUserByUsername("http://127.0.0.1:8088/user/", "test");
        Assert.assertEquals(result.getUsername(), "test");
    }

    @Test
    public void saveUser() throws URISyntaxException {
        UserDTO user = UserDTO.builder().username("test").date(new Date()).build();
        ResultDTO<UserDTO> result = userManager.saveUser("http://127.0.0.1:8088/result", user);
        Assert.assertEquals(result.getData().getUsername(), "test");
    }
}