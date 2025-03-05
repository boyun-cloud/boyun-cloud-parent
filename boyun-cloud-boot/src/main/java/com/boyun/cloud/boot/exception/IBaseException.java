package com.boyun.cloud.boot.exception;

/**
 * @className: com.boyun.cloud.boot.exception.IBaseException
 * @projectName: BoyunCloud项目
 * @module: BoyunCloud项目-IBaseException类，主要位于基础异常操作接口模块
 * @content: IBaseException-基础异常操作接口
 * @author: Powered by Marklin
 * @datetime: 2024-11-01 21:43
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
public interface IBaseException {

    /**
     * 异常编码
     *
     * @return 返回结果
     */
    String getCode();

    /**
     * 异常编码
     *
     * @return 返回结果
     */
    void setCode(String code);

    /**
     * 异常描述
     *
     * @return 返回结果
     */
    String getDesc();

    /**
     * 异常描述
     *
     * @return 返回结果
     */
    void setDesc(String desc);

    /**
     * 异常参数
     *
     * @return 返回结果
     */
    Object[] getArgs();

    /**
     * 异常参数
     *
     * @return 返回结果
     */
    void setArgs(Object[] parameters);
}
