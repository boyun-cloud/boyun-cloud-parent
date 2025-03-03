package com.boyun.cloud.common.domain.object.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.boyun.cloud.common.domain.Entity;
import lombok.*;

/**
 * @className: com.boyun.cloud.common.domain.object.entity.TenantEntity
 * @projectName: BoyunCloud项目
 * @module: BoyunCloud项目-TenantEntity类，主要位于Common工程统一Domain模块模块
 * @content: TenantEntity-租户实体基础类
 * @author: Powered by Marklin
 * @datetime: 2025-03-03 12:20
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2025 BoyunCloud Systems Incorporated. All rights reserved.
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TenantEntity extends BaseEntity {

    private static final long serialVersionUID = -3428730246433384031L;


    /**
     * 应用Id
     */
    @Getter
    @Setter
    @TableField(value = Entity.APP_ID)
    private Long appId;

    /**
     * 租户Id
     */
    @Getter
    @Setter
    @TableField(value = Entity.TENANT_ID)
    private Long tenantId;
}
