<%@page import="jspLogin.loginDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<title>Insert title here</title>
</head>
<body>
	<%
	//세션에 저장한 아이디 읽기
	String myid=(String)session.getAttribute("idok");
	//아이디에 해당하는 이름 가져오기
	loginDao dao=new loginDao();
	String name=dao.getName(myid);
	%>
	
	<div style="margin: 50px;">
	<b><%=name %>님이 로그인 하셨습니다.</b>&nbsp;&nbsp;&nbsp;&nbsp;
	<button type="button" class="btn btn-danger" onclick="location.href='logoutAction.jsp'">로그아웃</button>
	<br><br>
	<img alt="" src="../image/무한도전/다운로.jpg">
	<br><br>
	<button type="button" class="btn btn-info" onclick="location.href='../memguest/guestList.jsp'">회원방명록</button>
	</div>
</body>
</html>