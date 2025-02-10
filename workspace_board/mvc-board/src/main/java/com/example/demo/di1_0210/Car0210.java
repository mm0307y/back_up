package com.example.demo.di1_0210;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class Car0210 {
    @Autowired
    Engine0210 engine;

    @Autowired
    Door0210 door;

    @Override
    public String toString(){
        return "Car{" +
                "engine=" + engine +
                ", door=" + door +
                "}";
    }
}
