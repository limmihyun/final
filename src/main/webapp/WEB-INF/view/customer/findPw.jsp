<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>GD HEALTH</title>
<link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css' rel='stylesheet'>
<link href='https://use.fontawesome.com/releases/v5.7.2/css/all.css' rel='stylesheet'>
<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins&display=swap');
</style>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<script type='text/javascript' src='https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js'></script>
<script type='text/javascript' src='https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js'></script>
<link rel="stylesheet" href="/css/login.css">
</head>
<script>
	$(document).ready(function() {
		var msg = "${msg}";
		if (msg.trim() !== "") {
			alert(msg);
		}
	});
</script>
<body oncontextmenu='return false' class='snippet-body'>
	<div class="container">
		<div class="row">
			<div class="offset-md-2 col-lg-5 col-md-7 offset-lg-4 offset-md-3">
				<div class="panel border bg-white">
					<div class="panel-heading">
						<h3 class="pt-3 font-weight-bold">비밀번호찾기</h3>
					</div>
					<div class="panel-body p-3">
						<form name="form" action="/customer/findPw" method="post">
							<div class="form-group py-2">
								<div class="input-field">
									<span class="fa-user p-2"></span> <input type="text"
										placeholder="Username" id="customerId" name="customerId"
										required>
								</div>
							</div>
							<div class="form-group py-1 pb-2">
								<div class="input-field">
									<span class="fa-user p-2"></span> <input type="text"
										placeholder="YYYY-MM-DD" id="customerBirth" name="customerBirth" required>
									
								</div>
							</div>
							<button type="button" id="findPwBtn" class="btn btn-primary btn-block mt-3">비밀번호찾기</button>
						</form>
					</div>
					
				</div>
			</div>
		</div>
	</div>
<script>
	let getBirth = /^(19[0-9][0-9]|20\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
	let getId= RegExp(/^[a-zA-Z0-9]{4,12}$/);
	let getSpace = /\s/g;
	$('#findPwBtn').click(function(){
		if($('#customerId').val()==""){
			alert("아이디를 입력하세요");     
			$('#customerId').focus();   
			return false;
		}
		if(getSpace.test($('#customerId').val())){
			alert("공백은 입력 불가능 합니다"); 
			$("#customerId").val("");
			$('#customerId').focus(); 
			return false;
		}
		if(!getId.test($('#customerId').val())){
			alert("아이디는 4~12자, 영문 대소문자, 숫자만 가능합니다.");
			$("#customerId").val("");
			$('#customerId').focus();
			return false;
		}
    	if($('#customerBirth').val()==""){
			alert("생년월일을 입력하세요"); 
			$('#customerBirth').focus();
			return false;
		}
		if(getSpace.test($('#customerBirth').val())){
			alert("공백은 입력 불가능 합니다");
			$('#customerBirth').val("");
			$('#customerBirth').focus(); 
			return false;
		}
		if(!getBirth.test($('#customerBirth').val())){
			alert("유효한 생년월일을 입력해 주세요");
			$('#customerBirth').val("");
			$('#customerBirth').focus(); 
			return false;
		}
		
		document.form.submit();
		
    });
</script>
</body>
</html>