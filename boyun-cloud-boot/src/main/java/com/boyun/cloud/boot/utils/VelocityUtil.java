package com.boyun.cloud.boot.utils;

import com.boyun.cloud.boot.constant.Templates;
import com.boyun.cloud.boot.exception.ApplicationException;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.StringWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @className: com.boyun.cloud.starter.boot.utils.VelocityUtil
 * @projectName: BoyunCloud项目
 * @module: BoyunCloud项目-VelocityUtil类，主要位于模板引擎工具类模块
 * @content: VelocityUtil-模板引擎工具类
 * @author: Powered by Marklin
 * @datetime: 2024-09-22 02:47
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
public class VelocityUtil {


    private VelocityUtil() {
    }

    /**
     * 替换的模板中的参数
     *
     * @param template
     *         模板
     * @param parameters
     *         参数
     *
     * @return 替换后的文本
     */
    public static String parse(String template, Map<String, String> parameters) {
        return parse(template, parameters, Templates.APP_CODE);
    }

    /**
     * 替换的模板中的参数
     *
     * @param template
     *         模板
     * @param parameters
     *         参数
     *
     * @return 替换后的文本
     */
    public static String parseObject(String template, Map<String, Object> parameters) {
        return parseObject(template, parameters, Templates.APP_CODE);
    }

    /**
     * 替换的模板中的参数
     *
     * @param template
     *         模板
     *
     * @return 替换后的文本
     */
    public static String parse(String template) {
        return parse(template, Templates.APP_CODE);
    }

    /**
     * 替换的模板中的参数
     *
     * @param template
     *         模板
     * @param tags
     *         tag
     *
     * @return 替换后的文本
     */
    public static String parse(String template, String tags) {
        return parse(template, new HashMap<>(0), tags);
    }

    /**
     * 替换的模板中的参数
     *
     * @param template
     *         模板
     * @param parameters
     *         参数
     * @param tags
     *         tag
     *
     * @return 替换后的文本
     */
    public static String parse(String template, Map<String, String> parameters, String tags) {
        VelocityContext context = new VelocityContext();
        parameters.forEach(context::put);
        return parseContext(template, context, tags);
    }

    /**
     * 替换的模板中的参数
     *
     * @param template
     *         模板
     * @param parameters
     *         参数
     * @param tags
     *         tag
     *
     * @return 替换后的文本
     */
    public static String parseObject(String template, Map<String, Object> parameters, String tags) {
        VelocityContext context = new VelocityContext();
        parameters.forEach(context::put);
        return parseContext(template, context, tags);
    }

    /**
     * 解析文本
     *
     * @param template
     *         模板
     * @param context
     *         内容
     * @param tags
     *         日志标签
     *
     * @return 返回结果
     */
    private static String parseContext(String template, VelocityContext context, String tags) {
        try (StringWriter writer = new StringWriter()) {
            Velocity.init();
            context.put(Templates.CALENDAR, Calendar.getInstance());
            context.put(Templates.DATETIMES, DateTimesUtil.class);
            context.put(Templates.STRINGS, StringsUtil.class);
            Velocity.evaluate(context, writer, tags, template);
            return writer.toString();
        } catch (Exception exception) {
            throw new ApplicationException(exception);
        }
    }
}
