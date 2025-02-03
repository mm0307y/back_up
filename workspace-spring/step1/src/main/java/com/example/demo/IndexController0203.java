package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController0203 {
  // http://localhost:8000
  @RequestMapping("/")
  public String index() {
    // 아래 페이지 경로 - /resources/templates/index.html -> 404번에러 - 클라이언트 엔러
    return "index0203";
  }
}
