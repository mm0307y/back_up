package com.example.demo.pojo0106;

import java.io.IOException;
import java.io.PrintWriter;

import com.util.StringValidator0127;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

// 요청 URL패턴에 /를 사용하게 되면 이 서버에 들어오는 모든 요청이 이 클래스로 유입된다.
// 의미없는 확자장자 이지만 식별자로 사용하기 위해서 do를 붙였다.
// 개발자 입장에서는 doGet, doPost 이든 모두 처리를 해야 합니다. - 창구 일원화 - 관리
// 표준 서블릿에서는 메서드마다 URL패턴을 가질 수 없다.
// Rest API가 아닌 메서드는 구현할 수는 있겠지만 메서드 파라미터에 request와 response
// 객체를 주입 받지 못한다.
// 웹 서비스 구현시 자바는 안되고 서블릿만 되는 이유는 request, response 제공된다.

@WebServlet("*.do") // @Controller와 @RequestMapping이 합쳐졌다.
@Log4j2 // 롬복에서 객체 주입을 해준다. - getter/setter - 객체 주입법 그대로 적용
public class ActionServlet0106 extends HttpServlet {
  public void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    // -> http://localhost:8000/
    // -> pojo/board/boardList.do -> .do 앞에 있는 글자수:20개,앞에 붙인 pojo는 떼어 내어야 한다.
    // -> pojo/board/jsonBoardList.do -> 20개
    // -> pojo/board/boardInsert.do -> 22개
    // -> pojo/board/boardUpdate.do -> 22개
    // -> pojo/board/boardDelete.do -> 21개

    String uri = req.getRequestURI();
    log.info(uri); // /home
    String context = req.getContextPath(); // server.xml -> jsp_step1 1플젝 배포 -> 루트
    log.info(context); // -> /

    // sunstring 메서드는 문자열을 잘라준다.
    String command = uri.substring(context.length() + 1); // -> pojo/board/jsonBoardList.do
    int end = command.lastIndexOf("."); // 20 - .do의 이전위치 정보를 계산해준다. 24
    // pojo/board/boardList
    // pojo/board/boardInsert
    // pojo/board/boardUpdate
    // pojo/board/boardDelete

    command = command.substring(0, end); // 문자열뒤에 substring함수를 붙인다. 파라미터로 구간을 정해준다.
    // 요청 URL 맨 앞에 pojo는 react서버에서 다른 출저인 경우 CORS이슈로 요청이 전달되지 못 한다.
    // 그래서 3000번에서 8000번 출저로 요청이 바뀌면 프록시를 활용하여 요청을 전달 한다. - CORS이슈를 묵인해준다.
    // 우리는 배열에 값이 두 개면 된다.
    // upmu[0] = 업무이름 저장
    // upmu[1] = 페이지 이름
    // 배열은 복사가 안된다.

    String temp[] = null;
    temp = command.split("/"); // temp[0] = pojo, temp[1] = board, temp[2] = boardList, or boardInsert,
                               // boardUpdate, boardDelete
    String upmu[] = new String[temp.length - 1]; // 2개 upmu[0] = temp[1], upmu[1] = temp[2]

    // 업무배열을 생성시에 temp에 담긴 pojo는 제외 시킨다.
    System.arraycopy(temp, 1, upmu, 0, temp.length - 1);

    // 결과는 temp[0]에 있던 pojo는 제외되었다.
    log.info(upmu.length); // 2가 된다. 왜냐하면 temp에서 pojo를 제외 시켰다., upmu[0] = board, upmu[1] = boardList - .do는
                           // 제외되었다.

    // 실제 기능을 구현하는 클래스는 BoardController이므로 요쳥객체에 정보를 담아 둔다
    // req는 저장소역할 - 배열의 주소번지 저장. BoardController에서 사용할 수 있다.
    req.setAttribute("upmu", upmu); // 결과적으로 얕은복사가 된다.
    
