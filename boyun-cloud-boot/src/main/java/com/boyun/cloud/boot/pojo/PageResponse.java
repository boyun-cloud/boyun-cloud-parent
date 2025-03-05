package com.boyun.cloud.boot.pojo;

import com.boyun.cloud.boot.constant.Constants;
import com.boyun.cloud.boot.utils.ObjectsUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @className: com.boyun.cloud.boot.pojo.PageResponse
 * @projectName: 封装BoyunCloud项目-PageResponse类
 * @module: BoyunCloud项目-PageResponse类，主要位于BoyunCloud项目Boot工程模块的业务场景
 * @content: PageResponse类，主要用于完成PageResponse统一分页响应实体的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-06-19 12:02
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@Data
@ApiModel(value = "PageResponse<T>", description = "分页Response响应结果统一实体")
@SuppressWarnings("ALL")
public class PageResponse<T> implements Serializable {

    private static final long serialVersionUID = -1594861375090801138L;

    /**
     * 总记录数
     */
    @ApiModelProperty(value = "pageTotal", name = "pageTotal", notes = "总记录数", example = "1", required = true)
    @JsonProperty(value = "pageTotal")
    private long pageTotal;

    /**
     * 数据集合
     */
    @ApiModelProperty(value = "elements", name = "elements", notes = "数据集合", example = "1", required = true)
    @JsonProperty(value = "elements")
    private List<T> elements;

    /**
     * 当前页码数量
     */
    @ApiModelProperty(value = "pageNumber", name = "pageNumber", notes = "当前页码数量", example = "1", required = true)
    @JsonProperty(value = "pageNumber")
    private int pageNumber;

    /**
     * 每页数量
     */
    @ApiModelProperty(value = "pageSize", name = "pageSize", notes = "每页数量", example = "1", required = true)
    @JsonProperty(value = "pageSize")
    private int pageSize;

    /**
     * 总页码数
     */
    @ApiModelProperty(value = "pageCount", name = "pageCount", notes = "总页码数", example = "1", required = true)
    @JsonProperty(value = "pageCount")
    private int pageCount;

    /**
     * 当前页的数量
     */
    @ApiModelProperty(value = "pageCurrent", name = "pageCurrent", notes = "当前页的数量", example = "1", required = true)
    @JsonProperty(value = "pageCurrent")
    private int pageCurrent;

    public PageResponse() {
        // 默认总记录数为0
        this.pageTotal = Constants.NORMAL;
        // 默认数据集合为空列表
        this.elements = Lists.newArrayList();
        // 默认当前页码数量为1
        this.pageNumber = Constants.PAGE_NUMBER;
        // 默认每页数量为10
        this.pageSize = Constants.PAGE_SIZE;
        // 默认总页码数为1
        this.pageCount = Constants.DEFAULT;
        // 默认当前页的数量为0
        this.pageCurrent = Constants.NORMAL;
    }

    public PageResponse(List<T> list) {
        if (list != null) {
            if (list instanceof Page) {
                Page<T> page = (Page) list;
                this.pageNumber = page.getPageNum();
                this.pageSize = page.getPageSize();
                this.pageTotal = page.getTotal();
                this.pageCount = page.getPages();
                this.elements = page;
                this.pageCurrent = page.size();
            } else if (list instanceof PageInfo) {
                PageInfo<T> page = (PageInfo) list;
                this.pageNumber = page.getPageNum();
                this.pageSize = page.getPageSize();
                this.pageTotal = page.getTotal();
                this.pageCount = page.getPages();
                this.elements = page.getList();
                this.pageCurrent = page.getList().size();
            } else {
                this.pageNumber = 1;
                this.pageSize = list.size();
                this.pageTotal = list.size();
                this.pageCount = 1;
                this.elements = list;
                this.pageCurrent = list.size();
            }
        }
    }

    /**
     * 分页封装对象构造函数
     *
     * @param pageInfo
     *         pageInfo
     * @param elements
     *         content
     * @param total
     *         total
     */
    public PageResponse(PageInfo pageInfo, List<T> elements, long total) {
        this.elements = elements;
        this.pageNumber = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.pageTotal = total;
        this.pageCount = (pageSize > 0 ? ((int) (total - 1) / pageSize + 1) : 0);
        this.pageCurrent = pageInfo.getSize();
    }

    /**
     * 分页封装对象构造函数
     *
     * @param pageInfo
     *         pageInfo
     */
    public PageResponse(PageInfo pageInfo) {
        if (ObjectsUtil.isNotNull(pageInfo)) {
            this.pageNumber = pageInfo.getPageNum();
            this.pageSize = pageInfo.getPageSize();
            this.pageTotal = pageInfo.getTotal();
            this.pageCount = pageInfo.getPages();
            this.elements = pageInfo.getList();
            this.pageCurrent = pageInfo.getSize();
        } else {
            // 默认总记录数为0
            this.pageTotal = Constants.NORMAL;
            // 默认数据集合为空列表
            this.elements = Lists.newArrayList();
            // 默认当前页码数量为1
            this.pageNumber = Constants.PAGE_NUMBER;
            // 默认每页数量为10
            this.pageSize = Constants.PAGE_SIZE;
            // 默认总页码数为1
            this.pageCount = Constants.DEFAULT;
            // 默认当前页的数量为0
            this.pageCurrent = Constants.NORMAL;
        }
    }

    /**
     * 分页封装对象构造函数
     *
     * @param pageInfo
     *         pageInfo
     */
    public PageResponse(PageInfo pageInfo, List<T> elements) {
        if (ObjectsUtil.isNotNull(pageInfo)) {
            this.pageNumber = pageInfo.getPageNum();
            this.pageSize = pageInfo.getPageSize();
            this.pageTotal = pageInfo.getTotal();
            this.pageCount = pageInfo.getPages();
            this.elements = elements;
            this.pageCurrent = pageInfo.getSize();
        } else {
            // 默认总记录数为0
            this.pageTotal = Constants.NORMAL;
            // 默认数据集合为空列表
            this.elements = Lists.newArrayList();
            // 默认当前页码数量为1
            this.pageNumber = Constants.PAGE_NUMBER;
            // 默认每页数量为10
            this.pageSize = Constants.PAGE_SIZE;
            // 默认总页码数为1
            this.pageCount = Constants.DEFAULT;
            // 默认当前页的数量为0
            this.pageCurrent = Constants.NORMAL;
        }
    }
}
