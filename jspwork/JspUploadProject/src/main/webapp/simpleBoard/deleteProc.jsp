<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="simpleBoard.boardDto"%>
<%@page import="simpleBoard.boardDao"%>
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
	
	//입력값 읽기
	String num=request.getParameter("num");
	String pass=request.getParameter("pass");
	
	//dao
		boardDao dao=new boardDao();
	
	//비번이 맞으면 수정 후 datail페이지로 가고 비번이 틀리면 script로 경고창
	boolean b=dao.isEqualPass(num, pass);
	
	if(b){
		//게시글 지우기전 업로드한 이미지 삭제
		String imgName=dao.oneSelectBoard(num).getImgname();
		//업로드 경로
		String uploadPath=getServletContext().getRealPath("/save");
		//파일 지우기 전 생성
		File file=new File(uploadPath+"\\"+imgName);
		//파일 삭제
		if(file.exists()) //파일이 존재 한다면
			file.delete(); //파일을 삭제
		
		//비번이 맞는 경우
		dao.deleteBoard(num);
		response.sendRedirect("boardList.jsp?num="+num);
	} else {
		//비번이 틀린 경우
		%>
		<script type="text/javascript">
			alert("비밀번호가 틀렸습니다.");
			history.back();
		</script>
	<%}

	%>
</body>
</html>