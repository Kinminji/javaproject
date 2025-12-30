<%@page import="myBoard.boardDto"%>
<%@page import="myBoard.boardDao"%>
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
	request.setCharacterEncoding("utf-8");

%>

<!-- useBean new로 생성하는 것과 같다 -->
<jsp:useBean id="dto" class="myBoard.boardDto"/>
<jsp:useBean id="dao" class="myBoard.boardDao"/>
<!-- dto에 있는 멤버와 같은 이름의 폼태그는 자동으로 읽어서 dto에 넣어준다 -->
<jsp:setProperty property="*" name="dto"/>


<%
	dao.insertBoard(dto);

	response.sendRedirect("boardlist.jsp");
	
%>

<body>
</body>
</html>
