package com.example.demo.di2_0210;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeptCtx0210 {
  @Bean
  public DeptController0210 deptController() { // 여기 사용된 메서드 이름이 setter 객체 주입법에서 사용하는 메서드 이름이다.
    return new DeptController0210();
  }

  @Bean
  public DeptService0210 deptService() {
    return new DeptService0210();
  }

  @Bean
  public DeptDao0210 deptDao() {
    return new DeptDao0210();
  }
}