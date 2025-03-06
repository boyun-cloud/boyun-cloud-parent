package com.boyun.cloud.boot.pojo;

import com.boyun.cloud.boot.constant.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Maps;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.*;

/**
 * @className: com.boyun.cloud.boot.pojo.UserInfo
 * @projectName: 封装BoyunCloud项目-UserInfo类
 * @module: BoyunCloud项目-UserInfo类，主要位于BoyunCloud项目Boot工程模块的业务场景
 * @content: UserInfo类，主要用于完成UserInfo系统统一用户信息的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-06-19 13:20
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "系统用户信息(UserInfo)响应对象")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -1901869084733125293L;

    /**
     * 应用Id
     */
    @ApiModelProperty(value = "应用Id", name = "appId")
    private Long appId;

    /**
     * 用户池Id
     */
    @ApiModelProperty(value = "用户池Id", name = "poolId")
    private Long poolId;

    /**
     * 租户Id
     */
    @ApiModelProperty(value = "租户Id", name = "userId")
    private Long tenantId;

    /**
     * 商户Id
     */
    @ApiModelProperty(value = "商户Id", name = "merchantId")
    private Long merchantId;

    /**
     * 伙伴Id
     */
    @ApiModelProperty(value = "伙伴Id", name = "partnerId")
    private Long partnerId;

    /**
     * 店铺Id
     */
    @ApiModelProperty(value = "店铺Id", name = "storeId")
    private Long storeId;

    /**
     * 用户Id
     */
    @ApiModelProperty(value = "用户Id", name = "userId")
    private Long userId;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码", name = "phone")
    private String phone;

    /**
     * 登录账号
     */
    @ApiModelProperty(value = "登录账号", name = "account")
    private String account;

    /**
     * 登录人名
     */
    @ApiModelProperty(value = "登录人名", name = "username")
    private String username;

    /**
     * 登录昵称
     */
    @ApiModelProperty(value = "登录昵称", name = "nickname")
    private String nickname;

    /**
     * 用户头像
     */
    @ApiModelProperty(notes = "用户头像")
    private String avatar;

    /**
     * 登录状态
     */
    @ApiModelProperty(value = "状态[0=禁用，1=启用，2=冻结,3注销]", name = "status")
    private Integer status;

    /**
     * 登录账户角色集合
     */
    @ApiModelProperty(value = "状态[0=禁用，1=启用，2=冻结,3注销]", name = "roles")
    private List<String> roles;

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

    /**
     * 创建时间
     */
    @ApiModelProperty(notes = "创建时间")
    @JsonFormat(pattern = Constants.UNIFIED_FORMAT_TIME)
    private Date createTime;

    /**
     * 上次登录时间
     */
    @ApiModelProperty(notes = "上次登录时间")
    @JsonFormat(pattern = Constants.UNIFIED_FORMAT_TIME)
    private Date lastLogin;

    /**
     * 登录类型
     */
    @ApiModelProperty("登录类型 1 pc")
    private String parentName;

    /**
     * 登录类型
     */
    @ApiModelProperty("登录类型 1 pc")
    private Long parentId;

    /**
     * 登录类型
     */
    @ApiModelProperty("登录类型 1 pc")
    private String companyName;

    /**
     * 登录类型
     */
    @ApiModelProperty("登录类型 1 pc")
    private Integer loginType = 1;

    /**
     * 账户类型[0-系统用户 1-商户用户 2-租户用户 3-商家用户 4-员工用户 5-业务伙伴 6-游客]
     */
    @ApiModelProperty("账户类型[0-系统用户 1-商户用户 2-租户用户 3-商家用户 4-员工用户 5-业务伙伴 6-游客]")
    private Integer userType = 1;

    /**
     * 管理员标识[0-否 1-是]
     */
    @ApiModelProperty("管理员标识[0-否 1-是]")
    private Integer adminIdentifier = 0;

    /**
     * 首页权限标识[0-系统首页 1-统计分析 2-点单首页]
     */
    @ApiModelProperty("首页权限标识[0-系统首页 1-统计分析 2-点单首页]")
    private Integer indexIdentifier = 0;

    /**
     * 用户角色Id
     */
    @ApiModelProperty("用户角色Id")
    private Long authorityId;

    /**
     * 用户角色列表
     */
    @ApiModelProperty("用户角色列表")
    private List<String> authorities = new ArrayList<>();

    /**
     * 用户权限列表
     */
    @ApiModelProperty("用户权限列表")
    private List<String> permissions = new ArrayList<>();

    /**
     * 用户动态属性
     */
    @ApiModelProperty("用户动态属性")
    private Map<String, Object> attributes = Maps.newHashMap();
}
