<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  // 스크립틀릿 - 자바코드 작성가능 영역
  // ModelAndView는 scope가 request이다. - 요청이 유지되는 동안에는 사용할 수 있다.
  // mac.addObject("year", "2025");
  // request.getAttribute("year"); // 이 부분이 null인 경우 toString() - 500번 가능성.
  int year = Integer.parseInt(request.getAttribute("year").toString());
  int month = Integer.parseInt(request.getAttribute("month").toString());
  int day = Integer.parseInt(request.getAttribute("day").toString());
  String yoil = request.getAttribute("yoil").toString();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>년도<%=year%></h1>
    <h1>월<%=month%></h1>
    <h1>일<%=day%></h1>
    <h1>요일<%=yoil%></h1>
</body>
</html>

<!-- 
취업 관련
SI - 신규 개발 80%, 유지 보수 20% - 별로 사무실, 프로젝트팀 따로 꾸림(개발, 공통팀, 관리, 형상관리팀, 응용기술팀) - 파견근무
SM - 유지보수 80%, 신규 개발 20% - 정해진 장소, 현업담당자(소통), 12월, 1월 계약, 1년 단위
솔루션 - 입사한 회사에서 근무 - 보안솔루션, 결제 시스템, UI솔루션 등등
에이전시 - 호스팅 회사(가비아, 나누미넷, 오라클, MySQL서버 등 정액제, 도메인 대행, 쇼핑몰 구축, 매월 정기비용을 받고 관리해준다. -1년-리눅스-응용프로그래머-)
========================================

1. 레거시에서 사용되는 ModelAndView 클래스 소개
: @ModelAttribute와 MOdel의 등장으로 쓰임새가 줄었다.
: 화면 출력을 더 이상 jsp로 하지 않게 되었다.

2. jsp를 물리적인 위치를 webapp 아래 배포하기, WEB-INF/views/화면이름.jsp
: 응답페이지의 URL이  새로 만들어진다. -> application.yml 설정하기

-->