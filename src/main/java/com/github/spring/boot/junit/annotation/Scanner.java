package com.github.spring.boot.junit.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author 石少东
 * @date 2020-06-12 17:41
 */


@Retention(RetentionPolicy.RUNTIME)
public @interface Scanner {

    String value();

}
