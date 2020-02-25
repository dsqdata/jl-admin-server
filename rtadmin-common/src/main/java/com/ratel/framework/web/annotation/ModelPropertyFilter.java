package com.ratel.framework.web.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 注解参数对象自动基于request请求构建查询参数对象
 *
 * @see ModelPropertyFilterMethodProcessor
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ModelPropertyFilter {

    /**
     * Alias for {@link #clazz()}.
     */
    @AliasFor("clazz")
    Class<?> value() default void.class;

    /**
     * Alias for {@link #value()}.
     */
    @AliasFor("value")
    Class<?> clazz() default void.class;

    /**
     * 对于一些操作需要做数据访问检查，以确保当前登录用户只能访问关联的数据。
     * 指定需要进行数据访问检查的实体属性名称，处理器自动基于当前登录用户User对象与此属性进行比对，断言访问控制
     * 注意：指定实体属性名对应的类型必须是 com.entdiy.auth.entity.User ，否则抛出异常
     *
     */
    String dataAccessControl() default "";
}
