package com.design.pattern.observer.one2ManyPushMess;

/**
 * Created by Administrator on 2017/7/7.
 */
public class ObserverTest {

    public static void main(String[] args) {

        SeekJobCenter s = new SeekJobCenter();
        Observer o1 = new Student(s);
        Observer o2 = new Worker(s);

        s.giveNewMess("有新工作");
        s.notifyObverser();
        s.giveNewMess("有新工作1");
        s.notifyObverser();

    }

}
