package com.example.demo.basic;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet("/home/board/boardList.ko") // http://localhost:8000/home
public class HomeServlet0106 extends HttpServlet {
  public void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String upmu[] = null;
    String uri = req.getRequestURI();
    log.info(uri); // home
    upmu = uri.split("/");
    log.info(upmu.length); // 3, upmu[0] = home, upmu[1] = board, upmu[2] = boardList.ko
    // upmu[1] -> OrderController, BoardController, NoticeController, MemberController
    // upmu[2] -> boardList.do.jsp -> ko는 빼고, jsp붙여야 하므로 배열에 담을 때 ko는 제거할 것
  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    log.info("doDelete");
    doService(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    log.info("doGet");
    doService(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    log.info("doPost");
    doService(req, resp);
  }

  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    log.info("doPut");
    doService(req, resp);
  }

}

/*
 * 나는 프레임 워크를 직접 만들어 보고 싶다.
 * 오버라이드 메서드르르 분해서 사용자 정의 메서드로 구현하기
 * doGet(req,res) : return 타입은 void
 * doPost(req,res) : return 타입은 void
 * doPut(req,res) : return 타입은 void
 * doDelete(req,res) : return 타입은 void
 * 
 * 표준 서블릿은 req와 res에 의존적이다.
 * 스프링은 req와 res가 없더라도 페이지 이동처리, 세션활용,마임타임 설정.... 모두 가능하다.
 * 
 */