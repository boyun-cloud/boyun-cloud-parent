package com.boyun.cloud.common.domain.object.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @className: com.boyun.cloud.common.domain.object.response.QueryResponse
 * @projectName: 封装BoyunCloud项目-QueryResponse类
 * @module: BoyunCloud项目-QueryResponse类，主要位于BoyunCloud项目模块的业务场景
 * @content: QueryResponse类，主要用于完成QueryResponse的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-06-24 14:44
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QueryResponse extends BaseResponse {


    /**
     * 删除状态
     */
    @Getter
    @Setter
    @ApiModelProperty(value = "删除状态")
    private Integer deleted;

    /**
     * 版本号
     */
    @Getter
    @Setter
    @ApiModelProperty(value = "版本号")
    private Integer version;
}
