<%@page import="memguest.memguestDao"%>
<%@page import="memguest.memguestDto"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//save폴더의 실제서버위치 구하기
	String realPath=getServletContext().getRealPath("/save");
	System.out.println(realPath);
	
	//업로드할 이미지 크기제한
	int uploadSize=1024*1024*3; 
	
	MultipartRequest multi=null;
	
	try{
	multi=new MultipartRequest(request,realPath,uploadSize,"utf-8",
			new DefaultFileRenamePolicy());
	
	//입력한 데이터 읽기
	String photo=multi.getFilesystemName("photo");
	System.out.println("photo="+photo);
	String content=multi.getParameter("content");
	String num=multi.getParameter("num");
	
	memguestDto dto=new memguestDto();
	dto.setNum(num);
	dto.setPhoto(photo==null?"no":photo);
	dto.setContent(content);
	
	memguestDao dao=new memguestDao();
	dao.updatememguest(dto);
	
	response.sendRedirect("guestList.jsp");
	
	}catch(Exception e){
		
	}
%>