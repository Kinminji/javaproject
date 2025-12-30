<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="myBoard.boardDto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="myBoard.boardAnswerDto"%>
<%@page import="java.util.List"%>
<%@page import="myBoard.boardAnswerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
	int num=Integer.parseInt(request.getParameter("num"));

	boardAnswerDao dao=new boardAnswerDao();
	List<boardAnswerDto> list=dao.selectAnswer(num);
	
	JSONArray arr=new JSONArray();
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	for(boardAnswerDto dto:list)
	{
		JSONObject ob=new JSONObject();
		ob.put("idx", dto.getIdx());
		ob.put("num", dto.getNum());
		ob.put("nickname", dto.getNickname());
		ob.put("comment", dto.getComment());
		ob.put("writeday", sdf.format(dto.getWriteday()));
		
		arr.add(ob);
	}
	
%>
<%=arr.toString()%>