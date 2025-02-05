package com.example.demo.controller0205;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

// 선택하기
// 1) @Controller인가, 2) @RestController인가,
// @Controller(화면을 지정할 수 있다.), @RestController(JSON혁향식) 차이전 -> 구글 검색
// 페이지로 출력과를 내보단다. -1번, 만일 나는 React페이지에 출력을 할거야 2번
// 반복되는 코드가나오면 경계해야 한다. - 줄일 수 없나? - 문제의식 - 코드 변경 긍정적
// React와 Spring Boot 연동하기 (3000 -> 8000 호출하기)
// React서버 설정 - src/setProxy.js -> 접두어 api
// Spring Boot 설정
@Log4j2
@RestController
@RequestMapping("/api/*")
public class ReBoardController0205 {
  /* *******************************************************************************************
   * 게시글 목록 조회 구현하기 - search | select | where | GET
   * URL매핑 이름 : boadrList
   *********************************************************************************************/
  public String boardList() {
    log.info("boardList 호출  성공");
    String temp = "[{'b_title' : '글제목 입니다.', 'b_conent' : '글내용 입니다.'}]";
    return temp;
  }


   /* *******************************************************************************************
   * 게시글 등록 구현하기 - param(@Request) | insert | POST | GET
   * URL매핑 이름 : boardInsert
   *********************************************************************************************/

   /* *******************************************************************************************
   * 게시글 수정 구현하기 - param |updata | where(한건수정하면되니까) | PK (프라이머리 키) | PUT
   * URL매핑 이름 : boardUpdate
   *********************************************************************************************/

   /* *******************************************************************************************
   * 게시글 삭제 구현하기 - PK | delete | where | DELETE
   * URL매핑 이름 : boardDelete
   *********************************************************************************************/
}
