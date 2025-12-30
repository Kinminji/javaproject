<%@page import="java.text.SimpleDateFormat"%>
<%@page import="simpleBoard.boardDto"%>
<%@page import="java.util.List"%>
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
</head>
<%
boardDao dao=new boardDao();
List<boardDto> list=dao.selectBoard();
%>
<body>
	<div style="width: 800px; margin: 20px 50px">
		<table class="table table-bordered">
		<caption align="top">
			<span>[목록] &nbsp;&nbsp;<%=list.size() %>개의 글이 있습니다.</span>
			
			<button type="button" class="btn btn-success"
			style="float: right;" onclick="location.href='addForm.jsp'">글쓰기</button>
			<a href="boardList.jsp" style="float: right"><i class="bi bi-list-ul" style="font-size: 25px; margin: 5px 5px;"></i></a>
			<a href="imgicon.jsp" style="float: right"><i class="bi bi-grid-fill" style="font-size: 25px; margin: 5px 5px;"></i></a>
		</caption>
		
			<tr class="table-info">
				<td width="50">번호</td>
				<td width="200">제목</td>
				<td width="60">작성자</td>
				<td width="40">조회수</td>
				<td width="100">날짜</td>
			</tr>
			
			<%
			for(int i=0;i<list.size();i++){
				boardDto dto=list.get(i);
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); %>
				
				<tr>
					<td><%=list.size()-i %></td>
					<td style="cursor: pointer;"
					onclick="location.href='detailView.jsp?num=<%=dto.getNum()%>'"><%=dto.getSubject() %></td>
					<td><%=dto.getWriter() %></td>
					<td><%=dto.getReadcount() %></td>
					<td><%=sdf.format(dto.getWriteday()) %></td>
				</tr>
				
			<%}
			%>
			
		</table>
	</div>
</body>
</html>