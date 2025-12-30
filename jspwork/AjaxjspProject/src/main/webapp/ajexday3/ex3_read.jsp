<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//프론트에서 보낸 데이터 읽어오기
	String name=request.getParameter("name");
	String like=request.getParameter("like");
	String img=request.getParameter("img");
	
	System.out.println("점심메뉴: "+name);
	System.out.println("점수: "+like);

%>