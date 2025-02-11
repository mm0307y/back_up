package com.example.demo.di0211;

public class HelloBeanImpl0211 implements HelloBean0211 {
  // 선언만 하였다. - helloBean0211.xml 정의된 메시지값을 참조할 수 있다.
  private String msg = null;

  // setter객체 주입법 코드 이다.
  public void setMsg(String msg) {
    this.msg = msg;
  }

  @Override
  public String getGreeting(String msg) {
    return "Hello " + msg;
  }

  // Bean 초기화 된 후 호출 되는 메서드 설정
  public void initMethod() {
    System.out.println("initMethod 호출 성공");
  }

  // Bean이 소멸되기 전에 호출되는 메서드
  public void destroyMethod() {
    System.out.println("destroyMethod 호출 성공");
  }
}
