<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 
  jsp, servlet국한된게 아니다.

  // URL이 변한다.
  redirect === response.sendRedirect("XXX.jsp")

  // URL이 변하지 않지만 화면은 변한다.
  // 톰캣서버가 요청이 계속 유지되고 있다 라고 판단한다. - 상태값 유지
  // 반드시 쿠키나 세션을 사용하지 않고도 값을 유지하는 방법이 있다. - request scope
  RequestDispatcher view = request.getRequestDipatcher("XXX.jsp");
  
  forward === view.forward(request, response)

  배포 위치와 관련있다. - 404번 에러 발생한다.
-->
<!DOCTYPE html>
<html>
<head>
    <title>test3_0207.jsp[WEB-INF/views0206/intro0207]</title>
</head>
<body>
    <h1>test3_0207.jsp 입니다.</h1>
    <p>Content</p>
</body>
</html>