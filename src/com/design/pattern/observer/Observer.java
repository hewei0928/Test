package com.design.pattern.observer;

import java.time.LocalDate;

/**
 * 观察者接口
 */
public interface Observer {

    /**
     * 观察者更新数据
     * @param weather 天气
     * @param degree 温度
     */
    void update( String weather, Double degree);

}
