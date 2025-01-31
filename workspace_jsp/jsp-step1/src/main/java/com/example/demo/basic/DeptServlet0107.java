package com.example.demo.basic;

import java.io.IOException;

import com.example.demo.vo0107.DeptVO0107;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet("/dept")
public class DeptServlet0107 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    log.info("doGet 호출");
    DeptVO0107 dvo = new DeptVO0107();
    dvo.setDeptno(20);
    dvo.setDname("개발부");
    dvo.setLoc("서울");
    // jsp파일에서는 내장 객체로 제공되는 request 풀 네임을 다 적는다.
    req.setAttribute("dvo", dvo);

    // from.jsp -> to.jsp
    // -> /dept/ -> /dept/deptList.jsp 이동
    // 브라우저에는 /detp를 바라보고 있지만 실제 출력되는 화면은 deptList0107.jsp 이다.
    // 요청이 유지되는 동안에는 사용할 수 있다. - FrontController에서 제공이 되어야한다.
    RequestDispatcher view = req.getRequestDispatcher("/dept/deptList0107.jsp");
    view.forward(req, resp);
  } //// end of doGet
} //// end of DeptServlet
