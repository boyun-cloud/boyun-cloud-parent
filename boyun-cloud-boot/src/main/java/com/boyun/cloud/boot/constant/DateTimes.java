package com.boyun.cloud.boot.constant;

import com.boyun.cloud.boot.handler.BaseHandler;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: com.boyun.cloud.boot.constant.DateTimes
 * @projectName: BoyunCloud项目
 * @module: BoyunCloud项目-DateTimes类，主要位于时间常量类型模块
 * @content: DateTimes-时间常量类型
 * @author: Powered by Marklin
 * @datetime: 2024-08-26 16:03
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
public interface DateTimes {

    /**
     * 时间单位
     */
    @Getter
    @AllArgsConstructor
    enum Unit implements BaseHandler {

        /**
         * 年
         */
        YEAR(0, "year", "年", 0, "年(y)"),

        /**
         * 月
         */
        MONTH(1, "month", "月", 0, "个月(m)"),

        /**
         * 日
         */
        DAY(2, "day", "日", 24 * 60 * 60 * 1000, "天(d)"),

        /**
         * 时
         */
        HOUR(3, "hour", "时", 60 * 60 * 1000, "小时(h)"),

        /**
         * 分
         */
        MINUTE(4, "minute", "分", 60 * 1000, "分钟(min)"),

        /**
         * 秒
         */
        SECOND(5, "second", "秒", 1000, "秒钟(s)"),

        ;

        /**
         * 编号
         */
        private final Integer index;

        /**
         * 编码
         */
        private final String code;

        /**
         * 名称
         */
        private final String name;

        /**
         * 码值
         */
        private final Integer value;
        /**
         * 单位
         */
        private final String unit;

        /**
         * 根据Key得到枚举的Value
         *
         * @param value
         *         码值
         *
         * @return 返回编码
         */
        public static String matchCode(Integer value) {
            Unit[] operators = Unit.values();
            return Arrays.stream(operators).
                    filter(operator -> operator.getIndex().equals(value)).
                    findFirst().map(Unit::code).
                    orElse(StringUtils.EMPTY);
        }

        /**
         * 根据Key得到枚举的Name
         *
         * @param value
         *         码值
         *
         * @return 返回名称
         */
        public static String matchName(Integer value) {
            Unit[] operators = Unit.values();
            return Arrays.stream(operators).
                    filter(operator -> operator.getIndex().equals(value)).
                    findFirst().map(Unit::name).
                    orElse(StringUtils.EMPTY);
        }

        /**
         * 根据Key得到枚举的Name
         *
         * @param unit
         *         码值
         *
         * @return 返回名称
         */
        public static Integer matchValue(String unit) {
            Unit[] operators = Unit.values();
            return Arrays.stream(operators).
                    filter(operator -> operator.getUnit().equals(unit)).
                    findFirst().map(Unit::value).
                    orElse(0);
        }

        /**
         * 根据Key得到枚举的Value
         *
         * @return 返回枚举列表
         */
        public static List<Map<String, Object>> matchValueList() {
            Unit[] operators = Unit.values();
            List<Map<String, Object>> list = Lists.newArrayList();
            Arrays.stream(operators).forEachOrdered(operator -> {
                LinkedHashMap<String, Object> data = new LinkedHashMap<>();
                data.put("id", operator.index());
                data.put("code", operator.code());
                data.put("name", operator.desc());
                data.put("value", operator.value());
                data.put("unit", operator.unit);
                list.add(data);
            });
            return list;
        }

        /**
         * 索引-index
         *
         * @return desc
         */
        @Override
        public Integer index() {
            return index;
        }

        /**
         * 编码-code
         *
         * @return code
         */
        @Override
        public String code() {
            return code;
        }

        /**
         * 码值-value
         *
         * @return value
         */
        @Override
        public Integer value() {
            return value;
        }

        /**
         * 描述-desc
         *
         * @return desc
         */
        @Override
        public String desc() {
            return name;
        }

        /**
         * 单位-unit
         *
         * @return unit
         */
        @Override
        public String unit() {
            return unit;
        }

    }


    /**
     * 时间维度
     */
    @Getter
    @AllArgsConstructor
    enum Scope implements BaseHandler {
        /**
         * 年度
         */
        YEAR(0, "year", "年度", "年(y)"),

        /**
         * 季度
         */
        QUARTER(1, "quarter", "季度", "季(q)"),

        /**
         * 月度
         */
        MONTH(2, "month", "月度", "月(m)"),

        /**
         * 天时
         */
        DAY(3, "day", "天时", "天(d)"),

        /**
         * 小时
         */
        HOUR(4, "hour", "小时", "小时(h)"),

        /**
         * 分钟
         */
        MINUTE(5, "minute", "分钟", "分钟(min)"),

        /**
         * 秒钟
         */
        SECOND(6, "second", "秒钟", "秒钟(s)"),

        ;

        /**
         * 编号
         */
        private final Integer index;

        /**
         * 编码
         */
        private final String code;

        /**
         * 名称
         */
        private final String name;

        /**
         * 单位
         */
        private final String unit;

        /**
         * 根据Key得到枚举的Value
         *
         * @param value
         *         码值
         *
         * @return 返回编码
         */
        public static String matchCode(Integer value) {
            Unit[] operators = Unit.values();
            return Arrays.stream(operators).
                    filter(operator -> operator.getIndex().equals(value)).
                    findFirst().map(Unit::code).
                    orElse(StringUtils.EMPTY);
        }

        /**
         * 根据Key得到枚举的Name
         *
         * @param value
         *         码值
         *
         * @return 返回名称
         */
        public static String matchName(Integer value) {
            Unit[] operators = Unit.values();
            return Arrays.stream(operators).
                    filter(operator -> operator.getIndex().equals(value)).
                    findFirst().map(Unit::name).
                    orElse(StringUtils.EMPTY);
        }

        /**
         * 根据Key得到枚举的Name
         *
         * @param value
         *         码值
         *
         * @return 返回名称
         */
        public static String matchUnit(Integer value) {
            Unit[] operators = Unit.values();
            return Arrays.stream(operators).
                    filter(operator -> operator.getIndex().equals(value)).
                    findFirst().map(Unit::unit).
                    orElse(StringUtils.EMPTY);
        }

        /**
         * 根据Key得到枚举的Value
         *
         * @return 返回枚举列表
         */
        public static List<Map<String, Object>> matchValueList() {
            Unit[] operators = Unit.values();
            List<Map<String, Object>> list = Lists.newArrayList();
            Arrays.stream(operators).forEachOrdered(operator -> {
                LinkedHashMap<String, Object> data = new LinkedHashMap<>();
                data.put("id", operator.index());
                data.put("code", operator.code());
                data.put("name", operator.desc());
                data.put("value", operator.value());
                data.put("unit", operator.unit);
                list.add(data);
            });
            return list;
        }

        /**
         * 索引-index
         *
         * @return desc
         */
        @Override
        public Integer index() {
            return index;
        }

        /**
         * 编码-code
         *
         * @return code
         */
        @Override
        public String code() {
            return code;
        }

        /**
         * 描述-desc
         *
         * @return desc
         */
        @Override
        public String desc() {
            return name;
        }

        /**
         * 单位-unit
         *
         * @return unit
         */
        @Override
        public String unit() {
            return unit;
        }
    }
}
