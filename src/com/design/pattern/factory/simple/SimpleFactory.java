package com.design.pattern.factory.simple;

/**
 * Created by Administrator on 2017/6/21.
 */
public class SimpleFactory {

    public Object create(Class<?> clazz){
        if(clazz.getName().equals(Car.class.getName())){
            return createCar();
        }else if(clazz.getName().equals((Room.class.getName()))){
            return createRoom();
        }

        return null;
    }

    private Room createRoom() {
        return new Room();
    }

    private Car createCar(){
        return new Car();
    }

}
