<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mname = (String)request.getAttribute("mname");
	String mtel = (String)request.getAttribute("mtel");
	String mmovie = (String)request.getAttribute("mmovie");
	String mdate = (String)request.getAttribute("mdate");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 예매 확인</title>
</head>
<body>
<p>영화 예매 확인</p>
고객명 : <%=mname%><br>
연락처 : <%=mtel%><br>
영화선택 : <%=mmovie%><br>
예매일자 : <%=mdate%><br>
<br>
&nbsp&nbsp&nbsp<input type="button" value="확인" onclick="confirm()" style="background-color: navy; color: white;">
</body>
<script>
function confirm(){
	location.href="./reserve_movie.html";
}
</script>
</html>