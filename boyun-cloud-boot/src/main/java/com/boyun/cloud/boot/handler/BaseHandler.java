package com.boyun.cloud.boot.handler;

import com.boyun.cloud.boot.Handler;
import com.boyun.cloud.boot.constant.Constants;
import org.apache.commons.lang3.StringUtils;

/**
 * @className: com.boyun.cloud.boot.handler.BaseHandler
 * @projectName: 封装BoyunCloud项目-BaseHandler类
 * @module: BoyunCloud项目-BaseHandler类，主要位于BoyunCloud项目模块的业务场景
 * @content: BaseHandler类，主要用于完成BaseHandler-基础处理器的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-07-12 22:53
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
public interface BaseHandler extends Handler {

    /**
     * 索引-index
     *
     * @return desc
     */
    default Integer index() {
        return Constants.NORMAL;
    }

    /**
     * 编码-code
     *
     * @return code
     */
    default String code() {
        return StringUtils.EMPTY;
    }

    /**
     * 名称-name
     *
     * @return name
     */
    default String name() {
        return StringUtils.EMPTY;
    }

    /**
     * 标题-title
     *
     * @return title
     */
    default String title() {
        return StringUtils.EMPTY;
    }

    /**
     * 码值-value
     *
     * @return value
     */
    default Integer value() {
        return Constants.NORMAL;
    }

    /**
     * 描述-desc
     *
     * @return desc
     */
    default String desc() {
        return StringUtils.EMPTY;
    }

    /**
     * 实例名称-instance
     *
     * @return instance
     */
    default String instance() {
        return StringUtils.EMPTY;
    }

    /**
     * 来源/类型-source
     *
     * @return source
     */
    default Integer source() {
        return Constants.NORMAL;
    }

    /**
     * 前缀-prefix
     *
     * @return prefix
     */
    default String prefix() {
        return StringUtils.EMPTY;
    }

    /**
     * 后缀-suffix
     *
     * @return suffix
     */
    default String suffix() {
        return StringUtils.EMPTY;
    }

    /**
     * 长度-prefix
     *
     * @return prefix
     */
    default Integer length() {
        return Constants.NORMAL;
    }

    /**
     * 应用信息-message
     *
     * @return message
     */
    default String message() {
        return StringUtils.EMPTY;
    }

    /**
     * 签名-negate
     *
     * @return negate
     */
    default Boolean negate() {
        return Boolean.FALSE;
    }

    /**
     * 单位-unit
     *
     * @return unit
     */
    default String unit() {
        return StringUtils.EMPTY;
    }

    /**
     * 组-group
     *
     * @return group
     */
    default String group() {
        return StringUtils.EMPTY;
    }

    /**
     * URL地址-urls
     *
     * @return urls
     */
    default String urls() {
        return StringUtils.EMPTY;
    }

    /**
     * 路径-path
     *
     * @return path
     */
    default String path() {
        return StringUtils.EMPTY;
    }

    /**
     * 图标-icon
     *
     * @return icon
     */
    default String icon() {
        return StringUtils.EMPTY;
    }

    /**
     * 背景图-image
     *
     * @return image
     */
    default String image() {
        return StringUtils.EMPTY;
    }

    /**
     * 元数据-meta
     *
     * @return meta
     */
    default String meta() {
        return StringUtils.EMPTY;
    }

    /**
     * 颜色-color
     *
     * @return color
     */
    default String color() {
        return StringUtils.EMPTY;
    }

}
