package com.boyun.cloud.boot.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @className: com.boyun.cloud.starter.boot.compare.model.ObjectSourceModel
 * @projectName: BoyunCloud项目
 * @module: BoyunCloud项目-ObjectSourceModel类，主要位于来源模型Model对象模块
 * @content: ObjectSourceModel-来源模型Model对象
 * @author: Powered by Marklin
 * @datetime: 2024-08-17 02:52
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@Data
public class ObjectSourceModel implements Serializable {

    private static final long serialVersionUID = -1607709627982810760L;

    /**
     * 属性名称
     */
    private String property;

    /**
     * 属性注释
     */
    private String comment;

    /**
     * 属性值
     */
    private Object value;

    /**
     * 返回值类型
     */
    private Class<?> returnType;
}