    // 웹서비스에 필요한 requset와 response 객체는 ActionServlet으로 부터 주입 받는다.
    log.info("64");
    BoardController0106 boardController = new BoardController0106();
    log.info("69");
    try {
      // execute메서드의 선언에서 예외처리를 직접하지 않고 나를 호출한 곳에서 하시오.
      // 라는 의미로 throws하였다. 에러가 발생한다. -> 예외처리를 더 이상 미룰 수 없으니 네가 try_catch추가하고
      // 그 안에서 메서드 호출을 하면 된다.
      log.info("execute before...");

      // 리턴값으로 받는 정보가 페이지 이름과 redirect인지 forward인지에 대한 정보가 들어있다.
      // return "redirect:list.do"
      // return "forward:list.jsp"
      // 최초 쵸청을 ActionServlet이 바등면 톰캣 컨테이너로부터 request, response 객체를 주입받는다.
      // 주입을 받는 다는 말은 개발자가 직접 인스턴스화 하지 않고 바로 사용할 수 있다.
      // NullPointerException이 발생하지 않습니다. -> 그래서 ActionServlet을 만들 때 HttpServlet을 상속
      // 받습니다.
      // 표준 메서드는 doGet, doPost, doPut, doDelete가 맞지만 어차피 개발자인 나는 모두 처리를 해줘야 한다.
      // 그래서 메서드의 이름을 doSerice로 변경하고 4가지 요청이 모두 한 메서드로 연결되도록 설계하였다.
      // doGet, doPost, doPut, doDelete는 모두 리턴 타입이 void이다.
      // 질문 : 모두 리턴타입이 void인데 어떻게 응답페이지를 호출해서 응답페이지가 나가는 걸까요?
      String result = boardController.execute(req, res);
      // 백엔드에서 다시 프론트로 올라올 때

      log.info("execute after....");
      // 아래 배열에는 응답페이지 처리에 필요한 정보 담긴다.
      // forward:list.jsp

      String pageMove[] = null;
      // 위에서 내려준 응답메시지에서 :을 기준으로 배열에 담아준다.
      log.info("result : " + result); // forward:/board/list.jsp
      // pageMove = result.split(":");

      boolean isOk = false;
      String seperator = "";
      if (result != null) {
        log.info("result type check");
        if (StringValidator0127.containsColon(result)) {
        seperator = ":"; // return "redirect:xxx.jsp" ofr "forward:xxx.jsp"
        }
        
        else if (StringValidator0127.isJspExtension(result)) {
          seperator = "jsp";
        } else if (StringValidator0127.isJsonFormat(result)) {
          seperator = "json";
        }
      } // 오라클 DB연동하여 가져온 결과 타입을 분류

      // 조회결과가 없을 때 처리하기
      else {
        log.info("조회결과가 없을 때");
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.print("조회결과가 없습니다.");
      }

      // separator가 jsp일떄
      if ("jsp".equals(seperator)) {
        // 현재는 리액트로 UI를 처리하고 있어서 해당사항이 없다.
        log.info("jsp페이지로 응답할 때");

        // 요청을 받아서 처리한 후 응답페이지 처리하기 - 공통부분(spring기준 - ViewResolver제공)
        // 응답페이지에 대한 정보를 가지고 있는거야?
        if (pageMove != null) {
          if ("redirect".equals(pageMove[0])) {
            res.sendRedirect(pageMove[1]);
          } // end of redirect

          else if ("forward".equals(pageMove[0])) {
            RequestDispatcher view = req.getRequestDispatcher(pageMove[1]);
            view.forward(req, res);
          } // end of forward
        }
      } // end of jsp

      // separator가 json일 때 - React활용하기
      else if ("json".equals(seperator)) {
        log.info("json포맷으로 응답할 때");
        res.setContentType("application/json;charset=utf-8");
        PrintWriter out = res.getWriter();
        out.print(result);
      }
      /////////////////////////// [ ViewResolver ] ///////////////////////////

    } catch (Exception e) {
      log.info(e.toString()); // 예외가 발생하면 예외이름을 출력하시오. - 이름으로 예외를 조회, 검색
    }
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
