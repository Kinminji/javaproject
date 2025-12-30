<%@page import="myBoard.boardAnswerDao"%>
<%@page import="myBoard.boardAnswerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String idx=request.getParameter("idx");

	boardAnswerDto dto=new boardAnswerDto();
	dto.setIdx(idx);
	
	boardAnswerDao dao=new boardAnswerDao();
	dao.deleteAnswer(idx);
%>