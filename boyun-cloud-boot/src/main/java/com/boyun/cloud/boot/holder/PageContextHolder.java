package com.boyun.cloud.boot.holder;

import com.boyun.cloud.boot.pojo.PageResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @className: com.boyun.cloud.boot.convertor.PaginationConvertHolder
 * @projectName: 封装BoyunCloud项目-PaginationConvertHolder类
 * @module: BoyunCloud项目-PaginationConvertHolder类，主要位于BoyunCloud模块的业务场景
 * @content: PaginationConvertHolder类，主要用于完成PaginationConvertHolder的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-07-12 22:01
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@SuppressWarnings("ALL")
public class PageContextHolder {

    /**
     * 分页逻辑抽取
     *
     * @param pageNumber
     *         当前页码
     * @param pageSize
     *         条目数
     */
    public static void intercept(Integer pageNumber, Integer pageSize) {
        if (pageNumber > 0 && pageSize > 0) {
            PageHelper.startPage(pageNumber, pageSize, true, true, true);
        }
    }


    /**
     * 设置分页默认值
     *
     * @param <T>
     *         目标
     *
     * @return 返回结果
     */
    public static <T> PageResponse<T> defaultValue() {
        PageResponse<T> pageResult = new PageResponse<T>();
        return pageResult;
    }

    /**
     * 分页转换
     *
     * @param source
     *         分页源信息
     * @param elements
     *         目标数据列表
     *
     * @return 返回结果
     */
    public static <T> PageResponse<T> convert(final PageInfo source, final List<T> elements) {
        return new PageResponse<>(source, elements);
    }


    /**
     * 分页转换
     *
     * @param source
     *         分页源信息
     * @param target
     *         目标类型
     * @param <T>
     *         目标
     *
     * @return 返回结果
     */
    public static <T> PageResponse<T> convert(final PageInfo source, final Class<T> target) {
        PageResponse<T> pageResult = new PageResponse<T>();
        pageResult.setPageNumber(source.getPageNum());
        pageResult.setPageSize(source.getPageSize());
        pageResult.setPageTotal(source.getTotal());
        pageResult.setPageCurrent(source.getSize());
        pageResult.setPageCount(source.getPages());
        pageResult.setElements(source.getList());
        return pageResult;
    }
}
