package com.boyun.cloud.boot;

import org.springframework.beans.factory.DisposableBean;

/**
 * @className: com.boyun.cloud.boot.Environment
 * @projectName: 封装BoyunCloud项目-Environment类
 * @module: BoyunCloud项目-Environment类，主要位于BoyunCloud基础Boot工程模块的业务场景
 * @content: Environment类，主要用于完成Environment 上下文环境父级接口封装的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-06-17 12:29
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
public interface Environment extends DisposableBean {

    /**
     * 清空上下文内容
     */
    void clearContext();
}
