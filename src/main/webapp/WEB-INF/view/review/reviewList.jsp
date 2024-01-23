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
    	<jsp:include page="/WEB-INF/header/header.jsp" />
    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-area set-bg" data-setbg="/img/elements/element-bg.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb-content">
                        <h2>Review</h2>
                        <div class="links">
                            <a href="/customer/home">Home</a>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
  <div class="untree_co-section" style="padding-top: 80px;">
          <div class="container" style="margin-top: 100px;">
   
                    <h2 class="h3 mb-3 text-black">Review</h2>
                    <p class="mb-4">리뷰 게시판입니다.</p>
                    
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
      <td style="align-text:center;">${n.reviewNo}</td>
      <td><a href="${pageContext.request.contextPath}/review/reviewOne?reviewNo=${n.reviewNo}">${n.reviewTitle}</a></td>
      <td>${n.customerId}</td>
      <td>${n.createdate}</td>
      <td>${n.updatedate}</td>
   </tr>
   </c:forEach>
   </tbody>
   </table>
   <a href="${pageContext.request.contextPath}/review/addReview"><button type="submit" class="site-btn">리뷰쓰기</button></a>
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
