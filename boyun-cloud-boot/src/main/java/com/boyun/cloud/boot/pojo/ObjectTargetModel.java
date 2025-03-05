package com.boyun.cloud.boot.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @className: com.boyun.cloud.starter.boot.compare.model.ObjectTargetModel
 * @projectName: BoyunCloud项目
 * @module: BoyunCloud项目-ObjectTargetModel类，主要位于目标模型Model对象模块
 * @content: ObjectTargetModel-目标模型Model对象
 * @author: Powered by Marklin
 * @datetime: 2024-08-17 02:54
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@Data
public class ObjectTargetModel implements Serializable {

    private static final long serialVersionUID = -3531177162661845421L;

    /**
     * 属性字段名称
     */
    private String property;

    /**
     * 属性注释描述
     */
    private String comment;

    /**
     * 修改前的值
     */
    private Object oldValue;

    /**
     * 修改后的值
     */
    private Object newValue;
}
