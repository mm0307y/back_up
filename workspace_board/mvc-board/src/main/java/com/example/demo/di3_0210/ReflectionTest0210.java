package com.example.demo.di3_0210;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.example.demo.di1_0210.Car0210;
import com.example.demo.di1_0210.Engine0210;

public class ReflectionTest0210 {
  public static void main(String[] args) throws Exception {
    Car0210 car = new Car0210();

    // 1. 객체로부터 Class객체 얻기
    // Class가 뭐죠? 설계도
    Class carClass = car.getClass();
    carClass = Car0210.class;
    carClass = Class.forName("com.example.demo.di1_0210.Car0210");
    System.out.println(car);
    Car0210 car2 = (Car0210) carClass.newInstance();
    System.out.println(car == car2);

    // 2. 클래스에서 선언된 멤버변수 (field)와 method 목록 얻기 (상위 클래스 메서드 목록)
    Field[] mvArr = carClass.getDeclaredFields();
    for (Field f : mvArr) {
      System.out.println(f.getName());
    }
    Method[] methArr = carClass.getMethods();
    for (Method mt : methArr) {
      System.out.println(mt.getName());
    }
    System.out.println("================================");

    Method[] methArr2 = carClass.getDeclaredMethods();
    for (Method mt : methArr2) {
      System.out.println(mt.getName());
    }

    Method method = carClass.getMethod("setEngine", Engine0210.class);
    method.invoke(car, new Engine0210());
    System.out.println(method);
    System.out.println("car : " + car);

    // 3. 멤버변수에 set을 붙여서 setter호출하기
    for (Field mv : mvArr) {
      System.out.println(mv);
      String methodName = "set" + StringUtils.capitalize(mv.getName());
      System.out.println(methodName); // setEngine, setDoor
    }

    // 4. 멤버변수에 @Autowired 붙었는지 확인하기
    for (Field mv : mvArr) {
      Annotation[] annArr = mv.getDeclaredAnnotations();
      for (Annotation ann : annArr) {
        System.out.println(mv.getName());
        if (ann.annotationType() == Autowired.class) {
          String methodName = "set" + StringUtils.capitalize(mv.getName());
          method = carClass.getMethod(methodName, mv.getType());
          System.out.println("Autowired method : " + method);
          method.invoke(car, mv.getType().newInstance()); // car.setEngine(new Engine());
        }
      }
    } // end of for
  } // end of main
}
