package com.example.common.anonation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @description 标识MyBatis的DAO
 * @authon tyh
 * @time 9/10/2020 2:07 PM
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface MyBatisDao {

    /**
     * The value may indicate a suggestion for a logical component name,
     * to be turned into a Spring bean in case of an autodetected component.
     * @return the suggested component name, if any
     */
    String value() default "";

}
