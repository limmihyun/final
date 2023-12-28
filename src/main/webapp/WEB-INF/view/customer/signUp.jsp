<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="path" value="${pageContext.request.contextPath}" /><!-- request.getContextPath 간소화 -->
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="author" content="Saurav">
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/number.css" rel="stylesheet">
<title></title>
</head>

<body class="bg-light">
	<div class="container">
		<div class="py-5 text-center">
			<img class="d-block mx-auto mb-4" src="/logo.jpg" alt="" width="72"
				height="72">
			<h2>회원가입</h2>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<form name="form" method="post" action="${path}/customer/signup" enctype="multipart/form-data">
					<div class="form-group">
						<label>이름</label> <input type="text"
							class="form-control" id="customerName" name="customerName" placeholder="2~4자리 한글"
							required>
					</div>


					<div class="form-group">
						<label>아이디</label>
						<div class="row">
							<div class="col">
								<input class="form-control" id="customerId" name="customerId"
									placeholder="영문+숫자"
									style="position: relative;" required>
								<input type="hidden" class="form-control" id="customerIdSave">
							</div>
							<div class="col-auto">
								<button type="button" id="idCk" class="btn btn-primary">중복확인</button>
							</div>
						</div>
						<small id="idHelp" class="form-text text-muted">정보</small>
					</div>
					
					<div class="form-group">
						<label>비밀번호</label> <input type="password"
							class="form-control" id="customerPw" name="customerPw" placeholder="영문+숫자+특수문자"
							required>
						<small id="pwHelp" class="form-text text-muted">정보</small>
					</div>
					<div class="form-group">
						<label>비밀번호확인</label> <input type="password"
							class="form-control" id="customerPwCk" name="customerPwCk" placeholder=""
							required>
						<small id="pwCkHelp" class="form-text text-muted">정보</small>
					</div>
					

					<div class="form-group">
						<label for="exampleInputEmail1">이메일</label>
						<div class="row">
							<div class="col">
								<input type="email" class="form-control" id="customerEmail" name="customerEmail"
									placeholder="***@email.com" aria-describedby="emailHelp"
									style="position: relative;" required>
								<input type="hidden" class="form-control" id="customerEmailSave">
							</div>
							<div class="col-auto">
								<button type="button" id="emailCk" class="btn btn-primary">중복확인</button>
							</div>
						</div>
						<small id="emailHelp" class="form-text text-muted">정보</small>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">전화번호</label> <input type="text"
							class="form-control" id="customerPhone" name="customerPhone" placeholder="010********"
							required>
						<small id="hpHelp" class="form-text text-muted">정보</small>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">주소</label>
						<div class="row">
							<div class="col">
								<input type="text" class="form-control" id="address" name="customerAddress"
									placeholder="-" required>
							</div>
							<div class="col-auto">
								<input type="button" onclick="sample2_execDaumPostcode()"
									class="btn btn-primary" value="우편번호 찾기"><br>
							</div>
						</div>
					</div>

					<div class="form-group">
						<input type="text" class="form-control" id="addressDetail" name="customerAddressDetail"
							required> <small class="form-text text-muted">상세주소
						</small>
					</div>
					<div class="row">
						<div class="col-md-2 mb-3">
							<label for="country">성별</label> <select
								class="custom-select d-block w-50" id="gender" name="customerGender" required>
								<option>남</option>
								<option>여</option>
							</select>
						</div>
						<div class="col-md-2 mb-3">
							<label for="zip">나이</label> 
							<input type="number" min="0" max="100" class="form-control w-50" placeholder="만" id="customerAge" name="customerAge" required>
							<div class="invalid-feedback">Please provide a valid state.
							</div>
							
						</div>
						<div class="col-md-2 mb-3">
							<label for="zip">키</label> 
							<input type="number" class="form-control w-50" placeholder="cm" id="customerHeight" name="customerHeight" required>
							<div class="invalid-feedback">Please provide a valid state.
							</div>
						</div>
						
						<div class="col-md-3 mb-3">
							<label for="zip">체중</label> 
							<input type="number" class="form-control w-50" placeholder="**kg" id="customerWeight" name="customerWeight" required>
						</div>
					</div>
					<br>
					<label>사진</label>
					<br>
					<div class="custom-file">
					    <input type="file" class="custom-file-input" id="chooseFile" name="customerImg" accept="image/*" onchange="loadFile(this)" required>
					    <label class="custom-file-label" for="customFile" id="fileName">이미지 선택</label>
					</div>
					<hr class="mb-4">
					<button type="button" id="signUpBtn" class="btn btn-primary btn-lg btn-block">회원가입</button>
					</form>
					<br>
					<br>
					<br>

					
					
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
	$(document).ready(function(){
		$('#idCk').click(function(){
			if($('#customerId').val()==""){ //id값이 없을 경우
				alert("아이디를 입력하세요");         //메세지 경고창을 띄운 후
				$('#customerId').focus();     // id 텍스트박스에 커서를 위치
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
		    $.ajax({
		        async: true,
		        url: '/customer/idCk',
		        type: 'get',
		        data: {'customerId': $('#customerId').val() }, // 대분류 선택 문자열
		        success: function(jsonData){
		        	var customerNo = jsonData.customerNo;
		            if (customerNo == 0) {
		                alert('사용 가능한 ID입니다.');
		                $('#idHelp').html('중복체크완료');
		                $('#customerIdSave').val($('#customerId').val());
		            } else {
		                alert('중복된 ID입니다. 다른 ID를 사용해주세요.');
		            }
		        },
		        error: function(){
		            alert('ID 확인 중 오류가 발생했습니다. 다시 시도하십시오.');
		        }
		    });
		});
		$('#emailCk').click(function(){
			if($('#customerEmail').val()==""){
				alert("이메일을 입력하세요");
				$('#customerEmail').focus();
				return false;
			}
			if(getSpace.test($('#customerEmail').val())){
				alert("공백은 입력 불가능 합니다"); 
				$("#customerEmail").val("");
				$('#customerEmail').focus(); 
				return false;
			}
			if(!getEmail.test($('#customerEmail').val())){
				alert("이메일 형식을 맞춰주세요 ***@***.**");
				$("#customerEmail").val("");
				$('#customerEmail').focus();
				return false;
	    	}
		    $.ajax({
		        async: true,
		        url: '/customer/emailCk',
		        type: 'get',
		        data: {'customerEmail': $('#customerEmail').val() }, // 대분류 선택 문자열
		        success: function(jsonData){
		        	var customerNo = jsonData;
		            if (customerNo == 0) {
		                alert('사용 가능한 Email입니다.');
		                $('#emailHelp').html('중복체크완료');
		                $('#customerEmailSave').val($('#customerEmail').val());
		            } else {
		                alert('중복된 Email입니다. 다른 Email를 사용해주세요.');
		            }
		        },
		        error: function(){
		            alert('Email 확인 중 오류가 발생했습니다. 다시 시도하십시오.');
		        }
		    });
		});
	});
	</script>

	<script>
	let getId= RegExp(/^[a-zA-Z0-9]{4,12}$/);
	let getName= RegExp(/^[가-힣]+$/);
	let getExp =  /^(01[016789]{1})[0-9]{3,4}[0-9]{4}$/;
	let getPw = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{1,50}).{8,16}$/;
	let getSpace = /\s/g;
	let getEmail = /^[a-zA-Z0-9]+([\w\.\_\-])*([a-zA-Z0-9])+([\w\.\_\-])+@([a-zA-Z0-9]+\.)+[a-zA-Z0-9]{2,8}$/;
	let getNumber = /^[0-9]+$/;
	let fileInput = document.getElementById('chooseFile');
	
	$(document).ready(function(){
		
		
		
		
		
		
		
		
		$('#customerPw').blur(function(){
			if (!getPw.test($('#customerPw').val())){
				$('#pwHelp').html("비밀번호는 영문,숫자,특수문자를 각각 하나씩 포함한 8~16자리로 설정해주세요.");
				return false;
			}else{
				$('#pwHelp').html("");
			}
		});
		$('#customerPwCk').blur(function(){
			if($('#customerPw').val() != $('#customerPwCk').val()){
				$('#pwCkHelp').html("비밀번호가 다릅니다");
				return false;
			}else{
				$('#pwCkHelp').html("");
			}
		});
		
		$('#customerPhone').blur(function(){
			if(!getExp.test($("#customerPhone").val())){
				$('#hpHelp').html("유효한 휴대폰번호를 입력해주세요");
				return false;
			}else{
				$('#hpHelp').html("");
			}
		});
		
		
		// 회원가입 버튼 submit 전 유효성 체크
		$('#signUpBtn').click(function(){
			if($('#customerId').val()==""){ //id값이 없을 경우
				alert("아이디를 입력하세요");         //메세지 경고창을 띄운 후
				$('#customerId').focus();     // id 텍스트박스에 커서를 위치
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
			
			
			if($('#customerPw').val()==""){ 
				alert("비밀번호를 입력하세요");        
				$('#customerPw').focus();     
				return false;
			}
			if(getSpace.test($('#customerPw').val())){
				alert("공백은 입력 불가능 합니다");
				$("#customerPw").val("");
				$('#customerPw').focus();    
				return false;
			}
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
			
			
			if($('#customerName').val()==""){
				alert("이름을 입력하세요");  
				$('#customerName').focus(); 
				return false;
			}
			if(getSpace.test($('#customerName').val())){
				alert("공백은 입력 불가능 합니다"); 
				$("#customerName").val("");
				$('#customerName').focus(); 
				return false;
			}
			if(!getName.test($("#customerName").val())){
				alert("이름은 한글만 입력 가능합니다.")
				$("#customerName").val("");
				$("#customerName").focus();
				return false;
			}
			
			if($('#customerEmail').val()==""){
				alert("이메일을 입력하세요");
				$('#customerEmail').focus();
				return false;
			}
			if(getSpace.test($('#customerEmail').val())){
				alert("공백은 입력 불가능 합니다"); 
				$("#customerEmail").val("");
				$('#customerEmail').focus(); 
				return false;
			}
			if(!getEmail.test($('#customerEmail').val())){
				alert("이메일 형식을 맞춰주세요 ***@***.**");
				$("#customerEmail").val("");
				$('#customerEmail').focus();
				return false;
        	}
			
			
			if($('#customerPhone').val()==""){
				alert("전화번호를 입력하세요"); 
				$('#customerPhone').focus();
				return false;
			}
			if(getSpace.test($('#customerPhone').val())){
				alert("공백은 입력 불가능 합니다");
				$("#customerPhone").val("");
				$('#customerPhone').focus(); 
				return false;
			}
			if(!getExp.test($("#customerPhone").val())){
				alert("유효한 휴대폰번호를 입력해주세요 (010********)");
				$("#customerPhone").val("");
				$("#customerPhone").focus();
				return false;
			}
			
			
			if($('#customerAddress').val()==""){
				alert("주소를 입력하세요");  
				$('#customerAddress').focus(); 
				return false;
			}
			if(getSpace.test($('#customerAddress').val())){
				alert("공백은 입력 불가능 합니다");
				$("#customerAddress").val("");
				$('#customerAddress').focus(); 
				return false;
			}
			
			
			if($('#customerAge').val()==""){
				alert("나이를 입력하세요"); 
				$('#customerAge').focus();
				return false;
			}
			if(getSpace.test($('#customerAge').val())){
				alert("공백은 입력 불가능 합니다");
				$('#customerAge').val("");
				$('#customerAge').focus(); 
				return false;
			}
			if(!getNumber.test($('#customerAge').val())){
				alert("나이는 숫자(정수)만 입력가능합니다");
				$('#customerAge').val("");
				$('#customerAge').focus();
				return false;
        	}
			if($('#customerAge').val()<5 || $('#customerAge').val()>95){
				alert("정확한 나이를 입력해주세요");
				$('#customerAge').val("");
				$('#customerAge').focus();
				return false;
        	}
			
			if($('#customerHeight').val()==""){
				alert("키(신장)를 입력하세요"); 
				$('#customerHeight').focus();
				return false;
			}
			if(getSpace.test($('#customerHeight').val())){
				alert("공백은 입력 불가능 합니다");
				$('#customerHeight').val("");
				$('#customerHeight').focus(); 
				return false;
			}
			if($('#customerHeight').val()<50 || $('#customerHeight').val()>250){
				alert("정확한 키(신장)를 입력해주세요");
				$('#customerHeight').val("");
				$('#customerHeight').focus();
				return false;
        	}
			
			if($('#customerWeight').val()==""){
				alert("체중을 입력하세요"); 
				$('#customerWeight').focus();
				return false;
			}
			if(getSpace.test($('#customerWeight').val())){
				alert("공백은 입력 불가능 합니다");
				$('#customerWeight').val("");
				$('#customerWeight').focus(); 
				return false;
			}
			if($('#customerWeight').val()<20 || $('#customerWeight').val()>200){
				alert("정확한 체중을 입력해주세요");
				$('#customerWeight').val("");
				$('#customerWeight').focus();
				return false;
        	}
			
			if(fileInput.files.length === 0) {
			    alert("프로필 사진을 업로드해 주세요");
			    return false;
			}
			
			if ($('#customerIdSave').val().length === 0) {
			    alert("아이디 중복확인을 눌러주세요");
			    return false;
			}

			if ($('#customerEmailSave').val().length === 0) {
			    alert("이메일 중복확인을 눌러주세요");
			    return false;
			}
			
			if($('#customerId').val() !== $('#customerIdSave').val()){
				alert("아이디값이 변경되었습니다 다시 중복확인을 눌러주세요");
				return false;
			}
			if($('#customerEmail').val() !== $('#customerEmailSave').val()){
				alert("이메일값이 변경되었습니다 다시 중복확인을 눌러주세요");
				return false;
			}
			
			
			
			document.form.submit();
		});
		});
	
	
	
	
	
	
	
	
	
	
	
	</script>
	
	
	
	
	
	
	<div id="layer"
		style="display: none; position: fixed; overflow: hidden; z-index: 1; -webkit-overflow-scrolling: touch;">
		<img src="//t1.daumcdn.net/postcode/resource/images/close.png"
			id="btnCloseLayer"
			style="cursor: pointer; position: absolute; right: -3px; top: -3px; z-index: 1"
			onclick="closeDaumPostcode()" alt="닫기 버튼">
	</div>
	
	
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	
	<script>
		function loadFile(input) {
			var file = input.files[0];	//선택된 파일 가져오기
			
			//미리 만들어 놓은 div에 text(파일 이름) 추가
			var name = document.getElementById('fileName');
			name.textContent = file.name;
		};


	
		var element_layer = document.getElementById('layer');

		function closeDaumPostcode() {
			element_layer.style.display = 'none';
		}

		function sample2_execDaumPostcode() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							var addr = '';
							var extraAddr = '';
							if (data.userSelectedType === 'R') {
								addr = data.roadAddress;
							} else {
								addr = data.jibunAddress;
							}
							if (data.userSelectedType === 'R') {
								if (data.bname !== ''
										&& /[동|로|가]$/g.test(data.bname)) {
									extraAddr += data.bname;
								}
								if (data.buildingName !== ''
										&& data.apartment === 'Y') {
									extraAddr += (extraAddr !== '' ? ', '
											+ data.buildingName
											: data.buildingName);
								}
								if (extraAddr !== '') {
									extraAddr = ' (' + extraAddr + ')';
								}
								addr = addr + " " + extraAddr;

							} else {

							}

							document.getElementById("address").value = addr;
							document.getElementById("addressDetail").focus();

							element_layer.style.display = 'none';
						},
						width : '100%',
						height : '100%',
						maxSuggestItems : 5
					}).embed(element_layer);

			element_layer.style.display = 'block';

			initLayerPosition();
		}

		function initLayerPosition() {
			var width = 400;
			var height = 480;
			var borderWidth = 5;

			element_layer.style.width = width + 'px';
			element_layer.style.height = height + 'px';
			element_layer.style.border = borderWidth + 'px solid';
			element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width) / 2 - borderWidth)
					+ 'px';
			element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height) / 2 - borderWidth)
					+ 'px';
		}
	</script>
</body>
</html>
