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
#preview{
	position: absolute;
	left: 700px;
	top: 100px;
	width: 300px;
}
</style>
<script type="text/javascript">
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader(); // FileReader 객체 생성

        reader.onload = function(e) {
            // 파일 읽기 완료 시, 미리보기 이미지의 src 속성을 설정
            $('#preview').attr('src', e.target.result).show();
        };
        
        // 파일을 Data URL(base64 인코딩된 문자열)로 읽어옴
        reader.readAsDataURL(input.files[0]);

    }
}
</script>
</head>
<body>
	<div style="margin: 50px 50px; width: 500px">
		<form action="addAction.jsp" method="post" enctype="multipart/form-data">
			<table class="table table-bordred">
				<tr>
					<th width="100" class="table-secondary">작성자</th>
					<td>
						<input type="text" name="writer" class="form-control"
						style="width:120px;" required="required" placeholder="작성자">
					</td>
				</tr>
				<tr>
					<th width="100" class="table-secondary">제목</th>
					<td>
						<input type="text" name="subject" class="form-control"
						style="width:350px;" required="required">
					</td>
				</tr>
				<tr>
					<th width="100" class="table-secondary">업로드</th>
					<td>
						<input type="file" name="photo" class="form-control"
						style="width:250px;" required="required" onchange="readURL(this)">
					</td>
				</tr>
				<tr>
					<th width="100" class="table-secondary">비밀번호</th>
					<td>
						<input type="password" name="pass" class="form-control"
						style="width:150px;" required="required">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea style="width: 480px; height: 80px;" name="content"
						class="form-control" required="required" placeholder="내용">
						</textarea>
					</td>				
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-success">저장</button>
						<button type="button" class="btn btn-info"
						onclick="location.href='boardList.jsp'">목록</button>
					</td>
				</tr>
			</table>
		</form>
		
		<!-- 미리보기 할 이미지 -->
		<img alt="" src="" id="preview">
		
		
	</div>
</body>
</html>