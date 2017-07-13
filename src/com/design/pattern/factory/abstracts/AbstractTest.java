package com.design.pattern.factory.abstracts;

/**
 * Created by Administrator on 2017/6/27.
 */
public class AbstractTest {

    public static void main(String[] args) {
        Factory f = new ComboB();
        f.createIceBox();
        f.createWasher();
    }
}
