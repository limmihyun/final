<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="zxx">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>프로그램 추가</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
	<!------------------- favicon start ------------------>
	<link type="image/png" sizes="32x32" rel="icon" href="/admin/workoutFavicon.png">
	<!------------------- favicon end -------------------->
	
    <!-- Google Fonts
		============================================ -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900" rel="stylesheet">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/bootstrap.min.css">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/font-awesome.min.css">
    <!-- owl.carousel CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/owl.carousel.css">
    <link rel="stylesheet" href="/admin/css/owl.theme.css">
    <link rel="stylesheet" href="/admin/css/owl.transitions.css">
    <!-- animate CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/animate.css">
    <!-- normalize CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/normalize.css">
    <!-- meanmenu icon CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/meanmenu.min.css">
    <!-- main CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/main.css">
    <!-- educate icon CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/educate-custon-icon.css">
    <!-- morrisjs CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/morrisjs/morris.css">
    <!-- mCustomScrollbar CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/scrollbar/jquery.mCustomScrollbar.min.css">
    <!-- metisMenu CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/metisMenu/metisMenu.min.css">
    <link rel="stylesheet" href="/admin/css/metisMenu/metisMenu-vertical.css">
    <!-- calendar CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/calendar/fullcalendar.min.css">
    <link rel="stylesheet" href="/admin/css/calendar/fullcalendar.print.min.css">
    <!-- style CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/style.css">
    <!-- responsive CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/responsive.css">
    <!-- modernizr JS
		============================================ -->
    <script src="/admin/js/vendor/modernizr-2.8.3.min.js"></script>
</head>

