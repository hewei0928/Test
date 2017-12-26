package com.design.pattern.decorator;

public class Test {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        beverage = new Sugger(beverage);
        beverage = new Mocha(beverage);
        System.out.println(beverage.getDesc() + ": " + beverage.cost());
    }

}
