package com.boyun.cloud.common.domain.object.response;

import com.boyun.cloud.boot.pojo.BaseObject;
import com.boyun.cloud.common.domain.Response;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

/**
 * @className: com.boyun.cloud.common.domain.object.response.BaseResponse
 * @projectName: 封装BoyunCloud项目-BaseResponse类
 * @module: BoyunCloud项目-BaseResponse类，主要位于BoyunCloud基础Common工程模块的业务场景
 * @content: BaseResponse类，主要用于完成BaseResponse基础响应实体的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-06-17 15:25
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BaseResponse extends BaseObject implements Response {

    private static final long serialVersionUID = -8245667239024303578L;

    /**
     * 请求Id
     */
    @Getter
    @Setter
    @ApiModelProperty(value = "请求Id")
    private Long requestId;

    /**
     * 版本号
     */
    @Getter
    @Setter
    @ApiModelProperty(value = "版本号")
    private Integer version;

    /**
     * 创建人
     */
    @Getter
    @Setter
    @ApiModelProperty(value = "创建人")
    private Long creatorId;

    /**
     * 创建时间
     */
    @Getter
    @Setter
    @ApiModelProperty(value = "时间")
    private Date createdTime;


    /**
     * 更新人
     */
    @Getter
    @Setter
    @ApiModelProperty(value = "更新人")
    private Long updatorId;


    /**
     * 更新时间
     */
    @Getter
    @Setter
    @ApiModelProperty(value = "更新时间")
    private Date updatedTime;

    /**
     * 逻辑删除
     */
    @Getter
    @Setter
    @ApiModelProperty(value = "删除")
    private Integer deleted;

    /**
     * 版本号
     */
    @Getter
    @Setter
    @ApiModelProperty(value = "版本号")
    private Integer status;

    /**
     * 备注
     */
    @Getter
    @Setter
    @ApiModelProperty(value = "备注")
    private String remark;
}
