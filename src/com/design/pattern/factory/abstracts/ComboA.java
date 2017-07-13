package com.design.pattern.factory.abstracts;

/**
 * Created by Administrator on 2017/6/27.
 */
public class ComboA implements Factory {

    @Override
    public IceBox createIceBox() {
        return new IceBoxA();
    }

    @Override
    public Washer createWasher() {
        return new WasherA();
    }
}
