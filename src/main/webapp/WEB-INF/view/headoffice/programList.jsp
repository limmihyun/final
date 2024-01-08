<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>프로그램 관리</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!------------------- favicon start ------------------>
	<link type="image/png" sizes="32x32" rel="icon" href="/admin/workoutFavicon.png">
	<!------------------- favicon end -------------------->
	
    <!-- Google Fonts
		============================================ -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900" rel="stylesheet">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/bootstrap.min.css">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/font-awesome.min.css">
    <!-- owl.carousel CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/owl.carousel.css">
    <link rel="stylesheet" href="/admin/css/owl.theme.css">
    <link rel="stylesheet" href="/admin/css/owl.transitions.css">
    <!-- animate CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/animate.css">
    <!-- normalize CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/normalize.css">
    <!-- meanmenu icon CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/meanmenu.min.css">
    <!-- main CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/main.css">
    <!-- educate icon CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/educate-custon-icon.css">
    <!-- morrisjs CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/morrisjs/morris.css">
    <!-- mCustomScrollbar CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/scrollbar/jquery.mCustomScrollbar.min.css">
    <!-- metisMenu CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/metisMenu/metisMenu.min.css">
    <link rel="stylesheet" href="/admin/css/metisMenu/metisMenu-vertical.css">
    <!-- calendar CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/calendar/fullcalendar.min.css">
    <link rel="stylesheet" href="/admin/css/calendar/fullcalendar.print.min.css">
    <!-- style CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/style.css">
    <!-- responsive CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/responsive.css">
    <!-- modernizr JS
		============================================ -->
    <script src="/admin/js/vendor/modernizr-2.8.3.min.js"></script>
</head>

