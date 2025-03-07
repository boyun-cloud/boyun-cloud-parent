package com.boyun.cloud.boot.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @className: com.boyun.cloud.boot.exception.ValidationException
 * @projectName: 封装BoyunCloud项目-CommonException类
 * @module: BoyunCloud项目-ValidationException类，主要位于BoyunCloud项目模块的业务场景
 * @content: ValidationException类，主要用于完成ValidationException-通用异常的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-07-03 11:48
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
public class ValidationException extends RuntimeException{
    private static final Logger logger = LoggerFactory.getLogger(ValidationException.class);
    private static final long serialVersionUID = 5044938065901970022L;

    private final transient Object[] parameters;

    private String code;

    /**
     * 构造器
     *
     * @param code       异常code
     * @param parameters parameters
     */
    public ValidationException(String code, Object... parameters) {
        super(code);
        this.parameters = parameters;
        this.code = code;
    }

    public ValidationException(String code, Throwable cause, Object... parameters) {
        super(code, cause);
        this.parameters = parameters;
        this.code = code;
    }

    public ValidationException(String code, Throwable cause) {
        super(code, cause);
        this.code = code;
        this.parameters = new Object[]{};
    }


    public ValidationException(Throwable cause, Object... parameters) {
        super(cause);
        this.parameters = parameters;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public String getCode() {
        return code;
    }

    public String getTrace() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = null;
        try {
            ps = new PrintStream(baos, false, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            logger.error("Error get trace, unsupported encoding.", e);
            return null;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        this.printStackTrace(ps);
        ps.flush();
        return new String(baos.toByteArray(), StandardCharsets.UTF_8);
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> map = new LinkedHashMap<>();
        map.put("code", code);
        map.put("message", super.getMessage());
        return map;
    }
}
