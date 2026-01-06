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
	<div class="logform" style="margin: 50px; width: 250px;" >
		<h3>회원 로그인</h3>
		<form action="loginAction.jsp" method="post">
			<input type="text" name="id" class="form-control" style="width: 200px; margin-bottom:5px; " placeholder="ID 입력" required="required">
			<input type="password" name="password" class="form-control" style="width: 200px;" placeholder="Password" required="required">
			<br>
			<button type="sumbit" class="btn btn-success" style="width: 200px;">로그인</button>
			<br>
			<input type="checkbox" name="saveok">아이디저장
		</form>
	</div>
</body>
</html>