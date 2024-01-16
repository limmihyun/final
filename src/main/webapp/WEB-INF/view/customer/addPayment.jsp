<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charSet="utf-8"/>
  <title>결제 위젯</title>
  <script src="https://js.tosspayments.com/v1/payment-widget"></script>
  
</head>
<body>
  <!-- 상품 정보 영역-->
  <div class="title">상품 정보</div>
  <p>토스 티셔츠</p>
  <p>결제 금액: 15,000원</p>
  <form id="discount-coupon">
    <input type="checkbox" id="coupon"/>5,000원 할인받기 
  </form>
  <hr>	

  <!-- 결제 방법 영역-->
  <div class="title">결제 방법</div>
  <div id="payment-method"></div>
  <div id="agreement"></div> 
  <button id="payment-button">결제하기</button>
  <a href="#" onclick="testBtn()" class="btn btn-primary" style="padding: 10px 24px;">결제</a>
  <script>
    	var membershipNo = ${membershipNo};
    	var membershipPrice = ${membershipPrice};
  </script>
</body>

<script>

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