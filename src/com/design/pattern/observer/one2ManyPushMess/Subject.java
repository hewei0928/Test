package com.design.pattern.observer.one2ManyPushMess;

/**
 * Created by Administrator on 2017/7/7.
 */
public interface Subject {

    public void addObserver(Observer observer);

    public void deleteObserver(Observer observer);

    public void notifyObverser();
}
