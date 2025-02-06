package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

// MVC관심사의 분리
// 원격프로그램 작성 - @Controller, @RestController
@Log4j2
@Controller
public class InfoController0203 {
  @ModelAttribute("yoil")
  public static char getYoilValue (MyDate0204 myDate) {
    Calendar calendar = Calendar.getInstance(); // 현재 날짜 시간을 갖는 클래스
    calendar.set(myDate.getYear(), myDate.getMonth()-1, myDate.getDay());
    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    char yoil = "일월화수목금토".charAt(dayOfWeek - 1);
    return yoil;
  }

  // 1. 입력분리 - request필요없다. 왜냐면 파라미터에 참조형 타입 선언하면 알아서 담아준다. - @RequestParam
  // Test URL 작성하기

  // 파라미터 타입에 @ModelAttribute를 붙이면 model에 담아주는 코드를 생략할 수 있다.
  // 왜냐하면 자동으로 담아주니까, 단, 참조형 타입만 가능하다.. 원시형 타입은 안된다.
  // @ModelAttribute는 메서드 선언시 앞에 사용하면 자동으로 메서드도 호출되고 값도 자동으로 담긴다.
  // 파라미터에 사용하면 model객체에 담을 필요없이 자동으로 담아준다.
  // http://localhost:8000/getYoil4?year=2025&month=2&day=4
  @RequestMapping("/getYoil4")
  public String getYoil4(@ModelAttribute("myDate") MyDate0204 myDate, Model model) {
    // 1. 유효성 검사
    if (!isValid(myDate.getYear(), myDate.getMonth(), myDate.getDay())) {
      return "yoilError0204";
    }

    // 2. 다음 과정 수행
    // getYoilValue 메서드 앞에 @ModelAttribute를 붙이면 @RequestMapping 파라미터에 사용된 model에 자동으로 저장해준다.
    // 심지어 메서드 호출도 자동으로 된다.
    // char yoil = getYoilValue(myDate.getYear(), myDate.getMonth(), myDate.getDay());
    // model.addAttribute("yoil", yoil); // 이 작업을 생략이 가능하다. @ModelAttribute가 자동으로 작성해 준다.
    return "getYoil4";
  }

  // http://localhost:8000/getYoil3?year=2025&month=2&day=4
  @RequestMapping("/getYoil3")
  public String getYoil3(MyDate0204 myDate, Model model) {
    // 1. 유효성 검사
    if (!isValid(myDate.getYear(), myDate.getMonth(), myDate.getDay())) {
      return "yoilError0204";
    }

    // 2. 다음 과정 수행
    char yoil = getYoilValue(myDate);

    // 3. Model에 작업 결과 저장 - 응답 화면 분리
    model.addAttribute("yoil", yoil);
    model.addAttribute("year", myDate.getYear());
    model.addAttribute("month", myDate.getMonth());
    model.addAttribute("day", myDate.getDay());
    return "getYoil3";
  }

  // 스프링은 매개변수의 변화를 감지할 수 있다.
  // 스프링은 사용자가 queryString으로 넘기는 값을 자동으로 받아준다.
  // 원시형은 받아주지 앟는다. 참조형만 받아준다.
  // http://localhost:8000/getYoil2?year=2025&month=2&day=4
  @RequestMapping("/getYoil2")
  public void getYoil2(MyDate0204 myDate, HttpServletResponse res) throws IOException {
    System.out.println(myDate.getYear() + ", " + myDate.getMonth() + "," + myDate.getDay());// "2025" , "2", "4"
    // 1. 입력을 생력할 수 있다 - 자동으로 스프링 지원해준다.
    // 2. 처리 부터 관여
    Calendar calendar = Calendar.getInstance(); // 현재 날짜 시간을 갖는 클래스
    calendar.set(myDate.getYear(), myDate.getMonth() - 1, myDate.getDay());
    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    char yoil = "일월화수목금토".charAt(dayOfWeek - 1);
    
    // 3. 출력 - 작업 결과를 브라우저에 전송
    // 한글 윈도우 - MS949
    res.setCharacterEncoding("ms949");
    PrintWriter out = res.getWriter();
    out.print("<html>");
    out.print("<body>");
    out.print(myDate.getYear() + "-" + myDate.getMonth() + "-" + myDate.getDay() + " " + yoil + "요일 입니다.");
    out.print("</body>");
    out.print("</html>");
    // io사용 후에는 스트림을 닫기
    out.close();
  } // end of getyoil

