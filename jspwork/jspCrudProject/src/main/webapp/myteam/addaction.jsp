<%@page import="mysql_team.TeamDao"%>
<%@page import="mysql_team.TeamDto"%>
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
		request.setCharacterEncoding("utf-8");
	
	String name=request.getParameter("name");
	String addr=request.getParameter("addr");
	String marry=request.getParameter("marry");
	
	TeamDto dto=new TeamDto();
	dto.setName(name);
	dto.setAddr(addr);
	dto.setMarry(marry==null?"없음":"있음");
	
	TeamDao dao=new TeamDao();
	dao.insertMyteam(dto);
	
	response.sendRedirect("teamlist.jsp");
	%>
</body>
</html>