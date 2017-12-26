package com.design.pattern.decorator;

/**
 * 某种调料，具体装饰者
 */
public class Mocha extends CondimentDecorator {

    Beverage beverage;//要装饰的对象

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDesc() {
        return beverage.getDesc() + "加摩卡";
    }

    @Override
    public double cost() {
        return 0.20 + beverage.cost();
    }
}
