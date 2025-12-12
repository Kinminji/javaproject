<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="member.MemberDao"%>
<%@page import="member.MemberDto"%>
<%@page import="java.sql.Connection"%>
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
MemberDao dao=new MemberDao();
List<MemberDto> list=dao.getAllDate();
%>
<body>
	<div style="margin: 50px 50px; width: 700px">
		<button type="button" class="btn btn-success"
		onclick="location.href='addform.jsp'"><i class="bi bi-pencil-square">글쓰기</i></button>
		<br><br>
		
		<table class="table table-bordered">
			<caption align="top">동아리 회원 목록 list</caption>
			<tr class="table-info">
				<td width="50">번호</td>
				<td width="100">이름</td>
				<td width="200">연락처</td>
				<td width="100">운전면허</td>
				<td width="100">직업</td>
				<td width="150">가입일</td>
				<td width="240">편집</td>
			</tr>	
			<%
				for(int i=0;i<list.size();i++){
					MemberDto dto=list.get(i);
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");%>
					
					<tr>
					<td align="center"><%=i+1 %></td>
					<td align="center"><%=dto.getName() %></td>
					<td align="center"><%=dto.getHp() %></td>
					<td align="center"><%=dto.getDriver() %></td>
					<td align="center"><%=dto.getJob() %></td>
					<td align="center"><%=sdf.format(dto.getWriteday()) %></td>
					<td colspan="2" align="center">
						<button type="button" class="btn btn-warning"
						onclick="location.href='updateform.jsp?num=<%=dto.getNum()%>'">수정</button>
						<button type="button" class="btn btn-danger"
						onclick="if(confirm('정말 삭제하시겠습니까?')) location.href='memberdelete.jsp?num=<%=dto.getNum()%>'">삭제</button>
					</td>
				</tr>
				<%}
			%>
		</table>
	</div>
</body>
</html>