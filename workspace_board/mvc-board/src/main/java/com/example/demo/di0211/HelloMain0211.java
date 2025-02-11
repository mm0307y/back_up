package com.example.demo.di0211;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 파일 유형별 배포 위치 중요 - FileNotFoundException
public class HelloMain0211 {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("helloBean0211.xml");
    List<String> names = new ArrayList<>();
    // List<String> names2 = new List<>();

    // 아래와 같이 하드 코딩을 하면 개발자 객체 생성을 직접 하였다.
    // 자원관리 책임도 개발자에게 있다. - 메모리 관리도 해야한다.
    HelloBean0211 helloBean = new HelloBeanImpl0211(); // 하드 코딩
    System.out.println(helloBean.getGreeting("Hi"));
    // System.out.println(helloBean);

    // ApplicationContext가 getBean 메서드를 제공한다. getBean()리턴 타입은 Object이다.
    HelloBean0211 helloBean2 = (HelloBean0211)context.getBean("helloBean"); // ApplicationContext 반을 가져온다.
    System.out.println(helloBean2.getGreeting("Hi"));
    // System.out.println(helloBean);
  }
}

/* 
 * IoC(Injection of Controller) - 역제어(제어역전)
 * 기존 방식
 * 자바를 기반으로 애플리케이션을 개발할 때 자바 객체를 생성하고 서로 간의 의존관계를
 * 연결시키는 작업에 대한 제어권은 개발되는 애플리케이션이 가진다.
 * 문제제기
 * 컴포넌트 간의 결합도가 높아서 컴포넌트 확장 및 재사용이 어려운 문제점이 발생된다.
 * 
 * IoC활용 방식
 * 제어권이 Container(ApplicationContext)에게 넘어가 객체 생명주기를 컨테이너가 전담하게 된다.
 * 장점
 * 컴포넌트간의 결합도가 낮아져 컴포넌트의 재사용 및 확장이 쉽고 컴포넌트 의존관계가 변경이 쉽다. - 유연성 
 * 
 * IoC에서 이야기하는 제어역전이란?
 * 객체 생성 및 생명 주기에 대한 제어권이 개발자에서 컨테이너로 넘어갔다.
 */