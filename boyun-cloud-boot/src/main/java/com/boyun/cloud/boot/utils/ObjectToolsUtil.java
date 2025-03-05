package com.boyun.cloud.boot.utils;


import com.boyun.cloud.boot.annotation.ApiMetaProperty;
import com.boyun.cloud.boot.pojo.ObjectSourceModel;
import com.boyun.cloud.boot.pojo.ObjectTargetModel;
import lombok.experimental.UtilityClass;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @className: com.boyun.cloud.starter.boot.utils.ObjectBeanUtil
 * @projectName: BoyunCloud项目
 * @module: BoyunCloud项目-ObjectBeanUtil类，主要位于对象Bean操作工具类模块
 * @content: ObjectBeanUtil-对象Bean操作工具类
 * @author: Powered by Marklin
 * @datetime: 2024-08-17 03:03
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@UtilityClass
public class ObjectToolsUtil {
    private static final Logger logger = LoggerFactory.getLogger(ObjectToolsUtil.class);

    /**
     * 比较两个对象不同的属性并记录返回
     *
     * @param oldObject
     *         旧对象
     * @param newObject
     *         新对象
     * @param properties
     *         可忽略对比的属性
     *
     * @return java.util.List<com.boyun.cloud.starter.boot.compare.model.ObjectTargetModel>
     */
    public static <T> List<ObjectTargetModel> compare(T oldObject, T newObject, String... properties) {
        if (oldObject != null && newObject != null) {
            // 比较全部字段
            if (properties == null || properties.length > 0) {
                if (oldObject.equals(newObject)) {
                    return Collections.emptyList();
                }
            }
            List<ObjectSourceModel> oldObjectPropertyValue = buildPropertyValues(oldObject, properties);
            if (!CollectionUtils.isEmpty(oldObjectPropertyValue)) {
                List<ObjectTargetModel> propertyModels = new ArrayList<>(oldObjectPropertyValue.size());

                List<ObjectSourceModel> newObjectPropertyValue = buildPropertyValues(newObject, properties);
                Map<String, Object> objectMap = new HashMap<>(newObjectPropertyValue.size());
                // 获取新对象所有属性值
                for (ObjectSourceModel source : newObjectPropertyValue) {
                    String propertyName = source.getProperty();
                    Object value = source.getValue();
                    objectMap.put(propertyName, value);
                }

                for (ObjectSourceModel source : oldObjectPropertyValue) {
                    String property = source.getProperty();
                    String comment = source.getComment();
                    Object value = source.getValue();
                    if (objectMap.containsKey(property)) {
                        Object newValue = objectMap.get(property);
                        ObjectTargetModel target = new ObjectTargetModel();
                        if (value != null && newValue != null) {
                            if (!value.equals(newValue)) {
                                target.setProperty(property);
                                target.setComment(comment);
                                target.setOldValue(value);
                                target.setNewValue(newValue);
                                propertyModels.add(target);
                            }
                        } else if ((newValue == null && value != null && !StringUtils.isBlank(value.toString()))
                                ||
                                (value == null && newValue != null && !StringUtils.isBlank(newValue.toString()))) {
                            target.setProperty(property);
                            target.setComment(comment);
                            target.setOldValue(value);
                            target.setNewValue(newValue);
                            propertyModels.add(target);
                        }
                    }
                }
                return propertyModels;
            }
        }
        return Collections.emptyList();
    }


    /**
     * 通过反射获取对象的属性名称、getter返回值类型、属性值等信息
     *
     * @param object
     *         对象
     * @param properties
     *         可忽略比对的属性
     *
     * @return java.util.List<com.boyun.cloud.starter.boot.compare.model.ObjectTargetModel>
     */
    public static <T> List<ObjectSourceModel> buildPropertyValues(T object, String... properties) {
        if (object != null) {
            Class<?> objClass = object.getClass();
            PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(objClass);
            List<ObjectSourceModel> sourceModels = new ArrayList<>(propertyDescriptors.length);

            Field[] fields = objClass.getDeclaredFields();
            List<String> ignoreList = (properties != null ? Arrays.asList(properties) : null);
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                if (ignoreList == null || !ignoreList.contains(fieldName)) {
                    ObjectSourceModel source = new ObjectSourceModel();
                    source.setProperty(fieldName);
                    source.setReturnType(field.getType());
                    Object fieldValue = getFieldValueByName(fieldName, object);
                    // 通过自定义注解@ModelPropertyMeta拿到属性注释
                    if (field.isAnnotationPresent(ApiMetaProperty.class)) {
                        ApiMetaProperty annotation = field.getAnnotation(ApiMetaProperty.class);
                        source.setComment(annotation.name());
                    }
                    source.setValue(fieldValue == null ? StringUtils.EMPTY : fieldValue);
                    sourceModels.add(source);
                }
            }
            return sourceModels;
        }
        return Collections.emptyList();
    }

    private static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(o, new Object[]{});
            return value;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

}
