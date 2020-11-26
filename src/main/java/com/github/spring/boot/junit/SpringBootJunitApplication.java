package com.github.spring.boot.junit;

import com.github.caryyu.spring.embedded.redisserver.RedisServerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class SpringBootJunitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJunitApplication.class, args);
    }

    @Bean
    @Primary
    public RedisServerConfiguration redisServerConfigurationTest() {
        return new RedisServerConfiguration();
    }
}
