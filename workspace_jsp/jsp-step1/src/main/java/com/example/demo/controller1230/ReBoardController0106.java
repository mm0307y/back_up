package com.example.demo.controller1230;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.logic0106.ReBoardLogice0106;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/reboard0106/*") // http://localhost:8000/reboard0106/boardList
public class ReBoardController0106 {
  @Autowired
  private ReBoardLogice0106 reBoardLogic = null;

  @GetMapping("boardList")

  // public String boardList(HttpServletResponse res)
  // @query - select b_no, b_title, b_writer, b_content from react_board
  public String boardList() {
    log.info("boardList");
    List<Map<String, Object>> bList = null;
    bList = reBoardLogic.boardList();
    // return "forward:list0106.jsp";
    // 스프링은 모든 메서드에 URL이름을 매핑할 수 있고(@RequestMapping, @GetMapping, @PostMapping,
    // @PutMapping, @DeleteMapping)
    // res.sendRedirect("list0106.jsp");
    return "forward:list0106.jsp";
  }

  // 수정,입력,삭제는 반환값이 int이다.(0이면 실패, 1이면 성공)
  // 커밋과 롤백의 대상
  @PostMapping("boardInsert")
  public int boardInsert() {
    log.info("boardInsert");
    int result = -1; // end of file
    return result;
  }

  @PutMapping("boardUpdate")
  public int boardUpdate() {
    log.info("boardUpdate");
    int result = -1; // end of file
    return result;
  }

  @DeleteMapping("boardDelete")
  public int boardDelete() {
    log.info("boardDelete");
    int result = -1; // end of file
    return result;
  }
}

/*
 * 컨트롤 계층에서 페이지를 이동하는 방법
 * 1) return "forward:list0106.jsp";
 * : 접두어에 forward를 사용하면 기존 요청이 계속 유지되는 것으로 판단한다.
 * : URL은 그대로 인데 응답페이지 내용은 바뀌었다.
 * : ReBoardController0106.java에서 생성한 객체를 jsp페이지에서도 사용할 수 있다.
 * 
 * 2) return "redirect:list0106.jsp";
 * : 접두어에 redirect를 사용하면 기존 요청은 끊어지고 새로운 요청이 발생한 것으로 판단한다.
 * : URL도 바뀌고 응답페이지 내용도 바뀌었다.
 * : URL이 변경되었으니 기존의 정보는 유지가 안된다.
 * 
 * scope -> pageContext | request | session | application
 * 1) pageContext는 현재 페이지에서만 유지된다.
 * 2) request : 요청이 유지되는 동안에는 유지된다. - forward
 * 오라클 연동은 java로 하지만 응답 페이지는 jsp(html)에서 나간다.
 * java -> jsp 유지되려면 request나 session을 사용해야 한다.
 * jsp -> jsp 가능하다. -> jsp는 view 계층을 담당하는게 좋다.
 * 자바가 아니라서 직접 인스턴스화가 안된다. - 인스턴스화를 할 수 있지만 WAS지배를 받는다.
 * WAS가 클래스명을 정한다. WAS마다 클래스 이름이 변한다.
 * a.jsp -> a_jsp.java -> 컴파일화 -> a_jsp.class
 * 쿠키와 세션은 시간동안에 유지가 가능하다. -> request가 필요없이 무조건 유지한다.
 */