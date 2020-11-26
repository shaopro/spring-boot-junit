package com.github.spring.boot.junit.config;

import com.github.caryyu.spring.embedded.redisserver.RedisServerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author 石少东
 * @date 2020-11-26 21:26
 * @since 1.0
 */

@Component
public class RedisConfig {

    @Bean
    public RedisServerConfiguration redisServerConfiguration(){
        return new RedisServerConfiguration();
    }

}
