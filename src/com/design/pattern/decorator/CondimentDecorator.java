package com.design.pattern.decorator;


/**
 * 抽象装饰者
 */
public abstract class CondimentDecorator extends Beverage{//继承基础被装饰对象，实现多态

    @Override
    public abstract String getDesc();

}
