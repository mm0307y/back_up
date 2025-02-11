package com.example.demo.di3_0210;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.example.demo.di1_0210.Door0210;
import com.example.demo.di1_0210.Engine0210;
import com.example.demo.di1_0210.SportsCar0210;

// 스프링에서 di를 활용하기 - byName 찾기, byType찾기
// 스프링 DI활용 - 재현하는 실습
public class MyAppContext0211 {
  // Map을 활용하여 객체 관리, 키값은 String 하고, 값은 생성된 객체의 주소번지
  Map<String, Object> map = new HashMap<>();

  MyAppContext0211() {
    map.put("car", new SportsCar0210()); // Ox 200
    map.put("engine", new Engine0210()); // Ox 300
    map.put("door", new Door0210()); // Ox 400
  }

  // @Bean // 이 있는 메서드 자동 등록
  public MyAppContext0211(Class<?> clazz) {
    try {
      Object config = clazz.getDeclaredConstructor().newInstance();
      Method[] methods = clazz.getDeclaredMethods();
      for (Method method : methods) {
        System.out.println("method : " + method.getName());
        for (Annotation anno : method.getDeclaredAnnotations()) {
          if (anno.annotationType() == Bean.class) {
            System.out.println("Bean 어노테이션 이면 된다.");
            try {
              Object bean = method.invoke(config);
              map.put(method.getName(), bean);
            } catch (Exception e) {
              e.printStackTrace();
            }
          }
        } // inner for
      } // outter for - 메서드 갯수
    } catch (Exception e) {

    }
    doAutowired(); // Car에 있는 @Autowired를 찾아서 빈 간의 자동 연결 처리한다. - byType으로 찾기로 처리한다.
    // doResource(); // Car에 있는 @Resource를 찾아서 빈 간의 자동 연결 처리한다. - byName으로 찾기로 처리한다.
  } // 파라미터가 있는 생성자

  private void doAutowired() {
    System.out.println("doAutowired 호출");
    for (Object obj : map.values()) {
      for (Field field : obj.getClass().getDeclaredFields()) {
        if (field.getAnnotation(Autowired.class) != null) {
          System.out.println("Autowired일 때 ");
          try {
            field.set(obj, getBean(field.getType())); // car.engine = obj;

          } catch (Exception e) {

          }
        } // Engine클래스에 붙은 Autowired찾기 - 자동으로 빈을 연결해준다.
      } // end of Inner for
    } // end of Outter for
  } // end of doAutowired

  public Object getBean(Class<?> clazz) { // byType
    for (Object obj : map.values()) {
      if (clazz.isInstance(obj)) {
        return obj;
      }
    }
    return null;
  }

  public Object getBean(String key) { // byName 빈을 찾기
    return map.get(key); // key : car, engine, door
  }

}
