package com.boyun.cloud.boot.exception;

/**
 * @className: com.boyun.cloud.boot.exception.BaseRuntimeException
 * @projectName: BoyunCloud项目
 * @module: BoyunCloud项目-BaseRuntimeException类，主要位于基础运行时异常类模块
 * @content: BaseRuntimeException-基础运行时异常类
 * @author: Powered by Marklin
 * @datetime: 2024-11-01 22:07
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
public class BaseRuntimeException extends RuntimeException implements IBaseException {

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
     * 不应该直接实例化,应该定义子类.
     *
     * @param code
     *         异常 code,通常与模块 CODE 对应
     * @param args
     *         如果没有参数,可以传 null
     */
    public BaseRuntimeException(String code, Object... args) {
        super(code);
        this.code = code;
        this.desc = code;
        this.args = args;
    }

    /**
     * 不直接实例化,应该定义子类.
     *
     * @param code
     *         异常 code,通常与模块 CODE 对应
     * @param desc
     *         异常消息代码,系统描述中定义
     * @param args
     */
    public BaseRuntimeException(String code, String desc, Object... args) {
        super(desc);
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
