package com.design.pattern.singleton.lazy;

import org.jetbrains.annotations.Contract;

/**
 * Created by Administrator on 2017/6/27.
 */
public class LazySingleton {

    private static LazySingleton LazySingleton = null;

    public static LazySingleton getInstance(){
        for(int i = 0; i < 10000; i++){
            i = i + 1 - 1;
        }
        if(LazySingleton == null){
            LazySingleton = new LazySingleton();
        }

        return LazySingleton;
    }

    public static synchronized LazySingleton getInstance1(){
        if(LazySingleton == null){
            LazySingleton = new LazySingleton();
        }
        return LazySingleton;
    }


    private static class SingletonFactory{
        private static LazySingleton instance = new LazySingleton();
    }

    @Contract(pure = true)
    public static LazySingleton getInstance2(){
        return SingletonFactory.instance;
    }
}
