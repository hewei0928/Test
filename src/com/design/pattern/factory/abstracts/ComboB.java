package com.design.pattern.factory.abstracts;

/**
 * Created by Administrator on 2017/6/27.
 */
public class ComboB implements Factory {

    @Override
    public IceBox createIceBox() {
        return new IceBoxB();
    }

    @Override
    public Washer createWasher() {
        return new WasherB();
    }
}
