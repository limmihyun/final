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
    <header class="header-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="main-menu">
                        <div class="logo">
                            <a href="./index.html">
                                <img src="/img/logo.png" alt="">
                            </a>
                        </div>
                        <nav class="mobile-menu">
                            <ul>
                                <li><a href="./index.html">Home</a></li>
                                <li><a href="./about-us.html">About us</a></li>
                                <li><a href="./classes.html">Classes</a></li>
                                <li><a href="./elements.html">Instructors</a></li>
                                <li><a href="./blog.html">News</a></li>
                                <li><a href="./contact.html">Contact</a></li>
                                <li class="search-btn search-trigger"><i class="fa fa-search"></i></li>
                            </ul>
                        </nav>
                        <div id="mobile-menu-wrap"></div>
                    </div>
                </div>
            </div>
        </div>
    </header>
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
    <!-- Search Bar End -->
    <!-- Top Social Begin -->
    <div class="top-social">
        <div class="top-social-links">
            <ul>
                <li><a href="#"><i class="fa fa-pinterest"></i></a></li>
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                <li><a href="#"><i class="fa fa-behance"></i></a></li>
            </ul>
        </div>
    </div>
    <!-- Top Social End -->
    <!-- Hero Slider Section Begin -->
    <section class="hero-slider">
        <div class="slide-items owl-carousel">
            <div class="single-slide set-bg active" data-setbg="/img/bg.jpg">
                <a href="https://www.youtube.com/watch?v=SEVuD_djKrU" class="play-btn pop-up"><i class="fa fa-play"></i></a>
                <h1>Be Fit.Top Gym</h1>
                <a href="#" class="primary-btn">Read More</a>
            </div>
            <div class="single-slide set-bg" data-setbg="/img/bg-2.jpg">
                <a href="https://www.youtube.com/watch?v=SEVuD_djKrU" class="play-btn pop-up"><i class="fa fa-play"></i></a>
                <h1>Be Fit.Top Trainer</h1>
                <a href="#" class="primary-btn">Read More</a>
            </div>
            <div class="single-slide set-bg" data-setbg="/img/bg-3.jpg">
                <a href="https://www.youtube.com/watch?v=SEVuD_djKrU" class="play-btn pop-up"><i class="fa fa-play"></i></a>
                <h1>Be Fit.Top Body</h1>
                <a href="#" class="primary-btn">Read More</a>
            </div>
        </div>
    </section>
    <!-- Hero Slider End -->
	
	<section style="position: relative; height:100%;">
 	<div style="width:70%; position: absolute;">
		<div align="center">
			<h1>${calendarMap.targetMonth + 1} 월</h1>
		</div>
		<div style="text-align: left; position: relative;">
		    <p style="margin-top:50px;">${calendarMap.targetYear} 년</p>
		    <div style="position: absolute;  bottom:10%; left: 50%; transform: translateX(-50%);" class="d-flex justify-content-center" align="center">
		        <a class="btn btn-primary" href="${pageContext.request.contextPath}/customer/programrs?targetYear=${calendarMap.targetYear}&targetMonth=${calendarMap.targetMonth - 1}">&#60;&nbsp;이전달</a>&nbsp;
		        <a class="btn btn-primary" href="${pageContext.request.contextPath}/customer/programrs?targetYear=${calendarMap.targetYear}&targetMonth=${calendarMap.targetMonth + 1}">다음달&nbsp;&#62;</a>
		    </div>
		</div>
	
		<br>
		<br>
		<table class="table table-bordered">
			<tr>
				<th style="text-align:center;">SUN</th> 
				<th style="text-align:center;">MON</th>
				<th style="text-align:center;">TUE</th>
				<th style="text-align:center;">WED</th>
				<th style="text-align:center;">THU</th>
				<th style="text-align:center;">FRI</th>
				<th style="text-align:center;">SAT</th>
			</tr>
			<tr>
				<c:forEach var="i" begin="1" end="${calendarMap.totalTd}">
					<c:set var="d" value="${i - calendarMap.beginBlank}"></c:set>
					<td style="width:129.5px; height:82.164px;">
						<c:if test="${d < 1 || d > calendarMap.lastDate}">
							&nbsp;
						</c:if>
						<c:if test="${!(d < 1 || d > calendarMap.lastDate)}">
							<c:if test="${(i%7-1)==0}">
							  <a class="text-danger">${d}</a>
							  	 <c:if test="${calendarMap.targetYear < calendarMap.thisYear}">
								 	&nbsp;
								  </c:if>
								 <c:if test="${!(calendarMap.targetYear < calendarMap.thisYear)}">
								  	<c:if test="${calendarMap.targetMonth + 1 < calendarMap.thisMonth}">
								  		&nbsp;
								  	</c:if>							  
								  	<c:if test="${!(calendarMap.targetMonth + 1 < calendarMap.thisMonth)}">	
								  		<c:if test="${d < calendarMap.thisDay}">
								  			&nbsp;
								  		</c:if>					  	
								  		<c:if test="${!(d < calendarMap.thisDay)}">
										 <c:forEach var="l" items="${resultList}">
										   <c:set var="end" value="false"></c:set>
										 	<c:if test="${d == l.day}">
									 			<c:if test="${l.cnt == l.programMaxCustomer}">
										 			<a style="color:gray">${l.programName}</a>
										 			<p style="color:gray">${l.cnt} / ${l.programMaxCustomer}</p>
										 		</c:if>
										 		<c:if test="${l.cnt != l.programMaxCustomer}">								 		
												 	<c:forEach var="my" items="${myCalendarList}">
											 			<c:if test="${d == my.day}">
										   					<c:set var="sum" value="1"></c:set>		 
											 			</c:if>
											 			<c:set var="myempty" value="true"></c:set> 								 			
											 		</c:forEach>
											 		
											 		<c:if test="${sum > 0}">
											 			<a style="color:gray">${l.programName}</a>
												 		<p style="color:gray">${l.cnt} / ${l.programMaxCustomer}</p>
											 		</c:if>
											 		
											 		<c:if test="${sum == 0}">
											 			<a href="${pageContext.request.contextPath}/customer/prorsone?year=${l.year}&month=${l.month}&day=${l.day}&programName=${l.programName}">${l.programName}</a>
											 			<p>${l.cnt} / ${l.programMaxCustomer}</p>
											 		</c:if>
												 	<c:if test="${l.cnt != l.programMaxCustomer and not myempty}">
												 		<a href="${pageContext.request.contextPath}/customer/prorsone?year=${l.year}&month=${l.month}&day=${l.day}&programName=${l.programName}">${l.programName}</a>
												 		<p>${l.cnt} / ${l.programMaxCustomer}</p>
										 			</c:if>
										 		</c:if>
										 	</c:if>
										  </c:forEach> 
										 </c:if>
									 </c:if>
								</c:if>
							</c:if>
							<c:if test="${!((i%7-1)==0)}">
								${d}
								  <c:if test="${calendarMap.targetYear < calendarMap.thisYear}">
								 		&nbsp;
								  </c:if>
								  <c:if test="${!(calendarMap.targetYear < calendarMap.thisYear)}">
								  	<c:if test="${calendarMap.targetMonth + 1 < calendarMap.thisMonth}">
								  		&nbsp;
								  	</c:if>							  
								  	<c:if test="${calendarMap.targetMonth + 1 == calendarMap.thisMonth}">	
								  		<c:if test="${d < calendarMap.thisDay}">
								  			&nbsp;
								  		</c:if>					  	
								  		<c:if test="${!(d < calendarMap.thisDay)}">
										 <c:forEach var="l" items="${resultList}">
										   <c:set var="sum" value="0"></c:set>		 
										   <c:set var="end" value="false"></c:set>
										 	<c:if test="${d == l.day}">
									 			<c:if test="${l.cnt == l.programMaxCustomer}">
										 			<a style="color:gray">${l.programName}</a>
										 			<p style="color:gray">${l.cnt} / ${l.programMaxCustomer}</p>
										 		</c:if>
										 		<c:if test="${l.cnt != l.programMaxCustomer}">								 		
												 	<c:forEach var="my" items="${myCalendarList}">
											 			<c:if test="${d == my.day}">
										   					<c:set var="sum" value="1"></c:set>		 
											 			</c:if>
											 			<c:set var="myempty" value="true"></c:set> 								 			
											 		</c:forEach>
											 		
											 		<c:if test="${sum > 0}">
											 			<a style="color:gray">${l.programName}</a>
												 		<p style="color:gray">${l.cnt} / ${l.programMaxCustomer}</p>
											 		</c:if>
											 		
											 		<c:if test="${sum == 0}">
											 			<a href="${pageContext.request.contextPath}/customer/prorsone?year=${l.year}&month=${l.month}&day=${l.day}&programName=${l.programName}">${l.programName}</a>
											 			<p>${l.cnt} / ${l.programMaxCustomer}</p>
											 		</c:if>
											 		
											 		<c:if test="${l.cnt != l.programMaxCustomer and not myempty}">
											 			<a href="${pageContext.request.contextPath}/customer/prorsone?year=${l.year}&month=${l.month}&day=${l.day}&programName=${l.programName}">${l.programName}</a>
											 			<p>${l.cnt} / ${l.programMaxCustomer}</p>
									 				</c:if>
										 	 </c:if>
										 	</c:if>
										  </c:forEach> 
										 </c:if>
									 </c:if>
									 <c:if test="${calendarMap.targetMonth + 1 > calendarMap.thisMonth}">
										 <c:forEach var="l" items="${resultList}">
											   <c:set var="end" value="false"></c:set>
											 	<c:if test="${d == l.day}">
										 			<c:if test="${l.cnt == l.programMaxCustomer}">
											 			<a style="color:gray">${l.programName}</a>
											 			<p style="color:gray">${l.cnt} / ${l.programMaxCustomer}</p>
											 		</c:if>
											 		<c:if test="${l.cnt != l.programMaxCustomer}">								 		
												 	<c:forEach var="my" items="${myCalendarList}">
											 			<c:if test="${d == my.day}">
										   					<c:set var="sum" value="1"></c:set>		 
											 			</c:if>
											 			<c:set var="myempty" value="true"></c:set> 								 			
											 		</c:forEach>
											 		
											 		<c:if test="${sum > 0}">
											 			<a style="color:gray">${l.programName}</a>
												 		<p style="color:gray">${l.cnt} / ${l.programMaxCustomer}</p>
											 		</c:if>
											 		
											 		<c:if test="${sum == 0}">
											 			<a href="${pageContext.request.contextPath}/customer/prorsone?year=${l.year}&month=${l.month}&day=${l.day}&programName=${l.programName}">${l.programName}</a>
											 			<p>${l.cnt} / ${l.programMaxCustomer}</p>
											 		</c:if>
											 		
												 	<c:if test="${l.cnt != l.programMaxCustomer and not myempty}">
												 		<a href="${pageContext.request.contextPath}/customer/prorsone?year=${l.year}&month=${l.month}&day=${l.day}&programName=${l.programName}">${l.programName}</a>
												 		<p>${l.cnt} / ${l.programMaxCustomer}</p>
										 			</c:if>
											 		</c:if>
											 	</c:if>
											  </c:forEach> 
									 </c:if>
								</c:if>
							</c:if>
						</c:if>
						
						<!-- 한행에 7열씩.. -->
						<c:if test="${i < calendarMap.totalTd && i%7 == 0}">
							</tr><tr>
						</c:if>
					</td>
		         </c:forEach>
			</tr>
		</table>
	</div>
	
 	<div style="margin-left:80%; position: absolute; margin-top:13%; text-align:center;">
		<div>
		<!-- 
			이번달 프로그램 과 2달뒤 프로그램 까지 출력 
		 -->
					<c:set var="loop_flag" value="false" />
					<c:set value="${calendarMap.targetYear}" var="listYear"></c:set>
					<c:set value="${calendarMap.targetMonth + 1}" var="listMonth"></c:set>
					<!-- 앞으로 2달을 출력하는데 12 초과시 12를 빼서 날자 맞추기 -->
					<c:if test="${listMonth > 12}">
						<c:set value="${(calendarMap.targetMonth + 1) - 12}" var="listMonth"></c:set>
						<c:set value="${calendarMap.targetYear + 1}" var="listYear"></c:set>
					</c:if>
					<h3>${listYear} 년 ${listMonth} 월 </h3>
					<!-- 
						loop_flag 변수를 false로 선언 및 초기화 
						해당 월에 값이 없다면 if문을 활용하여 문구 출력 
						해당 월에 값이 있다면 해당 프로그램을 출력뒤 loop_flag를 true로 바꿈
					 -->
					 <!-- 이번 월  --> 
				<c:forEach var="ml" items="${listMonth1}">
					<c:set var="sum" value="0"></c:set>
					<c:if test="${ml.programMaxCustomer == ml.cnt}">
						<p>${ml.month} / ${ml.day} &nbsp; ${ml.programName}</p>
						<p style="margin-bottom:30px;">(${ml.cnt} / ${ml.programMaxCustomer})</p>
					</c:if>
					<c:if test="${ml.programMaxCustomer != ml.cnt}">
						<c:forEach var="my" items="${myCalendarList}">
				   		  <c:if test="${my.day == ml.day && ml.programDateNo == my.programDateNo}">
				   		  	<c:set var="sum" value="1"></c:set>
						  </c:if>		  								
				  		</c:forEach>
				  		<c:if test="${sum == 0}">
							<a href="${pageContext.request.contextPath}/customer/prorsone?year=${ml.year}&month=${ml.month}&day=${ml.day}&programName=${ml.programName}">${ml.month} / ${ml.day} &nbsp; ${ml.programName}</a>	  		
							<p style="margin-bottom:30px;">(${ml.cnt} / ${ml.programMaxCustomer})</p>
				  		</c:if>
				  		<c:if test="${sum > 0}">
							<p>${ml.month} / ${ml.day} &nbsp; ${ml.programName}</p>
							<p style="margin-bottom:30px;">(${ml.cnt} / ${ml.programMaxCustomer})</p>
				  		</c:if>
					</c:if>
				</c:forEach>
				<c:if test="${currentPageMonth1 > 1}"><a class="btn btn-primary" href="${pageContext.request.contextPath}/customer/programrs?currentPageMonth1=${currentPageMonth1 - 1}"> < </a></c:if>
				<c:if test="${currentPageMonth1 < lastPage}"><a class="btn btn-primary" href="${pageContext.request.contextPath}/customer/programrs?currentPageMonth1=${currentPageMonth1 + 1}" > > </a></c:if> 
				    <!-- 이번 월 끝 -->     
		</div>		
	</div> 
	</section>
	<a class="btn btn-primary" href="${pageContext.request.contextPath}/customer/myreservation">내 예약 보기</a>
	
	
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
                                <li><a href="./index.html">Home</a></li>
                                <li><a href="#">About us</a></li>
                                <li><a href="#">Classes</a></li>
                                <li><a href="#">Instructors</a></li>
                                <li><a href="#">News</a></li>
                                <li><a href="#">Contact</a></li>
                            </ul>
                        </div>
                        <div class="subscribe-form">
                            <form action="#">
                                <input type="text" placeholder="your Email">
                                <button type="submit">Sign Up</button>
                            </form>
                        </div>
                        <div class="social-links">
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-dribbble"></i></a>
                            <a href="#"><i class="fa fa-behance"></i></a>
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
    
    <script>
	$('#frontList').click(function(){
		console.log("클릭");
		
		$.ajax({
			async : true,
			url : '/customer/frontList',
			type : 'get',
			data : {programReservationNo : $('#programReservationNo').val()},
			success : function(jsonData){
				console.log(jsonData, " <--jsonData");
				
				$('#reservationList').load(location.href + " #reservationList");
			}
		    }
		});
	});
    </script>
</body>
</html>