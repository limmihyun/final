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
                        <h2>Notice</h2>
                        <div class="links">
                            <a href="/customer/home">Home</a>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

   <section class="features-section spad">
    <div id="Notice" align="left" style="margin-left: 40px;">
         <h1 class="h3 mb-3 text-black">Notice</h1>
      </div>
        <div style="text-align: left; position: relative; margin-left: 40px;">
            <p class="mb-4">공지사항을 잘 확인해주세요.</p>    
            <p class="mb-4">기타 문의사항은 Q&A 게시판을 통해 문의해 주세요.</p>
        </div>
        
   <div style="text-align: center; margin: 20px;">   
   <table class="table site-block-order-table mb-5">
      
   <thead>
       <th style="text-align: center;">번호</th>
       <th style="text-align: center;">제목</th>
       <th style="text-align: center;">작성자</th>
       <th style="text-align: center;">작성날짜</th>
       <th style="text-align: center;">수정날짜</th>
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
         <c:if test="${currentPage - 1 > 0}">
            <a style="margin-top:1%;" class="btn btn-white" href="${pageContext.request.contextPath}/notice/noticeList?currentPage=${1}">처음</a>
            <a style="margin-top:1%;" class="btn btn-primary" href="${pageContext.request.contextPath}/notice/noticeList?currentPage=${currentPage - 1}">이전</a>
              
         </c:if>
         <c:if test="${currentPage != lastPage}">
            <a style="margin-top:1%;" class="btn btn-primary" href="${pageContext.request.contextPath}/notice/noticeList?currentPage=${currentPage + 1}">다음</a>
         </c:if>
         <c:if test="${currentPage -1 > 0}">
            <a style="margin-top:1%;" class="btn btn-white" href="${pageContext.request.contextPath}/notice/noticeList?currentPage=${lastPage}">마지막</a>
         </c:if>
   </div>
   <c:choose>
        <c:when test="${branchLevel == 1}">
          <a style="margin-top: 10px;" class="btn btn-primary" href="${pageContext.request.contextPath}/notice/addNotice">공지추가</a>
     </c:when>
   </c:choose>
   
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