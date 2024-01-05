<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- request.getContextPath 간소화 -->
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="author" content="Saurav">
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/number.css" rel="stylesheet">
<title></title>
</head>
<script>
	$(document).ready(function() {
		var msg = "${msg}";
		if (msg.trim() !== "") {
			alert(msg);
		}
	});
</script>
<body class="bg-light">
	<div class="container">
		<div class="py-5 text-center">
			<br>
			<h2>회원탈퇴</h2>
		</div>
		<br>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
			<c:if test="${open eq 0}">
				<form name="form" method="post" action="${path}/customer/delete">
					<h3 style="color:red;">탈퇴한 아이디는 사용하실수 없습니다</h3>
					<br><br>
					<div class="form-group">
						<label>아이디</label>
						<div class="row">
							<div class="col">
								<input class="form-control" id="customerId" name="customerId"
									placeholder="아이디" style="position: relative;" required>
								<input type="hidden" class="form-control" id="customerIdSave">
							</div>
						</div>
						<small id="idHelp" class="form-text text-muted"></small>
					</div>

					<div class="form-group">
						<label>비밀번호</label> <input type="password" class="form-control"
							id="customerPw" name="customerPw" placeholder="비밀번호"
							required> <small id="pwHelp" class="form-text text-muted"></small>
					</div>
					<div class="form-group">
						<label>비밀번호확인</label> <input type="password" class="form-control"
							id="customerPwCk" name="customerPwCk" placeholder="비밀번호확인" required>
						<small id="pwCkHelp" class="form-text text-muted"></small>
					</div>
					<br><br>
					<hr class="mb-4">
					<button type="button" id="signUpBtn"
						class="btn btn-danger btn-lg btn-block">탈퇴하기</button>
				</form>
				<br> <br> <br>
			</c:if>
			<c:if test="${open eq 1}">
			<h2>정말 회원탈퇴합니까?</h2>
			<a href="/customer/deleteDo" class="btn btn-danger btn-lg btn-block">탈퇴하기</a>
			<a href="/customer/home" class="btn btn-success btn-lg btn-block">홈으로</a>
			</c:if>

			</div>
		</div>
		<footer class="my-5 pt-5 text-muted text-center text-small">
			<p class="mb-1">&copy; 2020-2024 GDHealth</p>
			<ul class="list-inline">
				<li class="list-inline-item"><a href="#">Privacy</a></li>
				<li class="list-inline-item"><a href="#">Terms</a></li>
				<li class="list-inline-item"><a href="#">Support</a></li>
			</ul>
		</footer>
	</div>
	<script>
		let getId= RegExp(/^[a-zA-Z0-9]{4,12}$/);
		let getPw = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{1,50}).{8,16}$/;
		let getSpace = /\s/g;
	
		$(document).ready(function() {
			
			
			$('#customerPw').blur(function() {
				if (!getPw.test($('#customerPw').val())) {
					$('#pwHelp').html("정확한 비밀번호를 입력해주세요");
					return false;
				} else {
					$('#pwHelp').html("");
				}
			});
			$('#customerPwCk').blur(function() {
				if ($('#customerPw').val() != $('#customerPwCk').val()) {
					$('#pwCkHelp').html("비밀번호가 다릅니다");
					return false;
				} else {
					$('#pwCkHelp').html("");
				}
			});

			
			$('#signUpBtn').click(function() {
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
					alert("정확한 아이디를 입혁하세요");
					$("#customerId").val("");
					$('#customerId').focus();
					return false;
	        	}
				if ($('#customerPw').val() == "") {
					alert("비밀번호를 입력하세요");
					$('#customerPw').focus();
					return false;
				}
				if (getSpace.test($('#customerPw').val())) {
					alert("공백은 입력 불가능 합니다");
					$("#customerPw").val("");
					$('#customerPw').focus();
					return false;
				}
				if (!getPw.test($('#customerPw').val())) {
					alert("비밀번호는 영문,숫자,특수문자를 각각 하나씩 포함한 8~16자리로 설정해주세요.");
					$("#customerPw").val("");
					$('#customerPw').focus();
					return false;
				}
				if ($('#customerPwCk').val() == "") {
					alert("비밀번호 확인을 입력하세요");
					$('#customerPwCk').focus();
					return false;
				}
				if (getSpace.test($('#customerPwCk').val())) {
					alert("공백은 입력 불가능 합니다");
					$("#customerPwCk").val("");
					$('#customerPwCk').focus();
					return false;
				}
				if ($('#customerPw').val() != $('#customerPwCk').val()) {
					alert('비밀번호가 맞지 않습니다 다시 입력해주세요');
					$('#customerPw').val('');
					$('#customerPwCk').val('');
					return false;
				}

				document.form.submit();
			});
		});
	</script>

</body>
</html>
