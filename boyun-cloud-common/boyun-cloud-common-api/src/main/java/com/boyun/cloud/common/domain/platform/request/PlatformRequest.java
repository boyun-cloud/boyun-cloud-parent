package com.boyun.cloud.common.domain.platform.request;

import com.boyun.cloud.boot.pojo.BaseObject;
import com.boyun.cloud.common.domain.Request;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @className: com.boyun.cloud.common.domain.platform.request.PlatformRequest
 * @projectName: 封装BoyunCloud项目-PlatformRequest类
 * @module: BoyunCloud项目-PlatformRequest类，主要位于BoyunCloud项目模块的业务场景
 * @content: PlatformRequest类，主要用于完成PlatformRequest-平台请求封装实体的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-07-16 00:59
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "应用平台平台服务统一请求对象")
public  class PlatformRequest extends BaseObject implements Request {

    private static final long serialVersionUID = 8576238687886383531L;

    /**
     * 平台标识-[web-系统平台 app-手机端 smr-小程序]
     */
    @ApiModelProperty(value = "平台标识", name = "platform")
    private String platform;

    /**
     * 终端标识-[console-应用管控平台 program-应用程序平台 management-应用管理平台]
     */
    @ApiModelProperty(value = "终端标识", name = "terminal")
    private String terminal;
}
