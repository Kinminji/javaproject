<%@page import="java.text.SimpleDateFormat"%>
<%@page import="board.ajaxDto"%>
<%@page import="board.ajaxDao"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//dao 읽기
	ajaxDao dao=new ajaxDao();
	//num읽기
	String num=request.getParameter("num");
	//oneselectBoard 읽기
	ajaxDto dto=dao.oneselectBoard(num);
	
	//dto를 json으로 변환
	JSONObject ob=new JSONObject();
	
	//날짜 문자열로 지정
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	//json에 추가
	ob.put("num", dto.getNum());
	ob.put("name", dto.getName());
	ob.put("subject", dto.getSubject());
	ob.put("emot", dto.getEmot());
	ob.put("content", dto.getContent());
	ob.put("writeday", sdf.format(dto.getWriteday()));
	
	out.print(ob.toString());
%>