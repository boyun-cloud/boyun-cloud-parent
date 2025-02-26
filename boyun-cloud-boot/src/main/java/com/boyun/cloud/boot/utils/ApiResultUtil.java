package com.boyun.cloud.boot.utils;

import com.boyun.cloud.boot.Timestamp;
import com.boyun.cloud.boot.pojo.OpenApiResponse;
import com.boyun.cloud.boot.pojo.Payload;
import lombok.experimental.UtilityClass;

/**
 * @className: com.boyun.cloud.boot.untils.ApiResultUtil
 * @projectName: 封装BoyunCloud项目-ApiResultUtil类
 * @module: BoyunCloud项目-ApiResultUtil类，主要位于BoyunCloud项目Boot工程模块的业务场景
 * @content: ApiResultUtil类，主要用于完成ApiResultUtil统一接口结果封装类的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-06-19 11:12
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@UtilityClass
public class ApiResultUtil {

    /**
     * 构建结果
     *
     * @param code
     *         编码
     * @param success
     *         状态
     * @param message
     *         消息
     * @param data
     *         数据
     * @param <T>
     *         数据实体
     *
     * @return 返回结果
     */
    public static <T> Payload<T> restResult(int code, boolean success, String message, T data) {
        Payload<T> payload = new Payload<>();
        payload.setCode(code);
        payload.setSuccess(success);
        payload.setData(data);
        payload.setMessage(message);
        payload.setTimestamp(Timestamp.currentTime());
        return payload;
    }

    /**
     * 构建结果
     *
     * @param code
     *         编码
     * @param success
     *         状态
     * @param message
     *         消息
     * @param <T>
     *         数据实体
     *
     * @return 返回结果
     */
    public static <T> Payload<T> restResult(int code, boolean success, String message) {
        Payload<T> payload = new Payload<>();
        payload.setCode(code);
        payload.setSuccess(success);
        payload.setData(null);
        payload.setMessage(message);
        payload.setTimestamp(Timestamp.currentTime());
        return payload;
    }

    /**
     * 构建结果
     *
     * @param code
     *         编码
     * @param message
     *         消息
     * @param <T>
     *         数据实体
     *
     * @return 返回结果
     */
    public static <T> Payload<T> restResult(int code, String message, T data) {
        Payload<T> payload = new Payload<>();
        payload.setCode(code);
        payload.setSuccess(true);
        payload.setData(data);
        payload.setMessage(message);
        payload.setTimestamp(Timestamp.currentTime());
        return payload;
    }

    /**
     * 构建结果
     *
     * @param code
     *         编码
     * @param success
     *         状态
     * @param message
     *         消息
     * @param data
     *         数据
     * @param <T>
     *         数据实体
     *
     * @return 返回结果
     */
    public static <T> OpenApiResponse<T> apiResult(int code, boolean success, String message, T data) {
        OpenApiResponse<T> response = new OpenApiResponse<>();
        response.setCode(code);
        response.setSuccess(success);
        response.setData(data);
        response.setMessage(message);
        response.setTimestamp(Timestamp.currentTime());
        return response;
    }

    /**
     * 构建结果
     *
     * @param code
     *         编码
     * @param success
     *         状态
     * @param message
     *         消息
     * @param <T>
     *         数据实体
     *
     * @return 返回结果
     */
    public static <T> OpenApiResponse<T> apiResult(int code, boolean success, String message) {
        OpenApiResponse<T> response = new OpenApiResponse<>();
        response.setCode(code);
        response.setSuccess(success);
        response.setData(null);
        response.setMessage(message);
        response.setTimestamp(Timestamp.currentTime());
        return response;
    }

    /**
     * 构建结果
     *
     * @param code
     *         编码
     * @param message
     *         消息
     * @param <T>
     *         数据实体
     *
     * @return 返回结果
     */
    public static <T> OpenApiResponse<T> apiResult(int code, String message, T data) {
        OpenApiResponse<T> payload = new OpenApiResponse<>();
        payload.setCode(code);
        payload.setSuccess(true);
        payload.setData(data);
        payload.setMessage(message);
        payload.setTimestamp(Timestamp.currentTime());
        return payload;
    }
}
