<%@page import="guest.guestDto"%>
<%@page import="guest.guestDao"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String nickname=request.getParameter("nickname");
	String content=request.getParameter("content");
	String emot=request.getParameter("emot");
	
	guestDto dto=new guestDto();
	dto.setNickname(nickname);
	dto.setContent(content);
	dto.setEmot(emot);
	
	guestDao dao=new guestDao();
	
	dao.insertGuest(dto);
%>

