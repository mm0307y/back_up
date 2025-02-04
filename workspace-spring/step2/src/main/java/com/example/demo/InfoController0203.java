package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

// MVC관심사의 분리
// 원격프로그램 작성 - @Controller, @RestController
@Log4j2
@Controller
public class InfoController0203 {
  // 스프링은 매개변수의 변화를 감지할 수 있다.
  @RequestMapping("/getYoil2")
  public String getYoil2(String year, String month, String day, HttpServletRequest req, HttpServletResponse res) throws IOException {
    System.out.println(year + ", " + month + ", " + day); // "2025", "2", "4"
    return "getYoil2";
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
    Calendar calenadar = Calendar.getInstance();
    calenadar.clear();
    calenadar.set(yyyy, mm - 1, dd);
    int dayOfWeek = calenadar.get(Calendar.DAY_OF_WEEK);
    char yoil = "일월화수목금통일".charAt(dayOfWeek - 1);
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
}
