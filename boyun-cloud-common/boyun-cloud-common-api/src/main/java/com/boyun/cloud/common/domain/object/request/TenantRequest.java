package com.boyun.cloud.common.domain.object.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @className: com.boyun.cloud.common.domain.object.request.TenantRequest
 * @projectName: 封装BoyunCloud项目-TenantRequest类
 * @module: BoyunCloud项目-TenantRequest类，主要位于BoyunCloud项目模块的业务场景
 * @content: TenantRequest类，主要用于完成TenantRequest的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-06-24 14:37
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TenantRequest extends BaseRequest {

    /**
     * 应用id
     */
    @Getter
    @Setter
    @ApiModelProperty(value = "应用id")
    private Long appId;

    /**
     * 租户id
     */
    @Getter
    @Setter
    @ApiModelProperty(value = "租户id")
    private Long tenantId;


    /**
     * 数据隔离id
     */
    @Getter
    @Setter
    @ApiModelProperty(value = "数据隔离id")
    private Long isolationId;
}
