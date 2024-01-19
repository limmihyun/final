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
    <!-- Header Section Begin -->
    <header class="header-section" style="background-color: #fff; box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1); position: fixed; width: 100%; z-index: 1000;">
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
  
  <div class="untree_co-section" style="padding-top: 80px;">
          <div class="container" style="margin-top: 100px;">
   
                    <h2 class="h3 mb-3 text-black">Notice</h2>
                    <p class="mb-4">공지사항을 잘 확인해주세요.</p>
                    <p class="mb-4">기타 문의사항은 Q&A 게시판을 통해 문의해 주세요.</p>
                    
                    <div class="p-3 p-lg-5 border bg-white">
                      <table class="table site-block-order-table mb-5">
      
   <thead>
        <th>번호</th>
       <th>제목</th>
       <th>작성자</th>
       <th>작성날짜</th>
       <th>수정날짜</th>
   </thead>
   <tbody>
   <c:forEach var="n" items="${list}">
   <tr>
      <td style="align-text:center;">${n.noticeNo}</td>
      <td><a href="${pageContext.request.contextPath}/notice/noticeOne?noticeNo=${n.noticeNo}">${n.noticeTitle}</a></td>
      <td>${n.employeeId}</td>
      <td>${n.createdate}</td>
      <td>${n.updatedate}</td>
   </tr>
   </c:forEach>
   </tbody>
   </table>
   <div>현재 페이지 ${currentPage}</div>
   <div>
	   	<c:if test="${currentPage -1) > 0}">
	   		<a href="${pageContext.request.contextPath}/noticeList?currenPage=${currentPage -1}">이전</a>
	   	</c:if>
	   	<c:if test="${currentPage < lastPage}">
	   		<a href="${pageContext.request.contextPath}/noticeList?currenPage=${currentPage +1}">다음</a>
	   	</c:if>
   </div>
   <c:choose>
   <c:when test="${branchLevel == 1}">
   <a href="${pageContext.request.contextPath}/notice/addNotice"><button type="submit" class="site-btn">공지추가</button></a>
   </c:when>
   
   </c:choose>
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
