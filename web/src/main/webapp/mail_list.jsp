<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<ArrayList<String>> alldata = (ArrayList)request.getAttribute("alldata");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>[총 제휴의뢰 건수] : <%=alldata.get(0).get(5)%></p>
<table border="1" cellpadding="0" cellspacing="0">
<thead>
	<tr height="30" align="center">
		<td width="100">번호</td>
		<td width="450">제목</td>
		<td width="200">의뢰인 메일주소</td>
		<td width="150">의뢰일자</td>
	</tr>
</thead>
<tbody>
<%
int w = 0;
int no = Integer.parseInt(alldata.get(0).get(5));
while(w < alldata.size()){
	String sj = "";
	//제목길이 제한 15자 이상 되었을 경우 말줄임표를 사용함
	if(alldata.get(w).get(3).length() > 15){
		sj = alldata.get(w).get(3).substring(0,15) + "...";
	}
	else{
		sj = alldata.get(w).get(3);
	}
%>
	<tr height="30" align="center">
		<td><%=no%></td>
		<td align="left" title="<%=alldata.get(w).get(3)%>"><%=sj%>
		<input type="button" value="삭제" onclick="mail_delete('<%=alldata.get(w).get(0)%>')"></td>
		<td><%=alldata.get(w).get(1)%>(<%=alldata.get(w).get(2)%>)</td>
		<td><%=alldata.get(w).get(4).substring(0,10)%></td>	
	</tr>
<%
no--;
w++;
}
%>
</tbody>
</table>
</body>
<script>
function mail_delete(n){
	if(confirm("해당 게시물을 삭제시 데이터는 복구되지 않습니다.")){
		location.href='./mail_del.do?midx='+n;
	}
}
</script>
</html>