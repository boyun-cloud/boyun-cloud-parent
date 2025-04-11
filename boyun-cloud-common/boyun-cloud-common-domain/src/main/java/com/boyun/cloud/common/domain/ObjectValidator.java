package com.boyun.cloud.common.domain;

import com.jieyun.cloud.common.validation.Validations;

/**
 * @className: com.jieyun.cloud.common.domain.ObjectValidator
 * @projectName: JieyunCloud项目
 * @module: JieyunCloud项目-ObjectValidator类，主要位于Common-Domain模块
 * @content: ObjectValidator-领域模型对象验证器
 * @author: Powered by Marklin
 * @datetime: 2025-04-11 15:31
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2025 JieyunCloud Systems Incorporated. All rights reserved.
 */
public interface ObjectValidator extends MarkerInterface{


    /**
     * 领域对象验证（支持Jsr380 Validation注解）<br/>
     * 注：
     * <ol>
     *     <li>建议在Domain Model多参数构造函数最末尾调用此验证逻辑，以保证Always-Valid Domain Model</li>
     *     <li>亦可使用Aspectj统一对Domain Model多参数构造函数进行织入</li>
     * </ol>
     */
    default void validateSelf() {
        Validations.validateObject(this);
    }
}
