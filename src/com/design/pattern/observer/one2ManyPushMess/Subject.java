package com.design.pattern.observer.one2ManyPushMess;


/**
 * 主题接口
 */
public interface Subject {

    /**
     * 新订阅者订阅主题
     * @param observer
     */
    void registerObserver(Observer observer);

    void removeObserver()

}
