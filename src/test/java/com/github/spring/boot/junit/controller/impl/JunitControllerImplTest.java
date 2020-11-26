package com.github.spring.boot.junit.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.caryyu.spring.embedded.redisserver.RedisServerConfiguration;
import com.github.spring.boot.junit.controller.RedisTestServer;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("junit")
class JunitControllerImplTest {

    @Resource
    private MockMvc mockMvc;

    @Resource
    private RedisTemplate<String, String> redisTemplate;
//
//    @MockBean
//    private RedisConnectionFactory factory;

//    @Rule
//    public final RedisTestServer redis = new RedisTestServer();

    @Before
    public void before(){
//        when(redisTemplate.opsForValue().get("1234")).thenReturn("4567");
    }
    

    @Test
    void get() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/1234"))
                .andDo(print())
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.username").value("TestName"))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }
}