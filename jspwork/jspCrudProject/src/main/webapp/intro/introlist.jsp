<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="intro.introDto"%>
<%@page import="intro.introDao"%>
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
	introDao dao=new introDao();
	List<introDto> list=dao.SelectIntro();
%>
<body>
	<div style="width: 700px; margin: 50px 50px;">
		<h3 class="alert alert-info">자기소개 list</h3>
		<table class="table table-bordered">
			<tr class="table-secondary">
				<th>번호</th>
				<th>이름</th>
				<th>생년월일</th>
				<th>전화번호</th>
				<th>가입날짜</th>
				<th>자세히보기</th>
			</tr>
			
			<%
			if(list.size()==0){%>
				<tr>
					<td colspan="6" align="center">
						<h5>현재 자기소개 데이터가 없습니다.</h5>
					</td>
				</tr>
			<%}else{
				for(int i=0;i<list.size();i++){
					introDto dto=list.get(i);
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");%>
					
					<!-- 리스트 출력 -->
					<tr>
						<td align="center"><%=i+1 %></td>
						<td><%=dto.getName() %></td>
						<td><%=dto.getBirthday()%></td>
						<td><%=dto.getHp()%></td>
						<td><%=sdf.format(dto.getWriteday())%></td>
						<td><button type="button" class="btn btn-primary"
						onclick="location.href='detailPage.jsp?num=<%=dto.getNum()%>'">자세히보기</button></td>
					</tr>
				<%}
			}
			%>
		</table>
		<button type="button" class="btn btn-warning" onclick="location.href='addfrom.jsp'">자기소개서 작성</button>
	</div>
</body>
</html>