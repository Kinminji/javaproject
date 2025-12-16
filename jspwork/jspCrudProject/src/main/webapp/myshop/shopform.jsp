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
</head>
<script type="text/javascript">
$(function(){
	var selImg=$("#photo").val();
	
	$("#myphoto").attr("src","../image/food/"+selImg+".jpg");
	
	$("#photo").change(function(){
		var s="../image/food/"+$(this).val()+".jpg";
		$("#myphoto").attr("src",s);
	});
});
</script>
<body>
	<div style="margin: 50px 50px; width: 500px;">
		<form action="addproc.jsp" method="post">
			<table class="table table-bordered">
			<caption align="top"><a>상품 입고 등록</a></caption>
				<tr>
					<th width="100" class="table-secondary">상품명</th>
					<td>
						<input type="text" name="sangpum" required="required"
						class="form-control" style="width: 200px">
					</td>
				</tr>
				
				<tr>
					<th width="100" class="table-secondary">상품이미지</th>
					<td class="input-group" style="width: 400px">
						<select name="photo" class="form-control" id="photo">
							<option value="1">에그샌드위치</option>
							<option value="2">야끼토리</option>
							<option value="3">얼큰닭개장</option>
							<option value="4">양념갈비찜</option>
							<option value="5">치즈그라탕</option>
							<option value="7">토마토카레</option>
							<option value="8">닭가슴살샌드위치</option>
						</select>
						&nbsp;&nbsp;&nbsp;
						<img alt="" src="" width="40" height="40" id="myphoto" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
				</tr>
				
				<tr>
					<th width="100" class="table-secondary">가격</th>
					<td>
						<input type="number" name="price" required="required"
						class="form-control" style="width: 200px" pattern="[0-9]+">
					</td>
				</tr>
				
				<tr>
					<th width="100" class="table-secondary">입고일자</th>
					<td>
						<input type="date" name="ipgoday" class="form-control" style="width: 200px"
						value="2025-12-19">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-info">상품 저장</button>
						<button type="button" class="btn btn-success"
						onclick="location.href='shoplist.jsp'">상품 목록</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>