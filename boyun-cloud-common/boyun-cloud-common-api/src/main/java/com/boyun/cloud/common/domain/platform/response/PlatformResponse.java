package com.boyun.cloud.common.domain.platform.response;

import com.boyun.cloud.boot.pojo.BaseObject;
import com.boyun.cloud.common.domain.Response;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @className: com.boyun.cloud.common.domain.platform.response.PlatformResponse
 * @projectName: 封装BoyunCloud项目-PlatformResponse类
 * @module: BoyunCloud项目-PlatformResponse类，主要位于BoyunCloud项目模块的业务场景
 * @content: PlatformResponse类，主要用于完成PlatformResponse-平台的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-07-16 01:18
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "平台服务统一响应对象")
public  class PlatformResponse extends BaseObject implements Response {

    private static final long serialVersionUID = 1177552930975245243L;

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
