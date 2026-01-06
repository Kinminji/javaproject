<%@page import="jspLogin.loginDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="memguest.memguestDto"%>
<%@page import="MemAnswer.answerDao"%>
<%@page import="MemAnswer.answerDto"%>
<%@page import="java.util.List"%>
<%@page import="memguest.memguestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<title>Insert title here</title>
<script type="text/javascript">
	function deletecheck(num){
		if(confirm("삭제하시겠습니까?")){
			location.href="deletememguest.jsp?num="+num;
			}
	}
</script>
<%
	memguestDao dao=new memguestDao();

	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");

	int totalCount=dao.getTotalCount();
	int perpage=3;
	int perBlock=5;
	int startnum;
	int startPage;
	int endPage;
	int currentPage;
	int totalPage;
	
	int no;
	
	if(request.getParameter("currentPage")==null){
		currentPage=1;
	}else {
		currentPage=Integer.parseInt(request.getParameter("currentPage"));
	}
	
	totalPage=totalCount/perpage+(totalCount%perpage==0?0:1);
	
	startPage=(currentPage-1)/perBlock*perBlock+1;
	endPage=startPage+perBlock-1;
	
	if(endPage>totalPage){
		endPage=totalPage;
	}
	
	startnum=(currentPage-1)*perpage;
	
	no=totalCount-(currentPage-1)*perpage;
	
	
%>
</head>
<body>
	<jsp:include page="guestForm.jsp"/>
	<hr>
	<table class="table table-bordered" style="margin: 50px;">
     	<div style="margin:50px;" align="top">
    <b><%=totalCount %>개의 게시글이 있습니다</b>

       <%
       loginDao logdao=new loginDao();
       
        List<memguestDto> list=dao.selectMemguest(startnum, perpage);
        for(memguestDto dto:list){
        	 String name=logdao.getName(dto.getMyid());
        %>
        	
        <!-- 상단 -->
        	<div class="card mb-3 shqdow-sm" style="margin-top: 20px;">
        	<div class="card-header d-flex justify-content-between">
        		<div>
        			<b><%=name %></b>
        			<span style="color: gray;">(<%=dto.getMyid() %>)</span>
        		</div>
        		<div style="color: lightgray;" >
        			<%=sdf.format(dto.getWriteday()) %>
        		</div>
        		</div>
        		
        		<!-- 내용 -->
        		<div class="card-body">
        			<p><%=dto.getContent() %></p>
        			
        			<%
        				if(dto.getPhoto()!=null && !dto.getPhoto().equals("")){%>
        					<img alt="" src="../save/<%=dto.getPhoto()%>" style="width: 100px;">
        				<%}
        			%>
        			
        			<!-- 버튼 -->
        			<%
        			//현재 로그인한 상태
        			String loginok=(String)session.getAttribute("loginok");
        			//로그인(세션)
        			String sessionId=(String)session.getAttribute("idok");
        			//로그인중이면서 로그인한 아이디와 글쓴아이디가 같다면
        			if(loginok!=null && sessionId.equals(dto.getMyid())){%>
        				<div style="position:absolute; right:15px; bottom:15px;">
							<button type="button" class="btn btn-outline-primary"
							onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>'">수정</button>  
							<button type="button" class="btn btn-outline-danger del"
							onclick="deletecheck(<%=dto.getNum()%>)">삭제</button>      	
        				</div>
        				<%}
        			%>
        		</div>
        	</div>
        	
        	<!-- 댓글창 -->
        	
        	<%
        		answerDao ansdao=new answerDao();
        		List<answerDto> alist=ansdao.selectAnswer(Integer.parseInt(dto.getNum()));
        		int answerCount=ansdao.countAnswer(Integer.parseInt(dto.getNum()));
        	%>
        	
        	<div class="answer">댓글(<%=answerCount %>)</div>
        	<div class="list d-flex">
        		<form action="../memAnswer/answerAddAction.jsp" method="post">
        		<input type="hidden" name="num" value="<%=dto.getNum()%>">
        		<input type="hidden" name="currentPage" value="<%=currentPage%>">
        			<input type="text" name="memo" class="form-control" required="required"
        			placeholder="댓글 입력" style="width: 650px; margin-right: 20px;">
        			
        			<button type="submit" class="btn btn-success btn-sm">저장</button>
        		</form>
        	</div>
        	
        	<div class="mt-2 ms-3">
        		<%
        			for(answerDto ansdto: alist){%>
        				<div class="border-bottom py-1">
        					<b><%=ansdto.getMyid() %></b>
        					<span style="color: gray; font-size: 12px;"><%=sdf.format(ansdto.getWriteday()) %></span>
        					<div class="d-flex justify-content-between">
        					<%=ansdto.getMemo() %>
        					<button type="button" class="btn btn-none" style="font-size: 11px;">삭제</button>
        					</div>
        				</div>
        			<%}
        		%>
        	</div>

        	<%}
        %>
        
      </table>
	
	  <!-- 페이지 번호 출력 -->
	<div>
		<nav aria-label="Page navigation example">
 	 		<ul class="pagination justify-content-center">

 	 		<!-- 이전 -->
 	 		<%
 	 			if(startPage>1){%>
 	 			<li class="page-item">
     			<a class="page-link" href="guestList.jsp?currentPage=<%=startPage-1 %>">이전</a>
    			</li>
 	 			<%}
 	 			for(int pp=startPage; pp<=endPage; pp++){
 	 				if(pp==currentPage){%>
 	 					<li class="page-item"><a class="page-link" href="guestList.jsp?currentPage=<%=pp%>"><%=pp %></a></li>
 	 				<%}else {%>
 							<li class="page-item"><a class="page-link" href="guestList.jsp?currentPage=<%=pp%>"><%=pp %></a></li>
 	 				<%}
 	 			}
 	 			
 	 			//다음
 	 			if(endPage<totalPage){%>
 	 				<li class="page-item">
      					<a class="page-link" href="guestList.jsp?currentPage=<%=endPage+1 %>">다음</a>
    				</li>
 	 			<%}
 	 		%>
    			
  			</ul>
		</nav>
	</div>
</body>
</html>