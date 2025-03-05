package com.boyun.cloud.boot.constant;

/**
 * @className: com.boyun.cloud.boot.constant.Formats
 * @projectName: 封装BoyunCloud项目-Formats类
 * @module: BoyunCloud项目-Formats类，主要位于BoyunCloud项目模块的业务场景
 * @content: Formats类，主要用于完成Formats的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-06-24 14:41
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
public interface Formats {

    /**
     * 年
     */
    String YEAR = "yyyy";
    /**
     * 月
     */
    String MONTH = "MM";

    /**
     * 日
     */
    String DAY = "dd";

    /**
     * 时
     */
    String HOUR = "HH";

    /**
     * 分
     */
    String MINUTE = "mm";

    /**
     * 秒
     */
    String SECOND = "ss";

    /**
     * 日期
     */
    String DATE = YEAR + Constants.LINE + MONTH + Constants.LINE + DAY;

    /**
     * 时间
     */
    String TIME = HOUR + Constants.COLON + MINUTE + Constants.COLON + SECOND;

    /**
     * 时间
     */
    String HOUR_MINUTE = HOUR + Constants.COLON + MINUTE;

    /**
     * 日期+时间
     */
    String DATETIME = DATE + Constants.SPACE + TIME;

    /**
     * 日期+时间
     */
    String SEQUENCE = YEAR + MONTH + DAY + HOUR + MINUTE + SECOND;
}
