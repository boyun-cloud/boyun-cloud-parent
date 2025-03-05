package com.boyun.cloud.boot.annotation;

import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.*;

/**
 * @className: com.boyun.cloud.starter.boot.compare.annotation.ModelPropertyMeta
 * @projectName: BoyunCloud项目
 * @module: BoyunCloud项目-ModelPropertyMeta类，主要位于模型对象属性元注解模块
 * @content: ModelPropertyMeta-模型对象属性元注解
 * @author: Powered by Marklin
 * @datetime: 2024-08-17 03:17
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@Inherited
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiMetaProperty {
    /**
     * 字段名称
     *
     * @return 返回结果
     */
    String name() default StringUtils.EMPTY;

    /**
     * 字段描述
     *
     * @return 返回结果
     */
    String value() default StringUtils.EMPTY;
}
