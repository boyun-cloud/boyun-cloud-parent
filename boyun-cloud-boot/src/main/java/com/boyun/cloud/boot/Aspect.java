package com.boyun.cloud.boot;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.Ordered;

/**
 * @className: com.boyun.cloud.boot.Aspect
 * @projectName: 封装BoyunCloud项目-Aspect类
 * @module: BoyunCloud项目-Aspect类，主要位于BoyunCloud基础boot工程模块的业务场景
 * @content: Aspect类，主要用于完成Aspect切面父级接口的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-06-17 12:24
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2025 BoyunCloud Systems Incorporated. All rights reserved.
 */
public interface Aspect extends Ordered {

    /**
     * 切面环绕通知-@Around
     *
     * @param point 切入点
     * @return 返回结果
     * @throws Throwable 异常消息
     */
    default Object aspectAround(ProceedingJoinPoint point) throws Throwable {
        return null;
    }

    /**
     * 切面切入之前-@Before
     *
     * @param point 切入点
     * @return 返回结果
     * @throws Throwable 异常消息
     */
    default void aspectBefore(JoinPoint point) throws Throwable {
    }

    /**
     * 切面切入之后(返回)-@AfterReturning
     *
     * @param object 返回对象
     */
    default void aspectReturn(Object object) {
    }

    /**
     * 切面切入之后(错误)-@AfterThrowing
     *
     * @param exception 返回对象
     */
    default void aspectError(Throwable exception) {
    }

    /**
     * 切面切入之后-@After
     *
     * @throws Throwable 异常消息
     */
    default void aspectAfter() throws Throwable {
    }
}
