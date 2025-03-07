package com.boyun.cloud.common.domain.program.request;

import com.boyun.cloud.boot.pojo.BaseObject;
import com.boyun.cloud.common.domain.Request;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: com.boyun.cloud.common.domain.program.request.ProgramRequest
 * @projectName: BoyunCloud项目
 * @module: BoyunCloud项目-ProgramRequest类，主要位于应用程序模块
 * @content: ProgramRequest-应用程序请求实体
 * @author: Powered by Marklin
 * @datetime: 2024-10-16 16:24
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ApiModel(value = "应用程序平台服务统一请求对象")
public class ProgramRequest extends BaseObject implements Request {

    private static final long serialVersionUID = -224791018861190350L;

    /**
     * 平台标识-[web-系统平台 app-手机端 smr-小程序]
     */
    @ApiModelProperty(value = "平台标识[web-系统平台 app-手机端 smr-小程序]", name = "platform")
    private String platform;

    /**
     * 登录账户
     */
    @ApiModelProperty(value = "登录账户", name = "account")
    private String account;

    /**
     * 登录密码
     */
    @ApiModelProperty(value = "登录密码", name = "password")
    private String password;

    /**
     * 登录验证码
     */
    @ApiModelProperty(value = "验证码", name = "captcha", required = true)
    private String captcha;

}
