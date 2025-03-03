package com.boyun.cloud.common.repository.object.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boyun.cloud.common.repository.object.mapper.BaseMapper;
import com.boyun.cloud.common.repository.object.service.BaseService;

/**
 * @className: com.boyun.cloud.common.repository.object.service.impl.BaseServiceImpl
 * @projectName: 封装BoyunCloud项目-BaseServiceImpl类
 * @module: BoyunCloud项目-BaseServiceImpl类，主要位于BoyunCloud项目Common工程模块的业务场景
 * @content: BaseServiceImpl类，主要用于完成BaseServiceImpl领域服务统一实现的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-06-19 02:40
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
public abstract class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {

    /**
     * 新增数据-create
     *
     * @param entity
     *         参数对象
     *
     * @return 返回结果
     */
    @Override
    public boolean create(T entity) {
        return this.baseMapper.insert(entity) > 0;
    }


    /**
     * 更新数据-update
     *
     * @param entity
     *         参数对象
     *
     * @return 返回结果
     */
    @Override
    public boolean update(T entity) {
        return this.baseMapper.updateById(entity) > 0;
    }
}
