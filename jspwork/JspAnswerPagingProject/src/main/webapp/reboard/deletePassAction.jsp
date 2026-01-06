<%@page import="reboard.ReboardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String num=request.getParameter("num");
String currentPage=request.getParameter("currentPage");
String pass=request.getParameter("pass");

ReboardDao dao=new ReboardDao();

boolean check=dao.isEqualPass(num, pass);

if(check){
	dao.deleteReboard(num);
	response.sendRedirect("boardList.jsp?currentPage="+currentPage);
}else{%>
	<script type="text/javascript">
	alert("비밀번호가 맞지 않습니다.");
	history.back();
</script>
<%}
%>