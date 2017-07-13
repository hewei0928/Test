package com.design.pattern.factory.simple;

/**
 * Created by Administrator on 2017/6/21.
 */
public class SimpleTest {
    public static void main(String[] args) {
        SimpleFactory sf = new SimpleFactory();
        System.out.println(((Car)sf.create(Car.class)).drive());
        System.out.println(((Room)sf.create(Room.class)));
    }
}
