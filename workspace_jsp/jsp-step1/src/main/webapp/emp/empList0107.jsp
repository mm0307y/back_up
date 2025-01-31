<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  // 세션에 담긴 정보는 URL의 변화와 상관없이 정보가 유지된다. 재사용이 가능하다.
  // sendRedirect, forward요청을 하든 상관이 없다. - 세션일 경우에 그렇다.
  String name = null; // 지역 변수, 반드시 초기화가 필요하다.

  // getAttribute() 리턴타입은 Object입니다.
  name = (String)session.getAttribute("name");
%>
<!DOCTYPE html>
<html>
<head>
    <title><%=name%>님 환영합니다.</title>
</head>
<body>
    <h1>Heading</h1>
    <p>세션값 : <%=name%>님 환영합니다.</p>
</body>
</html>