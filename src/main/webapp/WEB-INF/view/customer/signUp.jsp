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
							</div>
							<div class="col-auto">
								<button id="idCk" class="btn btn-primary">중복확인</button>
							</div>
						</div>
						<small id="idHelp" class="form-text text-muted">정보</small>
					</div>
					
					<div class="form-group">
						<label>비밀번호</label> <input
							class="form-control" id="customerPw" name="customerPw" placeholder="영문+숫자+특수문자"
							required>
						<small id="pwHelp" class="form-text text-muted">정보</small>
					</div>
					<div class="form-group">
						<label>비밀번호확인</label> <input type="text"
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
							</div>
							<div class="col-auto">
								<button id="emailCk" class="btn btn-primary">중복확인</button>
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
							<input type="text" class="form-control w-50" placeholder="만" id="age" name="customerAge" required>
							<div class="invalid-feedback">Please provide a valid state.
							</div>
							
						</div>
						<div class="col-md-2 mb-3">
							<label for="zip">키</label> 
							<input type="text" class="form-control w-50" placeholder="cm" id="height" name="customerHeight" required>
							<div class="invalid-feedback">Please provide a valid state.
							</div>
						</div>
						
						<div class="col-md-3 mb-3">
							<label for="zip">체중</label> 
							<input type="text" class="form-control w-50" placeholder="**kg" id="weight" name="customerWeight" required>
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
					<button type="submit" class="btn btn-primary btn-lg btn-block">회원가입</button>
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
	
	$('#idCk').click(function(){
	    $.ajax({
	        async: true,
	        url: '/customer/idCk',
	        type: 'get',
	        data: {'customerId': $('#customerId').val() }, // 대분류 선택 문자열
	        success: function(jsonData){
	        	var customerNo = jsonData.customerNo;
	            if (customerNo == 0) {
	                alert('사용 가능한 ID입니다.');
	            } else {
	                alert('중복된 ID입니다. 다른 ID를 선택하십시오.');
	            }
	        },
	        error: function(){
	            alert('ID 확인 중 오류가 발생했습니다. 다시 시도하십시오.');
	        }
	    });
	});
	
	$('#emailCk').click(function(){
	    $.ajax({
	        async: true,
	        url: '/customer/emailCk',
	        type: 'get',
	        data: {'customerEmail': $('#customerEmail').val() }, // 대분류 선택 문자열
	        success: function(jsonData){
	        	var customerNo = jsonData.customerNo;
	            if (customerNo == 0) {
	                alert('사용 가능한 ID입니다.');
	            } else {
	                alert('중복된 ID입니다. 다른 ID를 선택하십시오.');
	            }
	        },
	        error: function(){
	            alert('ID 확인 중 오류가 발생했습니다. 다시 시도하십시오.');
	        }
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
