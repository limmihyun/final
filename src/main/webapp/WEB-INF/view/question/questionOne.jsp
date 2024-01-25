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
   	<section class="breadcrumb-area set-bg" data-setbg="/img/elements/element-bg.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb-content">
                        <h2>Q&A</h2>
                        <div class="links">
                            <a href="/customer/home">Home</a>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Search Bar End -->
    <!-- Contact Section Begin -->
    <div class="untree_co-section before-footer-section">
            <div class="container">
             <div class="p-3 p-lg-5 border bg-white">
             <h1 class="mb-4 section-title">Q&A</h1>
             <br>
            <table class ="table">
        <tr>
            <th>질문번호</th>
            <td><p style="border: none;">${qsOne.questionNo}</p></td>
        </tr>
       <tr>
            <th>지점명</th>
            <td><p style="border: none;">${qsOne.branchName}</p></td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><p style="border: none;">${qsOne.customerId}</p></td>
        </tr>
        <tr>
            <th>제목</th>
            <td><p style="border: none;">${qsOne.questionTitle}</td>
        </tr>
        <tr>
          <th>내용</th>
          <td><textarea rows="6" cols="130" style="border: none;" readonly>${qsOne.questionContent}</textarea></td>
      </tr>
        <tr>
            <th>게시일</th>
            <td><p style="border: none;">${qsOne.createdate}</td>
        </tr>
        <tr>
            <th>수정일</th>
            <td><p style="border: none;">${qsOne.updatedate}</td>
        </tr>
    </table>

    <c:if test="${customerNo != null}">
     	<a style="float: right; margin-left: 10px;">
        	<a href="${pageContext.request.contextPath}/question/updateQuestion?questionNo=${qsOne.questionNo}" class="btn btn-primary">수정</a>
        	<a href="${pageContext.request.contextPath}/question/deleteQuestion?questionNo=${qsOne.questionNo}" class="btn btn-danger">삭제</a>
    	</a>
    </c:if>
    
    <!-- customer 입장: 답변이 달려 있다면 답변이 보이도록 -->
    <c:if test="${ansOne.answerContent != null && customerNo != null}">
	    <div class="untree_co-section before-footer-section" >
	    <div class="container">
        <div class="p-3 p-lg-5 border bg-white">
        	<div class="mt-5">
        	<br>
            	<h1 class="mb-2 section-title" style="font-size: 3.5rem; margin-bottom: 0;">Answer</h1>
            </div>
            <div style="border: 1px solid #ddd; padding: 10px; margin-bottom: 5;">
                <table class="table">
                    <tr>
                        <th>답변자</th>
                        <td>${ansOne.employeeId}</td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td><textarea rows="6" cols="130" style="border: none;" readonly>${ansOne.answerContent}</textarea></td>
                    </tr>
                    <tr>
                        <th>답변일자</th>
                        <td>${ansOne.createdate}</td>
                    </tr>
                    <tr>
                        <th>수정일자</th>
                        <td>${ansOne.updatedate}</td>
                    </tr>
                </table>
     </c:if>
     
   	  <!-- employee 입장: 답변이 달려 있는 상태에서, 답변을 수정할 수 있도록 -->
     <c:if test="${ansOne.answerContent != null && loginEmployee.employeeNo != null}">
		<div class="untree_co-section before-footer-section">
    <div class="container">
        <div class="p-3 p-lg-5 border bg-white">
            <div class="mt-5">
                <br>
                <h1 class="mb-2 section-title" style="font-size: 3.5rem; margin-bottom: 0;">Answer</h1>
            </div>
            <div style="border: 1px solid #ddd; padding: 10px; margin-bottom: 5;">
                <form method="post" action="${pageContext.request.contextPath}/answer/updateAnswer">
                    <input type="hidden" name="questionNo" value="${qsOne.questionNo}">
                    <table class="table">
                        <tr>
                            <th>답변자</th>
                            <td>${ansOne.employeeId}</td>
                        </tr>
                        <tr>
                            <th>내용</th>
                            <td><textarea rows="6" cols="130" style="border: none;" name="answerContent">${ansOne.answerContent}</textarea></td>
                        </tr>
                        <tr>
                            <th>답변일자</th>
                            <td>${ansOne.createdate}</td>
                        </tr>
                        <tr>
                            <th>수정일자</th>
                            <td>${ansOne.updatedate}</td>
                        </tr>
                    </table>
                    <div style="text-align: right; margin-top: 10px;">
                        <button type="submit" class="btn btn-primary">수정하기</button>
                        <a href="${pageContext.request.contextPath}/answer/deleteAnswer?questionNo=${qsOne.questionNo}" class="btn btn-danger">삭제</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
		
     	
    			
     </c:if>
   </div>
   </div>
   </div>
	
	  <!-- employee 입장: 답변이 달려 있지 않은 상태에, 답변을 작성할 수 있도록 -->
	<c:if test="${ansOne.answerContent == null && loginEmployee.employeeNo != null}">
	<section class="contact-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="contact-info">
                        <div class="contact-form">
                           <form method="post" action="${pageContext.request.contextPath}/answer/addAnswer">
                                <div class="row">
                                <input type="hidden" name="questionNo" value="${qsOne.questionNo}">
                                <input type="hidden" name="employeeNo" value="${loginEmployee.employeeNo}">
                                <div class="container" style="margin-top:-30px; margin-left: -20px;">
                                   <div class="col-lg-12">
                                        <textarea placeholder="답변을 작성하세요" name = "answerContent"></textarea>
                                        <button type="submit" class="site-btn">작성하기</button>
                                    </div>
                      </form>
</div>
</div>
</div> 
	
	</c:if>
	

    <!-- Contact Section End -->
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