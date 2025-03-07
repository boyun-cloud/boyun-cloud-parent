package com.boyun.cloud.common.domain.program.response;

import com.boyun.cloud.boot.pojo.BaseObject;
import com.boyun.cloud.common.domain.Response;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: com.boyun.cloud.common.domain.program.response.ProgramResponse
 * @projectName: BoyunCloud项目
 * @module: BoyunCloud项目-ProgramResponse类，主要位于应用程序模块
 * @content: ProgramResponse-应用程序响应对象
 * @author: Powered by Marklin
 * @datetime: 2024-10-16 16:22
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "应用程序服务统一响应对象")
public class ProgramResponse extends BaseObject implements Response {

    private static final long serialVersionUID = 3196414435289431988L;
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

}
