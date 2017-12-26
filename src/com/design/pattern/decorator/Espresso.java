package com.design.pattern.decorator;


/**
 * 基础咖啡
 */
public class Espresso extends Beverage {

    public Espresso() {
        desc = "浓缩咖啡";
    }

    @Override
    public double cost() {
        return  1.99;
    }
}