<body>

	<!---------------------- 사이드바 start --------------------->
	<c:import url="/WEB-INF/view/headoffice/include/sideBar.jsp"></c:import>
	<!---------------------- 사이드바 end ----------------------->
	
    <!-- Start Welcome area -->
    <div class="all-content-wrapper">
    	
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <h1 style="color:#2E64FE; margin-top:20px;">본사 페이지</h1> 
                </div>
            </div>
        </div>
        
        
    
		<div class="header-advance-area">
	        
	        <!---------------------- 상단바 start --------------------->
	        <c:import url="/WEB-INF/view/headoffice/include/topBar.jsp"></c:import>
	        <!---------------------- 상단바 end ----------------------->
	        
	        <div class="breadcome-area">
	            <div class="container-fluid">
	                <div class="row">
	                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
	                        <div class="breadcome-list">
	                            <div class="row">
	                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
	                                    <div class="breadcome-menu">
	                                    	<form id="searchForm" method="get" action="${pageContext.request.contextPath}/headoffice/emp/search">
	                                        	<table style="margin-top:8px;">
	                                        		<tr>
	                                        			<td>
	                                        				<select name="type" class="form-control" style="width:120px; margin-right:5px;" id="type">
																<option value="search">검색</option>
																<option value="title">제목</option>
																<option value="detail">설명</option>
																<option value="active">active</option>					
															</select>   															
	                                        			</td>
	                                        			<td id="plus1"></td>
	                                        			<td id="plus2"></td>
	                                        		</tr>	
	                                        	</table>	 
	                                        </form> 
	                                    </div>
	                                </div>
	                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
	                                	<!-- 
	                                	<ul class="breadcome-menu">
	                                        <li><a href="#">Home</a> <span class="bread-slash">/</span>
	                                        </li>
	                                        <li><span class="bread-blod">All Courses</span>
	                                        </li>
	                                    </ul>
	                                	 -->                                    
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	        
	    </div>
	
        
       <!--------------------- 프로그램 list start-------------------------->
	    <div class="courses-area" id="fragment">
	       
           <div class="container-fluid">
               <div class="row">
               
               	<c:forEach var="m" items="${programList}">
               	
               		<div class="col-lg-3 col-md-6 col-sm-6 col-xs-12" style="margin-bottom:15px;">
                        <div class="courses-inner res-mg-b-30">
                            <div style="text-align:center;">	           
                               	<img src="${pageContext.request.contextPath}/upload/program/${m.filename}" alt="${pageContext.request.contextPath}/noImg" style="height:270px; width:300px;">
                                
                            </div>
                          
                            <div class="course-des">
                            	<h3>${m.programName}</h3>
                                <p><span><i class="fa fa-clock"></i></span> <b>수용 인원 :</b> ${m.maxCustomer}</p>
                            </div>
                            <div class="product-buttons">
                                <button type="button" class="button-default cart-btn" onclick="location.href='${pageContext.request.contextPath}/headoffice/program/programOne/${m.programNo}'">자세히 보기</button>
                            </div>
                        </div>
                  	    </div>
               	
               	</c:forEach>
  
               </div>
           </div>
           <!--------------------- 프로그램 list end-------------------------->
	           	         
           <!--------------------- 페이징 start -----------------------------------> 
	       	<div style="text-align:center;">       	
	             <ul class="pagination">
	             	  <c:if test="${currentPage == 1}">
	           			<li class="page-item disabled">
	            	  		<a class="page-link">처음</a>  	
	            	 	</li>	
	          		  </c:if>
	          		  <c:if test="${currentPage != 1}">
	           			<li class="page-item">           	  	
	            	  		<a class="page-link pageBtn" data-page="1" href="${pageContext.request.contextPath}/headoffice/program?page=1">처음</a>
	            	 	</li>
	           		  </c:if>            	 				  
					  <c:if test="${prev}">
					  	<li class="page-item"><a class="page-link pageBtn" data-page="${startPageNum - 1}" href="${pageContext.request.contextPath}/headoffice/program?page=${startPageNum - 1}">이전</a></li>
					  </c:if>
					  <c:forEach begin="${startPageNum}" end="${endPageNum}" var="pageNum">
					  	<c:if test="${pageNum == currentPage}"> <!-- 페이징 버튼 색 변경o --> 
					  		<li class="page-item active">
						  		<a class="page-link">${pageNum}</a>
						  	</li>
					    </c:if>
					    <c:if test="${pageNum != currentPage}"> <!-- 페이징 버튼 색 변경x --> 
					  		<li class="page-item">
						  		<a class="page-link pageBtn" data-page="${pageNum}" href="${pageContext.request.contextPath}/headoffice/program?page=${pageNum}">${pageNum}</a>
						  	</li>
					  	</c:if>
					  </c:forEach>
					  <c:if test="${next}">
					  	<li class="page-item">
					  		<a class="page-link pageBtn" data-page="${endPageNum + 1}" href="${pageContext.request.contextPath}/headoffice/program?page=${endPageNum + 1}">다음</a>
					  	</li>
					  </c:if>
					  <c:if test="${currentPage == lastPage}">
					  	<li class="page-item disabled">
					  		<a class="page-link">끝</a>
					  	</li>
					  </c:if>
					  <c:if test="${currentPage != lastPage}">
					  	<li class="page-item">
					  		<a class="page-link pageBtn" data-page="${lastPage}" href="${pageContext.request.contextPath}/headoffice/program?page=${lastPage}">끝</a>
					  	</li>
					  </c:if>				  
				</ul>	  
	        </div>
	       <!----------------------- 페이징 end ---------------------------->          
	    </div> 
    </div>

    <!-- jquery
		============================================ -->
    <script src="/admin/js/vendor/jquery-1.12.4.min.js"></script>
    <!-- bootstrap JS
		============================================ -->
    <script src="/admin/js/bootstrap.min.js"></script>
    <!-- wow JS
		============================================ -->
    <script src="/admin/js/wow.min.js"></script>
    <!-- price-slider JS
		============================================ -->
    <script src="/admin/js/jquery-price-slider.js"></script>
    <!-- meanmenu JS
		============================================ -->
    <script src="/admin/js/jquery.meanmenu.js"></script>
    <!-- owl.carousel JS
		============================================ -->
    <script src="/admin/js/owl.carousel.min.js"></script>
    <!-- sticky JS
		============================================ -->
    <script src="/admin/js/jquery.sticky.js"></script>
    <!-- scrollUp JS
		============================================ -->
    <script src="/admin/js/jquery.scrollUp.min.js"></script>
    <!-- mCustomScrollbar JS
		============================================ -->
    <script src="/admin/js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="/admin/js/scrollbar/mCustomScrollbar-active.js"></script>
    <!-- metisMenu JS
		============================================ -->
    <script src="/admin/js/metisMenu/metisMenu.min.js"></script>
    <script src="/admin/js/metisMenu/metisMenu-active.js"></script>
    <!-- morrisjs JS
		============================================ -->
    <script src="/admin/js/sparkline/jquery.sparkline.min.js"></script>
    <script src="/admin/js/sparkline/jquery.charts-sparkline.js"></script>
    <script src="/admin/js/sparkline/sparkline-active.js"></script>
    <!-- calendar JS
		============================================ -->
    <script src="/admin/js/calendar/moment.min.js"></script>
    <script src="/admin/js/calendar/fullcalendar.min.js"></script>
    <script src="/admin/js/calendar/fullcalendar-active.js"></script>
    <!-- plugins JS
		============================================ -->
    <script src="/admin/js/plugins.js"></script>
    <!-- main JS
		============================================ -->
    <script src="/admin/js/main.js"></script>
 
