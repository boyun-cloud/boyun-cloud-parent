package com.boyun.cloud.common.domain.object.request;

import com.boyun.cloud.boot.constant.Formats;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @className: com.boyun.cloud.common.domain.object.request.QueryRequest
 * @projectName: 封装BoyunCloud项目-QueryRequest类
 * @module: BoyunCloud项目-QueryRequest类，主要位于BoyunCloud项目模块的业务场景
 * @content: QueryRequest类，主要用于完成QueryRequest的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-06-24 14:39
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QueryRequest extends BaseRequest {

    /**
     * 开始时间
     */
    @Getter
    @Setter
    @NotNull(message = "开始时间不能为空!")
    @DateTimeFormat(pattern = Formats.DATETIME)
    @JsonFormat(pattern = Formats.DATETIME, timezone = "GMT+8")
    @ApiModelProperty(value = "开始时间", required = true)
    private Date beginTime;

    /**
     * 结束时间
     */
    @Getter
    @Setter
    @NotNull(message = "结束时间不能为空!")
    @DateTimeFormat(pattern = Formats.DATETIME)
    @JsonFormat(pattern = Formats.DATETIME, timezone = "GMT+8")
    @ApiModelProperty(value = "结束时间", required = true)
    private Date endTime;

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
