<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

    <meta charset="UTF-8">
    <meta name="description" content="TopGym Template">
    <meta name="keywords" content="TopGym, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>GD HEALTH</title>
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
	
	<input type="hidden" id="targetYear" value="${calendarMap.targetYear}">
	<input type="hidden" id="targetMonth" value="${calendarMap.targetMonth}">
	<input type="hidden" id="targetDay" value="${calendarMap.targetDay}">
	
	
	<section style="position: relative; height:100%;">
 	<div id="calendar" style="width:70%; position: absolute;">
		<div align="center">
			<h1>${calendarMap.targetMonth + 1} 월</h1>
		</div>
		<div style="text-align: left; position: relative;">
		    <p style="margin-top:50px;">${calendarMap.targetYear} 년</p>
		    <div style="position: absolute; left: 50%; transform: translateX(-50%);" class="d-flex justify-content-center" align="center">
		    	<a class="btn btn-primary" href="#" onclick="backMonth(${calendarMap.targetYear}, ${calendarMap.targetMonth}, ${calendarMap.targetDay})">&#60;&nbsp;이전달</a>&nbsp;
		        <a class="btn btn-primary" href="#"  onclick="nextMonth(${calendarMap.targetYear}, ${calendarMap.targetMonth}, ${calendarMap.targetDay})">다음달&nbsp;&#62;</a>
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
							  <!-- 이번년도가 캘린더의 년도보다 클 경우 -->
							  	 <c:if test="${calendarMap.targetYear < calendarMap.thisYear}">
								 	&nbsp;
								  </c:if>
								  <!-- 이번년도가 캘린더의 년도보다 클 경우의 반대 경우 --> 
								 <c:if test="${!(calendarMap.targetYear < calendarMap.thisYear)}">
								 	 <!-- 이번월이 캘린더의 월보다 클 경우 -->
								  	<c:if test="${calendarMap.targetMonth + 1 < calendarMap.thisMonth}">
								  		&nbsp;
								  	</c:if>							  
								  	<!-- 이번월이 캘린더의 월보다 클 경우의 반대 -->		  								  	
								  	<c:if test="${!(calendarMap.targetMonth + 1 < calendarMap.thisMonth)}">	
								  		<!-- 일이 오늘보다 작을 경우 -->
								  		<c:if test="${d < calendarMap.thisDay}">
								  			&nbsp;
								  		</c:if>			
								  		<!-- 일이 오늘보다 작을 경우의 반대 -->	  	
								  		<c:if test="${!(d < calendarMap.thisDay)}">
										 <c:forEach var="l" items="${resultList}">
										 	<c:set var="sum" value="0"></c:set>		 
										 	<c:if test="${d == l.day}">
										 		<!-- 프로그램 최대 인원수와 예약자수가 같을 경우 -->
									 			<c:if test="${l.cnt == l.programMaxCustomer}">
										 			<a style="color:gray">${l.programName}</a>
										 			<p style="color:gray">${l.cnt} / ${l.programMaxCustomer}</p>
										 		</c:if>
										 		<c:if test="${l.cnt != l.programMaxCustomer}">								 		
												 	<c:forEach var="my" items="${myCalendarList}">
											 			<c:if test="${d == my.day }">
										   					<c:set var="sum" value="1"></c:set>		 
											 			</c:if>
											 			<c:set var="myempty" value="true"></c:set> 								 			
											 		</c:forEach>
											 		
											 		<c:if test="${sum > 0}">
											 			<a style="color:gray">${l.programName}</a>
												 		<p style="color:gray">${l.cnt} / ${l.programMaxCustomer}</p>
											 		</c:if>
											 		
											 		<c:if test="${sum == 0 and myempty}">
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
										 	<c:if test="${d == l.day}">
									 			<c:if test="${l.cnt == l.programMaxCustomer}">
										 			<a style="color:gray">${l.programName}</a>
										 			<p style="color:gray">${l.cnt} / ${l.programMaxCustomer}</p>
										 		</c:if>
										 		<c:if test="${l.cnt != l.programMaxCustomer}">								 		
												 	<c:forEach var="my" items="${myCalendarList}">
											 			<c:if test="${d == my.day && l.programDateNo == my.programDateNo}">
										   					<c:set var="sum" value="1"></c:set>		 
											 			</c:if>
											 			<c:set var="myempty" value="true"></c:set> 								 			
											 		</c:forEach>
											 		
											 		<c:if test="${sum > 0}">
											 			<a style="color:gray">${l.programName}</a>
												 		<p style="color:gray">${l.cnt} / ${l.programMaxCustomer}</p>
											 		</c:if>
											 		
											 		<c:if test="${sum == 0 and myempty}">
											 			<a href="${pageContext.request.contextPath}/customer/prorsone?year=${l.year}&month=${l.month}&day=${l.day}&programName=${l.programName}">${l.programName}</a>
											 			<p>${l.cnt} / ${l.programMaxCustomer}</p>
											 		</c:if>
											 		
											 		
											 		<!-- 그달에 예약된게 하나도 없는 경우  -->
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
										 <c:set var="sum" value="0"></c:set>		 
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
											 		
											 		<c:if test="${sum == 0 and myempty}">
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
	
 	<div style="margin-left:80%; position: absolute; margin-top:13%; text-align:center;" id="reservationList">
 	
		<input type="hidden" id="currentPageMonth1" value="${currentPageMonth1}">
		
					<c:set var="loop_flag" value="false" />
					<c:set value="${calendarMap.targetYear}" var="listYear"></c:set>
					<c:set value="${calendarMap.targetMonth + 1}" var="listMonth"></c:set>

					<h3>${listYear} 년 ${listMonth} 월 </h3>
					 <!-- 이번 월  --> 
				<c:forEach var="ml" items="${listMonth1}">
					<c:set var="sum" value="0"></c:set>
					<!-- 프로그램 인원수가 꽉차면 -->
					<c:if test="${ml.programMaxCustomer == ml.cnt}">
						<p id="test">${ml.month} / ${ml.day} &nbsp; ${ml.programName}</p>
						<p style="margin-bottom:30px;">(${ml.cnt} / ${ml.programMaxCustomer})</p>
					</c:if>
					<c:if test="${ml.programMaxCustomer != ml.cnt}">
						<!-- 내가 예약한 날짜 no와 프로그램 날짜 no가 같을 경우  -->
						<c:forEach var="my" items="${myCalendarList}">
				   		  <c:if test="${my.day == ml.day && ml.programDateNo == my.programDateNo}">
				   		  <!-- sum이 증가 -->
				   		  	<c:set var="sum" value="1"></c:set>
						  </c:if>		  				
						  <c:set var="myempty" value="true"></c:set> 								 				
				  		</c:forEach>
				  		
				  		<!-- sum이 0이랑 같고, myempty가 true인 경우 / true인 조건을 넣은 경우는 이 조건이 다음달에 예약자가 없는 경우도 나오나  -->
				  		<!-- 이 조건은 myempty가 true니 조건 추가  -->
				  		<c:if test="${sum == 0 and myempty}">
							<a href="${pageContext.request.contextPath}/customer/prorsone?year=${ml.year}&month=${ml.month}&day=${ml.day}&programName=${ml.programName}">${ml.month} / ${ml.day} &nbsp; ${ml.programName}</a>	  		
							<p style="margin-bottom:30px;">(${ml.cnt} / ${ml.programMaxCustomer})</p>
				  		</c:if>
				  		
				  		<!-- sum이 0보다 컸을 경우  -->
				  		<c:if test="${sum > 0}">
							<p>${ml.month} / ${ml.day} &nbsp; ${ml.programName}</p>
							<p style="margin-bottom:30px;">(${ml.cnt} / ${ml.programMaxCustomer})</p>
				  		</c:if>
					</c:if>
					<!-- 인원수가 다 차있지 않고, 해당월에 예약자가 한명도 없을경우  -->
					<c:if test="${ml.cnt != ml.programMaxCustomer and not myempty}">
						<a href="${pageContext.request.contextPath}/customer/prorsone?year=${ml.year}&month=${ml.month}&day=${ml.day}&programName=${ml.programName}">${ml.month} / ${ml.day} &nbsp; ${ml.programName}</a>	  		
						<p style="margin-bottom:30px;">(${ml.cnt} / ${ml.programMaxCustomer})</p>
		 			</c:if>
				</c:forEach>

				
				<c:if test="${currentPageMonth1 > 1}"><a href="#" onclick="backPage()" class="btn btn-primary"> < </a></c:if>
				<c:if test="${currentPageMonth1 < lastPage}"><a href="#" onclick="nextPage()" class="btn btn-primary"> > </a></c:if> 		
	</div> 
	</section>
	
	<a style="margin-top:5%;" class="btn btn-primary" href="${pageContext.request.contextPath}/customer/myreservation">내 예약 보기</a>
	
	
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
    
