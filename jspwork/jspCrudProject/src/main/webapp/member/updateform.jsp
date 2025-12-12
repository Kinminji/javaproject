<%@page import="member.MemberDto"%>
<%@page import="member.MemberDao"%>
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
String num=request.getParameter("num");
MemberDao dao=new MemberDao();
MemberDto dto=dao.selectMember(num);
%>
<body>
	<div style="width: 500px; margin: 50px 50px;">
		<form action="updateation.jsp" method="post">
		<input type="hidden" name="num" value="<%= dto.getNum()%>">
			<table class="table table-bordered">
				<caption align="top"><b>동아리 정보 수정</b></caption>
				<tr>
					<th width="100px" class="table-success">회원명</th>
					<td>
						<input type="text" name="name" class="form-control"
						value="<%=dto.getNum()%>">
					</td>
				</tr>
				<tr>
					<th width="100px" class="table-success">연락처</th>
					<td>
						<input type="text" name="hp" class="form-control"
						value="<%=dto.getName()%>">
					</td>
				</tr>
				<tr>
					<th width="100px" class="table-success">운전면허</th>
					<td>
						<input type="checkbox" name="driver"
						<%=dto.getDriver().equals("있음")?"checked":"" %>>&nbsp;有(있음)
					</td>
				</tr>
				<tr>
					<th width="100px" class="table-success">직업</th>
					<td>
						<input type="text" name="job" class="form-control"
						<%=dto.getJob()%>>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-warning">수정</button>
						<button type="button" class="btn btn-success"
						onclick="location.href='memberlist.jsp'">목록</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>