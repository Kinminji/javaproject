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
	<!-- 폼으로 quizAction에 전송후 action페이지에서 처리할것
	1. 본인입력(text)  2.오늘점심메뉴 radio  3.가능it언어(checkbox) -->
	<form action="quizAction.jsp">
	<h3>[정보입력]</h3>
	<table class="table table-bordered" style="width: 500px">
		<tr>
			<th width="120">성함: </th>
			<td>
				<input type="text" name="name" placeholder="이름입력">
			</td>
		</tr>
		<tr>
			<th>오늘점심메뉴: </th>
			<td>
				<input type="radio" name="menu" value="단백질쉐이크+두유">단백질쉐이크+두유
				<input type="radio" name="menu" value="서브웨이 에그마요샌드위치">서브웨이 에그마요샌드위치
				<input type="radio" name="menu" value="질할브로스 콤보라이스">질할브로스 콤보라이스
				<input type="radio" name="menu" value="감">감
			</td>
		</tr>
		<tr>
			<th>가능IT언어: </th>
			<td>
				<input type="checkbox" name="it" value="HTML">HTML
				<input type="checkbox" name="it" value="JAVASCRIPT">JAVASCRIPT
				<input type="checkbox" name="it" value="JAVA">JAVA
				<input type="checkbox" name="it" value="JSP">JSP
				<input type="checkbox" name="it" value="ORACLE">ORACLE
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-primary">전송</button>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>