package com.boyun.cloud.common.domain.platform.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @className: com.boyun.cloud.common.domain.platform.request.AuthenticationRequest
 * @projectName: BoyunCLoud项目
 * @module: BoyunCLoud项目-AuthenticationRequest类，主要位于Common模块统一认证请求模块模块
 * @content: AuthenticationRequest
 * @author: Powered by Marklin
 * @datetime: 2025-03-07 12:14
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2025 BoyunCLoud Systems Incorporated. All rights reserved.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "应用平台统一认证请求对象")
public class AuthenticationRequest extends PlatformRequest{

    private static final long serialVersionUID = -2067651148442487802L;

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
    @ApiModelProperty(value = "验证码", name = "captcha")
    private String captcha;
}
