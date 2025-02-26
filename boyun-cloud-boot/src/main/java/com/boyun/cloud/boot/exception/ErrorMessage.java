package com.boyun.cloud.boot.exception;

import lombok.Data;

import java.io.Serializable;

/**
 * @className: com.boyun.cloud.boot.exception.ErrorMessage
 * @projectName: 封装BoyunCloud项目-ErrorMessage类
 * @module: BoyunCloud项目-ErrorMessage类，主要位于BoyunCloud项目Boot工程模块的业务场景
 * @content: ErrorMessage类，主要用于完成ErrorMessage接口错误信息对象的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-06-19 11:16
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@Data
public class ErrorMessage implements Serializable {

  private static final long serialVersionUID = 5541318063593352872L;

  /** 错误码-code */
  private final Integer index;

  /** 错误码-code */
  private final Integer code;

  /** 错误提示-desc */
  private final String desc;

  public ErrorMessage(Integer index, Integer code, String desc) {
    this.index = index;
    this.code = code;
    this.desc = desc;
    }
}
