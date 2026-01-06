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
#camera{
	cursor: pointer;
}
#preview{
	position: absolute;
	left: 600px;
	top: 100px;
	max-width: 200px;
}
</style>
</head>
<body>
<script type="text/javascript">

$(function(){
	$("#camera").click(function(){
		//id photo를 강제 클릭한 이벤트
		$("#photo").trigger("click");
	})
})

function readURL(input) {
	   // 파일이 선택되었고, 파일 객체가 존재하는지 확인
	   if (input.files[0]) {
	       var reader = new FileReader(); // FileReader 객체 생성
	      
	       reader.onload = function (e) {
	          
	           $('#preview').attr('src', e.target.result);
	       };

	       reader.readAsDataURL(input.files[0]);
	   }
	}

</script>
<%
	//세션으로부터 로그인한 사람의 아이디 얻기
	String id=(String)session.getAttribute("idok");

	//로그인한 상태인지 체크
	String loginok=(String)session.getAttribute("loginok");
	
	//이미지 미리보기
	if(loginok!=null){%>
	<img id="preview">
	<div style="margin: 50px; width: 500px;">
		<form action="guestAction.jsp" method="post" enctype="multipart/form-data">
		
		<!-- hidden -->
		<input type="hidden" name="myid" value="<%=id%>">
		
		 <div class="d-flex justify-content-between align-items-center mb-2">
        	<b style="font-size: 15px; color: gray;">회원방명록(<%=id %>)</b>
        	<button type="button" class="btn btn-danger btn-sm"
        	onclick="location.href='../login/logoutForm.jsp'">로그아웃</button>
   		 </div>
		
			<table class="table table-bordered">
				<tr height="150">
					<td>
						<i class="bi bi-camera" id="camera"></i>
						<b>사진을 선택해 주세요.(1개)</b>
	
						<input type="file" name="photo" id="photo" style="display: none;"
						onchange="readURL(this)">
						<br>
						<textarea style="width: 400px; height: 100px; margin-top: 5px;"
						class="form-control" required="required" name="content"></textarea>
						
						<button type="submit" class="btn btn-success"
						style="width: 80px; height: 40px; margin-top: 5px;">저장</button>
					</td>
				</tr>
			</table>
		</form>
		</div>
	<%}
%>

</body>
</html>