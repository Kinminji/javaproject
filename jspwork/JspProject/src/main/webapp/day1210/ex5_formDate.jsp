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
	<form action="ex5_action.jsp" method="post">
	<h3>[정보입력]</h3>
	<table class="table table-warning" style="width: 500px">
		<tr>
			<th width="120">사원명: </th>
			<td>
				<input type="text" name="s_name" placeholder="이름입력">
			</td>
		</tr>
		<tr>
			<th width="120">해외근무여부 </th>
			<td>
				<input type="checkbox" name="cbarea">가능
			</td>
		</tr>
		<tr>
			<th width="120">입사일자 </th>
			<td>
				<input type="date" name="ipsaday">
			</td>
		</tr>
		<tr>
			<th>직무 </th>
			<td>
				<input type="radio" name="teem" value="인사팀" checked="checked">인사팀
				<input type="radio" name="teem" value="개발팀">개발팀
				<input type="radio" name="teem" value="마케팅팀">마케팅팀
				<input type="radio" name="teem" value="재무팀">재무팀
			</td>
		</tr>
		<tr>
			<th>제2외국어 </th>
			<td>
				<input type="checkbox" name="it" value="영어">영어
				<input type="checkbox" name="it" value="일본어">일본어
				<input type="checkbox" name="it" value="중국어">중국어
				<input type="checkbox" name="it" value="프랑스어">프랑스어
				<input type="checkbox" name="it" value="스페인어">스페인어
			</td>
		</tr>
		<tr>
			<th>명절선물(택1)</th>
			<td>
				<select name="gift">
					<option value="../image/logoimg/acc01.png">시계</option>
					<option value="../image/logoimg/acc03.png">향수</option>
					<option value="../image/logoimg/icon03.png">게임기</option>
					<option value="../image/logoimg/money.png">현금</option>
				</select>
			</td>
		</tr>
		<tr>
			<th></th>
			<td>
				<input type="color" name="bgcolor" value="#ffcccc">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-success">사원 투표 전송</button>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>