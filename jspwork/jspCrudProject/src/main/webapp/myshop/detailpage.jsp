<%@page import="java.text.NumberFormat"%>
<%@page import="myshop.shopDao"%>
<%@page import="myshop.shopDto"%>
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
<script>
function funcdel(num){
    if(confirm("정말 삭제하시겠습니까?")){
        location.href = "deleteshop.jsp?num=" + num;
    }
}
</script>
</head>
<%
String num=request.getParameter("num");
	shopDao dao=new shopDao();
	shopDto dto=dao.oneselectShop(num);
	NumberFormat nf=NumberFormat.getCurrencyInstance();
%>
<body>
	<div style="margin: 50px 50px; width: 700px">
		<table class="table">
			<tr>
				<td rowspan="6">
					<img alt="" src="../image/food/<%=dto.getPhoto() %>.jpg" style="width: 300px">
				</td>
			</tr>
			<tr>
				<th>음식명</th>
				<td>
					<%=dto.getSangpum() %>
				</td>
			</tr>
			<tr>
				<th>가격</th>
				<td>
					<%=dto.getPrice() %>
				</td>
			</tr>
			<tr>
				<th>입고날짜</th>
				<td>
					<%=dto.getIpgoday() %>
				</td>
			</tr>
			<tr>
				<th>등록날짜</th>
				<td>
					<%=dto.getWriteday() %>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="button" class="btn btn-warning"
					onclick="location.href='updateform.jsp?num=<%=dto.getNum()%>'">수정</button>
					<button type="button" class="btn btn-danger"
					onclick="funcdel('<%=dto.getNum() %>')">삭제</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>