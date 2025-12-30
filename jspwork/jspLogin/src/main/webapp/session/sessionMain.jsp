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
	//세션 저장
	session.setAttribute("dragon", "sist");
	session.setMaxInactiveInterval(10);
%>
	<h2>10초 안에 클릭</h2>
	<form action="sessionAction.jsp" method="post">
		<h4>배우고 싶은 IT언어</h4>
		<input type="radio" value="java" name="lang">JAVA&nbsp;
		<input type="radio" value="html" name="lang">HTML&nbsp;
		<input type="radio" value="oracle" name="lang">ORACLE&nbsp;
		<input type="radio" value="spring" name="lang">SPRING&nbsp;
		<input type="submit" value="수강신청">
	</form>
</body>
</html>