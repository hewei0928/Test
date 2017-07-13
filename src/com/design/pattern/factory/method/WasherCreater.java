package com.design.pattern.factory.method;

/**
 * Created by Administrator on 2017/6/27.
 */
public class WasherCreater implements Factory {

    @Override
    public Product create() {
        return new Washer();
    }
}
