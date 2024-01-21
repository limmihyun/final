<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
	<title>Chating</title>
	<style>
		*{
			margin:0;
			padding:0;
		}
		.container{
			width: 500px;
			margin: 0 auto;
			padding: 25px
		}
		.container h1{
			text-align: left;
			padding: 5px 5px 5px 15px;
			color: #FFBB00;
			border-left: 3px solid #FFBB00;
			margin-bottom: 20px;
		}
		.chating{
			background-color: #000;
			width: 500px;
			height: 500px;
			overflow: auto;
		}
		.chating .me{
			color: #F6F6F6;
			text-align: right;
		}
		.chating .others{
			color: #FFE400;
			text-align: left;
		}
		input{
			width: 330px;
			height: 25px;
		}		
	</style>
</head>
<body>
	<div id="container" class="container">
		<h1>${customerId}의 채팅방</h1>
		<input type="hidden" id="customerId" value="${customerId}">
		<input type="hidden" id="employeeId" value="${sessionScope.loginEmployee.employeeId}">
		<div id="chating" class="chating"></div>
				
		<div id="yourMsg">
			<table class="inputTable">
				<tr>
					<th>메시지</th>
					<th><input id="chatting" placeholder="보내실 메시지를 입력하세요."></th>
					<th><button onclick="send()" id="sendBtn">보내기</button></th>
				</tr>
			</table>
		</div>
	</div>
</body>

<script type="text/javascript">
	
	wsOpen();
	
	var ws;

	function wsOpen(){
		//웹소켓 전송시 현재 방의 번호를 넘겨서 보낸다.
		ws = new WebSocket("ws://" + location.host + "/chating/"+$("#customerId").val());
		wsEvt();
	}
		
	function wsEvt() {
		ws.onopen = function(data){
			//소켓이 열리면 동작
		}
		
		ws.onmessage = function(data) {
			
			//메시지를 받으면 동작
			var msg = data.data;
			console.log('message : ' + msg);
			
			if(msg != null && msg.trim() != ''){
				var d = JSON.parse(msg);
				if(d.type == "message"){
					if(d.id == $("#customerId").val()){
						$("#chating").append("<p class='me'>나 : " + d.msg + "</p>");	
					} else{
						$("#chating").append("<p class='others'>" + d.id + " : " + d.msg + "</p>");
					}
						
				} 
			}
			
		}

		document.addEventListener("keypress", function(e){
			if(e.keyCode == 13){ // 엔터 키를 눌렀을 때
				send();
			}
		});
	}
	
	function send() {
		
		let id = $('#employeeId').val();
		if(id == '') {
			id = $("#customerId").val();
		}
		console.log('send id : ' + id);
		
		var option ={
			type: "message",
			id : id,
			msg : $("#chatting").val()
		}
		ws.send(JSON.stringify(option));
		$('#chatting').val("");
	}
</script>
</html>