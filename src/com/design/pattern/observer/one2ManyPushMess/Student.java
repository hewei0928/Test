package com.design.pattern.observer.one2ManyPushMess;

/**
 * Created by Administrator on 2017/7/7.
 */
public class Student implements Observer {
    private Subject subject;

    public Student(Subject subject) {
        this.subject = subject;
        subject.addObserver(this);
    }

    @Override
    public void hearTelephone(String heardMess) {
        System.out.println(this.getClass().getName() + heardMess);
    }
}
