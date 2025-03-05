package com.boyun.cloud.boot.utils;

import com.boyun.cloud.boot.pojo.PageResponse;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * @className: com.boyun.cloud.boot.untils.BeanCopierUtil
 * @projectName: 封装BoyunCloud项目-BeanCopierUtil类
 * @module: BoyunCloud项目-BeanCopierUtil类，主要位于BoyunCloud项目Boot工程模块的业务场景
 * @content: BeanCopierUtil类，主要用于完成BeanCopierUtil对象操作工具类的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-06-19 10:30
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@UtilityClass
@SuppressWarnings("ALL")
public class BeanCopierUtil extends BeanUtils {
    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(BeanCopierUtil.class);

    /**
     * DozerBeanMapper映射
     */
    private static final Mapper objectMapper = DozerBeanMapperBuilder.buildDefault();

    /**
     * BeanCopier缓存
     */
    public static Map<String, BeanCopier> beanCopierCacheMap = Maps.newConcurrentMap();

    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = Maps.newHashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            Iterator var3 = beanMap.keySet().iterator();

            while(var3.hasNext()) {
                Object key = var3.next();
                map.put(key.toString(), beanMap.get(key));
            }
        }

        return map;
    }

    public static <T> T mapToBean(Map<String, Object> map, Class<T> clazz) {
        Object bean;
        try {
            bean = clazz.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException var4) {
            throw new RuntimeException(var4);
        }

        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return (T) bean;
    }

    public static void merge(Object source, Object target) throws BeansException {
        merge(source, target, (Class)null, (String[])null);
    }

    public static void merge(Object source, Object target, @Nullable String... ignoreProperties) throws BeansException {
        merge(source, target, (Class)null, ignoreProperties);
    }

    public static void merge(Object source, Object target, @Nullable Class<?> editable, @Nullable String... ignoreProperties) throws BeansException {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");
        Class<?> actualEditable = target.getClass();
        if (Objects.nonNull(editable)) {
            if (!editable.isInstance(target)) {
                String var10002 = target.getClass().getName();
                throw new IllegalArgumentException("Target class [" + var10002 + "] not assignable to Editable class [" + editable.getName() + "]");
            }

            actualEditable = editable;
        }

        PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
        List<String> ignoreList = Objects.nonNull(ignoreProperties) ? Arrays.asList(ignoreProperties) : null;
        PropertyDescriptor[] var8 = targetPds;
        int var9 = targetPds.length;

        for(int var10 = 0; var10 < var9; ++var10) {
            PropertyDescriptor targetPd = var8[var10];
            Method writeMethod = targetPd.getWriteMethod();
            boolean check = Objects.nonNull(writeMethod) && (Objects.isNull(ignoreList) || !ignoreList.contains(targetPd.getName()));
            if (check) {
                PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (sourcePd != null) {
                    Method readMethod = sourcePd.getReadMethod();
                    if (Objects.nonNull(readMethod) && ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType())) {
                        try {
                            if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                                readMethod.setAccessible(true);
                            }

                            Object value = readMethod.invoke(source);
                            if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                writeMethod.setAccessible(true);
                            }

                            if (Objects.nonNull(value)) {
                                writeMethod.invoke(target, value);
                            }
                        } catch (Throwable var16) {
                            throw new FatalBeanException("Could not copy property '" + targetPd.getName() + "' from source to target", var16);
                        }
                    }
                }
            }
        }

    }

    /**
     * 将source对象的属性拷贝到target对象中去
     *
     * @param source
     *         source对象
     * @param target
     *         target对象
     */
    public static void copyProperties(Object source, Object target) {
        String cacheKey = source.getClass().toString() + target.getClass().toString();

        BeanCopier beanCopier = null;

        if (!beanCopierCacheMap.containsKey(cacheKey)) {
            synchronized (BeanCopierUtil.class) {
                if (!beanCopierCacheMap.containsKey(cacheKey)) {
                    beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
                    beanCopierCacheMap.put(cacheKey, beanCopier);
                } else {
                    beanCopier = beanCopierCacheMap.get(cacheKey);
                }
            }
        } else {
            beanCopier = beanCopierCacheMap.get(cacheKey);
        }

        try {
            beanCopier.copy(source, target, null);
        } catch (Exception e) {
            logger.error("copy error", e);
            throw e;
        }

    }

    /**
     * 获取BeanCopier
     *
     * @param source
     * @param target
     *
     * @return
     */
    private static <T> BeanCopier getBeanCopier(Object source, T target) {
        String cacheKey = String.format("%s|%s", source.getClass().toString(), target.getClass().toString());
        BeanCopier beanCopier = null;

        if (!beanCopierCacheMap.containsKey(cacheKey)) {
            beanCopier = BeanCopier.create(source.getClass(), target.getClass(), true);
            beanCopierCacheMap.put(cacheKey, beanCopier); //缓存Bean对象，效率更高
        } else {
            beanCopier = beanCopierCacheMap.get(cacheKey);
        }

        return beanCopier;
    }

    /**
     * 转换对象
     *
     * @param source
     *         来源对象
     * @param targetClass
     *         目标类
     * @param <T>
     *         范型
     *
     * @return 返回结果
     */
    public static <T> T convertBean(Object source, Class<T> targetClass) {
        if (ObjectsUtil.isNull(source)) {
            return null;
        }
        return objectMapper.map(source, targetClass);
    }

    /**
     * 转换列表
     *
     * @param sourceList
     *         来源对象
     * @param targetClass
     *         目标类
     * @param <T>
     *         范型
     *
     * @return 返回结果
     */
    public static <T> List<T> convertList(List<?> sourceList, Class<T> targetClass) {
        List<T> targetList = Lists.newArrayList();
        if (CollectionsUtil.isEmpty(sourceList)) {
            return targetList;
        }
        sourceList.forEach(source -> {
            targetList.add(convertBean(source, targetClass));
        });
        return targetList;
    }



    /**
     * 转换为分页对象
     *
     * @param source
     *         来源对象
     * @param targetClass
     *         目标类
     * @param <T>
     *         范型
     * @param <M>
     *         范型
     *
     * @return 返回结果
     *
     * @throws Exception
     */
    public static <T, M> PageResponse<T> convertPage(M source, Class<T> targetClass) throws Exception {
        PageResponse result = convertBean(source, PageResponse.class);
        List<T> elements = convertList(result.getElements(), targetClass);
        result.setElements(elements);
        return result;
    }
}
