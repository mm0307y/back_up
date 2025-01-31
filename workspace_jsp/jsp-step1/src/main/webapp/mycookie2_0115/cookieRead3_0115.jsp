<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>쿠키정보 읽어오기-cookieRead3_0115.jsp</title>
</head>
<body>
  <%
    Cookie[] cs = request.getCookies();
    // 쿠키에 값이 있는지 유무 체크하기 - 안전한 코드를 작성하는 방법이다. - NullPointerException
    if (cs != null && cs.length !=0) {
      String c_name = null;

      for(int i = 0; i<cs.length; i++){
        if("notebook".equals(cs[i].getName())) {
          c_name = cs[i].getValue();
          out.print(c_name);
        }

        else if("computer".equals(cs[i].getName())) {
          c_name = cs[i].getValue();
          out.print(c_name);
        }

        else if("mouse".equals(cs[i].getName())) {
          c_name = cs[i].getValue();
          out.print(c_name);
        }
      } //// end of for
    } //// end of if
  %>
</body>
</html>