package com.design.pattern.decorator;

/**
 * 基础被装饰对象, 类似于一杯淡咖啡
 */
public abstract class Beverage {

    String desc = "一杯淡咖啡";

    public String getDesc(){
        return this.desc;
    }
    public abstract double cost();

}
