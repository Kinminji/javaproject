<%@page import="board.ajaxDto"%>
<%@page import="board.ajaxDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String num=request.getParameter("unum");
	String name=request.getParameter("uname");
	String subject=request.getParameter("usubject");
	String content=request.getParameter("ucontent");
	String emot=request.getParameter("uemot");
	
	ajaxDto dto=new ajaxDto();
	dto.setNum(num);
	dto.setName(name);
	dto.setSubject(subject);
	dto.setContent(content);
	dto.setEmot(emot);
	
	ajaxDao dao=new ajaxDao();
	dao.updateBoard(dto);
%>