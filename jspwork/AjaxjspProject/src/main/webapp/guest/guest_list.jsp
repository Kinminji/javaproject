<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="guest.guestDto"%>
<%@page import="java.util.List"%>
<%@page import="guest.guestDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
	guestDao dao=new guestDao();
	List<guestDto> list=dao.getAllGuest();
	
	JSONArray arr=new JSONArray();
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	for(guestDto dto:list){
		JSONObject ob=new JSONObject();
		ob.put("num", dto.getNum());
		ob.put("nick", dto.getNickname());
		ob.put("content", dto.getContent());
		ob.put("emot", dto.getEmot());
		ob.put("writeday", sdf.format(dto.getWriteday()));
		
		//arr추가
		arr.add(ob);
		}
	
	out.print(arr.toString());
	%>