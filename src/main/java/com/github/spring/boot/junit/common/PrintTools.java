package com.github.spring.boot.junit.common;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * <p>
 * 创建时间为 下午6:44 2020/4/21
 * 项目名称 spring-boot-junit
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public class PrintTools {

    @NotNull
    @Contract(pure = true)
    public static String getMessage() {
        return "Message";
    }

}
