package com.example.demo.controller1230;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestBoardController0106 {
  
}
/* 
 * 스프링에서는 컨트롤러 계층을 지원하는 두 가지 어노테이션이 있다.
 * 1) @Controller
 * -> 응답페이지에 대한 처리 책임을 갖는다.
 * (response.sendRedirect(페이지 이름))
 * POJO에서는 반드시 응답객체가 있어야 응답페이지를 부를 수 있다.
 * 그런데 스프링에서는 요청객체나 응답객체가 없어도 처리가 가능하다. - 안보인다.
 * 
 * 2) @RestController
 * -> 응답을 직접 JSON포맷으로 내보낸다.
 */