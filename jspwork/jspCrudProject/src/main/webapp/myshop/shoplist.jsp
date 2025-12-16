<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="myshop.shopDto"%>
<%@page import="java.util.List"%>
<%@page import="myshop.shopDao"%>
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
	shopDao dao=new shopDao();
	List<shopDto> list=dao.selectShop();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	NumberFormat nf=NumberFormat.getCurrencyInstance();
%>
<body>
	<div style="margin: 50px 50px; width: 900px">
		<h3 class="alert alert-info">MY SHOP 전체목록</h3><br>
		<button type="button" class="btn btn-warning"
		onclick="location.href='shopform.jsp'">상품추가</button>
		<br><br>
		<table class="table table-bordered">
			<tr class="table-warning" align="center">
				<th width="80">번호</th>
				<th width="250">상품명</th>
				<th width="100">가격</th>
				<th width="150">입고날짜</th>
				<th width="150">등록날짜</th>
			</tr>
			
			<%
				if(list.size()==0){%>
					<tr>
						<td colspan="5" align="center">
						<h5>입고된 상품이 없습니다.</h5>
						</td>
					</tr>
				<%}else{
					for(int i=0;i<list.size();i++){
						shopDto dto=list.get(i); %>
						
						<tr>
							<td><%=i+1 %></td>
							<td>
							<a href="detailpage.jsp?num=<%=dto.getNum()%>"><img alt="" src="../image/food/<%=dto.getPhoto() %>.jpg" width="50" height="50"></a>
							<%=dto.getSangpum() %></td>
							<td><%=nf.format(dto.getPrice()) %></td>
							<td><%=dto.getIpgoday() %></td>
							<td><%=sdf.format(dto.getWriteday()) %></td>
						</tr>
					<%}
				}
			%>
		</table>
	</div>
</body>
</html>