<!-- 스크립트 부분을 body 태그 끝 부분으로 이동시킵니다. -->
<script>    
       function nextPage(){
           event.preventDefault();
            var currentPage = $('#currentPageMonth1');
            var nextPage = Number(currentPage.val()) + 1;
            var formData = {
                targetYear: $('#targetYear').val(),
                targetMonth: $('#targetMonth').val(),
                currentPageMonth1: nextPage
            };
            $.ajax({
                url: '/customer/nextPage',
                type: 'get',
                data: formData,
                success: function(data){
                    var a = '';
                    var lastPage = data.lastPage;
                    var listYear = data.calendarMap.targetYear;
                    var listMonth = data.calendarMap.targetMonth + 1;
                	a += '<h3>' +listYear+ '년 '+listMonth+'월</h3>';
 					
                	
                	// 이번 월
                	for (var i = 0; i < data.listMonth1.length; i++) {
                	    var ml = data.listMonth1[i];
                	    var sum = 0;
                	    var myempty = true;
                	    var contextPath = "${pageContext.request.contextPath}";

                	    
                	    a += '<input type="hidden" id="targetYear" value="'+listYear+'">';
                	    a += '<input type="hidden" id="targetMonth" value="'+data.calendarMap.targetMonth+'">';
                	    a += '<input type="hidden" id="currentPageMonth1" value="'+data.currentPageMonth1+'">';

                	    
                	    // 프로그램 인원수가 꽉 차면
                	    if (ml.programMaxCustomer == ml.cnt) {
                	        a += '<p>' + ml.month + ' / ' + ml.day + ' &nbsp; ' + ml.programName + '</p>';
                	        a += '<p style="margin-bottom:30px;">(' + ml.cnt + ' / ' + ml.programMaxCustomer + ')</p>';
                	    }

                	    // 프로그램 인원수가 꽉 차지 않으면
                	    if (ml.programMaxCustomer != ml.cnt) {
                	        // 내가 예약한 날짜 no와 프로그램 날짜 no가 같을 경우
                	        for (var j = 0; j < data.myCalendarList.length; j++) {
                	            var my = data.myCalendarList[j];
                	            if (my.day == ml.day && ml.programDateNo == my.programDateNo) {
                	                // sum이 증가
                	                sum = 1;
                	            }
                	        }

                	        // sum이 0이랑 같고, myempty가 true인 경우
                	        if (sum == 0 && myempty) {
                	            a += '<a href="'+contextPath+'/customer/prorsone?year=' + ml.year + '&month=' + ml.month + '&day=' + ml.day + '&programName=' + ml.programName + '">' + ml.month + ' / ' + ml.day + ' &nbsp; ' + ml.programName + '</a>';
                	            a += '<p style="margin-bottom:30px;">(' + ml.cnt + ' / ' + ml.programMaxCustomer + ')</p>';
                	        }

                	        // sum이 0보다 크면
                	        if (sum > 0) {
                	            a += '<p>' + ml.month + ' / ' + ml.day + ' &nbsp; ' + ml.programName + '</p>';
                	            a += '<p style="margin-bottom:30px;">(' + ml.cnt + ' / ' + ml.programMaxCustomer + ')</p>';
                	        }
                	    }

                	    // 인원수가 다 차있지 않고, 해당월에 예약자가 한 명도 없을 경우
                	    if (ml.cnt != ml.programMaxCustomer && !myempty) {
                	        a += '<a href="'+contextPath+'/customer/prorsone?year=' + ml.year + '&month=' + ml.month + '&day=' + ml.day + '&programName=' + ml.programName + '">' + ml.month + ' / ' + ml.day + ' &nbsp; ' + ml.programName + '</a>';
                	        a += '<p style="margin-bottom:30px;">(' + ml.cnt + ' / ' + ml.programMaxCustomer + ')</p>';
                	    }
                	}
                	
                	if(data.currentPageMonth1 > 1){
                		a += '<a href="#" onclick="backPage()" class="btn btn-primary"> < </a>'
                	}
                	
                	if(data.currentPageMonth1 < data.lastPage){
                		a += '<a href="#" onclick="nextPage()" class="btn btn-primary"> > </a>'
                	}

                	// 추가로 필요한 부분을 위에 계속해서 추가하세요.

                	// 최종적으로 생성된 HTML 문자열 사용
                	document.getElementById('reservationList').innerHTML = a;


                },
                error: function(xhr, status, error){
                    console.error(error);
                }
            });
        };
        
        function backPage(){
            event.preventDefault();
            var currentPage = $('#currentPageMonth1');
            var nextPage = Number(currentPage.val()) - 1;
            var formData = {
                targetYear: $('#targetYear').val(),
                targetMonth: $('#targetMonth').val(),
                targetDay: $('#targetDay').val(),
                currentPageMonth1: nextPage
            };
            $.ajax({
                url: '/customer/nextPage',
                type: 'get',
                data: formData,
                success: function(data){
                    var a = '';
                    var lastPage = data.lastPage;
                    var listYear = data.calendarMap.targetYear;
                    var listMonth = data.calendarMap.targetMonth + 1;
                	a += '<h3>' +listYear+ '년 '+listMonth+'월</h3>';
 					
                	
                	// 이번 월
                	for (var i = 0; i < data.listMonth1.length; i++) {
                	    var ml = data.listMonth1[i];
                	    var sum = 0;
                	    var myempty = true;
                	    var contextPath = "${pageContext.request.contextPath}";

                	    
                	    a += '<input type="hidden" id="targetYear" value="'+listYear+'">';
                	    a += '<input type="hidden" id="targetMonth" value="'+data.calendarMap.targetMonth+'">';
                	    a += '<input type="hidden" id="currentPageMonth1" value="'+data.currentPageMonth1+'">';

                	    
                	    // 프로그램 인원수가 꽉 차면
                	    if (ml.programMaxCustomer == ml.cnt) {
                	        a += '<p>' + ml.month + ' / ' + ml.day + ' &nbsp; ' + ml.programName + '</p>';
                	        a += '<p style="margin-bottom:30px;">(' + ml.cnt + ' / ' + ml.programMaxCustomer + ')</p>';
                	    }

                	    // 프로그램 인원수가 꽉 차지 않으면
                	    if (ml.programMaxCustomer != ml.cnt) {
                	        // 내가 예약한 날짜 no와 프로그램 날짜 no가 같을 경우
                	        for (var j = 0; j < data.myCalendarList.length; j++) {
                	            var my = data.myCalendarList[j];
                	            if (my.day == ml.day && ml.programDateNo == my.programDateNo) {
                	                // sum이 증가
                	                sum = 1;
                	            }
                	        }

                	        // sum이 0이랑 같고, myempty가 true인 경우
                	        if (sum == 0 && myempty) {
                	            a += '<a href="'+contextPath+'/customer/prorsone?year=' + ml.year + '&month=' + ml.month + '&day=' + ml.day + '&programName=' + ml.programName + '">' + ml.month + ' / ' + ml.day + ' &nbsp; ' + ml.programName + '</a>';
                	            a += '<p style="margin-bottom:30px;">(' + ml.cnt + ' / ' + ml.programMaxCustomer + ')</p>';
                	        }

                	        // sum이 0보다 크면
                	        if (sum > 0) {
                	            a += '<p>' + ml.month + ' / ' + ml.day + ' &nbsp; ' + ml.programName + '</p>';
                	            a += '<p style="margin-bottom:30px;">(' + ml.cnt + ' / ' + ml.programMaxCustomer + ')</p>';
                	        }
                	    }

                	    // 인원수가 다 차있지 않고, 해당월에 예약자가 한 명도 없을 경우
                	    if (ml.cnt != ml.programMaxCustomer && !myempty) {
                	        a += '<a href="'+contextPath+'/customer/prorsone?year=' + ml.year + '&month=' + ml.month + '&day=' + ml.day + '&programName=' + ml.programName + '">' + ml.month + ' / ' + ml.day + ' &nbsp; ' + ml.programName + '</a>';
                	        a += '<p style="margin-bottom:30px;">(' + ml.cnt + ' / ' + ml.programMaxCustomer + ')</p>';
                	    }
                	}
                	
                	if(data.currentPageMonth1 > 1){
                		a += '<a href="#" onclick="backPage()" class="btn btn-primary"> < </a>'
                	}
                	
                	if(data.currentPageMonth1 < data.lastPage){
                		a += '<a href="#" onclick="nextPage()" class="btn btn-primary"> > </a>'
                	}

                	// 추가로 필요한 부분을 위에 계속해서 추가하세요.

                	// 최종적으로 생성된 HTML 문자열 사용
                	document.getElementById('reservationList').innerHTML = a;


                },
                error: function(xhr, status, error){
                    console.error(error);
                }
            });
        };
        
        function nextMonth(targetYear, targetMonth, targetDay){
            event.preventDefault();
        	console.log(targetYear);
        	console.log(targetMonth);
        	console.log(targetDay);

            var formData = {
                    targetYear: targetYear,
                    targetMonth: targetMonth + 1,
                    targetDay: targetDay
                };
        	$.ajax({
                url: '/customer/reservationCalendar',
                method: 'get',
                data: formData,
                success: function(data){

                	$('#calendar').html(data);	
                	
                	
                }
        	});
        };
        
        function backMonth(targetYear, targetMonth, targetDay){
            event.preventDefault();
        	console.log(targetYear);
        	console.log(targetMonth);
        	console.log(targetDay);

            var formData = {
                    targetYear: targetYear,
                    targetMonth: targetMonth - 1,
                    targetDay: targetDay
                };
        	$.ajax({
                url: '/customer/reservationCalendar',
                method: 'get',
                data: formData,
                success: function(data){

                	$('#calendar').html(data);	
                	
                	
                }
        	});
        };
</script>
</body>
</html>