<%@page import="org.json.simple.JSONObject"%>
<%@page import="myBoard.boardAnswerDto"%>
<%@page import="myBoard.boardAnswerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String idx=request.getParameter("idx");
boardAnswerDao dao=new boardAnswerDao();
boardAnswerDto dto=dao.oneselectAnswer(idx);

JSONObject ob=new JSONObject();
ob.put("idx", dto.getIdx());
ob.put("nickname", dto.getNickname());
ob.put("comment", dto.getComment());
%>

<%= ob.toString()%>