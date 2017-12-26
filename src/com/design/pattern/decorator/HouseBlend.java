package com.design.pattern.decorator;

/**
 * 基础咖啡
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        desc = "综合咖啡";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
