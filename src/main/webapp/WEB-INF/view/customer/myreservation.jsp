<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="TopGym Template">
    <meta name="keywords" content="TopGym, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>GD HEALTH</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,300i,400,500,700,900" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="/css/barfiller.css" type="text/css">
    <link rel="stylesheet" href="/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="/css/style.css" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>


     <jsp:include page="/WEB-INF/header/header.jsp" />
    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-area set-bg" data-setbg="/img/elements/element-bg.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb-content">
                        <h2>프로그램 예약</h2>
                        <div class="links">
                            <a href="/customer/home">Home</a>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
	
	<section>
		<div>
			<div style="margin:2%;" id="reservationList">
					<c:forEach var="l" items="${resultList}">
						<div  class="button-elem" style="border-radius:10px; border-style:solid; border-color:black;background-color:#F6F6F6; margin:1%;">
							<div style="margin:1%;">
								<p>${l.branchName}</p>
								<p>${l.programName} · ${l.year}년 ${l.month}월 ${l.day}일 </p>
								<input type="hidden" value="${l.programReservationNo}" id="programReservationNo">
								<a href="#" onclick="deleteBtn()" class="btn btn-primary" style="padding: 10px 24px;">취소하기</a>
							</div>
						</div>
					</c:forEach>
				<a href="${pageContext.request.contextPath}/customer/programrs"> < 이전으로</a>
			</div>
		</div>
	</section>
	
     <jsp:include page="/WEB-INF/footer/footer.jsp" />


    <!-- Js Plugins -->
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/jquery.slicknav.js"></script>
    <script src="/js/owl.carousel.min.js"></script>
    <script src="/js/jquery.magnific-popup.min.js"></script>
    <script src="/js/circle-progress.min.js"></script>
    <script src="/js/jquery.barfiller.js"></script>
    <script src="/js/main.js"></script>
    
    <script>
    	function deleteBtn(){
    	
    		
            event.preventDefault();

			console.log("클릭");
			
    		$.ajax({
    			async : true,
    			url : '/customer/reservationdelete',
    			type : 'get',
    			data : {programReservationNo : $('#programReservationNo').val()},
    			success : function(jsonData){
					console.log(jsonData, " <--jsonData");
					
    				$('#reservationList').load(location.href + " #reservationList");
    			},
     		    error: function (jqXHR, textStatus, errorThrown) {
    		        if (jqXHR.status === 500) {
    		            alert("로그인을 확인해주세요.");
    		            window.location.href = "/customer/login";
    		            // 세션값이 없을때 뜨는 500 Internal Server Error를 해결하기 위해
    		            // 해당 오류가 뜨면 alert 창을 띄우고 redirect
    		        } else {
    		            alert("알 수 없는 오류가 발생했습니다.");
    		        }
    		    } 
    		});
    	};
    </script>
</body>

</html>