<body>
	
	<!---------------------- 사이드바 start --------------------->
	<c:import url="/WEB-INF/view/headoffice/include/sideBar.jsp"></c:import>
	<!---------------------- 사이드바 end ----------------------->
	
    <!-- Start Welcome area -->
    <div class="all-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <h1 style="color:#2E64FE; margin-top:20px;">본사 페이지</h1> 
                </div>
            </div>
        </div>
        <div class="header-advance-area">
        	<!---------------------- 상단바 start --------------------->
	        <c:import url="/WEB-INF/view/headoffice/include/topBar.jsp"></c:import>
	        <!---------------------- 상단바 end ----------------------->    
        </div>
        
        <!-- 프로그램 추가 화면 start--> 	          
		<form id="insertForm" method="post" 
					action="${pageContext.request.contextPath}/headoffice/program/addProgram"
					enctype="multipart/form-data">
			
			<div class="row" id="font" style="padding:15px;">
			
				<div class="col-lg-3 col-md-2 col-sm-1 col-xs-12"></div>	
				<div class="col-lg-6 col-md-8 col-sm-10 col-xs-12">
					<h3 style="margin-bottom:20px;">프로그램 추가하기</h3>
					<div style="margin-bottom:10px;">
						<label for="programName" class="form-label">프로그램 제목</label>
					    <input type="text" class="form-control" id="programName" name="programName" placeholder="입력하기">
					</div>
					<div>
						<label for="programDetail" class="form-label">프로그램 내용</label>
						<textarea name="programDetail" id="programDetail" class="form-control" rows="15" maxlength="1000" style="resize:none; margin-bottom:10px;" placeholder="입력하기"></textarea>			
					</div>
		 			
		 			<div class="row" style="margin-bottom:10px;">
			 			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
							<label for="programMaxCustomer" class="form-label">수용 인원</label>
							<input type="text" class="form-control" id="programMaxCustomer" name="programMaxCustomer" placeholder="입력하기">
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
							<label for="programFile" class="form-label">프로그램 이미지</label>
							<input type="file" class="form-control" id="programFile" name="programFile">
						</div>
		 			</div>
									
					<div style="text-align:center;">
						<button type="button" class="btn btn-primary" id="insertBtn" style="margin-top:15px;">추가하기</button>
					</div>	
				</div>
				
				<div class="col-lg-3 col-md-2 col-sm-1 col-xs-12"></div>
			 </div>			
		</form>           
        <!-- 프로그램 추가 화면 end-->
        
    </div>

    <!-- jquery
		============================================ -->
    <script src="/admin/js/vendor/jquery-1.12.4.min.js"></script>
    <!-- bootstrap JS
		============================================ -->
    <script src="/admin/js/bootstrap.min.js"></script>
    <!-- wow JS
		============================================ -->
    <script src="/admin/js/wow.min.js"></script>
    <!-- price-slider JS
		============================================ -->
    <script src="/admin/js/jquery-price-slider.js"></script>
    <!-- meanmenu JS
		============================================ -->
    <script src="/admin/js/jquery.meanmenu.js"></script>
    <!-- owl.carousel JS
		============================================ -->
    <script src="/admin/js/owl.carousel.min.js"></script>
    <!-- sticky JS
		============================================ -->
    <script src="/admin/js/jquery.sticky.js"></script>
    <!-- scrollUp JS
		============================================ -->
    <script src="/admin/js/jquery.scrollUp.min.js"></script>
    <!-- mCustomScrollbar JS
		============================================ -->
    <script src="/admin/js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="/admin/js/scrollbar/mCustomScrollbar-active.js"></script>
    <!-- metisMenu JS
		============================================ -->
    <script src="/admin/js/metisMenu/metisMenu.min.js"></script>
    <script src="/admin/js/metisMenu/metisMenu-active.js"></script>
    <!-- morrisjs JS
		============================================ -->
    <script src="/admin/js/sparkline/jquery.sparkline.min.js"></script>
    <script src="/admin/js/sparkline/jquery.charts-sparkline.js"></script>
    <!-- calendar JS
		============================================ -->
    <script src="/admin/js/calendar/moment.min.js"></script>
    <script src="/admin/js/calendar/fullcalendar.min.js"></script>
    <script src="/admin/js/calendar/fullcalendar-active.js"></script>
    <!-- maskedinput JS
		============================================ -->
    <script src="/admin/js/jquery.maskedinput.min.js"></script>
    <script src="/admin/js/masking-active.js"></script>
    <!-- datepicker JS
		============================================ -->
    <script src="/admin/js/datepicker/jquery-ui.min.js"></script>
    <script src="/admin/js/datepicker/datepicker-active.js"></script>
    <!-- form validate JS
		============================================ -->
    <script src="/admin/js/form-validation/jquery.form.min.js"></script>
    <script src="/admin/js/form-validation/jquery.validate.min.js"></script>
    <script src="/admin/js/form-validation/form-active.js"></script>
    <!-- tab JS
		============================================ -->
    <script src="/admin/js/tab.js"></script>
    <!-- plugins JS
		============================================ -->
    <script src="/admin/js/plugins.js"></script>
    <!-- main JS
		============================================ -->
    <script src="/admin/js/main.js"></script>

</body>

<script>
	$('#programName').focus();
	
	$('#insertBtn').click(function(){
		
		if($('#programName').val().trim() == '') {
			alert('프로그램 제목을 입력하세요.');
			$('#programName').val('');
			$('#programName').focus();
			return;
		}
		
		if($('#programDetail').val().trim() == '') {
			alert('내용을 입력하세요.');
			$('#programDetail').val('');	
			$('#programDetail').focus();			
			return;
		}
		
		if($('#programMaxCustomer').val().trim() == '') {
			alert('수용 인원을 입력하세요.');
			$('#programMaxCustomer').val('');	
			$('#programMaxCustomer').focus();			
			return;
		}
		
		let checkNumber = $('#programMaxCustomer').val().search(/[0-9]/g);
		
		if(checkNumber < 0) { 
			alert('수용 인원은 숫자만 입력 가능합니다.')
			$('#programMaxCustomer').val('');	
			$('#programMaxCustomer').focus();			
			return;
		}	
				
		if($('#programFile').val().length == 0) {
			alert('프로그램 사진을 첨부하세요.');
			$('#programFile').focus();
			return;
		}
		
		alert('추가 완료되었습니다.');
		$('#insertForm').submit();
	});
</script>

</html>