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
	<h4>JSP 구조는 html구조 + 자바코드 사용가능한 서버언어</h4>
	<h4>Servlet은 확장자가 java이며 자바클랙스 구조의 <br>
	html,css,javascript도 사용가능한 서버언어</h4>
	<hr>
	<!--주석: html기본주석: 소스보기에선 보임  -->
	<%--jsp주석: 소스보기에서도 안보임 --%>
	
	<h4>java코드를 쓰려면 Scriptlet 영역을 표시후 코딩</h4>
	<%
	//스크립트릿
	//여기서 선언하면 지역변수로 등록
	//여기에서의 지역변수를 만약에 html에서 사용하고 싶다면 선언한 곳보다는 무조건 아래에서 사용한다
	//출력은 표현식을 사용한다 <%=
	int age=20;
	String name="윤도운";
	%>
	
	<h4>자바의 변수를 출력_표현식</h4>
	<b>이름: <%=name %></b><br>
	<b>나이: <%=age %>세</b>
</body>
</html>