<%@page import="java.text.SimpleDateFormat"%>
<%@page import="myinfo.MyinfoDto"%>
<%@page import="java.util.List"%>
<%@page import="myinfo.MyinfoDao"%>
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
	MyinfoDao dao=new MyinfoDao();
	List<MyinfoDto> list=dao.getAllDates();
%>
<body>
	<div style="width: 700px; margin: 50px 50px;">
		<button type="button" class="btn btn-warning"
		onclick="location.href='insertForm.jsp'">글쓰기</button>
		
		<br><br>
		<table class="table table-dordered">
			<caption align="top"><b>Myinfo 목록</b></caption>
			<tr class="table-info">
				<th width="50">번호</th>
				<th width="90">이름</th>
				<th width="220">주소</th>
				<th width="120">등록일</th>
				<th width="100">편집</th>
			</tr>
			<%
				for(int i=0;i<list.size();i++){
				MyinfoDto dto=list.get(i);
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				%>
					<tr>
						<td align="center"><%=i+1 %></td>
						<td><%=dto.getName() %></td>
						<td><%=dto.getAddr() %></td>
						<td><%=sdf.format(dto.getSdate()) %></td>
						<td>
							<button type="button" class="btn btn-info btn-sm"
							onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>'">수정</button>
							<button type="button" class="btn btn-danger btn-sm"
							onclick="location.href='delete.jsp?num=<%=dto.getNum()%>'">삭제</button>
						</td>
					</tr>
				<%}
			%>
		</table>
	</div>
</body>
</html>