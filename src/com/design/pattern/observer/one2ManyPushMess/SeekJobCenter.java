package com.design.pattern.observer.one2ManyPushMess;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/7.
 */
public class SeekJobCenter implements Subject {

    private String mess;
    private boolean changed;
    private ArrayList<Observer> personList;

    public SeekJobCenter() {
        personList = new ArrayList<>();
        mess = "";
        changed = false;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public ArrayList<Observer> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Observer> personList) {
        this.personList = personList;
    }

    @Override
    public void addObserver(Observer observer) {
        if(!personList.contains(observer)){
            personList.add(observer);
        }
    }

    @Override
    public void deleteObserver(Observer observer) {
        if(personList.contains(observer)){
            personList.remove(observer);
        }
    }

    @Override
    public void notifyObverser() {
        if(changed){
            for(int i = 0; i < personList.size(); i++){
                Observer o = personList.get(i);
                o.hearTelephone(mess);
            }
            changed = false;
        }
    }

    public void giveNewMess(String str){
        if(str.equals(mess)){
            changed = false;
        } else {
            mess = str;
            changed = true;
        }
    }

}
