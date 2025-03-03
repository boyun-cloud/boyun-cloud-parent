package com.boyun.cloud.common.domain.object.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.boyun.cloud.common.domain.Entity;
import lombok.*;

import java.util.Date;

/**
 * @className: com.boyun.cloud.common.domain.object.entity.BaseEntity
 * @projectName: BoyunCloud项目
 * @module: BoyunCloud项目-BaseEntity类，主要位于统一Common工程Domain模块模块
 * @content: BaseEntity-基础实体类
 * @author: Powered by Marklin
 * @datetime: 2025-03-03 12:18
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2025 BoyunCloud Systems Incorporated. All rights reserved.
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
public class BaseEntity implements Entity {

    private static final long serialVersionUID = 1363028260282722381L;
    /**
     * 版本号
     */
    @Getter
    @Setter
    @TableField(value = Entity.VERSION)
    private Integer version;

    /**
     * 创建人
     */
    @Getter
    @Setter
    @TableField(value = Entity.CREATOR_ID, fill = FieldFill.INSERT)
    private Long creatorId;

    /**
     * 创建时间
     */
    @Getter
    @Setter
    @TableField(value = Entity.CREATED_TIME, fill = FieldFill.INSERT)
    private Date createdTime;


    /**
     * 更新人
     */
    @Getter
    @Setter
    @TableField(value = Entity.UPDATOR_ID, fill = FieldFill.INSERT_UPDATE)
    private Long updatorId;


    /**
     * 更新时间
     */
    @Getter
    @Setter
    @TableField(value = Entity.UPDATED_TIME, fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    /**
     * 逻辑删除
     */
    @Getter
    @Setter
    @TableField(value = Entity.DELETED)
    private Integer deleted;

    /**
     * 版本号
     */
    @Getter
    @Setter
    @TableField(value = Entity.STATUS)
    private Integer status;

    /**
     * 备注
     */
    @Getter
    @Setter
    @TableField(value = Entity.REMARK)
    private String remark;
}
