<%@page import="java.text.SimpleDateFormat"%>
<%@page import="mysql_team.TeamDao"%>
<%@page import="java.util.List"%>
<%@page import="mysql_team.TeamDto"%>
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
	TeamDao dao=new TeamDao();
	List<TeamDto> list=dao.getAllDate();
%>
<body>
	<div style="width: 700px; margin: 50px 50px;'">
		<button type="button" class="btn btn-success" onclick="location.href='addform.jsp'">팀가입</button>
		<br><br>
		
		<table class="table table-bordered">
			<caption align="top">팀 회원 목록</caption>
			<tr>
				<td style="width: 50">번호</td>
				<td style="width: 100">성함</td>
				<td style="width: 220">주소</td>
				<td style="width: 100">결혼 유무</td>
				<td style="width: 120">가입날짜</td>
				<td style="width: 120">편집</td>
			</tr>
			<%
				for(int i=0;i<list.size();i++){
					TeamDto dto=list.get(i);
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");%>
					
					<tr>
						<td><%=i+1 %></td>
						<td><%=dto.getName() %></td>
						<td><%=dto.getAddr()%></td>
						<td><%=dto.getMarry() %></td>
						<td><%=sdf.format(dto.getGaipday()) %></td>
						<td colspan="2" align="center">
							<button type="button" class="btn btn-warning" 
							onclick="location.href='updateform.jsp?num=<%=dto.getNum()%>'">수정</button>
							<button type="button" class="btn btn-danger"
							onclick="location.href='deleteteam.jsp?num=<%=dto.getNum()%>'">삭제</button>
						</td>
					</tr>
				<%}
			%>
		</table>
		
	</div>
</body>
</html>