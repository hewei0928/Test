package com.design.pattern.observer;

/**
 * 天气显示公告牌，显示当前天气
 */
public class WeatherDisplayElement implements Observer, DisplayElement {

    private String weather;
    private Subject subject;

    public WeatherDisplayElement(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void diplay() {
        System.out.println("天气公告牌显示天气为：" + weather);
    }

    @Override
    public void update(String weather, Double degree) {
        System.out.println("天气公告牌更新");
        this.weather = weather;
        diplay();
    }
}
