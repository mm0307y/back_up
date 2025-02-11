package com.example.demo.di1_0210;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.Resource;
import lombok.Data;

@Data
public class Car0210 {
  @Autowired
  public Engine0210 engine;

  @Resource
  public Door0210 door;

  @Override
  public String toString() {
    return "Car{" +
        "engine=" + engine +
        ", door=" + door +
        "}";
  }
}
