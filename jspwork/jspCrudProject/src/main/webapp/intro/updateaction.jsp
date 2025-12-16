<%@page import="intro.introDao"%>
<%@page import="intro.introDto"%>
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
		//수정메서드 받아서 처리 후 목록으로 이동
		request.setCharacterEncoding("utf-8");
	
		String name=request.getParameter("name");
		String birthday=request.getParameter("birthday");
		String hp=request.getParameter("hp");
		String hometown=request.getParameter("hometown");
		String hobby=request.getParameter("hobby");
		String mbti=request.getParameter("mbti");
		String free=request.getParameter("free");
		String num=request.getParameter("num");
		
		introDto dto=new introDto();
		dto.setName(name);
		dto.setBirthday(birthday);
		dto.setHp(hp);
		dto.setHometown(hometown);
		dto.setHobby(hobby);
		dto.setMbti(mbti);
		dto.setFree(free);
		dto.setNum(num);
		
		introDao dao=new introDao();
		dao.updateIntro(dto);
		
		
		response.sendRedirect("introlist.jsp");
	%>
</body>
</html>