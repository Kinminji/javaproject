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
</style>
</head>
<%
String num=request.getParameter("num");
boardDao dao=new boardDao();
boardDto dto = dao.oneSelectBoard(num);
%>
<body>
	<div style="margin: 50px 50px; width: 500px">
		<form action="deleteProc.jsp" method="post">
			<table class="table table-borderless">
				<caption align="top"><b>삭제비번입력</b></caption>
				<tr>
					<th>
					<!-- 미리보기 할 이미지 -->
					<img alt="" src="../save/<%=dto.getImgname() %>" id="preview">
					</th>
				</tr>
				<tr>
					<th>비밀번호를 입력하세요
						<input type="password" name="pass" class="form-control" style="width: 150px;" required="required"
						placeholder="입력">
						<!-- 폼 안에 hidden 넣기 -->
						<input type="hidden" name="num" value="<%=num %>">
					</th>
				</tr>
				<tr>
					<th>
						<button type="submit" class="btn btn-danger">삭제</button>
						<button type="button" class="btn btn-info" onclick="history.back()">이전</button>
					</th>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>