<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
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
		String realFolder=getServletContext().getRealPath("/save");
	System.out.println(realFolder);
	
	int fileSize=1024*1024*5; //5메가
	
	MultipartRequest multi=null;
	
	try{
	multi=new MultipartRequest(request,realFolder,fileSize,"utf-8",new DefaultFileRenamePolicy());
	
	String name=multi.getParameter("name");
	String subject=multi.getParameter("subject");
	String uploadFileName=multi.getFilesystemName("uploadfile");
	String originalFileName=multi.getOriginalFileName("uploadfile");
	%>
	
	<div style="width: 300px; border: 1px solid gray;">
		<h3>이름: <%=name %></h3>
		<h3>제목: <%=subject %></h3>
		<h3>원래파일명: <%=originalFileName %></h3>
		<img alt="" src="../save/<%=uploadFileName%>">
		<br>
		<button type="button" onclick="location.href='uploadform.jsp'">다시 업로드 하기</button>
	</div>
	
	<%}catch(Exception e){
		
	}
	%>
</body>
</html>