package com.boyun.cloud.boot.aop;

import com.boyun.cloud.boot.Aspect;

/**
 * @className: com.boyun.cloud.boot.aop.ApplicationAspect
 * @projectName: BoyunCloud项目
 * @module: BoyunCloud项目-ApplicationAspect类，主要位于统一Boot模块模块
 * @content: ApplicationAspect-应用切面抽象接口
 * @author: Powered by Marklin
 * @datetime: 2025-02-26 13:29
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2025 BoyunCloud Systems Incorporated. All rights reserved.
 */
public interface ApplicationAspect extends Aspect {

    /**
     * aspect切面-切入点
     */
    void aspectPoint();
}
