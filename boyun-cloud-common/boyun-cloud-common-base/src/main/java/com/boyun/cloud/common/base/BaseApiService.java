package com.boyun.cloud.common.base;

import com.boyun.cloud.boot.utils.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Validator;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Collection;
import java.util.function.Function;


/**
 * @className: com.boyun.cloud.common.base.BaseApiService
 * @projectName: 封装BoyunCloud项目-BaseApiService类
 * @module: BoyunCloud项目-AppBaseService类，主要位于BoyunCloud项目模块的业务场景
 * @content: AppBaseService类，主要用于完成AppBaseService-应用基础抽象服务类的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-07-03 12:33
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
public class BaseApiService {

    @Autowired
    private Validator validator;

    /**
     * 验证单个对象
     *
     * @param object
     *         验证对象
     * @param groups
     *         验证分组
     * @param <T>
     *         Bean 泛型
     */
    protected <T> void validObject(T object, @SuppressWarnings("rawtypes") Class... groups) {
        ValidatorUtil.valid(validator, object, groups);
    }


    /**
     * 验证单个对象
     *
     * @param object
     *         验证对象
     * @param groups
     *         验证分组
     * @param process
     *         异常信息处理
     * @param <T>
     *         Bean 泛型
     */
    protected <T> void validObject(T object, ValidatorUtil.Validation process, @SuppressWarnings("rawtypes") Class... groups) {
        ValidatorUtil.valid(validator, object, process, groups);
    }

    /**
     * 迭代验证集合元素，使用默认异常信息处理
     *
     * @param collection
     *         Bean集合
     * @param groups
     *         验证组
     * @param <T>
     *         Bean 泛型
     */
    protected <T> void validList(Collection<T> collection, @SuppressWarnings("rawtypes") Class... groups) {
        ValidatorUtil.valid(validator, collection, groups);
    }

    /**
     * 迭代验证集合元素，使用默认异常信息处理
     *
     * @param collection
     *         Bean集合
     * @param groups
     *         验证组
     * @param process
     *         异常信息处理
     * @param <T>
     *         Bean 泛型
     */
    protected <T> void validList(Collection<T> collection, ValidatorUtil.Validation process, @SuppressWarnings("rawtypes") Class... groups) {
        ValidatorUtil.valid(validator, collection, process, groups);
    }


    /**
     * 获取字段方法
     *
     * @param clazz
     *         实体类
     * @param fieldName
     *         字段名称
     * @param <T>
     *         范型
     *
     * @return 返回结果
     */
    protected <T> Function<T, ?> getFieldMethod(Class<T> clazz, String fieldName) {
        try {
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            MethodHandle getter = lookup.findVirtual(clazz, "get" + capitalize(fieldName), MethodType.methodType(Object.class));
            MethodType functionType = MethodType.methodType(Function.class);
            MethodHandle factory = LambdaMetafactory.metafactory(lookup, "apply", functionType, getter.type(), getter, getter.type()).getTarget();
            return (Function<T, ?>) factory.invokeExact(getter);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 输入字符串的首字母大写
     *
     * @param name 参数名
     *
     * @return 返回结果
     */
    protected String capitalize(String name) {
        if (name == null || name.length() == 0) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
