package me.fivedragons.chapter01.item01;

import org.checkerframework.checker.units.qual.C;

// 우리가 원하는 만들어주는 객체의 특징을 팩토리 메서드의 이름으로 더 잘 표현 할 수 있음

public class Car {
    
    private String name;
    
    private int year;

    public static Car testCar(String name) {
        Car car = new Car();
        return car;
    }


    public static void main(String[] args) {
        Car car = new Car();
    }
}
