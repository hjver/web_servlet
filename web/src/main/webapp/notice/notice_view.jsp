<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Controller에서 1차 클래스 배열값을 JSP에서 받아서 출력하는 방식
	ArrayList<String> view = (ArrayList)request.getAttribute("notice_v");
	if(view == null){ 
		out.print("<script> alert('올바른 접근이 아닙니다.'); location.href='./notice_list.do' </script>");
	}
	else { //null이 아닐 경우 HTML을 활성화
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 내용확인</title>
<style>
.data1{
	width:400px;
	height:30px;
	line-height: 30px;
	border-bottom: 1px solid gray;
}
.n{
	display: flex;
	flex-direction: row;
	justify-content: flex-start;
	align-content: center;
}
.data2{
	border: 1px solid gray;
	width: 800px;
	height: 400px;
	overflow-y: auto; 
}
</style>
</head>
<body>
<span class="n">등록일 : <div class="data1"><%=view.get(8)%></div></span><br>
<span class="n">제목 : <div class="data1"><%=view.get(1)%></div></span><br>
<span class="n">글쓴이 : <div class="data1"><%=view.get(2)%></div></span><br>
<span class="n">조회수 : <div class="data1"><%=view.get(7)%></div></span><br>
<span class="n">내용 : <div class="data2"><%=view.get(4)%></div></span><br>
<%
if(view.get(5) != null) {  //첨부파일이 있을 경우만 해당 태그가 작동되도록 설정함
%>
<span class="n">첨부파일 : <div class="data1">
<a href="../notice_file/<%=view.get(5)%>" target="_blank"><%=view.get(5)%></div></span><br>
<%
}
%>
<br><br>
<!-- 패스워드 확인 후 데이터 삭제 -->
<form id="frm" method="post" action="./notice_delete.do">
<!-- 자동증가값을 hidden 적용하여 form 전송 -->
<input type="hidden" name="nidx" value="<%=view.get(0)%>">
<!-- DB에 저장된 md5 암호화 패스워드 -->
<input type="hidden" name="ori_pw" value="<%=view.get(3)%>">
<!--  -->
패스워드 : <input type="password" name="npw">
</form>
<input type="button" value="글목록" onclick="notice_info(1)">
<input type="button" value="글수정" onclick="notice_info(2)">
<input type="button" value="글삭제" onclick="notice_info(3)">
</body>
<%
	}
%>
<script>
function notice_info(p){
	switch(p){
	case 1:
		location.href='./notice_list.do';
	break;
	case 2:
		location.href='./notice_modify.do';
	break;
	case 3:
		if(confirm("해당 게시물을 삭제시 복구 되지 않습니다.")){
			if(frm.npw.value==""){
				alert("게시물 삭제시 패스워드를 입력하셔야 합니다.");
			}
			else{
				frm.submit();
			}
		}
	break;
	}
}

</script>
</html>