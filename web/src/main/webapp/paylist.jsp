<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] ck = (String[])request.getAttribute("ck");
	//String[] ck = {"프리즘코리아,399000", "이스트라,359000"};
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매확정 물품</title>
</head>
<body>
<p>구매확정 물품</p>
<%


	String[] product = null;
	int sum=0;
	for(int i=0; i<ck.length; i++){
		product = ck[i].split(",");
		sum += Integer.valueOf(product[1]);
%>
	<%=product[0]%> : <%=product[1]%><br>
<%
	}
%>
<br>
<form id="frm" method="post" action="http://172.30.1.5:8080/web/shoppingcart.do">
최종 결제 금액 : <input type="text" name="mtotal" value="<%=sum%>" readonly>
<br>
<input type="radio" name="mpay" value="신용카드">신용카드<br>
<input type="radio" name="mpay" value="가상계좌">가상계좌<br>
<input type="radio" name="mpay" value="휴대폰 결제">휴대폰 결제<br>
<input type="radio" name="mpay" value="무통장 입금">무통장 입금<br>
<input type="button" value="결제진행" onclick="pay()">
</form>
</body>
<script>
function pay(){
	var count = 0;
	for(var i=0; i<frm.mpay.length; i++){
		if(frm.mpay[i].checked == true){
			count++;
		}
	}
	
	if(count > 0){
		frm.submit();
	}else{
		alert("결제방식을 선택해 주세요!!");
	}
}
</script>
</html>