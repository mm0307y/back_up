package com.example.demo.controller0205;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class HomeController0205 {
  @RequestMapping("/")
  public String home() {
    log.info("home");
    return "home0205.html";
  }

  @GetMapping("/test8")
  public ModelAndView test8(@RequestParam(name = "year", required = false) int year
                          , @RequestParam(name = "month", required = false) int month
                          , @RequestParam(name = "day", required = false) int day) {
    ModelAndView mav = new ModelAndView();
    // 처리
    char yoil = getYoilValue(year, month, day);

    // Model에 처리결과를 저장하기
    mav.addObject("yoil", yoil);
    mav.addObject("year", year);
    mav.addObject("month", month);
    mav.addObject("day", day);

    // ModelAndView에 담긴 4가지 정보를 출력하는 페이지 이름 설정하기
    // 출력으로 나갈 페이지 이름을 적어두면 접두어 /WEB-INF/views0206/board0206/yoilInfo0206.jsp
    mav.setViewName("boadr0206/yoilInfo0206");
    return mav;
  } 

  public static char getYoilValue (int year, int month, int day) {
    Calendar calendar = Calendar.getInstance(); // 현재 날짜 시간을 갖는 클래스
    calendar.set(year, month-1, day);
    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    char yoil = "일월화수목금토".charAt(dayOfWeek - 1);
    return yoil;
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