<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="board.ajaxDao"%>
<%@page import="board.ajaxDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ajaxDao dao=new ajaxDao();
	List<ajaxDto> list=dao.selectBoard();
	
	JSONArray arr=new JSONArray();
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	for(ajaxDto dto:list){
		JSONObject ob=new JSONObject();
		ob.put("num", dto.getNum());
		ob.put("name", dto.getName());
		ob.put("subject", dto.getSubject());
		ob.put("content", dto.getContent());
		ob.put("emot", dto.getEmot());
		ob.put("writeday", sdf.format(dto.getWriteday()));
		
		arr.add(ob);
	}
	
	out.print(arr.toString());
%>
