package com.design.pattern.observer;

public class Test {

    public static void main(String[] args) {
        WeatherData subject = new WeatherData();
        Observer degreeDisplayElement = new DegreeDisplayElement(subject);
        Observer weatherDisplayElement = new WeatherDisplayElement(subject);
        subject.measurementsChanges("晴天", 0.1);
    }


}
