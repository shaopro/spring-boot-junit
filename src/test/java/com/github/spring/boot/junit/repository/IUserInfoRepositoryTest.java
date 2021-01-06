package com.github.spring.boot.junit.repository;

import com.github.spring.boot.junit.pojo.UserInfoDO;
import org.jetbrains.annotations.NotNull;
import org.junit.ClassRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.annotation.Resource;
import java.util.function.Consumer;


@Testcontainers
@SpringBootTest
class IUserInfoRepositoryTest {

    @Container
    public static MySQLContainer container = new MySQLContainer("mysql:5.7.31")
            .withUsername("ut")
            .withPassword("ut")
            .withDatabaseName("ut_db");

    @DynamicPropertySource
    static void postgresqlProperties(@NotNull DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.username", container::getUsername);
    }

    @Resource
    private IUserInfoRepository repository;

    @BeforeEach
    public void beforeEach() {
        UserInfoDO userInfo = UserInfoDO.builder().username("TestName").password("TestPassword").build();
        repository.save(userInfo);
    }

    @Test
    void saveOne() {
        Assertions.assertEquals(1, repository.findAll().size());
        repository.findAll().forEach(System.out::println);
    }

}