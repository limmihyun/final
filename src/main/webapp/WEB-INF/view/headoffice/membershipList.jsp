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
	    
	    <!-- Latest compiled and minified CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Latest compiled JavaScript -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
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
                        <h2>회원권</h2>
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
			<c:forEach var="m" items="${membershipList}">
				<div style="border-radius:10px; border-style:solid; border-color:black;background-color:#F6F6F6; margin:1%;">
					<div style="margin:1%;">
						<p>${m.membershipName}</p>
						<p>${m.membershipMonth}개월</p>
						<p>${m.membershipPrice}원</p>
						<a href="#" class="btn btn-primary" style="padding: 10px 24px;">결제하기</a>		
					</div>
				</div>
			</c:forEach>
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
</body>

</html>