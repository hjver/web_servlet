function ajaxs(){  //
	var mid = document.getElementById("mid");
	var memail = document.getElementById("memail");
	if(mid.value==""){
		alert("아이디를 입력하세요!");
	}
	else if(memail.value==""){
		alert("이메일을 입력하세요!");
	}
	else{
		//ajax post통신을 위한 함수 호출
		this.ajax_post(mid.value, memail.value);
	}
}

//Ajax POST 전송하는 함수
function ajax_post(mid, memail){
	var http, result;  //http : 백앤드 통신, result : 백앤드에서 제공한 데이타
	http = new XMLHttpRequest();
	http.onreadystatechange = function(){
		if(http.readyState==4 && http.status==200){
			console.log(this.response)
		}
		else if(http.status==404){
			console.log("경로 오류 발생!!")
		}
		else if(http.status==405){
			console.log("통신규격 오류 발생!!")
		}
	}
	/* //get 통신
	http.open("post", "./ajax_postok.do?userid="+mid,true);
	http.send();
	*/
	//post 통신
	http.open("post", "./ajax_postok.do",true);
	/*
	ajax post 전송시 content-type 적용하여
	urlencoded 적용해야만 정상적으로 백앤드에게 값을 전송함
	*/
	http.setRequestHeader("content-type","application/x-www-form-urlencoded");
	//http.send("userid="+mid); //데이터 값을 한개 전송
	http.send("userid="+mid+"&usermail="+memail);
}