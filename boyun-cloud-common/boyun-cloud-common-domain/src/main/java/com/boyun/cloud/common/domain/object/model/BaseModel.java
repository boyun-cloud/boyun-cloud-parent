package com.boyun.cloud.common.domain.object.model;

import com.boyun.cloud.common.domain.Model;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @className: com.boyun.cloud.common.domain.object.model.BaseModel
 * @projectName: 封装BoyunCloud项目-BaseModel类
 * @module: BoyunCloud项目-BaseModel类，主要位于BoyunCloud项目Common工程Domain模块模块的业务场景
 * @content: BaseModel类，主要用于完成BaseModel基础模版类的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-06-19 07:44
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class BaseModel implements Model {

    private static final long serialVersionUID = 264112200062767516L;

    /**
     * 主键id
     */
    @Getter
    @Setter
    private Long id;

    /**
     * 创建人id
     */
    @Getter
    @Setter
    private Long creatorId;


    /**
     * 创建人
     */
    @Getter
    @Setter
    private Long creatorName;

    /**
     * 创建时间
     */
    @Getter
    @Setter
    private Date createdTime;


    /**
     * 更新人id
     */
    @Getter
    @Setter
    private Long updatorId;

    /**
     * 更新人
     */
    @Getter
    @Setter
    private String updatorName;

    /**
     * 更新时间
     */
    @Getter
    @Setter
    private Date updatedTime;

    /**
     * 逻辑删除
     */
    @Getter
    @Setter
    private Boolean deleted;

    /**
     * 版本号
     */
    @Getter
    @Setter
    private Integer status;

    /**
     * 备注
     */
    @Getter
    @Setter
    private String remark;
}
