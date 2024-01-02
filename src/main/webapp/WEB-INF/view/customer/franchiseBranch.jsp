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
    <title>Elements | Template</title>

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
                            <a href="#" class="rt-breadcrumb"></a>
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
                <div class="col-lg-12">
                    <div class="button-elem">
                        <h2>Buttons</h2>
                        <a href="#" class="primary-btn">Send Message1</a>
                        <a href="#" class="primary-btn b-btn">Send Message2</a>
                        <a href="#" class="primary-btn border-btn">Send Message3</a>
                        <a href="#" class="primary-btn sky-btn">Send Message4</a>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <div class="accordin-elem">
                        <h2>Accordions & Tabs</h2>
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
                            <div class="card">
                                <div class="card-heading">
                                    <a data-toggle="collapse" data-target="#collapseTwo">
                                        경기
                                    </a>
                                </div>
                                <div id="collapseTwo" class="collapse" data-parent="#accordionExample">
                                    <div class="card-body">
                                        &nbsp;&nbsp;
                                    	<div class="btn-group">
                                        <a href="#" class="btn btn-primary">00점</a>
                                        <a href="#" class="btn btn-primary">00점</a>
                                        <a href="#" class="btn btn-primary">00점</a>
                                        <a href="#" class="btn btn-primary">00점</a>
                                        </div>
                                        <br><br>
                                    </div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-heading active">
                                    <a class="active" data-toggle="collapse"
                                        data-target="#collapseThree">
                                        전국
                                    </a>
                                </div>
                                <div id="collapseThree" class="collapse show" data-parent="#accordionExample">
                                    <div class="card-body">
                                        &nbsp;&nbsp;
                                    	<div class="btn-group">
                                        <a href="#" class="btn btn-primary">00점</a>
                                        <a href="#" class="btn btn-primary">00점</a>
                                        <a href="#" class="btn btn-primary">00점</a>
                                        <a href="#" class="btn btn-primary">00점</a>
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
                        <h2>지점현황</h2>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="milestone-counter">
                        <div class="counter-icon">
                            
                        </div>
                        <span id="memberCount" class="m-counter">561</span>
                        <p>Members</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="milestone-counter">
                        <div class="counter-icon">
                            
                        </div>
                        <span class="m-counter">12</span>
                        <p>Trainers</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="milestone-counter">
                        <div class="counter-icon">
                            
                        </div>
                        <span id="congestion">full</span>
                        <p>혼잡도 레벨</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="milestone-counter">
                        <div class="counter-icon">
                            
                        </div>
                        <span class="m-counter">56</span>
                        <strong>k</strong>
                        <p>Ig Folowers</p>
                    </div>
                </div>
            </div>
            <div class="row m-80">
                <div class="col-lg-12">
                    <div class="loaders-title">
                        <h2>그래프</h2>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="single-loader">
                        <div class="loader-circle-wrap">
                            <div class="circle-progress" data-cpid="id-1" data-cpvalue="150" data-cpcolor="#233ede"></div>
                        </div>
                        <span>Morbi auctor lacus</span>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="single-loader">
                        <div class="loader-circle-wrap">
                            <div class="circle-progress" data-cpid="id-2" data-cpvalue="25" data-cpcolor="#233ede"></div>
                        </div>
                        <span>Morbi auctor lacus</span>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="single-loader">
                        <div class="loader-circle-wrap">
                            <div class="circle-progress" data-cpid="id-3" data-cpvalue="50" data-cpcolor="#233ede"></div>
                        </div>
                        <span>Morbi auctor lacus</span>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="single-loader">
                        <div class="loader-circle-wrap">
                            <div class="circle-progress" data-cpid="id-4" data-cpvalue="75" data-cpcolor="#233ede"></div>
                        </div>
                        <span>Morbi auctor lacus</span>
                    </div>
                    
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="icon-box-title">
                        <h2>Icon Boxes</h2>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="single-icon-box">
                        <div class="single-icon-box-img">
                            
                        </div>
                        <h5>Amazing Setting</h5>
                        <p>Pellentesque dictum nisl in nibh dictum volutpat nec a quam. Vivamus suscipit nisl quis nulla
                            pretium, vitae ornare leo.</p>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="single-icon-box">
                        <div class="single-icon-box-img">
                        
                        </div>
                        <h5>Best Trainers</h5>
                        <p>Pellentesque dictum nisl in nibh dictum volutpat nec a quam. Vivamus suscipit nisl quis nulla
                            pretium, vitae ornare leo.</p>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="single-icon-box">
                        <div class="single-icon-box-img">
                        
                        </div>
                        <h5>Diet Plans</h5>
                        <p>Pellentesque dictum nisl in nibh dictum volutpat nec a quam. Vivamus suscipit nisl quis nulla
                            pretium, vitae ornare leo.</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Elements Section End -->
    <!-- Footer Section Begin -->
    <footer class="footer-section set-bg" data-setbg="/img/footer-bg.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="footer-content">
                        <div class="footer-logo">
                            <a href="#"><img src="/img/logo.png" alt=""></a>
                        </div>
                        <div class="footer-menu">
                            <ul>
                                <li><a href="./home.html">Home</a></li>
                                <li><a href="#">About us</a></li>
                                <li><a href="#">Classes</a></li>
                                <li><a href="#">Instructors</a></li>
                                <li><a href="#">News</a></li>
                                <li><a href="#">Contact</a></li>
                            </ul>
                        </div>
                        <div class="footer-icon-img">
                            <img src="/img/footer-icon.png" alt="">
                        </div>
                        <div class="copyright">
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
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
	 function loadBranchDetails(branchNo) {
	        // Ajax 호출
	        $.ajax({
	            type: 'post',
	            url: '/customer/branchCk', 
	            data: { branchNo: branchNo },
	            success: function(response) {
	            	$('#memberCount').html(response.count)
	            	
	            	if(response.count < 15){
	            		$('#congestion').html(1)
	            	}else if(response.count < 30){
	            		$('#congestion').html(2)
	            	}else if(response.count < 50){
	            		$('#congestion').html(3)
	            	}else if(response.count < 70){
	            		$('#congestion').html(4)
	            	}else if(response.count > 100 && response.count < 150){
	            		$('#congestion').html(5)
	            	}else{
	            		$('#congestion').html(full)
	            	}
	                console.log(response);
	            },
	            error: function(xhr, status, error) {
	                // Ajax 통신이 실패하면 이 부분에서 에러 처리를 수행합니다.
	                console.error(xhr.responseText);
	            }
	        });
	  }

</script>

</html>