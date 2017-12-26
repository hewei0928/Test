package com.design.pattern.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 天气数据存储类， 公告牌从此获取数据变化
 */
public class WeatherData implements Subject {

    private List<Observer> observers;//主题的订阅者
    private String weather;
    private Double drgee;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        if (observer != null){
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        Iterator<Observer> observerIterator = observers.iterator();
        while (observerIterator.hasNext()){
            Observer o = observerIterator.next();
            if (o.equals(observer)){
                observerIterator.remove();
            }
        }
    }

    /**
     * 提醒订阅者们新的消息
     */
    @Override
    public void notifyObservers() {
        Iterator<Observer> observerIterator = observers.iterator();
        while (observerIterator.hasNext()){
            Observer observer = observerIterator.next();
            observer.update(weather, drgee);
        }
    }

    /**
     * 气象状态有更新时调用此方法通知订阅者
     */
    public void measurementsChanges(String weather, Double degree){
        this.weather = weather;
        this.drgee = degree;
        notifyObservers();
    }
}
