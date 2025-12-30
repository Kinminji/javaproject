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
	#wrap{
		position: absolute;
		left: 50%;
		top: 50%;
		transform:translate(-50%,-50%);		
	}
</style>
</head>
<%
	String num=request.getParameter("num");
	
%>
<body>
	<div id="wrap">
		<form action="updatePathAction.jsp" method="post">
		<!-- form안에 hidden 넣기 -->
		<input type="hidden" name="num" value="<%=num%>">
			<h4>수정할 비밀번호</h4>
			<input type="password" class="form-control" required="required" style="width: 250px;" name="path">
			<button type="submit" class="btn btn-success">비밀번호 확인</button>
		</form>
	</div>
</body>
</html>