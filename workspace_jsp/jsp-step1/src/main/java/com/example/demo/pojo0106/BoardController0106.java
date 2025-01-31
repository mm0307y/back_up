package com.example.demo.pojo0106;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.util.HashMapBinder0117;

@Log4j2
public class BoardController0106 implements Controller0106 {
  BoardLogic0106 boardLogic = new BoardLogic0106();

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
    // upmu[0] = board, order, notice, member, login
    // upmu[1] = boardList, boardInsert, boardUpdate, boardDelete,
    String upmu[] = (String[])req.getAttribute("upmu");

    // 스프링은 메서드 위에 GetMapping, PostMapping, PutMapping, DeleteMapping이 지원되니까
    // 이렇게 if문으로 제어를 하지 않아도 되었다.
    // 왜 서블릿에서 이것이 최선인가? - 개발자가 작성하는 메서드 이름을 알 수 없다.

    // 글 목록 조회 할거야?
    log.info(upmu[1]); //jsonBoardList출력되는지 확인할 것.
    if ("jsonBoardList".equals(upmu[1])) {
      log.info("jsonBoardList");
      // 메서드 호출
      // 인스턴스화 - 누구를 인스턴스화 하면 되나요? XXXLogic.java
      // 주소번지(인턴스변수).메서드이름(싱글톤)
      // 메서드 선언이 아직 안되어 있다. - 메서드  선언을 한다는건 리턴타입과 파라미터를 결정하는 일이다.
      List<Map<String, Object>> bList = boardLogic.boardList(null);
      log.info("bList ==> " + bList.size()); // 0이면 조회결과가 없습니다. 1이면 조회결과가 1건이다.
      Gson g = new Gson();
      String temp = g.toJson(bList);
      res.setContentType("application/json;charset=utf-8");

      // 응답객체가 제공하는 getWriter()로 객체를 생성한다.
      // 메서드의 리턴타입으로 객체를 생성하는 것은 예를 들어 if문으로
      // null 체크와 같은 과정을 거칠 수 있다.
      // 만일 34번 문장과 아래 문자의 순서를 바꾸면 한글이 깨진다.
      PrintWriter out = res.getWriter();
      out.print(temp);
    }
    else if ("boardList".equals(upmu[1])) {
      // 메서드 호출
      // 인스턴스화 - 누구를 인스턴스화 하면 되나요? XXX.Logic.java
      // 주소번지(인턴스변수).메서드이름(싱글톤)
      // 메서드 선언이 아직 안되어 있다. - 메서드  선언을 한다는건 리턴타입과 파라미터를 결정하는 일이다.
      Map<String, Object> pMap = new HashMap<>();
      HashMapBinder0117 hmb = new HashMapBinder0117(req);
      hmb.bind(pMap);
      log.info("pMap : " + pMap);
      List<Map<String, Object>> bList = boardLogic.boardList(pMap);

      // 사용자가 직접 처리하는 것을 스프링 부트에서는 @RestController자동으로 해준다.
      Gson g = new Gson();
      String temp = g.toJson(bList);
      res.setContentType("application/json;charset=utf-8");
      PrintWriter out = res.getWriter();
      // out.print(temp); //result = null
      return temp;
      // return "forward:/board0106/list0114.jsp";
    }

    // 글 등록하기 구현
    else if ("boardInsert".equals(upmu[1])) {
      log.info("boardInsert 호출 성공");
      Map<String, Object> pmap = new HashMap<>();
      log.info("before : " + pmap);
      HashMapBinder0117 hmb = new HashMapBinder0117(req);
      hmb.bind(pmap); // get 방식일 때
      // hmb.bindPost(pmap); // post 방식일 때
      log.info("after : " + pmap);
      // 메서드 호출
      // 주소번지.메서드이름
      // int result = boardLogic.boardInsert();
    }

    // 글 수정하기 구현
    else if ("boardUpdate".equals(upmu[1])) {
      // 메서드 호출
      // 주소번지.메서드이름
      // int result = boardLogic.boardUpdate();
    }

    // 글 삭제하기 구현
    else if ("boardDelete".equals(upmu[1])) {
      // 메서드 호출
      // 주소번지.메서드이름
      // int result = boardLogic.boardDelete();
    }

    // 글 상세보기 구현
    else if ("boardDetail".equals(upmu[1])) {
      // 메서드 호출
      // 주소번지.메서드이름
      Map<String, Object> pmap = new HashMap<>();
      pmap.put("b_no",1);
      List<Map<String, Object>> bList = boardLogic.boardDetail(pmap);
      log.info(bList.size());
    }
    return null;
  }

}
