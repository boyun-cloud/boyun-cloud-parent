package com.boyun.cloud.common.repository.object.service;

import com.boyun.cloud.common.repository.Service;

/**
 * @className: com.boyun.cloud.common.repository.object.service.BaseService
 * @projectName: 封装BoyunCloud项目-BaseService类
 * @module: BoyunCloud项目-BaseService类，主要位于BoyunCloud项目Common工程模块的业务场景
 * @content: BaseService类，主要用于完成BaseService统一领域服务Service的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-06-19 02:38
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
public interface BaseService<T>  extends Service<T> {

    /**
     * 新增数据-create
     * @param entity 参数对象
     * @return 返回结果
     */
    boolean create(T entity);


    /**
     * 更新数据-update
     * @param entity 参数对象
     * @return 返回结果
     */
    boolean update(T entity);

}
