package com.boyun.cloud.boot.pojo;

import com.boyun.cloud.boot.constant.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @className: com.boyun.cloud.boot.pojo.CurrentUser
 * @projectName: BoyunCloud项目
 * @module: BoyunCloud项目-CurrentUser类，主要位于系统当前用户统一模型对象模块
 * @content: CurrentUser-系统当前用户统一模型对象
 * @author: Powered by Marklin
 * @datetime: 2024-07-27 19:42
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CurrentUser implements Serializable {

  private static final long serialVersionUID = 90015355975627L;

  private Long appId;

  /** 用户池Id */
  @ApiModelProperty(value = "用户池Id", name = "poolId")
  private Long poolId;

  /** 租户Id */
  @ApiModelProperty(value = "租户Id", name = "userId")
  private Long tenantId;

  /** 用户id */
  @ApiModelProperty(value = "用户id", name = "userId")
  private Long userId;

  /** phone */
  @ApiModelProperty(value = "phone", name = "phone")
  private String phone;

  /** 登录账号 */
  @ApiModelProperty(value = "登录账号", name = "userCode")
  private String account;

  /** 登录人名 */
  @ApiModelProperty(value = "登录人名", name = "username")
  private String username;

  /** 登录昵称 */
  @ApiModelProperty(value = "登录昵称", name = "nickname")
  private String nickname;

  /** 用户头像 */
  @ApiModelProperty(notes = "用户头像")
  private String avatar;

  /** 登录人名 */
  @ApiModelProperty(value = "状态[0=禁用，1=启用，2=冻结,3注销]", name = "status")
  private Integer status;

  /** 登录账户角色集合 */
  @ApiModelProperty(value = "状态[0=禁用，1=启用，2=冻结,3注销]", name = "status")
  private List<String> roles;

  /** 平台标识-[web-系统平台 app-手机端 smr-小程序] */
  @ApiModelProperty(value = "平台标识", name = "platform")
  private String platform;

  /** 创建时间 */
  @ApiModelProperty(notes = "创建时间")
  @JsonFormat(pattern = Constants.UNIFIED_FORMAT_TIME)
  private Date createTime;

  /** 上次登录时间 */
  @ApiModelProperty(notes = "上次登录时间")
  @JsonFormat(pattern = Constants.UNIFIED_FORMAT_TIME)
  private Date lastLogin;

  /** 登录类型 */
  @ApiModelProperty("登录类型 1 pc")
  private String parentName;

  /** 登录类型 */
  @ApiModelProperty("登录类型 1 pc")
  private Long parentId;

  /** 登录类型 */
  @ApiModelProperty("登录类型 1 pc")
  private String companyName;

  /** 登录类型 */
  @ApiModelProperty("登录类型 1 pc")
  private Integer loginType = 1;

  /** 用户类型 */
  @ApiModelProperty("用户类型 1 pc")
  private Integer userType = 1;

  /** 管理员标识[0-否 1-是] */
  @ApiModelProperty("管理员标识[0-否 1-是]")
  private Integer adminIdentifier = 0;

  /** 用户角色Id */
  private Long authorityId;

  /** 用户列表 */
  @ApiModelProperty("用户列表")
  private List<String> authorities = new ArrayList<>();

  /** 用户列表 */
  @ApiModelProperty("用户列表")
  private List<String> permissions = new ArrayList<>();

  /** 授权范围 */
  @ApiModelProperty("授权范围")
  private List<String> scopes = new ArrayList<>();

}
