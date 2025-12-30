<%@page import="myBoard.boardAnswerDto"%>
<%@page import="myBoard.boardAnswerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String idx=request.getParameter("idx");
String nickname=request.getParameter("nickname");
String comment=request.getParameter("comment");

boardAnswerDto dto=new boardAnswerDto();
dto.setIdx(idx);
dto.setNickname(nickname);
dto.setComment(comment);

boardAnswerDao dao=new boardAnswerDao();
dao.updateAnswer(dto);
%>