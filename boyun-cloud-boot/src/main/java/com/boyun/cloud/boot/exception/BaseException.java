package com.boyun.cloud.boot.exception;

/**
 * @className: com.boyun.cloud.boot.exception.BaseException
 * @projectName: BoyunCloud项目
 * @module: BoyunCloud项目-BaseException类，主要位于基础异常类模块
 * @content: BaseException-基础异常类
 * @author: Powered by Marklin
 * @datetime: 2024-11-01 21:40
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
public abstract class BaseException extends Exception implements IBaseException {

    /**
     * 异常编码
     */
    private String code;

    /**
     * 异常描述
     */
    private String desc;

    /**
     * 异常参数
     */
    private Object[] args;


    /**
     *  不直接实例化,应该定义子类.
     *
     * @param code
     *         异常 code,通常与模块 CODE 对应
     * @param desc
     *         异常消息代码,系统描述中定义
     * @param args
     *         如果没有参数,可以传 null
     */
    public BaseException(String code, String desc, Object... args) {
        super(code);
        this.code = code;
        this.desc = desc;
        this.args = args;
    }



    /**
     * 异常编码
     *
     * @return 返回结果
     */
    @Override
    public String getCode() {
        return code;
    }

    /**
     * 异常编码
     *
     * @param code
     *         编码
     *
     * @return 返回结果
     */
    @Override
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 异常描述
     *
     * @return 返回结果
     */
    @Override
    public String getDesc() {
        return desc;
    }

    /**
     * 异常描述
     *
     * @param desc
     *         描述信息
     *
     * @return 返回结果
     */
    @Override
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 异常参数
     *
     * @return 返回结果
     */
    @Override
    public Object[] getArgs() {
        return args;
    }

    /**
     * 异常参数
     *
     * @param args
     *         参数
     *
     * @return 返回结果
     */
    @Override
    public void setArgs(Object[] args) {
        this.args = args;
    }
}
