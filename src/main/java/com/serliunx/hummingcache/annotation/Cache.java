package com.serliunx.hummingcache.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * @author SerLiunx
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Cache {

    /**
     * 缓存的键值, 留空即使用类名+方法名的方式生成
     */
    String value() default "";

    /**
     * 缓存时间中的单元, 与time()搭配使用
     */
    TimeUnit timeUnit() default TimeUnit.MINUTES;

    /**
     * 缓存时长, 需要与timeUnit()搭配使用
     */
    int time() default 5;

    /**
     * 是否在调用方法时强制刷新缓存
     * <li>主要用于定时任务, 主动调用的方法请保持默认值
     */
    boolean forceRefresh() default false;
}
