<%@page import="intro.introDto"%>
<%@page import="intro.introDao"%>
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
	function goFocus(hp) {
		if(hp.value.length==4){
			frm.hp3.focus();
		}
	}
</script>
<%
String num=request.getParameter("num");
introDao dao=new introDao();
introDto dto=dao.oneselectIntro(num);
%>
</head>
<body>
	<div style="width: 600px; margin: 50px 50px;">
		<form action="updateaction.jsp" method="post" name="frm">
		<input type="hidden" name="num" value="<%=num%>">
			<table class="table table-bordered">
				<tr>
					<th style="text-align: center" class="table-secondary">이름</th>
					<td>
						<input type="text" name="name" class="form-control"
						value="<%=dto.getName()%>">
					</td>
				</tr>
				<tr>
					<th style="text-align: center" class="table-secondary">생년월일</th>
					<td>
						<input type="date" name="birthday" class="form-control"
						value="<%=dto.getBirthday()%>">
					</td>
				</tr>
				<tr>
					<th style="text-align: center" class="table-secondary">전화번호</th>
					<td class="input-group">
						<select size="1" name="hp1" style="width: 60px">
							<option value="02">02</option>
							<option value="031">031</option>
							<option value="032">032</option>
							<option value="051">051</option>
							<option value="064">064</option>
						</select>
						&nbsp;&nbsp;<b>-</b>&nbsp;&nbsp;
						<input type="text" name="hp2" style="width:75px;" required="required"
						onkeyup="goFocus(this)">
						&nbsp;&nbsp;<b>-</b>&nbsp;&nbsp;
						<input type="text" name="hp3" style="width:75px;" required="required">
					</td>
				</tr>
				<tr>
					<th style="text-align: center" class="table-secondary">사는곳</th>
					<td>
					<%String hometown = dto.getHometown(); %>
						<label><input type="radio" name="hometown" value="성동구" <%="성동구".equals(hometown)?"checked":"" %>>&nbsp;성동구&nbsp;</label>
						<label><input type="radio" name="hometown" value="광진구" <%="광진구".equals(hometown)?"checked":"" %>>&nbsp;광진구&nbsp;</label>
						<label><input type="radio" name="hometown" value="송파구" <%="송파구".equals(hometown)?"checked":"" %>>&nbsp;송파구&nbsp;</label>
						<label><input type="radio" name="hometown" value="동대문구" <%="동대문구".equals(hometown)?"checked":"" %>>&nbsp;동대문구&nbsp;</label>
						<label><input type="radio" name="hometown" value="기타" <%="기타".equals(hometown)?"checked":"" %>>&nbsp;기타&nbsp;</label>
					</td>
				</tr>
				<tr>
					<th style="text-align: center" class="table-secondary">취미</th>
					<td>
						<label><input type="checkbox" name="hobby" value="운동">&nbsp;운동&nbsp;</label>
						<label><input type="checkbox" name="hobby" value="독서">&nbsp;독서&nbsp;</label>
						<label><input type="checkbox" name="hobby" value="영화">&nbsp;영화&nbsp;</label>
						<label><input type="checkbox" name="hobby" value="뜨개">&nbsp;뜨개&nbsp;</label>
						<label><input type="checkbox" name="hobby" value="맛집탐방">&nbsp;맛집탐방&nbsp;</label>
						<label><input type="checkbox" name="hobby" value="게임">&nbsp;게임&nbsp;</label>
					</td>
				</tr>
				<tr>
					<th style="text-align: center" class="table-secondary">MBTI</th>
					<td>
						<select name="mbti">
						<%
							String [] mstr={"ENFP","ENFJ","INFP","INFJ","ESFP","ESFJ","ISFP","ISFJ","ENTP",
									"ENTJ","INTP","INTJ","ESTP","ESTJ","ISTP","ISTJ"};
							for(int i=0;i<mstr.length;i++){
								if(dto.getMbti().equals(mstr[i])){
									%> 
									<option value="<%=mstr[i]%>" selected="selected"><%=mstr[i]%></option>
								<%}else{%>
									<option value="<%=mstr[i]%>"><%=mstr[i]%></option>									
								<%}
							}
						%>
						
						</select>
					</td>
				</tr>
				<tr>
					<th style="text-align: center" class="table-secondary">코멘트</th>
					<td>
						<textarea style="width: 500px; height:80px;"
						name="free" placeholder="자신의 성향 혹은 하고싶은 말을 자유롭게 작성해주세요."
						class="form-control">
						<%=dto.getFree() %>
						</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-warning"
						style="width: 100px">수정완료</button>
						<button type="button" class="btn btn-success"
						style="width: 100px" onclick="location.href='introlist.jsp'">목록</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>