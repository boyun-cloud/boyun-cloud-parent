package com.boyun.cloud.starter.redis.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @className: com.boyun.cloud.redis.properties.DynamicRedisProperties
 * @projectName: 封装BoyunCloud项目-DynamicRedisProperties类
 * @module: BoyunCloud项目-DynamicRedisProperties类，主要位于BoyunCloud项目模块的业务场景
 * @content: DynamicRedisProperties类，主要用于完成DynamicRedisProperties-动态Redis属性配置类的封装和定义.
 * @author: Powered by Marklin
 * @datetime: 2024-07-13 16:32
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2024 BoyunCloud Systems Incorporated. All rights reserved.
 */
@ConfigurationProperties(prefix = DynamicRedisProperties.PREFIX)
public class DynamicRedisProperties {

    public static final String PREFIX = "spring.dynamic.redis";

    /**
     * 是否开启动态数据库切换 默认开启
     */
    private boolean dynamicDatabase = true;

    /**
     * 启用redis消息队列
     */
    private boolean redisQueue = true;

    /**
     * 队列消息默认db
     */
    private int queueDb = 1;

    /**
     * 消费间隔时间，单位秒
     */
    private int intervals = 5;

    public boolean isDynamicDatabase() {
        return dynamicDatabase;
    }

    public void setDynamicDatabase(boolean dynamicDatabase) {
        this.dynamicDatabase = dynamicDatabase;
    }

    public int getQueueDb() {
        return queueDb;
    }

    public void setQueueDb(int queueDb) {
        this.queueDb = queueDb;
    }

    public boolean isRedisQueue() {
        return redisQueue;
    }

    public DynamicRedisProperties setRedisQueue(boolean redisQueue) {
        this.redisQueue = redisQueue;
        return this;
    }

    public int getIntervals() {
        return intervals;
    }

    public DynamicRedisProperties setIntervals(int intervals) {
        this.intervals = intervals;
        return this;
    }
}
