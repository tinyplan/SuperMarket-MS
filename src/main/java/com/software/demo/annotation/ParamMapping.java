package com.software.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author tinyplan
 * 2021/6/5
 * <p>
 * 在对象转换时使用的注解
 * 标注内容(targetField)为: 目标对象中的目标字段名
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamMapping {

    // 目标类
    Class<?> targetClz();

    // 目标字段
    String targetField();


}
