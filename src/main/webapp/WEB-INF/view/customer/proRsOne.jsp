<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
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
			<div class="container" style="margin-top:2%; margin-bottom:2%;">
				<form method="POST" action="${pageContext.request.contextPath}/customer/prorsone">
					<input type="hidden" value="${resultList.programDateNo}" name="programDateNo">
					<table class="table" style="font-size:13px;">
						<tr>
							<th>프로그램 이름</th>
							<th>선택 날짜</th>
							<th>고객 ID</th>
							<th>지점명</th>
						</tr>
						<tr>
							<td>${resultList.programName}</td>
							<td>${resultList.programDate}</td>
							<td>${customerId}</td>
							<td><select name="branchNo">
								<c:forEach var="b" items="${branchList}">
									<option value="${b.branchNo}">${b.branchName}</option>
								</c:forEach>
							</select></td>
						</tr>
					</table>
					<button class="btn btn-dark btn-lg">예약하기</button>
				</form>
				<br>
				<a href="${pageContext.request.contextPath}/customer/programrs" style="font-size:12px;"> < 이전으로</a>
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
</body>

</html>