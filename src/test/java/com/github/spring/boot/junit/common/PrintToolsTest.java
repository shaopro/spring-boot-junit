package com.github.spring.boot.junit.common;

import com.github.spring.boot.junit.service.JunitService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.powermock.api.mockito.PowerMockito.when;

/**
 * <p>
 * 创建时间为 下午6:54 2020/4/21
 * 项目名称 spring-boot-junit
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@PrepareForTest({PrintTools.class})
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringRunner.class)
@PowerMockIgnore({"javax.management.*"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PrintToolsTest {

    @Resource
    private JunitService service;

    @Before
    public void before() {
        PowerMockito.mockStatic(PrintTools.class);
        when(PrintTools.getMessage()).thenReturn("123");
    }


    @Test
    public void get() throws Exception {
        service.print();
        System.out.println(PrintTools.getMessage());
    }

}