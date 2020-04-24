package com.github.spring.boot.junit.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 创建时间为 下午10:12 2020/4/19
 * 项目名称 spring-boot-junit
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Component
public class PrintBeanNameRunner implements CommandLineRunner {

    @Resource
    private ApplicationContext applicationContext;

    @Resource
    private RequestMappingHandlerMapping mapping;

    @Override
    public void run(String... args) throws Exception {
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();
        map.forEach((k, v) -> {
            Set<String> paths = k.getPatternsCondition().getPatterns();
            Set<String> methods = k.getMethodsCondition().getMethods().stream().map(Enum::name).collect(Collectors.toSet());
            Method method = v.getMethod();
            Class<?> clz = v.getBeanType();
        });
    }
}
