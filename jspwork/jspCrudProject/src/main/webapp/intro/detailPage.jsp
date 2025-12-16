<%@page import="intro.introDto"%>
<%@page import="intro.introDao"%>
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
	<%
	String num=request.getParameter("num");
	introDao dao=new introDao();
	introDto dto=dao.oneselectIntro(num);
	%>
<body>
	<div style="margin: 50px 50px; width: 500px">
		<h2 class="alert alert-warning"><%=dto.getName() %>님의 자기소개서</h2>
		<br><br>
		<h4>
			<b>생년월일: </b><%=dto.getBirthday() %><br>
			<b>전화번호: </b><%=dto.getHp() %><br>
			<b>사는 지역: </b><%=dto.getHometown() %><br>
			<b>취미: </b><%=dto.getHobby().equals("no")?"취미가 없습니다.":dto.getHobby() %><br>
			<b>MBTI: </b><%=dto.getMbti() %><br>
			<b>코멘트: </b><%=dto.getFree() %><br>
		</h4>
		<button type="button" class="btn btn-warning"
		onclick="location.href='updateForm.jsp'">수정</button>
		<button type="button" class="btn btn-warning"
		onclick="location.href='delete.jsp'">삭제</button>
	</div>
</body>
</html>