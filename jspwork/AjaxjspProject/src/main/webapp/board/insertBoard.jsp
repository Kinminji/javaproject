<%@page import="board.ajaxDao"%>
<%@page import="board.ajaxDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String name=request.getParameter("name");
	String subject=request.getParameter("subject");
	String content=request.getParameter("content");
	String emot=request.getParameter("emot");
	
	ajaxDto dto=new ajaxDto();
	dto.setName(name);
	dto.setSubject(subject);
	dto.setContent(content);
	dto.setEmot(emot);
	
	ajaxDao dao=new ajaxDao();
	dao.insertBoard(dto);
%>