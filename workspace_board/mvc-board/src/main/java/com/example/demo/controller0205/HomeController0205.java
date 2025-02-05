package com.example.demo.controller0205;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class HomeController0205 {
  @RequestMapping("/")
  public String home() {
    log.info("home");
    return "home0205.html";
  }
}


/* 프로그래밍이란?
 * 입력 - 처리 - 출력
 * 입력 사요자가 입력한다.
 * 처리 - 동사형- 메서드
 * 웹프로그맹
 * URL -> http://localhost:8000/
 * request.getParameter("id")
 * URL을 통해서 메서드를 호출할 수 없다. -> 어떤 클래스의 메서드인가?  -> @Controller 붙어 있는 메서드이다.
 * 백엔드 즉 Spring Boot 서버로 연결이된다.
 */