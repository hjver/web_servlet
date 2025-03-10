<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
.n {
width:500px;
height:300px
border:1px, solid black;
overflow-y:auto;
}

</head>
<body>
제목 : <%=request.getAttribute("subject")%>
글쓴이 : <%=request.getAttribute("writer")%>
내용 : <div class="n"><%=request.getAttribute("wtext")%></div><br>

</body>
</html>