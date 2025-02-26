package com.boyun.cloud.boot.utils;

import cn.hutool.core.text.StrFormatter;
import cn.hutool.core.util.ObjectUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * @className: com.boyun.cloud.boot.untils.StringUtil
 * @projectName: 封装BoyunCloud项目-StringUtil类
 * @module: BoyunCloud项目-StringUtil类，主要位于BoyunCloud项目模块的业务场景
 * @content: StringUtil类，主要用于完成StringUtil-自定义字符串工具类的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-07-15 10:09
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
public class StringsUtil extends StringUtils {

    /**
     * 判断参数
     *
     * @param targetValue
     *         参数值
     * @param defaultValue
     *         默认值
     * @param <T>
     *         范型
     *
     * @return 返回结果
     */
    public static <T> T nvl(T targetValue, T defaultValue) {
        return ObjectUtil.isNull(targetValue) ? targetValue : defaultValue;
    }

    /**
     * * 判断一个对象是否为空
     *
     * @param object
     *         Object
     *
     * @return true：为空 false：非空
     */
    public static boolean isNull(Object object) {
        return object == null;
    }

    /**
     * * 判断一个对象数组是否为空
     *
     * @param objects
     *         要判断的对象数组
     *         * @return true：为空 false：非空
     */
    public static boolean isEmpty(Object[] objects) {
        return isNull(objects) || (objects.length == 0);
    }

    /**
     * 格式化文本, {} 表示占位符<br>
     * 此方法只是简单将占位符 {} 按照顺序替换为参数<br>
     * 如果想输出 {} 使用 \\转义 { 即可，如果想输出 {} 之前的 \ 使用双转义符 \\\\ 即可<br>
     * 例：<br>
     * 通常使用：format("this is {} for {}", "a", "b") -> this is a for b<br>
     * 转义{}： format("this is \\{} for {}", "a", "b") -> this is \{} for a<br>
     * 转义\： format("this is \\\\{} for {}", "a", "b") -> this is \a for b<br>
     *
     * @param template
     *         文本模板，被替换的部分用 {} 表示
     * @param params
     *         参数值
     *
     * @return 格式化后的文本
     */
    public static String format(String template, Object... params) {
        if (isEmpty(params) || isEmpty(template)) {
            return template;
        }
        return StrFormatter.format(template, params);
    }

    /**
     * 非空判断
     * @param input  请求参数
     * @return 返回结果
     */
    public static boolean notEmpty(String input) {
        return StringUtils.isNotEmpty(input) && StringUtils.isNotBlank(input);
    }
}
