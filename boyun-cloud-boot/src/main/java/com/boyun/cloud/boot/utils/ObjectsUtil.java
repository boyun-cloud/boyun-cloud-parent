package com.boyun.cloud.boot.utils;

import cn.hutool.core.util.ObjectUtil;
import com.boyun.cloud.boot.pojo.BaseObject;
import com.github.pagehelper.Page;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @className: com.boyun.cloud.boot.untils.ObjectToolsUtil
 * @projectName: BoyunCloud项目
 * @module: BoyunCloud项目-ObjectToolsUtil类，主要位于封装对象操作工具类模块
 * @content: ObjectToolsUtil-封装对象操作工具类
 * @author: Powered by Marklin
 * @datetime: 2024-07-27 01:47
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@SuppressWarnings("ALL")
public class ObjectsUtil extends ObjectUtil {
  /**
   * 转换列表
   *
   * @param source 目标
   * @param target 返回结果
   * @param <T> 参数类型
   * @return 返回值
   */
  public static <T> List<T> convertList(List<? extends BaseObject> source, Class<T> target) {
    if (source == null) {
      return null;
    } else {
      Iterator iterator;
      BaseObject sourceObject;
      if (source instanceof Page) {
        Page<T> targetPage = buildPageReuslt(source);
        iterator = source.iterator();

        while (iterator.hasNext()) {
          sourceObject = (BaseObject) iterator.next();
          targetPage.add(sourceObject.clone(target));
        }

        return targetPage;
      } else {
        List<T> targetList = new ArrayList();
        iterator = source.iterator();

        while (iterator.hasNext()) {
          sourceObject = (BaseObject) iterator.next();
          targetList.add(sourceObject.clone(target));
        }

        return targetList;
      }
    }
  }

  /**
   * 转换列表
   *
   * @param source 来源
   * @param target 目标
   * @param direction 层级
   * @param <T> 参数模块
   * @return 返回结果
   */
  public static <T> List<T> convertList(
          List<? extends BaseObject> source, Class<T> target, Integer direction) {
    if (source == null) {
      return null;
    } else {
      Iterator var4;
      BaseObject sourceObject;
      if (source instanceof Page) {
        Page<T> targetPage = buildPageReuslt(source);
        var4 = source.iterator();

        while (var4.hasNext()) {
          sourceObject = (BaseObject) var4.next();
          targetPage.add(sourceObject.clone(target, direction));
        }

        return targetPage;
      } else {
        List<T> targetList = new ArrayList();
        var4 = source.iterator();

        while (var4.hasNext()) {
          sourceObject = (BaseObject) var4.next();
          targetList.add(sourceObject.clone(target, direction));
        }

        return targetList;
      }
    }
  }

  /**
   * 构建分页结果
   * @param sourceList 来源列表
   * @param <T> 范型
   * @return 返回结果
   */
  private static <T> Page<T> buildPageReuslt(List<? extends BaseObject> sourceList) {
    Page<? extends BaseObject> source = (Page) sourceList;
    Page<T> target = new Page(source.getPageNum(), source.getPageSize(), source.isCount());
    target.setStartRow(source.getStartRow());
    target.setEndRow(source.getEndRow());
    target.setTotal(source.getTotal());
    target.setPages(source.getPages());
    target.setReasonable(source.getReasonable());
    target.setPageSizeZero(source.getPageSizeZero());
    target.setCountColumn(source.getCountColumn());
    target.setOrderBy(source.getOrderBy());
    target.setOrderByOnly(source.isOrderByOnly());
    return target;
  }
}
