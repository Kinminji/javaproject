<%@page import="reboard.ReboardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
//수정폼에서 넘긴 3개 받아서
String num=request.getParameter("num");
String currentPage=request.getParameter("currentPage");
String pass=request.getParameter("pass");

//num,pass로는 비번이 맞는지 체크, 맞으면 수정폼이동(num,currentPage) 틀리면 경고창
ReboardDao dao=new ReboardDao();

boolean check=dao.isEqualPass(num, pass);

if(check==true){%>
	<script>
		location.href="updateForm.jsp?num=<%=num%>&currentPage=<%=currentPage%>";
	</script>
<%}else{%>
	<script type="text/javascript">
	alert("비밀번호가 맞지 않습니다.");
	history.back();
	</script>
	
<%}

%>