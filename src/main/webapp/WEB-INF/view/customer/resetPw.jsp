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
						<h3 class="pt-3 font-weight-bold">비밀번호 재설정</h3>
					</div>
					<div class="panel-body p-3">
						<form name="form" action="/customer/resetPw" method="post">
							<div class="form-group py-1 pb-2">
								<div class="input-field">
									<span class="fas fa-lock px-2"></span> <input type="password"
										placeholder="Password" id="customerPw" name="customerPw"
										required>
									<button type="button" class="btn bg-white text-muted toggle-password1">
										<span class="far fa-eye-slash"></span>
									</button>
								</div>
							</div>
							<div class="form-group py-1 pb-2">
								<div class="input-field">
									<span class="fas fa-lock px-2"></span> <input type="password"
										placeholder="PasswordCheck" id="customerPwCk" name="customerPwCk"
										required>
									<button type="button" class="btn bg-white text-muted toggle-password2">
										<span class="far fa-eye-slash"></span>
									</button>
								</div>
								<input type="hidden" value="${customerNo}" name="customerNo">
							</div>
							<div class="form-inline">
							<button type="button" id="resetPwBtn" class="btn btn-primary btn-block mt-3">비밀번호 수정</button>
							</div>
						</form>
					</div>
					
				</div>
			</div>
		</div>
	</div>
<script>
    $(document).ready(function(){
        // 비밀번호 숨기기/보이기 토글 기능
        $(".toggle-password1").click(function() {
            var passwordField = $("#customerPw");
            var passwordFieldType = passwordField.attr('type');
            if (passwordFieldType === 'password') {
                passwordField.attr('type', 'text');
            } else {
                passwordField.attr('type', 'password');
            }
        });
        $(".toggle-password2").click(function() {
            var passwordField = $("#customerPwCk");
            var passwordFieldType = passwordField.attr('type');
            if (passwordFieldType === 'password') {
                passwordField.attr('type', 'text');
            } else {
                passwordField.attr('type', 'password');
            }
        });

    });
    
    
	let getPw = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{1,50}).{8,16}$/;
	let getSpace = /\s/g;
    $('#resetPwBtn').click(function(){
    	if (!getPw.test($('#customerPw').val())){
    		alert("비밀번호는 영문,숫자,특수문자를 각각 하나씩 포함한 8~16자리로 설정해주세요.");
    		$("#customerPw").val("");
    		$('#customerPw').focus();
    		return false;
    	}
    	if($('#customerPwCk').val()==""){
    		alert("비밀번호 확인을 입력하세요"); 
    		$('#customerPwCk').focus();
    		return false;
    	}
    	if(getSpace.test($('#customerPwCk').val())){
    		alert("공백은 입력 불가능 합니다"); 
    		$("#customerPwCk").val("");
    		$('#customerPwCk').focus(); 
    		return false;
    	}
    	if($('#customerPw').val() != $('#customerPwCk').val()){
    		alert('비밀번호가 맞지 않습니다 다시 입력해주세요');
    		$('#customerPw').val('');
    		$('#customerPwCk').val('');
    		return false;
    	}
		
		document.form.submit();
		
    });
</script>
</body>
</html>