package com.design.pattern.decorator;

/**
 * 某种调料，具体装饰者
 */
public class Sugger extends CondimentDecorator {

    Beverage beverage;//要装饰的对象

    public Sugger(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDesc() {
        return beverage.getDesc() + "加糖";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.18;
    }
}
