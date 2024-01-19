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
    <!-- Header Section Begin -->
    <!-- Header End -->
    <!-- Search Bar Begin -->
    <!-- Search Bar End -->
    <!-- Top Social Begin -->
    <!-- Top Social End -->
    <jsp:include page="/WEB-INF/header/header.jsp" />
    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-area set-bg" data-setbg="/img/elements/element-bg.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb-content">
                        <h2>지점</h2>
                        <div class="links">
                            <a href="/customer/home">Home</a>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->
    <!-- Elements Section Begin -->
    <section class="element-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="accordin-elem">
                        <h2>franchise branch</h2>
                        <div class="accordion" id="accordionExample">
                            <div class="card">
                                <div class="card-heading">
                                    <a data-toggle="collapse" data-target="#collapseOne">
                                        서울
                                    </a>
                                </div>
                                <div id="collapseOne" class="collapse"
                                    data-parent="#accordionExample">
                                    <div class="card-body">
                                    	&nbsp;&nbsp;
                                    	<div class="btn-group">
                                    	
                                    	<!-- 지점 리스트  -->
                                    	<c:forEach items="${branch}" var="b">
                                    		<a id="${b.branchNo}" href="#" class="btn btn-primary" onclick="loadBranchDetails(${b.branchNo})">${b.branchName}</a>
                                    	</c:forEach>
                                    	
                                        </div>
                                        <br><br>
                                    </div>
                                </div>
                            </div>
                            
                        </div>
                    </div>
                </div>
                
            </div>
            <div class="row m-80">
                <div class="col-lg-12">
                    <div class="milestone-title">
                        <h2 id="branchName">전국현황</h2>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="milestone-counter">
                        <div class="counter-icon">
                            
                        </div>
                        <span id="memberCount" class="m-counter">${cnt.count}</span>
                        <p>Members</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="milestone-counter">
                        <div class="counter-icon">
                            
                        </div>
                        <span id="trainerCount" class="m-counter">${cnt.trainerCount}</span>
                        <p>Trainers</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="milestone-counter">
                        <div class="counter-icon">
                        </div>
                        <span id="congestion">5</span>
                        <p>혼잡도 레벨</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="milestone-counter">
                        <div class="counter-icon">
                            
                        </div>
                        <span id="reviews" class="m-counter">56</span>
                        <strong></strong>
                        <p id="reviewsName">followers</p>
                    </div>
                </div>
            </div>
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="icon-box-title">
                        <h2>INFOMATION</h2>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="single-icon-box">
                        <div class="single-icon-box-img">
                            
                        </div>
                        <h5>TEL</h5>
                        <p id="branchTel"></p>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="single-icon-box">
                        <div class="single-icon-box-img">
                        
                        </div>
                        <h5>ADDRESS</h5>
                        <p id="branchAddress"></p>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="single-icon-box">
                        <div class="single-icon-box-img">
                        
                        </div>
                        <h5>Diet Plans</h5>
                        <p></p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Elements Section End -->
    <!-- Footer Section Begin -->
    <jsp:include page="/WEB-INF/footer/footer.jsp" />
    <!-- Footer Section End -->

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
    // 페이지 로드 후 실행되는 JavaScript 코드
    document.addEventListener('DOMContentLoaded', function() {
        // cnt.count의 값을 가져와서 숫자에 따라 span 내용을 변경
        var cntCount = ${cnt.count};

        // 변경된 숫자를 설정할 요소
        var congestionSpan = document.getElementById('congestion');


   		// cnt.count 값에 따라 내용 변경
        if (cntCount < 200) {
            congestionSpan.textContent = '1';
        } else if (cntCount < 400) {
            congestionSpan.textContent = '2';
        } else if (cntCount < 700) {
            congestionSpan.textContent = '3';
        } else if (cntCount < 1000) {
            congestionSpan.textContent = '4';
        } else if (cntCount < 1300) {
            congestionSpan.textContent = '5';
        } else {
            congestionSpan.textContent = 'full';
        } 

    });
</script>
<script>
function loadBranchDetails(branchNo) {
	console.log(branchNo)
    // Ajax 호출
    $.ajax({
        type: 'post',
        url: '/customer/branchCk',
        data: { branchNo: branchNo },
        success: function(response) {
            // 받아온 값으로 memberCount 업데이트
            $('#memberCount').html(response.count);
            $('#branchTel').html(response.branchName +"  :  "+ response.branchTel);
            $('#branchAddress').html(response.branchAddress);
            $('#trainerCount').html(response.trainerCount);
            $('#branchName').html(response.branchName +" 현황");
            $('#reviewsName').html("reviews");
            $('#reviews').html(response.reviewCount);
            // Congestion 업데이트
            updateCongestion(response.count);

        },
        error: function(xhr, status, error) {
            console.error(xhr.responseText);
        }
    });
}

// Congestion 업데이트 함수
function updateCongestion(count) {
    var congestionLevel;

    if (count < 15) {
        congestionLevel = 1;
    } else if (count < 30) {
        congestionLevel = 2;
    } else if (count < 50) {
        congestionLevel = 3;
    } else if (count < 70) {
        congestionLevel = 4;
    } else if (count < 150) {
        congestionLevel = 5;
    } else {
        congestionLevel = 'full';
    }

    // Congestion 업데이트
    $('#congestion').html(congestionLevel);
}


</script>

</html>