</body>

<script>
	$('#type').change(function(){
		
		if($(this).val() == 'search') {
			$('#plus1').html('');
			$('#plus2').html('');
		}
		
		if($(this).val() == 'title' || $(this).val() == 'detail') {
			$('#plus1').html('<input type="text" name="keyword" id="keyword" placeholder="검색어 입력" class="form-control" style="width:170px;">');
			$('#plus2').html('<button style="margin-left:10px; width:50px;" type="button" class="btn" id="searchBtn">검색</button>');
		}
		
		if($(this).val() == 'active') {
			let selectHtml = `
				<select name="keyword" class="form-control" style="width:130px;" id="keyword">
					<option value="">선택</option>
					<option value="Y">활성화</option>
					<option value="N">비활성화</option>
				</select> 
			`;
			
			$('#plus1').html(selectHtml);
			$('#plus2').html('<button style="margin-left:10px; width:50px;" type="button" class="btn" id="searchBtn">검색</button>');
		}
	});
	
	// 동적으로 추가된 요소에 대해 이벤트 처리
	// 검색
	$(document).on('click', '#searchBtn', function(e){
		
		e.preventDefault();
		let type = $('#type').val();
		let keyword = $('#keyword').val();
		
		if(type == 'active') {
			
			if(keyword == '') {
				alert('active를 선택하세요.');
				$('#keyword').focus();
				return;
			}
			
		} else {
		
			if(keyword.trim() == '') {
				alert('검색할 내용을 입력하세요.');
				$('#keyword').focus();
				return;
			}
			
		}
		
		$.ajax({
			url : '${pageContext.request.contextPath}/headoffice/program/search',
			method : 'get',
			data : {
				type : type,
				keyword : keyword
			},
			success : function(result){
				console.log('검색 성공!')
				$('#fragment').html(result);
			}
		});
		
	});
	
	// 동적으로 추가된 요소에 대해 이벤트 처리
	// 페이징
	$(document).on('click', '.pageBtn', function(e){
		e.preventDefault();
		let page = $(this).data('page');
		console.log(page);
		
		$.ajax({
			url : '${pageContext.request.contextPath}/headoffice/program/paging',
			method : 'get',
			data : {
				page : page
			},
			success : function(result){
				console.log('페이징 성공!')
				$('#fragment').html(result);
			}			
		});		
	});
	
	// 동적으로 추가된 요소에 대해 이벤트 처리
	// search 후 페이징
	$(document).on('click', '.searchPageBtn', function(e){
		e.preventDefault();
		let page = $(this).data('page');
		let type = $(this).data('type');
		let keyword = $(this).data('keyword');
		
		$.ajax({
			url : '${pageContext.request.contextPath}/headoffice/program/searchPaging',
			method : 'get',
			data : {
				page : page,
				type : type,
				keyword : keyword
			},
			success : function(result){
				console.log('페이징 성공!')
				$('#fragment').html(result);
			}			
		});
		
	});
</script>

</html>