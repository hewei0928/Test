package com.design.pattern.observer;

/**
 * 温度显示告示牌, 显示温度
 */
public class DegreeDisplayElement implements Observer, DisplayElement {

    private Double degree;
    private Subject subject;

    public DegreeDisplayElement(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void diplay() {
        System.out.println("温度公告牌显示当前温度为：" + this.degree);
    }

    @Override
    public void update(String weather, Double degree) {
        System.out.println("温度公告牌更新");
        this.degree = degree;
        diplay();
    }
}
