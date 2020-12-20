package com.example.common.anonation;

import java.lang.annotation.*;

/**
 * @description 缓存异常直接抛出处理类
 * @authon tyh
 * @time 9/10/2020 2:07 PM
 **/
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheIngoreException {
}
