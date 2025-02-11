package com.example.demo.di1_0210;

import java.io.FileReader;
import java.util.Properties;

public class CarApp0210 {
  static Object getObject(String key) throws Exception {
    // config.txt파일을 읽어서 Properties 객체에 저장하기
    Properties prop = new Properties();
    // File f = new File("config.txt");
    prop.load(new FileReader(
        "D:\\Java\\workspace_board\\mvc-board\\src\\main\\java\\com\\example\\demo\\di1_0210\\config0210.txt"));
        // C:\\Users\\mtwd9\\Desktop\\Java\\workspace_board\\mvc-board\\src\\main\\java\\com\\example\\demo\\di1_0210  // 집

    // 클래스 정보를 가져와서 Class 객체 저장
    Class clazz = Class.forName(prop.getProperty(key));
    return clazz.newInstance(); // 객체 생성 후 반환한다.
  }

  public static void main(String[] args) throws Exception {
    Car0210 myCar = (Car0210) getObject("car");
    System.out.println(myCar);
  }
}
