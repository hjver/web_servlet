<%@page import="mallpage.ProductDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<ProductDto> products = (ArrayList)request.getAttribute("products");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품리스트 출력 파트</title>
<style>
s{
	color:red
}
</style>
</head>

<body>
<table>
<tbody>
<%for(int i=0; i<products.size(); i++){
%>
<tr>
<td><a href="./product_list.do?midx=<%=products.get(i).getMidx()%>"><img src=".<%=products.get(i).getPimg()%>"></a></td>
<td>상품명 : "<%=products.get(i).getPnm()%>"</td>
<td>상품금액 : <s>"<%=products.get(i).getPmoney()%>" 원</s></td>
<td>할인율 : "<%=products.get(i).getPsales()%>" %</td>
<td>할인금액 : "<%=products.get(i).getPsmoney()%>" 원</td>
</tr>
<%
}
%>
</tbody>
</table>
</body>
</html>