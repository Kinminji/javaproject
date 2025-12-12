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
	String name=request.getParameter("s_name");
	String cbarea=request.getParameter("cbarea");
	String ipsaday=request.getParameter("ipsaday");
	String teem=request.getParameter("teem");
	String []it=request.getParameterValues("it");
	String gift=request.getParameter("gift");
	String bgcolor=request.getParameter("bgcolor");
	%>
	
	<div style="background-color:<%=bgcolor%>">
		<h3><%=name %>Info</h3><br>
		<b>해외근무 <%=cbarea==null?"불가능":"가능" %></b><br>
		<b>입사일: <%=ipsaday %></b><br>
		<b>담당부서: <%=teem %></b><br>
		<b>제2외국어: 
		<%
			if(it==null){%>
				가능한 외국어가 없습니다.
			<%}else{
				for(int i=0; i<it.length;i++){%>
					[<%=it[i] %>]&nbsp;
				<%}%>
				총 <%=it.length %>개 있습니다.
			<%}
		%></b><br>
		<b>선호하는 명절선물:
			<img alt="" src="<%=gift%>" width="150px">
		</b>
		<a href="ex5_formDate.jsp">다시입력</a>
	</div>
</body>
</html>