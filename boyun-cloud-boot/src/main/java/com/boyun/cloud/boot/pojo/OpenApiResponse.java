package com.boyun.cloud.boot.pojo;

import cn.hutool.core.util.IdUtil;
import com.boyun.cloud.boot.Timestamp;
import com.boyun.cloud.boot.exception.ErrorMessage;
import com.boyun.cloud.boot.utils.ApiResultUtil;
import com.boyun.cloud.boot.constant.Constants;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @className: com.boyun.cloud.boot.pojo.OpenApiResponse
 * @projectName: 封装BoyunCloud项目-OpenApiResponse类
 * @module: BoyunCloud项目-OpenApiResponse类，主要位于BoyunCloud项目Boot工程模块的业务场景
 * @content: OpenApiResponse类，主要用于完成OpenApiResponse适用于OpenApi的接口请求/响应结果类的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-06-19 11:21
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@Builder
@ToString
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "OpenApi统一返回数据实体")
public class OpenApiResponse<T> implements Serializable {

    private static final long serialVersionUID = -6193349631086606932L;

    /**
     * 编码-code
     */
    @Getter
    @Setter
    @ApiModelProperty(value = "编码-code：成功标记=200，失败标记=500")
    @JsonProperty(value = "code")
    private Integer code = 200;

    /**
     * 状态-success
     */
    @Getter
    @Setter
    @ApiModelProperty(value = "状态-success：成功标记=true，失败标记=false")
    @JsonProperty(value = "success")
    private Boolean success = true;

    /**
     * 消息-message
     */
    @Getter
    @Setter
    @ApiModelProperty(value = "消息-message")
    @JsonProperty(value = "message")
    private String message = "成功";

    /**
     * 数据-data
     */
    @Getter
    @Setter
    @ApiModelProperty(value = "数据-data")
    @JsonProperty(value = "data")
    private T data;

    /**
     * 接口调用时间-timestamp
     */
    @Getter
    @Setter
    @ApiModelProperty(value = "接口调用时间-timestamp")
    @JsonProperty(value = "timestamp")
    private long timestamp;

    /**
     * 请求Id-requestId
     */
    @Getter
    @Setter
    @ApiModelProperty(value = "请求Id-requestId")
    @JsonProperty(value = "requestId")
    private String requestId;

    public OpenApiResponse() {
        this.timestamp = Timestamp.currentTime();
        this.requestId = IdUtil.objectId();
    }


    /**
     * 将传入的 result 对象，转换成另外一个泛型结果的对象
     * <p>
     * 因为 A 方法返回的 Payload 对象，不满足调用其的 B 方法的返回，所以需要进行转换。
     *
     * @param payload
     *         传入的 result 对象
     * @param <T>
     *         返回的泛型
     *
     * @return Payload 对象
     */
    public static <T> OpenApiResponse<T> error(OpenApiResponse<?> payload) {
        return ApiResultUtil.apiResult(payload.getCode(), false, payload.getMessage(), null);
    }


    /**
     * @param code
     * @param message
     * @param <T>
     *         返回的泛型
     *
     * @return Payload 对象
     */
    public static <T> OpenApiResponse<T> error(Integer code, String message) {
        return ApiResultUtil.apiResult(code, false, message, null);
    }

    /**
     * @param error
     *         错误对象
     * @param <T>
     *         返回的泛型
     *
     * @return Payload 对象
     */
    public static <T> OpenApiResponse<T> error(ErrorMessage error) {
        return ApiResultUtil.apiResult(error.getCode(), false, error.getDesc());
    }

    public static <T> OpenApiResponse<T> error(T data) {
        return ApiResultUtil.apiResult(Constants.ERROR, false, "请求失败！", data);
    }

    public static <T> OpenApiResponse<T> error(T data, String message) {
        return ApiResultUtil.apiResult(Constants.ERROR, false, message, data);
    }

    /**
     * @param payload
     *         错误对象
     * @param <T>
     *         返回的泛型
     *
     * @return Payload 对象
     */
    public static <T> OpenApiResponse<T> success(OpenApiResponse<T> payload) {
        return ApiResultUtil.apiResult(payload.getCode(), true, payload.getMessage(), payload.getData());
    }

    /**
     * @param <T>
     *         返回的泛型
     *
     * @return Payload 对象
     */
    public static <T> OpenApiResponse<T> success() {
        return ApiResultUtil.apiResult(200, true, "请求成功！", null);
    }

    /**
     * 携带数据
     *
     * @param data
     *         错误对象
     * @param <T>
     *         返回的泛型
     *
     * @return Payload 对象
     */
    public static <T> OpenApiResponse<T> success(T data) {
        return ApiResultUtil.apiResult(Constants.SUCCESS, true, "请求成功!", data);
    }

    /**
     * 携带数据和指定消息
     *
     * @param data
     *         错误对象
     * @param <T>
     *         返回的泛型
     *
     * @return Payload 对象
     */
    public static <T> OpenApiResponse<T> success(T data, String message) {
        return ApiResultUtil.apiResult(Constants.SUCCESS, true, message, data);
    }
}
