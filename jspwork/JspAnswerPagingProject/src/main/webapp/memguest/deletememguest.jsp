<%@page import="java.io.File"%>
<%@page import="memguest.memguestDto"%>
<%@page import="memguest.memguestDao"%>
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
String currentPage=request.getParameter("currentPage");

if (currentPage == null || currentPage.equals("null")) {
    currentPage = "1";
}

memguestDao dao=new memguestDao();

//num에 해당하는 photo값 얻기
String photo=dao.getData(num).getPhoto();
//save의 실제 경로
String realPath=getServletContext().getRealPath("/save");

//파일생성
File file=new File(realPath+"\\"+photo);
//해당폴더에서 파일 삭제
file.delete();
//db삭제
dao.deletememguest(num);

response.sendRedirect("guestList.jsp?currentPage="+currentPage);
%>
<body>
	
</body>
</html>