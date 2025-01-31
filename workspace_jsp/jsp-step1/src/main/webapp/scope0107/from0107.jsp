<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.demo.vo0107.DeptVO0107" %>
<%
  // 스크립틀릿, - 자바코드를 작성할 수 있다.
  DeptVO0107 dvo = new DeptVO0107();
  dvo.setDeptno(10);
  dvo.setDname("총무부");
  dvo.setLoc("대전");

  //from.jsp 에서 생성한 객체를 to.jsp에서 사용이 가능하다.
  request.setAttribute("dvo", dvo);
%>

<!-- 
클리언트 사이드 렌더링
서버의 물리적인(webapp) 위치에서 다운로드 받는다.
확장자가 jsp인 경우에는 서버단에 선처리가 되고 그 결과를 응답으로 내려 보낸다.
-->  

<!DOCTYPE html>
  <html>
  <head>
    <title>from.jsp</title>
  </head>

  <body>
    <h1>from.js페이지</h1>
    <p>Content</p>
    <jsp:forward page="to0107.jsp" />
  </body>
  </html>

  <!-- 
  scope 속성 중에서 rsquest에 대해 알아보는 예제
  1)from.jsp
  2)to.jsp
  실제 브라우저에서 요청하는 페이지는 1번이었다.
  : 주소창에 통해서만 확이 가능하다.
  : 화면에 출력되는 애용은 더이상 from.jps가 아니었다.
  : 실제 출력되는 페이지는 to.jsp 내용이었다.
  : 요청 URL이 그래도 이면 요청은 계속 유지되고 있다 라고 WAS가 판단한다.
  : from.jsp에서 생성한 객체를 to.jsp에서도 사용이 가능하다.
  : from.jsp 소스에서 jsp 액셔태그인 forward를 만나면 그 페이지에 모든 내용은 볼 수가 없다.

  jsp 페이지에서 자바 코드를 사용할 수 있는 선언문
  1) 디클러레이션 : 메서드 선언, 전역변수 

  2) 스크립플릿 : 서블릿 라이프 사이클에서 service()에서 포함된다.
  제어문 사용 가능
  init() -> service() -> destroy()
  메서드 안에서 선언하는 변수는 모두 지변이다.
  메서드 선언이 불가하다.
  자바에서는 메서드 안에서 메서드 선언이 불가하다.
  자바스크립트에서는 가능하다. - 일급함수, 고차함수, 일급객체 -> 트위터 -> 리덕스 -> Flux아키텍쳐(One binding)

  3) 익스프레션 - 출력문이다. -> System.out.println()
  주의사항은 println() 괄호안에 세미콜론을 찍으며 안된다.
  -->