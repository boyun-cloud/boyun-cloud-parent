package com.boyun.cloud.boot.constant;


import com.boyun.cloud.boot.utils.StringsUtil;

import java.io.File;
import java.math.BigDecimal;

/**
 * @className: com.boyun.cloud.boot.constant.Constants
 * @projectName: 封装BoyunCloud项目-Constants类
 * @module: BoyunCloud项目-Constants类，主要位于BoyunCloud项目模块的业务场景
 * @content: Constants类，主要用于完成Constants的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-06-24 14:42
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
public interface Constants {

    /**
     * UTF-8
     */
    String UTF8 = "UTF-8";

    /**
     * 并且
     */
    String AND = "&";

    /**
     * 空白格
     */
    String SPACE = StringsUtil.SPACE;

    /**
     * 空字符串
     */
    String EMPTY = StringsUtil.EMPTY;

    /**
     * 下划线
     */
    String LINE = "-";
    /**
     * 下划线
     */
    String UNDERLINE = "_";

    /**
     * 分隔符
     */
    String URL_SPLITOR = "/";

    /**
     * 竖线
     */
    String VLINE = "|";

    /**
     * 逗号
     */
    String COMMA = ",";

    /**
     * 句号
     */
    String STOP = "。";

    /**
     * 点
     */
    String DOT = ".";

    /**
     * http url冒号
     */
    String COLON = ":";

    /**
     * 百分号
     */
    String PERCENT = "%";

    /**
     * 路径分隔符
     */
    String S = File.separator;

    /**
     * 换行符
     */
    String R = "\n";

    /**
     * 转义字符
     */
    String escape = "\\";

    /**
     * 不可见字符0x01，用于分割字符串
     */
    String unsee0x01 = String.valueOf((char) 0x01);

    /**
     * 点分隔符\\.
     */
    String DOT_SPLITOR = Constants.escape + Constants.DOT;

    /**
     * 问号
     */
    String question = "?";

    /**
     * 等号
     */
    String equal = "=";

    /**
     * 井号
     */
    String well = "#";

    /**
     * at号
     */
    String at = "@";

    /**
     * !号
     */
    String exclamation = "!";

    /**
     * 成功标识码-200
     */
    Integer SUCCESS = 200;

    /**
     * 失败标识码-500
     */
    Integer FAILURE = 500;

    /**
     * 错误标识码-000
     */
    Integer ERROR = 500;

    /**
     * 错误标识码-800
     */
    Integer EXPIRED = 800;

    /**
     * 角色前缀
     */
    String ROLE = "role_";

    /**
     * 内部
     */
    String FROM_IN = "Y";

    /**
     * 标志
     */
    String FROM = "from";

    /**
     * header 中租户ID
     */
    String TENANT_ID = "tenant_id";

    /**
     * 客户端编号
     */
    String CLIENT_ID = "client_id";

    /**
     * TOC 客户端
     */
    String HEADER_TOC = "CLIENT-TOC";

    /**
     * header 中版本信息
     */
    String VERSION = "VERSION";

    /**
     * header 中版本信息
     */
    String CONTEXT = "CONTEXT";

    /**
     * 默认国际管码
     */
    String CROWN_CODE = "+86";

    /**
     * 通用标识码-0
     */
    Integer NORMAL = 0;

    Integer DEFAULT_ID = 101;

    String ID_CODE = "00";

    /**
     * 通用标识码-1
     */
    Integer DEFAULT = 1;

    /**
     * 指定标识码-2
     */
    Integer SPECIAL = 2;

    /**
     * 默认时效
     */
    Integer TIMELINESS =24;

    /**
     * 禁用标识码-0
     */
    Integer DISABLE = 0;

    /**
     * 启用标识码-1
     */
    Integer ENABLE = 1;


    /**
     * 删除标识码-1
     */
    Integer DELETE = 1;

    /**
     * 统一时间格式
     */
    String UNIFIED_FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";

    /**
     * 验证码开关
     */
    String CAPTCHA_FLAG = "captcha_flag";

    /**
     * 密码传输是否加密
     */
    String ENC_FLAG = "enc_flag";

    /**
     * 每页页码数-默认值(1)
     */
    Integer PAGE_NUMBER = 1;

    /**
     * 每页条目数-默认值(10)
     */
    Integer PAGE_SIZE = 10;

    /**
     * 金额
     */
    String DECIMAL = "0.00";

    /**
     * 金额
     */
    String HUNDRED ="100.00";

    /**
     * 默认金额(0)
     */
    BigDecimal AMOUNT = new BigDecimal(DECIMAL);

    /**
     * 默认金额(100)
     */
    BigDecimal MULTIPLE = new BigDecimal(HUNDRED);

    /**
     * 默认国家
     */
    String COUNTRY = "中国";

    /**
     * 默认国家地区
     */
    String LANGUAGE = "zh_CN";

    /**
     * 默认时间时区
     */
    String TIMEZONE = "UTC+8";

    interface Direction {
        /**
         * 1-正向
         */
        Integer FORWARD = 1;

        /**
         * 2-逆向
         */
        Integer OPPOSITE = 2;
    }

    interface Numbers {
        /**
         * 0 - Zero
         */
        Integer ZERO = 0;
        /**
         * 1 - One
         */
        Integer ONE = 1;
        /**
         * 2-Two
         */
        Integer TWO = 2;
        /**
         * 3-Three
         */
        Integer THREE = 3;
        /**
         * 4-Four
         */
        Integer FOUR = 4;

        /**
         * 5-Five
         */
        Integer FIVE = 5;
        /**
         * 6-Six
         */
        Integer SIX = 6;
        /**
         * 7-Seven
         */
        Integer SEVEN = 7;
        /**
         * 8-Eight
         */
        Integer EIGHT = 8;
        /**
         * 9-Nine
         */
        Integer NINE = 9;
    }


    /**
     * 常用数字
     */
    interface Digital {
        int NEGATIVE_ONE = -1;
        int ZERO = 0;
        int ONE = 1;
        int TWO = 2;
        int FOUR = 4;
        int EIGHT = 8;
        int SIXTEEN = 16;
    }

    /**
     * 日期时间匹配格式
     */
    interface Pattern {
        //
        // 常规模式
        // ----------------------------------------------------------------------------------------------------
        /**
         * yyyy-MM-dd
         */
        String DATE = "yyyy-MM-dd";
        /**
         * yyyy-MM-dd HH:mm:ss
         */
        String DATETIME = "yyyy-MM-dd HH:mm:ss";
        /**
         * yyyy-MM-dd HH:mm
         */
        String DATETIME_MM = "yyyy-MM-dd HH:mm";
        /**
         * yyyy-MM-dd HH:mm:ss.SSS
         */
        String DATETIME_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
        /**
         * HH:mm
         */
        String TIME = "HH:mm";
        /**
         * HH:mm:ss
         */
        String TIME_SS = "HH:mm:ss";

        //
        // 系统时间格式
        // ----------------------------------------------------------------------------------------------------
        /**
         * yyyy/MM/dd
         */
        String SYS_DATE = "yyyy/MM/dd";
        /**
         * yyyy/MM/dd HH:mm:ss
         */
        String SYS_DATETIME = "yyyy/MM/dd HH:mm:ss";
        /**
         * yyyy/MM/dd HH:mm
         */
        String SYS_DATETIME_MM = "yyyy/MM/dd HH:mm";
        /**
         * yyyy/MM/dd HH:mm:ss.SSS
         */
        String SYS_DATETIME_SSS = "yyyy/MM/dd HH:mm:ss.SSS";

        //
        // 无连接符模式
        // ----------------------------------------------------------------------------------------------------
        /**
         * yyyyMMdd
         */
        String NONE_DATE = "yyyyMMdd";
        /**
         * yyyyMMddHHmmss
         */
        String NONE_DATETIME = "yyyyMMddHHmmss";
        /**
         * yyyyMMddHHmm
         */
        String NONE_DATETIME_MM = "yyyyMMddHHmm";
        /**
         * yyyyMMddHHmmssSSS
         */
        String NONE_DATETIME_SSS = "yyyyMMddHHmmssSSS";

        /**
         * EEE MMM dd HH:mm:ss 'CST' yyyy
         */
        String CST_DATETIME = "EEE MMM dd HH:mm:ss 'CST' yyyy";

        //
        // 数字格式
        // ------------------------------------------------------------------------------
        /**
         * 无小数位 0
         */
        String NONE_DECIMAL = "0";
        /**
         * 一位小数 0.0
         */
        String ONE_DECIMAL = "0.0";
        /**
         * 两位小数 0.00
         */
        String TWO_DECIMAL = "0.00";
        /**
         * 千分位表示 无小数 #,##0
         */
        String TB_NONE_DECIMAL = "#,##0";
        /**
         * 千分位表示 一位小数 #,##0.0
         */
        String TB_ONE_DECIMAL = "#,##0.0";
        /**
         * 千分位表示 两位小数 #,##0.00
         */
        String TB_TWO_DECIMAL = "#,##0.00";

    }
}
