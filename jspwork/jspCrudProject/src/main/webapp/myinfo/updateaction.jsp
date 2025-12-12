<%@page import="myinfo.MyinfoDao"%>
<%@page import="myinfo.MyinfoDto"%>
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
		String addr=request.getParameter("addr");
		String num=request.getParameter("num");
		
		MyinfoDto dto=new MyinfoDto();
		dto.setName(name);
		dto.setAddr(addr);
		dto.setNum(num);
		
		MyinfoDao dao=new MyinfoDao();
		dao.updateMyinfo(dto);
		
		response.sendRedirect("infolist.jsp");
	%>
</body>
</html>