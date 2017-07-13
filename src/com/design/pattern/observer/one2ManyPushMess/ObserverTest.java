package com.design.pattern.observer.one2ManyPushMess;

/**
 * Created by Administrator on 2017/7/7.
 */
public class ObserverTest {

    public static void main(String[] args) {

        SeekJobCenter s = new SeekJobCenter();
        Observer o1 = new Student(s);
        Observer o2 = new Worker(s);

        s.giveNewMess("���¹���");
        s.notifyObverser();
        s.giveNewMess("���¹���1");
        s.notifyObverser();

    }

}
