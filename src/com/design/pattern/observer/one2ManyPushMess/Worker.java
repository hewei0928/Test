package com.design.pattern.observer.one2ManyPushMess;

/**
 * Created by Administrator on 2017/7/7.
 */
public class Worker implements Observer {

    private Subject subject;

    public Worker(Subject subject) {
        this.subject = subject;
        subject.addObserver(this);
    }

    @Override
    public void hearTelephone(String heardMess) {
        System.out.println(this.getClass().getName());
    }
}
