package com.example.demo.basic;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet("/mysession/login")
public class AuthServlet0127 extends HttpServlet {
  // http://localhost:8000/mysession/login로 요청하는 것은 모두 get방식이다.
  public void doPost(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException 
  {
    log.info("doPost 호출");
    HttpSession session = req.getSession();
    String db_email = "kiwi@hot.com";
    String db_pw = "1234";
    String db_name = "김키위";
    // insert here - 사용자로부터 입력받은 이메일과 비번을 가져오기
    String u_email = req.getParameter("email");
    String u_pwd = req.getParameter("mem_pw");
    log.info("u_email : " + u_email + "u_pwd : " + u_pwd);
    
    if(db_email.equals(u_email)) {
      if(db_pw.equals(u_pwd)){
        session.setAttribute("s_name", db_name);
      }
      else{
        log.info("비밀번호가 틀립니다.");
      }
    }
    else{
      log.info("이메일이 존재하지 않습니다.");
    }
    res.sendRedirect("/mysession0115/loginForm0127.jsp");
  } // end of Post
} // end of AuthServlet
