<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="guest.guestDto"%>
<%@page import="guest.guestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

request.setCharacterEncoding("UTF-8");

	//num
	String num=request.getParameter("num");
	//dao
	guestDao dao=new guestDao();
	
	guestDto dto=dao.oneselectguest(num);
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	JSONObject ob=new JSONObject();
	ob.put("num", dto.getNum());
	ob.put("nickname", dto.getNickname());
	ob.put("content", dto.getContent());
	ob.put("emot", dto.getEmot());
	ob.put("writeday", sdf.format(dto.getWriteday()));
%>
<%= ob.toString()%>