  @RequestMapping("/getYoil")
  // http://localhost:8000/getYoil?year=2025&month=2&day=4
  public void getYoil(HttpServletRequest req, HttpServletResponse res) throws IOException {
    // 1. 입력
    String year = req.getParameter("year"); // year=2025
    String month = req.getParameter("month"); // month=2
    String day = req.getParameter("day"); // day=4
    int yyyy = Integer.parseInt(year);
    int mm = Integer.parseInt(month);
    int dd = Integer.parseInt(day);

    // 2. 처리 - 요일을 계산
    // 메서드를 통해서 객체 생성하기
    Calendar calendar = Calendar.getInstance();
    calendar.clear();
    calendar.set(yyyy, mm - 1, dd);
    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    char yoil = "일월화수목금토".charAt(dayOfWeek - 1);
    System.out.println("오늘은 " + yoil + "요일 입니다.");

    // 3. 출력 - 작업 결과를 브라우저에 전송
    // 한글 윈도우 - MS949
    res.setCharacterEncoding("ms949");
    PrintWriter out = res.getWriter();
    out.print("<html>");
    out.print("<body>");
    out.print(year + "-" + month + "-" + day + " = " + yoil + "요일");
    out.print("</body>");
    out.print("</html>");
    // io사용 후에는 스트림을 닫기
    out.close();
  } // end of getyoil

  // 화면 없이 쿼리 스트링으로 값을 전달 할 수 있어요. - GET방식 - URL이 변한다.
  // ? 뒤에는 여러가지 값을 담아서 전달할 수 있다. (8000byte 정도 가능하다.)
  // js api - window.location.search
  // year=2025담긴다, month=2담긴다, day=3담긴다.
  // 이 때 주의할 점은 값을 구분하는 & 연산자를 반드시 붙여야 한다.
  // 톰캣 서버가 내장되어 있어서 파라미터 자리에 요청객체를 대신 주입해준다.
  // http://localhost:8000/currentDate?year=2025&month=2&day=3
  @RequestMapping("/currentDate")
  public String currentDate(HttpServletRequest req) {
    // insert here
    String year = req.getParameter("year");
    String month = req.getParameter("month");
    String day = req.getParameter("day");
    System.out.println(year + "-" + month + "-" + day);
    return "오늘 날짜 정보 " + year + "-" + month + "-" + day;
  }

  public boolean isValid(int year, int month, int day) {
    // 연도 체크: 일반적으로 연도는 1 이상이어야 함
    if (year < 1) {
      return false;
    }

    // 월 체크: 1월 ~ 12월
    if (month < 1 || month > 12) {
      return false;
    }

    // 각 월별 최대 일 수를 결정
    int maxDay;
    switch (month) {
      case 1: 
      case 3: 
      case 5: 
      case 7: 
      case 8: 
      case 10: 
      case 12:
      maxDay = 31;
      break;

      case 4: 
      case 6: 
      case 9: 
      case 11:
      maxDay = 30;
      break;

      case 2:
        // 2월의 경우 윤년이면 29일, 아니면 28일
        if (isLeapYear(year)) {
          maxDay = 29;
        } else {
          maxDay = 28;
        }
        break;
      default:
        // 이 부분은 실제로 도달하지 않음
        return false;
    }

    // 일(day) 체크: 1일 이상, 해당 월의 최대 일 이하
    if (day < 1 || day > maxDay) {
      return false;
    }
    return true;
  } // end of isValid

  private boolean isLeapYear(int year) {
    // 윤년 조건: (4의 배수이고 100의 배수가 아니거나) 또는 400의 배수
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
  } // end of isLeapYear
}
