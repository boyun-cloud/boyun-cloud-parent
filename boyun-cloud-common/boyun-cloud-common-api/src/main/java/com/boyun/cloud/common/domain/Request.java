package com.boyun.cloud.common.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @className: com.boyun.cloud.common.domain.Request
 * @projectName: 封装BoyunCloud项目-Request类
 * @module: BoyunCloud项目-Request类，主要位于BoyunCloud基础Common工程模块的业务场景
 * @content: Request类，主要用于完成Api请求Request对象接口实体的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-06-17 15:09
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
public interface Request extends Serializable {

    /**
     * 获取Token
     *
     * @return 返回Token
     */
    @JsonIgnore
    default String getToken() {
        return StringUtils.EMPTY;
    }

    /**
     * 设置Token
     *
     * @param token
     *         token值
     */
    @JsonIgnore
    default void setToken(String token) {
    }


    /**
     * 返回关联的实体类型，自定义 DTO 可以重写这个方法，返回对应的<strong>实体类型</strong>
     *
     * @return 实体类型
     */
    @JsonIgnore
    default Class<? extends Request> associateEntityClass() {
        return null;
    }
}
