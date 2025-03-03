package com.boyun.cloud.common.domain.object.model;


import lombok.*;
import lombok.experimental.Accessors;

/**
 * @className: com.boyun.cloud.common.domain.object.model.TenantModel
 * @projectName: 封装BoyunCloud项目-TenantModel类
 * @module: BoyunCloud项目-TenantModel类，主要位于BoyunCloud项目模块的业务场景
 * @content: TenantModel类，主要用于完成TenantModel-租户模型对象基类的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-07-05 11:10
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class TenantModel extends BaseModel {

    private static final long serialVersionUID = 4162983208220061132L;

    /**
     * 应用Id
     */
    @Getter
    @Setter
    private Long appId;

    /**
     * 租户Id
     */
    @Getter
    @Setter
    private Long tenantId;
}
