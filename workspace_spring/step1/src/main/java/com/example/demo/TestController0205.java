package com.example.demo;

// 스프링 부트를 활용한 웹어플리케이션 구현 (어느만큼 제약은 필요하다.)
// 스프링도 FrontController를 제공하고 있다. - DispatcherServlet
// 원격 프로그램을 위해서 추가하는 @Controller가 개발자의 자유도를 제한하지는 않는다.
// POJO - 게시판 구현 - 필수요소 - request, response, doGet(res, req)의 리턴타입은 void, doPost(res, req)의 리턴타입은 void
// 리턴타입과 파미터를 손댈 수 없다. - 메서드 오버라이딩(재정의 - 원형 훼손 - 강제성 - 자유도를 생각하게 된다. - 틀안에서 활용한다.)
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

// 원격프로그램이려면 URL이 필요하다.
// 원격프로그램이지만 메서드 호출이 가능하다. - 한개의 메서드는 한개의 책임만 갖는다.
@Log4j2
@Controller // 어노테잉션을 누리는 대신에 약간의 제약은 존재한다.
public class TestController0205 {

  // 파라미터가 1개 인것도 허용할께 - 유연하다. - 자유도가 있다.(무한하지는 않다.)
  // http://localhost:8000/test1?year=2025
  @RequestMapping("/test1")
  public String test1(HttpServletRequest request) {
    log.info("test1 호출");
    log.info(request.getParameter("year"));
    return "test1";
  }

  // http://localhost:8000/test2
  @RequestMapping("/test2")
  public void test2() { // 파라미터가 없어도 괜찮다.
    log.info("test2 호출");
  }

  // http://localhost:8000/test3?year=2025
  @RequestMapping("/test3")
  public void test3(@RequestParam(name = "year", required = true) String year) { // 파라미터가 없어도 괜찮다.
    log.info("test3 호출");
    log.info("year : " + year); // 2025
  }

  // http://localhost:8000/test4?year=2025
  @RequestMapping("/test4")
  public void test4(@RequestParam(name = "year", required = false) String year) { // 파라미터가 없어도 괜찮다.
    log.info("test4 호출");
    log.info("year : " + year); // 2025
  }

  // 타입까지도 변환을 스프링 부트가 해준다.
  // @RequestParam - required=true 이면 필수 입력 사항이다.
  // http://localhost:8000/test5?year=2025
  @RequestMapping("/test5")
  public void test5(@RequestParam(name = "year", required = true) int year) { // 쿼리스트링이 반드시 있어야 한다.
    log.info("test5 호출");
    log.info("2025" + 1); // 20251
    log.info(year + 1); // 2026
  }

  // http://localhost:8000/test5?year=2025
  @RequestMapping("/test6")
  public void test6(@RequestParam(name = "year", required = true) int year) { // 쿼리스트링이 반드시 있어야 한다.
    log.info("test6 호출");
    log.info("2025" + 1); // 20251
    log.info(year + 1); // 2026
  }

  // http://localhost:8000/test5?year=2025
  @RequestMapping("/test7")
  public void test7(@RequestParam(name = "year", required = true, defaultValue="1") int year) { // 쿼리스트링이 반드시 있어야 한다.
    log.info("test7 호출 : " + year);
  }
}
