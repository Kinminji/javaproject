<%@page import="board.ajaxDao"%>
<%@page import="board.ajaxDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ajaxDao dao=new ajaxDao();
	
	String num=request.getParameter("num");
	
	dao.delectBoard(num);
	
%>