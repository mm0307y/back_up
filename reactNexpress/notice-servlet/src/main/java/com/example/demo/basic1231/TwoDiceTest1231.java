package com.example.demo.basic1231;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet("/roll") // Spring @Controller + @RequsetMapping
public class TwoDiceTest1231 extends HttpServlet {
  // 주사위 숫자 채번하기
  int getRandomInt(int range) {
    return new Random().nextInt(range) + 1;
  }

  @Override
  public void init() throws ServletException {
    log.info("init() - 최초 한번만 실행");

  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    log.info("service() - 요청시 마다 호출된다.");
    int runm1 = getRandomInt(6);
    int runm2 = getRandomInt(6);
    resp.setContentType("text/html");
    resp.setCharacterEncoding("utf-8");
    PrintWriter out = resp.getWriter();
    out.println("<html>");
    out.println("<body>");
    out.println("<img src='/img1231/dice" + runm1 + ".jpg'>");
    out.println("<img src='/img1231/dice" + runm2 + ".jpg'>");
    out.println("</body>");
    out.println("</html>");
    out.close(); // 스트림이 누수되는 것을 막는다.

  }

  @Override
  public void destroy() {
    // 서블릿 제거될 때 단 한번만 실행된다.
    log.info("destroy() - 자원 회수");
  }

}
