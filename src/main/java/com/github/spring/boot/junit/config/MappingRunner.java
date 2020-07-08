package com.github.spring.boot.junit.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Map;
import java.util.Set;

/**
 * @author 石少东
 * @date 2020-06-12 17:35
 */

@Component
@RequiredArgsConstructor
public class MappingRunner implements CommandLineRunner {

    private final RequestMappingHandlerMapping mapping;

    @Override
    public void run(String... args) throws Exception {
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();
        map.forEach((k, v) -> {
            // 取出控制器对象
            Class<?> clz = v.getBeanType();
            Set<Class<?>> handlerTypes = ClassUtils.getAllInterfacesForClassAsSet(v.getBeanType());


        });


    }

}
