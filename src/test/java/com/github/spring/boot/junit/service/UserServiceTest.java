package com.github.spring.boot.junit.service;

import com.github.spring.boot.junit.pojo.UserDO;
import com.github.spring.boot.junit.repository.IUserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 下午12:20 2020/3/31
 * 项目名称 spring-boot-junit
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */



@SpringBootTest
@DirtiesContext
@ActiveProfiles("junit")
@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UserServiceTest {

    @Resource
    private UserService service;

    @Resource
    private IUserRepository repository;

    @Before
    public void setUp() throws Exception {
        UserDO user = UserDO.builder().userId(1L).username("test").build();
        repository.save(user);
    }

    @Test
    public void getUserById() {
        UserDO user = service.findUserById(1L);
        long id = user.getUserId();
        Assert.assertEquals(id, 1L);
    }
}