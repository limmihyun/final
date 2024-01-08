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
    <title>TopGym | Fitness HTML Template</title>
	    <script>
        $(document).ready(function() {
            var msg = "${msg}";
            if (msg.trim() !== "") {
                alert(msg);
            }
        });
    </script>
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
    <section class="search-bar-wrap">
        <span class="search-close"><i class="fa fa-close"></i></span>
        <div class="search-bar-table">
            <div class="search-bar-tablecell">
                <div class="search-bar-inner">
                    <h2>Search</h2>
                    <form action="#">
                        <input type="search" placeholder="Type Keywords">
                        <button type="submit">Search</button>
                    </form>
                </div>
            </div>
        </div>
    </section>
    
   	<jsp:include page="/WEB-INF/header/header.jsp" />
    		
    <section class="hero-slider">
        <div class="slide-items owl-carousel">
            <div class="single-slide set-bg active" data-setbg="/img/bg.jpg">
                <h1>Be Fit.Top Gym</h1>
                <a href="#" class="primary-btn">Read More</a>
            </div>
            <div class="single-slide set-bg" data-setbg="/img/bg-2.jpg">
                <h1>Be Fit.Top Trainer</h1>
                <a href="#" class="primary-btn">Read More</a>
            </div>
            <div class="single-slide set-bg" data-setbg="/img/bg-3.jpg">
                <h1>Be Fit.Top Body</h1>
                <a href="#" class="primary-btn">Read More</a>
            </div>
        </div>
    </section>
    <!-- Hero Slider End -->
    <!-- Features Section Begin -->
    <section class="features-section spad">
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="single-features">
                        <div class="features-img">
                            <img src="/img/features/feature-3.jpg" alt="">
                        </div>
                        <div class="feature-text">
                        <br>
                            <h5>Amazing Setting</h5>
                            <p>헬스장은 운동을 즐겁게 하고 건강한 라이프스타일을 추구하는 분들을 위한 공간입니다. 뛰어난 시설과 조용한 분위기는 여러분이 몸과 마음을 동시에 강화할 수 있도록 돕습니다.</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="single-features">
                        <div class="features-img">
                            <img src="/img/features/feature-2.jpg" alt="">
                        </div>
                        <div class="feature-text">
                        <br>
                            <h5>Best Trainers</h5>
                            <p>우리의 훌륭한 트레이너들은 여러분의 운동 목표를 달성하기 위해 항상 도와드립니다. 개별 맞춤 피트니스 계획과 지속적인 모니터링으로, 건강과 몸매 변화를 지속적으로 경험할 수 있습니다.</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="single-features">
                        <div class="features-img">
                            <img src="/img/features/feature-1.jpg" alt="">
                        </div>
                        <div class="feature-text">
                        <br>
                            <h5>Diet Plans</h5>
                            <p>건강한 몸을 만들기 위해 맞춤식 다이어트 계획을 제공합니다. 영양 전문가와 협력하여 여러분의 식단을 최적화하고, 균형 잡힌 영양을 통해 더 건강한 삶을 살 수 있도록 돕겠습니다.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Features Section End -->
    <!-- Services Section Begin -->
    <section class="services-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="section-title">
                        <span>Features</span>
                        <h2>Services</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-3 col-sm-6">
                    <div class="single-service">
                        <h5>Pilates</h5>
                        <p>PILATES는 몸 전체의 균형을 강화하고 근육을 강조하는 종합적인 운동 방식입니다. 우리의 PILATES 클래스는 자세한 가이드와 함께, 효과적인 코어 강화와 유연성 향상을 경험할 수 있는 기회를 제공합니다.</p>
                    </div>
                </div>
                
                <div class="col-lg-3 col-sm-6">
                    <div class="single-service c-text">
                        <h5>Free Lifting</h5>
                        <p>자유로운 움직임과 무게를 이용한 효과적인 근육 강화를 추구하는 FREE LIFTING 클래스에서는 단련된 인스트럭터의 지도 아래, 안전하게 몸을 강화하고 높은 퍼포먼스를 이끌어냅니다.</p>
                    </div>
                </div>
                
                <div class="col-lg-3 col-sm-6">
                    <div class="single-service">
                        <h5>Yoga</h5>
                        <p>YOGA는 몸과 마음을 조화롭게 유지하는데 도움을 주는 운동입니다. 저희의 YOGA 수업은 다양한 레벨과 스타일을 제공하여, 신체의 강도와 유연성을 향상시키며 동시에 내적 평화를 찾을 수 있는 기회를 제공합니다.</p>
                    </div>
                </div>
                <div class="col-lg-3 col-sm-6">
                    <div class="single-service">
                        <h5>Spinning</h5>
                        <p>SPINNING은 강도높은 유산소 운동으로, 실내에서 자전거를 이용하여 몸을 강화하고 지방을 연소하는 활력 넘치는 운동입니다. 저희의 SPINNING 클래스는 역동적인 음악과 함께 몸과 마음을 활기차게 만들어줍니다.</p>
                    </div>
                </div>
            </div>
            <div class="row p-70">
                <div class="col-lg-12 text-center">
                    <a href="#" class="service-btn primary-btn">see all the services</a>
                </div>
            </div>
        </div>
    </section>
    <!-- Services Section End -->
    <!-- Trainer Section Begin -->
   
    <!-- Traniner Section End -->
    <!-- Upcoming Event Begin -->
    <section class="upcoming-event-section spad-2">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-6">
                    <div class="upcoming-classes">
                        <div class="up-title">
                            <span>Next</span>
                            <h5>Upcomming Classes</h5>
                        </div>
                        <ul class="classes-time">
                            <li><img src="/img/stopwatch.png" alt=""> Gym Fitness <span>11:00 - 12:00</span></li>
                            <li><img src="/img/stopwatch.png" alt=""> Pilates <span>12:00 - 13:00</span></li>
                            <li><img src="/img/stopwatch.png" alt=""> Spinning <span>13:00 - 14:00</span></li>
                            <li><img src="/img/stopwatch.png" alt=""> Yoga <span>14:00 - 15:00</span></li>
                            <li><img src="/img/stopwatch.png" alt=""> Gym Fitness <span>15:00 - 16:00</span></li>
                            <li><img src="/img/stopwatch.png" alt=""> Pilates <span>16:00 - 17:00</span></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="membership-card set-bg" data-setbg="img/m-card.jpg">
                        <div class="membership-details">
                            <div class="up-title">
                                <span>Next</span>
                                <h5>Membership Cards</h5>
                            </div>
                            <div class="discount">
                                <h1>25% <span>Discount</span></h1>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-12">
                    <div class="member-sign-up set-bg" data-setbg="img/signup-bg.jpg">
                        <div class="up-title">
                            <span>New</span>
                            <h5>Personal Trainer</h5>
                        </div>
                        <p>Pellentesque dictum nisl in nibh dictum volutpat nec a quam. Vivamus suscipit nisl quis nulla
                            pretium.Pellentesque dictum nisl in nibh dictum volutpat nec a quam. Vivamus suscipit nisl
                            quis nulla pretium.</p>
                        <div class="member-signup-btn">
                            <a href="#" class="primary-btn">Sign up Now</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Upcoming Event End -->
    <!-- Footer Section Begin -->
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

</html>