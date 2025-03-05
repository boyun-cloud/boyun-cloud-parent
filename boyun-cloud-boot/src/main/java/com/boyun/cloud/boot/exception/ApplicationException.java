package com.boyun.cloud.boot.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @className: com.boyun.cloud.boot.exception.ApplicationException
 * @projectName: 封装BoyunCloud项目-ApplicationException类
 * @module: BoyunCloud项目-ApplicationException类，主要位于BoyunCloud项目Boot工程模块的业务场景
 * @content: ApplicationException类，主要用于完成ApplicationException应用异常类的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-06-19 13:03
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ApplicationException extends RuntimeException implements Serializable {

    /**
     * 构建应用异常-ApplicationException
     *
     * @param exception 异常类
     */
    public ApplicationException(final Throwable exception) {
        super(exception);
    }

    /**
     * 构建应用异常-ApplicationException
     *
     * @param message the message
     */
    public ApplicationException(final String message) {
        super(message);
    }

    /**
     * 构建应用异常-ApplicationException
     *
     * @param message   the message
     * @param throwable the throwable
     */
    public ApplicationException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}
