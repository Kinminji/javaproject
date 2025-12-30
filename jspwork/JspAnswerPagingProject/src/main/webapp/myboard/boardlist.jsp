<%@page import="java.text.SimpleDateFormat"%>
<%@page import="myBoard.boardDto"%>
<%@page import="java.util.List"%>
<%@page import="myBoard.boardDao"%>
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
<style type="text/css">
	.subject-link{
		text-decoration: none;
		color: #000;
	}
	.subject-link:hover{
		text-decoration: underline;
	}
	
</style>
</head>
<%
	boardDao dao=new boardDao();
	//List<boardDto> list=dao.selectBoard(); 
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	//전체갯수
	int total=dao.getTotalCount();
	int perPage=4;//한페이지에 보여질 글 갯수
	int perBlock=2;//한블럭에 보여질 페이지 갯수
	int startNum; //db에서 가져올 글의 시작번호(mysql이므로 첫글이 0,오라클은 1)
	int startPage; //각 블럭당 보여질 시작 페이지
	int endPage; //각 블럭당 보여질 끝 페이지
	int currentPage; //현재 페이지
	int totalPage; //총 페이지
	
	int no; //각페이지당 출력할 시작 번호
	
	
	//현재 페이지 읽기,단 null일 경우 1로 둔다
	if(request.getParameter("currentPage")==null)
		currentPage=1;
	else
		currentPage=Integer.parseInt(request.getParameter("currentPage"));
	
	//총페이지 구하기
	//총페이지 갯수%한페이지에 보여질 갯수
	//나머지가 1이라도 있으면 무조건 1페이지 추가
	totalPage=total/perPage+(total%perPage==0?0:1);
	
	//각 블럭당 보여질 시작페이지
	//perBlock=5일 경우 현재페이지1~5일경우는 시작페이지 1, 끝페이지 5
	//만약 현재페이지가 13이면 11~15
	startPage=(currentPage-1)/perBlock*perBlock+1;
	endPage=startPage+perBlock-1;
	
	//총페이지 갯수가 23이면 마지막페이지는 23으로 표기
	if(endPage>totalPage)
		endPage=totalPage;
	
	//각페이지에서 보여질 시작번호
	//예: 1페이지->0번 2페이지->5번 3페이지->10
	startNum=(currentPage-1)*perPage;
	
	//no
	no=total-(currentPage-1)*perPage;
	
	//페이지에서 보여질 글만 가져오기
	List<boardDto> list=dao.pagingListBoard(startNum, perPage);	
	
%>
<body>
	<div style="margin: 30px 50px; width: 800px;">
		<button type="button" class="btn btn-success" onclick="location.href='insertForm.jsp'">글쓰기</button>
		<br>
		<h5><%=total %>개의 개시글이 있습니다.</h5>
	
	
	<table class="table table-bordered">
		<caption align="top"><b>MyBoard 전체 목록</b></caption>
		<tr class="table-success" align="center">
			<th width="70">번호</th>
			<th width="350">제목</th>
			<th width="150">작성자</th>
			<th width="120">작성일</th>
			<th width="70">조회수</th>		
		</tr>
		<%
			if(total==0){%>
				<tr>
					<td colspan="5" align="center">등록된 게시글이 없습니다.</td>
				</tr>
			<%} else{
				for(int i=0;i<list.size();i++){
					boardDto dto=list.get(i);%>
					
					<tr>
						<td><%=no-i %></td>
						<td><a href="contentView.jsp?num=<%=dto.getNum()%>" class="subject-link">
						<%=dto.getSubject() %></a>
						</td>
						<td><%=dto.getWriter() %></td>
						<td><%=sdf.format(dto.getWriteday()) %></td>
						<td><%=dto.getWidthcount() %></td>
					</tr>
				<%}
			}
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
     			<a class="page-link" href="boardlist.jsp?currentPage=<%=startPage-1 %>">이전</a>
    			</li>
 	 			<%}
 	 			for(int pp=startPage; pp<=endPage; pp++){
 	 				if(pp==currentPage){%>
 	 					<li class="page-item"><a class="page-link" href="boardlist.jsp?currentPage=<%=pp%>"><%=pp %></a></li>
 	 				<%}else {%>
 							<li class="page-item"><a class="page-link" href="boardlist.jsp?currentPage=<%=pp%>"><%=pp %></a></li>
 	 				<%}
 	 			}
 	 			
 	 			//다음
 	 			if(endPage<totalPage){%>
 	 				<li class="page-item">
      					<a class="page-link" href="boardlist.jsp?currentPage=<%=endPage+1 %>">다음</a>
    				</li>
 	 			<%}
 	 		%>
    			
  			</ul>
		</nav>
	</div>
</div>
</body>

</html>