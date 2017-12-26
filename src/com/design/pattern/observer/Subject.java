package com.design.pattern.observer;


/**
 * 主题接口
 */
public interface Subject {

    /**
     * 新订阅者订阅主题
     * @param observer 某一订阅者
     */
    void registerObserver(Observer observer);

    /**
     * 某一订阅者取消订阅本主题
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 主题发生改变时用于提醒所有订阅者
     */
    void notifyObservers();

}
