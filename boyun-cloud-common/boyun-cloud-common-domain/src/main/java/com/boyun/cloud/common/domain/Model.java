package com.boyun.cloud.common.domain;

import java.io.Serializable;

/**
 * @className: com.boyun.cloud.common.domain.Model
 * @projectName: 封装BoyunCloud项目-Model类
 * @module: BoyunCloud项目-Model类，主要位于BoyunCloud项目Common工程模块的业务场景
 * @content: Model类，主要用于完成Model操作对象的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-06-19 02:22
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
public interface Model extends Serializable {
    /**
     * 应用Id
     */
    String APP_ID ="`app_id`";

    /**
     * 租户Id
     */
    String TENANT_ID ="`tenant_id`";

    /**
     * 系统版本号
     */
    String VERSION ="`version`";

    /**
     * 创建人
     */
    String CREATOR_ID ="`creator_id`";

    /**
     * 创建时间
     */
    String CREATED_TIME ="`created_time`";

    /**
     * 更新人
     */
    String UPDATOR_ID ="`updator_id`";

    /**
     * 更新时间
     */
    String UPDATED_TIME ="`updated_time`";

    /**
     * 删除状态
     */
    String DELETED ="`deleted`";

    /**
     * 系统状态
     */
    String STATUS ="`status`";

    /**
     * 备注描述
     */
    String REMARK ="`remark`";
}
