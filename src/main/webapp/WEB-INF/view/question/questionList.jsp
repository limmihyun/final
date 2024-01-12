<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">
<head>
   <meta charset="UTF-8">
    <meta name="description" content="TopGym Template">
    <meta name="keywords" content="TopGym, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>TopGym | Fitness HTML Template</title>

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
    <jsp:include page="/WEB-INF/header/header.jsp"/>
  
  <div class="untree_co-section" style="padding-top: 80px;">
          <div class="container" style="margin-top: 100px;">
   
                    <h2 class="h3 mb-3 text-black">Q&A</h2>
                    <p class="mb-4">문의사항은 이곳을 통해 문의해 주세요.</p>
                    <p class="mb-4">Q&A 게시판은 로그인 후 이용이 가능합니다.</p>
                    
                    <div class="p-3 p-lg-5 border bg-white">
                      <table class="table site-block-order-table mb-5">
      
   <thead>
       <th>질문번호</th>
       <th>지점명</th>
       <th>제목</th>
       <th>작성자</th>
       <th>작성날짜</th>
       <th>수정날짜</th>
   </thead>
   <tbody>
   
	<c:forEach var="n" items="${list}">
	   <tr>
	     <td style="align-text:center;">${n.questionNo}</td>
	     <td>${n.branchName}</td>
	     <c:choose>
	     	<c:when test="${n.isSecret == 'TRUE'}">
	     		<c:choose>
	     			
	 				<c:when test="${n.branchNo == branchNo}">
	 				
	     				<td><a href="${pageContext.request.contextPath}/question/questionOne?questionNo=${n.questionNo}">${n.questionTitle}</a></td>
	     			</c:when>
	     			
	     			
	     			<c:when test="${branchLevel == 1}">
	     			
	     				<td><a href="${pageContext.request.contextPath}/question/questionOne?questionNo=${n.questionNo}">${n.questionTitle}</a></td>
	     			</c:when>
	     			
	     			
	     			<c:when test="${n.customerNo == customerNo}">
	     			
	     				<td><a href="${pageContext.request.contextPath}/question/questionOne?questionNo=${n.questionNo}">${n.questionTitle}</a></td>
	     			</c:when>
	     			
	     			<c:otherwise>
	     					<td>비밀글입니다</td>
	     			</c:otherwise>
	     		</c:choose>
	     	</c:when>
	     	<c:otherwise>
	     		<td><a href="${pageContext.request.contextPath}/question/questionOne?questionNo=${n.questionNo}">${n.questionTitle}</a></td>
	     	</c:otherwise>
	     </c:choose>
	     <td>${n.customerId}</td>
	     <td>${n.createdate}</td>
	     <td>${n.updatedate}</td>
	   </tr>
	 </c:forEach>
	
 
   </tbody>
   </table>
   <a href="${pageContext.request.contextPath}/question/addQuestion"><button type="submit" class="site-btn">문의하기</button></a>
   			
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
