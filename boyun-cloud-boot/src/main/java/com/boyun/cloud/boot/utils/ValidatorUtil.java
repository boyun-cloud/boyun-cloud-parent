package com.boyun.cloud.boot.utils;

import com.boyun.cloud.boot.exception.ValidationException;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @className: com.boyun.cloud.boot.untils.ValidatorUtil
 * @projectName: 封装BoyunCloud项目-ValidatorUtil类
 * @module: BoyunCloud项目-ValidatorUtil类，主要位于BoyunCloud项目模块的业务场景
 * @content: ValidatorUtil类，主要用于完成ValidatorUtil-验证工具类的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-07-03 11:15
 * @version: 1.0.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
public class ValidatorUtil {
    private ValidatorUtil() {
    }

    private static final Validation DEFAULT_PROCESS = new Validation() {
    };

    /**
     * 验证单个元素，使用默认异常信息处理
     *
     * @param validator 验证器
     * @param object    Bean
     * @param groups    验证组
     * @param <T>       Bean 泛型
     */
    public static <T> void valid(Validator validator, T object, Class<?>... groups) {
        valid(validator, object, DEFAULT_PROCESS, groups);
    }

    /**
     * 验证单个元素，使用默认异常信息处理
     *
     * @param validator 验证器
     * @param object    Bean
     * @param process   异常信息处理
     * @param groups    验证组
     * @param <T>       Bean 泛型
     */
    public static <T> void valid(Validator validator, T object, Validation process, Class<?>... groups) {
        Set<ConstraintViolation<T>> violationSet;
        if (groups == null) {
            violationSet = validator.validate(object);
        } else {
            violationSet = validator.validate(object, groups);
        }
        if (process != null) {
            process.process(violationSet);
        }
    }

    /**
     * 迭代验证集合元素，使用默认异常信息处理
     *
     * @param validator  验证器
     * @param collection Bean集合
     * @param groups     验证组
     * @param <T>        Bean 泛型
     */
    public static <T> void valid(Validator validator, Collection<T> collection, Class<?>... groups) {
        valid(validator, collection, DEFAULT_PROCESS, groups);
    }

    /**
     * 迭代验证集合元素，使用自定义异常信息处理
     *
     * @param validator  验证器
     * @param collection Bean集合
     * @param process    异常信息处理
     * @param groups     验证组
     * @param <T>        Bean 泛型
     */
    public static <T> void valid(Validator validator, Collection<T> collection, Validation process,
                                 Class<?>... groups) {
        if (CollectionUtils.isEmpty(collection)) {
            return;
        }
        int index = 0;
        Map<Integer, Set<ConstraintViolation<T>>> resultMap = new HashMap<>(collection.size());
        for (T obj : collection) {
            Set<ConstraintViolation<T>> violationSet;
            if (groups == null) {
                violationSet = validator.validate(obj);
            } else {
                violationSet = validator.validate(obj, groups);
            }
            if (!CollectionUtils.isEmpty(violationSet)) {
                resultMap.put(index, violationSet);
            }
            ++index;
        }
        if (process != null) {
            process.process(resultMap);
        }
    }

    /**
     * 校验两个日期是否相等
     * date1 == date2
     *
     * @param source 日期1
     * @param target 日期2
     */
    public static void isSameDay(final Date source, final Date target) {
        if (!DateUtils.isSameDay(source, target)) {
            throw new ValidationException("error.data.not.same");
        }
    }

    /**
     * 校验第一个日期是否是第二个日期之前
     * startDate &lt; endDate
     *
     * @param source 开始日期
     * @param target   结束日期
     */
    public static void isAfterDay(final Date source, final Date target) {
        if (source == null || target == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        if (source.getTime() >= target.getTime()) {
            throw new ValidationException("error.data.not.after");
        }
    }

    /**
     * 校验第一个日期是否是第二个日期之前或相等
     * startDate &lt;= endDate
     *
     * @param source 开始日期
     * @param target   结束日期
     */
    public static void isSameOrAfterDay(final Date source, final Date target) {
        if (source == null || target == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        if (source.getTime() > target.getTime()) {
            throw new ValidationException("error.data.not.same.after");
        }
    }



    public interface Validation {
        /**
         * 批量验证结果处理接口，默认打印日志，抛出异常
         *
         * @param resultMap 验证结果
         * @param <T>       验证对象泛型
         */
        default <T> void process(Map<Integer, Set<ConstraintViolation<T>>> resultMap) {
            if (!CollectionUtils.isEmpty(resultMap)) {
                StringBuilder sb = new StringBuilder();
                resultMap.forEach((key, value) -> sb.append("index : ").append(key).append(" , error : ").append(
                        value.stream().map(item -> item.getPropertyPath().toString() + " " + item.getMessage())
                                .collect(Collectors.toList()).toString())
                        .append(";\n"));
                throw new ValidationException(sb.toString());
            }
        }

        /**
         * 耽搁验证结果处理接口，默认打印日志，抛出异常
         *
         * @param resultSet 验证结果
         * @param <T>       验证对象泛型
         */
        default <T> void process(Set<ConstraintViolation<T>> resultSet) {
            if (!CollectionUtils.isEmpty(resultSet)) {
                throw new ValidationException(resultSet
                        .stream()
                        .map(item -> item.getPropertyPath().toString() + " " + item.getMessage() + "; ")
                        .collect(Collectors.toList())
                        .toString());
            }
        }
    }
}
