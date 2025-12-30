<%@page import="guest.guestDao"%>
<%@page import="guest.guestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("uft-8");

	String num=request.getParameter("num");
	String nickname=request.getParameter("nickname");
	String content=request.getParameter("content");
	String emot=request.getParameter("emot");
	
	guestDto dto=new guestDto();
	dto.setNum(num);
	dto.setNickname(nickname);
	dto.setContent(content);
	dto.setEmot(emot);
	
	guestDao dao=new guestDao();
	dao.updateGuest(dto);
%>