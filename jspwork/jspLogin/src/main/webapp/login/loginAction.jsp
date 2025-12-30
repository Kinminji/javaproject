<%@page import="jspLogin.loginDao"%>
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
	<%
	String id=request.getParameter("id");
	String password=request.getParameter("password");
	String save=request.getParameter("saveok");
	
	//아이디와 비번이 맞는지 확인
	loginDao dao=new loginDao();
	boolean flag=dao.islogin(id, password);
	
	if(flag){
		//로그인중인지 아닌지 판단할 session저장
		session.setAttribute("loginok", "yes");
		//아이디와 체크값 저장
		session.setAttribute("idok", id);
		//아이디체크값: 체크하면 on, 에크인 안하면 null
		session.setAttribute("saveok", save);
		
		//세션유지시간
		session.setMaxInactiveInterval(60*60*0);//8시간 유진
		
		//로그인 메인으로 이동(원래는 로그아웃폼..)
		response.sendRedirect("loginMain.jsp");
	}else{%>
		<script type="text/javascript">
			alert("아이디와 비밀번호를 다시 확인해주세요.");
			history.back();
		</script>
	<%}
			
	%>
</body>
</html>