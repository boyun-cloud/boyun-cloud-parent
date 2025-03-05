package com.boyun.cloud.boot.utils;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.boyun.cloud.boot.constant.Constants;
import com.boyun.cloud.boot.constant.DateTimes;
import com.boyun.cloud.boot.constant.Formats;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @className: com.boyun.cloud.boot.untils.DateTimesUtil
 * @projectName: BoyunCloud项目
 * @module: BoyunCloud项目-DateTimesUtil类，主要位于时间处理工具类模块
 * @content: DateTimesUtil-时间处理工具类
 * @author: Powered by Marklin
 * @datetime: 2024-08-26 15:25
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@UtilityClass
public class DateTimesUtil extends DateUtil {

    /**
     * 系统当前时间
     *
     * @return 返回系统当前时间
     */
    public static Date currentTime() {
        return DateTime.now();
    }

    /**
     * 根据值和单位计算时间
     *
     * @param value
     *         数值
     * @param unit
     *         单位
     *
     * @return 返回时间
     */
    @SneakyThrows
    public static Date computeTime(String value, String unit) {
        Integer presetValue = DateTimes.Unit.matchValue(unit);
        Date currentTime = DateTimesUtil.currentTime();
        Instant instant = currentTime.toInstant();
        // 这里采用的String的原因，需要支持整数和小数
        Double paramValue = Convert.toDouble(value);
        Instant future = instant.plusMillis(Convert.toLong(paramValue * presetValue));
        Date futureTime = DateTime.from(future);
        return DateUtil.parse(DateUtil.format(futureTime, Formats.DATETIME));
    }


    private static final ConcurrentMap<String, DateTimeFormatter> FORMATTER_CACHE = new ConcurrentHashMap<>(Constants.Digital.SIXTEEN);

    private static final int PATTERN_CACHE_SIZE = 500;

    /**
     * 获取当前时间的yyyy-MM-dd格式字符串
     *
     * @return 当前时间的yyyy-MM-dd格式字符串
     */
    public static String getNow() {
        return getNow(Constants.Pattern.NONE_DATETIME);
    }

    /**
     * 获取当前时间指定格式字符串
     *
     * @param pattern
     *         日期时间格式(如:yyyy-MM-dd,MM-dd-yyyy等)
     *
     * @return 当前时间指定格式字符串
     */
    private static String getNow(String pattern) {
        LocalDateTime ldt = LocalDateTime.now();
        return ldt.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * Date转换为格式化时间
     *
     * @param date
     *         date
     * @param pattern
     *         格式
     *
     * @return 时间
     */
    public static String format(Date date, String pattern) {
        return format(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()), pattern);
    }

    /**
     * localDateTime转换为格式化时间
     *
     * @param localDateTime
     *         localDateTime
     * @param pattern
     *         格式
     *
     * @return 时间
     */
    public static String format(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter formatter = createCacheFormatter(pattern);
        return localDateTime.format(formatter);
    }

    /**
     * 格式化字符串转为Date
     *
     * @param time
     *         格式化时间
     * @param pattern
     *         格式
     *
     * @return 时间
     */
    public static Date parseDate(String time, String pattern) {
        return Date.from(parseLocalDateTime(time, pattern).atZone(ZoneId.systemDefault()).toInstant());

    }

    /**
     * 格式化字符串转为LocalDateTime
     *
     * @param time
     *         格式化时间
     * @param pattern
     *         格式
     *
     * @return 时间
     */
    private static LocalDateTime parseLocalDateTime(String time, String pattern) {
        DateTimeFormatter formatter = createCacheFormatter(pattern);
        return LocalDateTime.parse(time, formatter);
    }

    /**
     * 在缓存中创建DateTimeFormatter
     *
     * @param pattern
     *         格式
     *
     * @return 时间
     */
    private static DateTimeFormatter createCacheFormatter(String pattern) {
        if (pattern == null || pattern.length() == 0) {
            throw new IllegalArgumentException("Invalid pattern specification");
        }
        DateTimeFormatter formatter = FORMATTER_CACHE.get(pattern);
        if (formatter == null) {
            if (FORMATTER_CACHE.size() < PATTERN_CACHE_SIZE) {
                formatter = DateTimeFormatter.ofPattern(pattern);
                DateTimeFormatter oldFormatter = FORMATTER_CACHE.putIfAbsent(pattern, formatter);
                if (oldFormatter != null) {
                    formatter = oldFormatter;
                }
            }
        }
        return formatter;
    }

    /**
     * 对象实例
     *
     * @return 返回结果
     */
    private static DateTimesUtil getInstance() {
        return InstanceHolder.INSTANCE;
    }


    private static class InstanceHolder {
        private static final DateTimesUtil INSTANCE = new DateTimesUtil();
    }
}
