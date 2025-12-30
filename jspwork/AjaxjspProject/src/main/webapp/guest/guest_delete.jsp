<%@page import="guest.guestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String num=request.getParameter("num");
	
	guestDao dao=new guestDao();
	
	dao.deleteGuest(num);

%>
