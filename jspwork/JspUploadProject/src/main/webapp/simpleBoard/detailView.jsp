<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="simpleBoard.boardDto"%>
<%@page import="simpleBoard.boardDao"%>
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
<style type="text/css">
 .day,.read{
 	font-size: 0.9em;
 	color: gray;
 }
</style>
</head>
	<%
	String num=request.getParameter("num");
	boardDao dao=new boardDao();
	boardDto dto=dao.oneSelectBoard(num);
	dao.updateReadcount(num);
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd. HH:mm");
	NumberFormat nf=NumberFormat.getCurrencyInstance();
	%>
<body>
	<div style="width: 800px; margin: 30px 50px">
		<table class="table table-bordered">
		<tr>
			<td>
				<h2><%=dto.getSubject() %></h2>
				<b><%=dto.getWriter() %></b>
				<span class="day"><%=sdf.format(dto.getWriteday()) %></span>
				<span class="read">조회<%=dto.getReadcount() %></span>
			</td>
		</tr>
		<tr>
			<td>
				<%=dto.getContent().replace("\n", "<br>") %><br>
				<a href="../save/<%=dto.getImgname()%>" target="_blank">
				<img alt="" src="../save/<%=dto.getImgname()%>" style="max-width: 200px;"></a>
			</td>
		</tr>
			<tr>
				<td align="right">
					<button type="button" class="btn btn-primary"
					onclick="location.href='addForm.jsp'">글쓰기</button>
					<button type="button" class="btn btn-primary"
					onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>'">수정</button>
					<button type="button" class="btn btn-primary"
					onclick="location.href='deletePassForm.jsp?num=<%=dto.getNum()%>'">삭제</button>
					<button type="button" class="btn btn-primary"
					onclick="location.href='boardList.jsp'">목록</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>