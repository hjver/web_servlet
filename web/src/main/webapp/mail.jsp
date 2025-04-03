<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메일 전송 시스템</title>
<style>
.area{
width:300px;
height:300px;
resize: none;
}
</style>
<script src="./jquery/jquery.js"></script>
<script>
//. => class, # => id
$(function(){
	//$("#btn").on("click", function(){	//예전 버전
	$("#btn").click(function(){
		if($("#to_name").val()==""){
			alert("담당자 성함을 입력하세요");
		}
		else if($("#to_mail").val()==""){
			alert("회신받을 메일주소를 입력하세요");
		}
		else if($("#subject").val()==""){
			alert("제목을 입력하세요");
		}
		else if($("#context").val()==""){
			alert("제휴내용을 입력하세요");
		}
		else{
			//정규식 코드에 \ 사용하는 이유는 특정 문자를 기준입니다.
			var $reg = /^[a-z0-9]([a-z0-9-_.])+\@[a-z0-9ㄱ-힇-_]+\.[a-z0-9ㄱ-힇]{2,}/i;
			if($reg.test($("#to_mail").val())==false){
				alert("올바른 이메일 주소를 입력하세요");
				$("#to_mail").val("");  //jquery로 사용자가 입력한 값을 초기화
			}
			else{
				$("#frm").submit();
			}
			
			
			//test() : 단어를 검토하여 true 또는 false를 출력하여 정규식 코드르 확인함
			//var $word = "123a45"; 
			/*
			/[0-9]/와 /[0-9]/g는 정규식표현.test($word)에서는 차이가 없고,
			$word.match(정규식표현)에서는 아래와 같은 차이가 있음
			  /[0-9]/ => 일치하는 첫 번째 숫자만 반환
			  /[0-9]/g => 문자열 전체에서 일치하는 모든 항목을 배열로 반환
			*/
			//var $reg = /[0-9]/; //0~9 숫자가 한개라도 있으면 true
			//var $reg = /[^0-9]/;  //0~9 외 문자가 한개라도 있으면 true
			//var $reg = /^[0-9]/; //0~9로 시작하면 true
			//var $reg = /[a-zA-Z]/g;
			//var $reg = /a-z/gi; //i는 소문자,대문자 무관
			//console.log($reg.test($word));
			
		}
	});
});
</script>
</head>
<body>
<form id="frm" method="post" action="./portfolio/mailok.do">
담당자 성함 : <input type="text" id="to_name" name="to_name"><br>
회신받을 메일주소 : <input type="text" id="to_mail" name="to_mail"><br>
제목 : <input type="text" id="subject" name="subject"><br>
제휴내용 : <textarea class="area" id="context" name="context"></textarea><br>
<input type="button" id="btn" value="제휴문의">
</form>
</body>
</html>