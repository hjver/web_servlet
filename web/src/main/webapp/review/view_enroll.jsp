<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mid = (String)request.getAttribute("mid");
	String mcouponno = (String)request.getAttribute("mcouponno");
	String magree = (String)request.getAttribute("magree");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰 등록 완료 페이지</title>
</head>
<body>
<p>쿠폰 등록 완료 페이지</p>
아이디 : <%=mid%><br>
쿠폰번호 : <%=mcouponno%><br>
<%=magree%><br>
</body>
</html>