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
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
%>
<body>
	<div style="width: 800px; margin: 20px 50px">
	<table class="table table-boarded">
		<caption align="top">
			<span>[목록]&nbsp;&nbsp;<%=list.size() %>개의 글이 있습니다.</span>
			
			<button type="button" class="btn btn-success"
			style="float: right;" onclick="location.href='addForm.jsp'">글쓰기</button>
			<a href="boardList.jsp" style="float: right"><i class="bi bi-list-ul" style="font-size: 25px; margin: 5px 5px;"></i></a>
			<a href="imgicon.jsp" style="float: right"><i class="bi bi-grid-fill" style="font-size: 25px; margin: 5px 5px;"></i></a>
		</caption>
		
		<tr>
		<%
			for(int i=0;i<list.size();i++){
				boardDto dto=list.get(i); %>
				
				<td>
					<b style="cursor: pointer" onclick="location.href='detailView.jsp?num=<%=dto.getNum()%>'">
					<img alt="" src="../save/<%=dto.getImgname()%>" style="width: 180px; height: 180px; border: 1px solid gray">
					</b>
					<br>
					<b style="padding-top: 3px; font-size: 13px;"><%=dto.getSubject() %></b><br>
					<b style="font-size:11px; color: gray; font-weight: 400;"><%=dto.getWriter() %></b>
					<b style="font-size:11px; color: gray; font-weight: 400;"><%=sdf.format(dto.getWriteday()) %></b>
				</td>
			<%
			
			if((i+1)%4==0){
				%>
				
				</tr><tr>
			<%}
			
			}
		%>
		</tr>
		
	</table>
	</div>
</body>
</html>