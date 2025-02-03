package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class RequestPrint0203 {
  @RequestMapping("/requestInfo")
  public void main(HttpServletRequest req) {
    System.out.println("req.getMethod()" + req.getMethod()); // GET or POST
    System.out.println("req.getRequsetURL()" + req.getRequestURL()); // -> /requestInfo
    System.out.println("req.getRequsetURL()" + req.getRequestURL()); // -> http://localhost:8000/reqestInfo
    System.out.println("req.ContextPath()" + req.getContextPath()); // -> project이름이 있을 때 값이 존재하지만
    System.out.println("req.getProtocol()" + req.getProtocol()); // HTTP/1.1 - 톰캣이 만들어서브라우저 쓴다.
    // 한글을 작성해서 넘기면 깨진다. - non - ASCII 문자이다. URLEncoder.encode("", "utf-8")
    System.out.println("req.getQueryString()" + req.getQueryString());
    System.out.println("req.getServletPath()" + req.getServletPath());
  }
}
