package com.example.demo.di3_0210;

import com.example.demo.di1_0210.Car0210;
import com.example.demo.di1_0210.Door0210;
import com.example.demo.di1_0210.Engine0210;

public class MyAppConfigMain0211 {
  public static void main(String[] args) {
    MyAppContext0211 mac = new MyAppContext0211(MyAppConfig0211.class);
    Car0210 car = (Car0210)mac.getBean("car");
    System.out.println("car : " + car);

    Car0210 car2 = (Car0210)mac.getBean(Car0210.class);
    System.out.println("car2 : " + car2);

    // 빈들 끼리의 관계를 설명 - 수동
    Engine0210 engine = (Engine0210)mac.getBean("engine");
    // car.setEngine(engine);
    System.out.println("engine : " + engine);

    Door0210 door = (Door0210)mac.getBean("door");
    // car.setDoor(door);
    System.out.println("door : " + door);
  }
}
