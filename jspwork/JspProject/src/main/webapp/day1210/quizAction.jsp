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
		String name=request.getParameter("name");
		String menu=request.getParameter("menu");
		String [] it=request.getParameterValues("it");
	%>
	
	<h3>결과 출력</h3>
	<b>본인 이름: <%=name %></b><br>
	<b>점심 메뉴:
	<%
		if(menu==null)
		{%>
			오늘이 점심메뉴는 없습니다.
		<%}else {%>
			오늘의 점심 메뉴는<%=menu %> 입니다.
		<%}
	%>
	</b><br>
	<b>가능IT언어: 
	<%
		if(it==null)
		{%>
			가능한 it 언어가 하나도 없습니다.
		<%} else {
			for(int i=0;i<it.length;i++)
			{%>
				[<%=it[i] %>]&nbsp;
				
			<%}%>
			총 <%=it.length %>개 있습니다.
		<%}
	%>
	</b><br>
	<a href="quizForm.jsp">다시입력</a>
</body>
</html>