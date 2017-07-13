package com.design.pattern.factory.method;

/**
 * Created by Administrator on 2017/6/27.
 */
public class MethodeTest {

    public static void main(String[] args) {
        Factory f = new WasherCreater();
        f.create();
        f= new IceBoxCreater();
        f.create();
    }
}
