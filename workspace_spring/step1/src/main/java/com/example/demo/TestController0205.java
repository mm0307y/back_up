package com.example.demo;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
  public void test7(@RequestParam(name = "year", required = true, defaultValue = "1") int year) { // 쿼리스트링이 반드시 있어야 한다.
    log.info("test7 호출 : " + year);
  }

  // Model과 @ModelAttribute 지원하는 현재로는 잘 사용하지 않는다.
  // 그러나 레거시 시스템에서는 주로 사영된다. ModelAndView
  // 스프링에서는 WebDataBinde 클래스가 있어서 타입 변환이 필요할 때
  // 데이터 검증을 한다.(Validator가 제공된다.)
  // 타입 변환이나 데이터 검증 중 에러가 발생하면 BindeingResult에 에러 내용을 담아준다.
  // 타입의 이슈가 부각되는 이유는 프론트와 백엔드 분리된 경우는 매우 민감한 문제이다. -> TypeScript - 타입 체크
  // queryString은 모두 문자열인데 숫자가 들어가는 경우를 말한다.
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
    mav.setViewName("board0206/yoilInfo0206");
    return mav;
  }

  public static char getYoilValue(int year, int month, int day) {
    Calendar calendar = Calendar.getInstance(); // 현재 날짜 시간을 갖는 클래스
    calendar.set(year, month - 1, day);
    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    char yoil = "일월화수목금토".charAt(dayOfWeek - 1);
    return yoil;
  }
}

/*
 * @RequestParam
 * 요청의 파라미터를 연결할 매개변수에 붙이는 어노테이션이다.
 * 주의사항은 @RequestParam을 생략하지 않고 쓰면 required=true 이어서 파라미터 값을 필수로 줘야 한다.
 * 만일 필수 값을 주지 않으면 400번 즉, Bad Request에러가 발생한다.
 * 
 * @ModelAttribute
 * 적용 대상을 Model의 속성으로 자동 추가해주는 어노테이션이다.
 * 반환 타입 또는 컨트롤러 메서드의 매개변수에 적용할 수 있다.
 * Model객체에 작업 결과를 저장하는 코드를 따로 작성하지 않아도 된다.
 */
