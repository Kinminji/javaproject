<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.beans.SimpleBeanInfo"%>
<%@page import="myBoard.boardDao"%>
<%@page import="myBoard.boardDto"%>
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
	$(function(){
		
		var num=$("#num").val();
		list();
		
		//alert(num);
		$("#btnSend").click(function(){
			
			var nickname=$("#nickname").val();
			var comment=$("#comment").val();
			
			if(nickname.trim()===""){
				alert("닉네임을 입력해주세요.");
				$("#nickname").focus();
				return;
			}
			
			if(comment.trim()===""){
				alert("내용을 입력해주세요.");
				$("#comment").focus();
				return;
			}
			
			$.ajax({
				type:"post",
				url:"../myboardAnswer/insertAnswer.jsp",
				dataType:"html",
				data:{"num":num,"nickname":nickname,"comment":comment},
				success:function(){
					$("#comment").val("");
					$("#nickname").val("");
					list();
				}
			})
		})
		
		$(document).on("click",".del",function(){
			var idx=$(this).data("idx");
			
			if(!confirm("댓글을 삭제하시겠습니까?"))return;
			
			$.ajax({
				type:"post",
				url:"../myboardAnswer/deleteAnswer.jsp",
				dataType:"html",
				data:{"idx":idx},
				success:function(){
					list();
				}
			})
		})
	})
	
	function list(){
			var num=$("#num").val();
			//alert(num);
			
			$.ajax({
				type:"get",
				url:"../myboardAnswer/listAnswer.jsp",
				dataType:"json",
				data:{"num":num},
				success:function(res){
					//댓글갯수 출력
					$("b.acount>span").text(res.length);
					
					var s="";
					$.each(res,function(idx,item){
						s+="<div style='font-size:0.9em;'>"+item.nickname+":"+item.comment;
						s+="<i class='bi bi-pencil-square' style='margin:5px; cursor:pointer;'></i>";
						s+="<i class='bi bi-trash2 del' style='cursor:pointer;' data-idx='"+item.idx+"'></i>";
						s+="<span class='aday' style='font-size:0.8em; color:gray; float:right;'>"+item.writeday+"</span>";
						s+="</div>";
					})
					$("div.alist").html(s);
				}
			})
		}
		
</script>
</head>
<%
String num=request.getParameter("num");
boardDao dao=new boardDao();

//조회수 증가
dao.updateWidthcount(num);

boardDto dto=dao.oneselectBoard(num);

//날짜
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");


%>
<body>

<input type="hidden" id="num" value="<%=num%>">
	<div style="margin: 50px 50px; width: 500px;">
		<table class="table table-bordered">
			<caption align="top"><b style="font-size: 1.2em;"><%=dto.getSubject() %></b></caption>
			<tr>
				<td>
					<b>작성자: <%=dto.getWriter() %></b><br>
					<span style="font-size: 0.8em; color: gray;"><%=sdf.format(dto.getWriteday()) %></span>&nbsp;&nbsp;
					<span style="font-size: 0.8em; color: gray;">조회: <%=dto.getWidthcount() %></span>
				</td>
			</tr>
			<tr height="200">
				<td>
					<%=dto.getContent().replace("\n","<br>") %>
				</td>
			</tr>
			
			<!-- 댓글 -->
			<tr>
				<td>
					<b class="acount">댓글 <span>0</span> </b>
					<div class="alist">
						댓글목록...
					</div>
					
					<div class="aform" style="display: flex;">
						<input type="text" id="nickname" class="form-control" style="width: 120px; margin-right: 5px;"
						placeholder="닉네임">
						<input type="text" id="comment" class="form-control" style="width: 250px; margin-right: 5px;""
						placeholder="입력">
						<button type="button" id="btnSend" class="btn btn-secondary">저장</button>
					</div>
				</td>
			</tr>
			<tr>
				<td align="right">
					<button type="button" class="btn btn-secondary" onclick="location.href='insertForm.jsp'">글쓰기</button>
					<button type="button" class="btn btn-secondary" 
					onclick="location.href='updatePathForm.jsp?num=<%=dto.getNum()%>'">수정</button>
					<button type="button" class="btn btn-secondary"
					onclick="location.href='deletePathForm.jsp?num=<%=dto.getNum()%>'">삭제</button>
					<button type="button" class="btn btn-secondary" onclick="location.href='boardlist.jsp'">목록</button>
				</td>
			</tr>
		</table>
	</div>	
</body>
</html>