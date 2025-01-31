<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>
  <head>
    <title>로그인[Get방식]</title>
  </head>
  <body>
  <%
    // 자바코드를 작성할 수 있는 영역 - 스크립틀릿
    String s_name = (String)session.getAttribute("s_name");
    if(s_name == null) { // 세션에 값이 null이라면 로그인 과정을 거치지 않고 URL을 직접 입력하고 입장한 경우
  
  %>
  <form method="post" action="/mysession/login">
<!-- 
    id 사용할때 - document.querySelector('#id') - 정적처리할 때 id를 사용한다.
    name을 사용할 때 - request.getParameter('email') - 동적처리할 때는 name을 사용한다.
-->

<input type="text" name="email" />
    <br/>
    <input type="text" name="mem_pw" />
    <button>로그인</button>
  </form>
<%
    } //// end of if
    else{
     // out.print("cs.length : " + cs.length); // JSESSIONID가 항상 디폴트로 들어가 있다.
%>
  <form method="get" action="/mycookie/logout">
    <%=s_name%> 님 환영합니다.<br/>
    <button>로그아웃</button>
  </form>
<%
    } //// end of else 쿠키에 값이 있을 때
%>
  </body>
  </html>

  <!-- 
  쿠키
  Cookie c = new Cookie("이름", "값")
  문자열만 담기
  로컬 PC저장(text형태 - 암호화)

  세션
  캐쉬 메모리 - 서버측
  자료구조모두 담기
  톰캣서버 경우 디폴트가 30분입니다.
  HttpSession session = request.getSession();

  저장
  session.setAttribute("이름", "값")

  읽기
  session.getAttribute("이름")

  삭제
  session.removeAttribute("이름")
  session.invalidate();
  -->