package com.boyun.cloud.boot.constant;

/**
 * @className: com.boyun.cloud.boot.constant.Templates
 * @projectName: BoyunCloud项目
 * @module: BoyunCloud项目-Templates类，主要位于模板常量类模块
 * @content: Templates-模板常量类
 * @author: Powered by Marklin
 * @datetime: 2024-09-22 03:16
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
public interface Templates {

    /**
     * 应用编码
     */
    String APP_CODE = "boyun-cloud";

    /**
     * Calendar
     */
    String CALENDAR = "Calendar";

    /**
     * DateTimes
     */
    String DATETIMES = "DateTimes";

    /**
     * DateTimes
     */
    String STRINGS = "Strings";

    interface Engine {

        /**
         * Freemarker模板
         */
        String FREEMARKER = "freemarker";

        /**
         * Velocity模板
         */
        String VELOCITY = "velocity";

        /**
         * Thymeleaf模板
         */
        String THYMELEAF = "thymeleaf";
    }
}
