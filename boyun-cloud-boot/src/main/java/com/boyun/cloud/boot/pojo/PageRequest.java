package com.boyun.cloud.boot.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @className: com.boyun.cloud.boot.pojo.PageRequest
 * @projectName: 封装BoyunCloud项目-PageRequest类
 * @module: BoyunCloud项目-PageRequest类，主要位于BoyunCloud项目Boot工程模块的业务场景
 * @content: PageRequest类，主要用于完成PageRequest统一分也请求基类的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-06-19 12:01
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@Data
@ApiModel(value = "PageRequest", description = "分页Request请求参数基础实体类")
public class PageRequest implements Serializable {

  private static final long serialVersionUID = -5806027488468638495L;

  /**
   * 每页页码数
   */
  @ApiModelProperty(
          value = "pageNumber",
          name = "pageNumber",
          notes = "每页页码数",
          example = "1",
          required = true)
  @JsonProperty(value = "pageNumber")
  private Integer pageNumber;

  /**
   * 每页条目数
   */
  @ApiModelProperty(
          value = "pageSize",
          name = "pageSize",
          notes = "每页条目数",
          example = "10",
          required = true)
  @JsonProperty(value = "pageSize")
  private Integer pageSize;

  /**
   * 搜索关键词
   */
  @ApiModelProperty(
          value = "keyword",
          name = "keyword",
          notes = "关键词",
          example = "关键词",
          required = true)
  @JsonProperty(value = "keyword")
  private String keyword;
}
