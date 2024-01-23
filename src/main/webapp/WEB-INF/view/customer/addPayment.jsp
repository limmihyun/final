<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charSet="utf-8"/>
  <title>결제 위젯</title>
  <script src="https://js.tosspayments.com/v1/payment-widget"></script>
  
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
                        <h2>회원권 구매</h2>
                        <div class="links">
                            <a href="/customer/home">Home</a>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
  <!-- 상품 정보 영역-->
  <div style="margin:2%;">
  <div class="title" style="font-weight: bold; font-size:20px;">상품 정보</div>
	  <p>${membershipName}회원권<p>
	  <p>결제 금액: ${membershipPrice}원</p>
  </div>
  <hr>	

  <!-- 결제 방법 영역-->
  <div id="payment-method"></div>
  <div id="agreement"></div>
  <div style="text-align:center; margin-bottom:1%;">
  	<button id="payment-button" class="btn btn-primary">결제하기</button>
  </div>
  
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
</body>

<script>
		
		var membershipNo = ${membershipNo};
		var membershipPrice = ${membershipPrice};

		const button = document.getElementById("payment-button");
		var membershipNo = ${membershipNo};
		
		console.log(membershipNo)
		
		// 클라이언트 키로 객체 초기화 
		var clientKey = "test_gck_docs_Ovk5rk1EwkEbP0W43n07xlzm"
		var customerKey = "i2EIaT_0sKkHjO71yz7Rq";
	    var paymentWidget = PaymentWidget(clientKey, customerKey)
	    
	    const paymentMethodWidget = paymentWidget.renderPaymentMethods(
	        "#payment-method",
	        { value: membershipPrice }, // 결제금액 
	        { variantKey: "DEFAULT" }
        );
	    
	    paymentWidget.renderAgreement(
	    	        "#agreement", 
	    	        { variantKey: "AGREEMENT" }
	    );

	    
	    // 결제창 시작
        button.addEventListener("click", function () {

         paymentWidget.requestPayment({ // 결제수단 파라미터 (카드, 계좌이체, 가상계좌, 휴대폰 등)
	     
	    	orderId: '1W_pCfO4rzG9szdasKe',
	    	orderName: '테스트',
	    	customerName: '김토토스',
	    	successUrl: window.location.origin + "/customer/processPayment?membershipNo=" + membershipNo,
	    	failUrl: window.location.origin + "/customer/fail",
	    	
	     });
	 });
</script>

</html>