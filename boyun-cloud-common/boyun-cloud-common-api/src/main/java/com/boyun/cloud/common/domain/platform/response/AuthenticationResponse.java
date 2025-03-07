package com.boyun.cloud.common.domain.platform.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @className: com.boyun.cloud.common.domain.platform.response.AuthenticationResponse
 * @projectName: BoyunCloud项目
 * @module: BoyunCloud项目-AuthenticationResponse类，主要位于Common模块统一认证响应模型模块
 * @content: AuthenticationResponse
 * @author: Powered by Marklin
 * @datetime: 2025-03-07 12:10
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2025 BoyunCloud Systems Incorporated. All rights reserved.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "应用平台统一认证响应对象")
public class AuthenticationResponse extends PlatformResponse{

    private static final long serialVersionUID = 3724756661379326726L;

    /**
     * 令牌Token作用域
     */
    @ApiModelProperty(value = "令牌Token作用域", name = "scope")
    private String scope;

    /**
     * Token标识
     */
    @ApiModelProperty(value = "Token标识", name = "tokenHeader")
    private String tokenHeader;

    /**
     * Token前缀
     */
    @ApiModelProperty(value = "Token前缀", name = "tokenPrefix")
    private String tokenPrefix;

    /**
     * Token类型
     */
    @ApiModelProperty(value = "Token类型", name = "tokenType")
    private String tokenType;

    /**
     * 身份凭证Token
     */
    @ApiModelProperty(value = "身份凭证Token", name = "identityToken")
    private String identityToken;

    /**
     * 访问令牌Token
     */
    @ApiModelProperty(value = "访问令牌Token", name = "accessToken")
    private String accessToken;

    /**
     * 刷新令牌Token
     */
    @ApiModelProperty(value = "刷新令牌Token", name = "refreshToken")
    private String refreshToken;

    /**
     * Token时效
     */
    @ApiModelProperty(value = "Token时效", name = "expiredTime")
    private Integer expiredTime;
}
