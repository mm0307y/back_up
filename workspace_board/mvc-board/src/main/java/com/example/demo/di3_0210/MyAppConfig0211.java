package com.example.demo.di3_0210;

import org.springframework.context.annotation.Bean;

import com.example.demo.di1_0210.Car0210;
import com.example.demo.di1_0210.Door0210;
import com.example.demo.di1_0210.Engine0210;

public class MyAppConfig0211 {
  @Bean
  public Car0210 car() { // 메서드 이름이 빈의 이름이 된다.
    // map.put("car", new Car0210());
    // <bean id="car" class="com.example.demo.di1_0210.Car0210" />
    Car0210 car = new Car0210();
    return car;
  }

  @Bean
  public Engine0210 engine() { // 메서드 이름이 빈의 이름이 된다.
    return new Engine0210();    
  }

  @Bean
  public Door0210 door() { // 메서드 이름이 빈의 이름이 된다.
    return new Door0210();    
  }
}
