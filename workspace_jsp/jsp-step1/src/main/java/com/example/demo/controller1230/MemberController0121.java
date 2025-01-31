package com.example.demo.controller1230;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.logic0106.MemberLogic0121;
import com.google.gson.Gson;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController // 리액트 요청을 받아서 응답을 json포맷으로 내보내야 한다. 응답이 jsp로 나가지 않는 경우에 사용한다.
@RequestMapping("/member/*") // 회원관리시 들어오는 요청은 member가 공통으로 들어있다.
public class MemberController0121 {
  @Autowired
  private MemberLogic0121 memberLogic0121 = null;

  // 로그인 관련 조회
  // 이메일 로그인 진행
  // 소셜 로그인으로 진행시 회원가입 유무를 체크하여 강제 회원가입을 유도 할 때도 사용된다.
  // 소셜 로그인으로 진행시 MEM_UID 유무가 핵심조건이다.
  // 닉네임 중복검사 할 때, 이메일 중복검사 할때 사용 한다.
  // POJO와의 가장 큰 차이점 중 하나로 스프링 코드 어디에서도 request, response 흔적이 없다.
  // 스프링 부트는 더 이상 서블릿에 의존적이지 않은 프레임워크 이다.
  @GetMapping("memberList") // 클래스 선언 앞에 공통으로 member를 꺼내놓았고 앞뒤에 슬래쉬가 있어서 생략을 하면 된다.
  public String memberList(@RequestParam Map<String, Object> pMap) {
    log.info("memberList 호출");
    log.info("사용자가 입력한 값 : " + pMap);
    Object obj = memberLogic0121.memberList(pMap);
    String result = null;
    Gson g = new Gson();
    result = g.toJson(obj);
    return result;
  } // end of memberList
  
  /**************************************************************************************************************************** 
   * 회원가입 구현 - POST
   * 1) form 전송 - @RequestParam
   * 2) js object 전송 - @RequestBody
   * 
   * @param pMap
   * @return
  *****************************************************************************************************************************/
  @PostMapping("memberInsert")
  public int memberInsert(@RequestBody Map<String, Object> pMap) {
    log.info("memberInsert");
    log.info(pMap);
    int result = -1;
    result = memberLogic0121.memberInsert(pMap);
    return result;
  } // end of memberInsert

}
