<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/css/myPage.css" type="text/css">
<title>GD HEALTH</title>

</head>
<body>
   <div class="wrap">
      <div class="greenContainer">
         <div>
            <div class="grade">${info.customerEmail}</div>
            <div class="name">${info.customerName}</div>
         </div>
         <div class="modify">i</div>
      </div>
      <div class="summaryContainer">
         <div class="item">
            <div class="number">${attendanceCount}</div>
            <div>출석횟수</div>
         </div>
         <div class="item">
            <div class="number">${reviewCount}</div>
            <div>리뷰</div>
         </div>
         <div class="item">
            <div class="number">${questionCount}</div>
            <div>문의</div>
         </div>
         <div class="item">
            <div class="number">${membership}</div>
            <div>맴버십</div>
         </div>
      </div>
      <div class="shippingStatusContainer">
      	<form method="post" action="${pageContext.request.contextPath}/customer/updateMyPage">
         <div class="title">신체 정보</div>
         <div class="status">
          <input type="hidden" id="customerNo" value="${info.customerNo}">
         <div class="item">
         <div>
            <div class="center">신장</div>
            <div class="number">
               <input type="text" id="customerHeight" name="customerHeight" value="${info.customerHeight}">
                </div>
         </div>
         </div>

         <div class="item">
         <div style="position: relative; left: -337px;">
            <div class="center">체중</div>
            <div class="number">
            <input type="text" id="customerWeight" name="customerWeight" value="${info.customerWeight}">
            </div>      
         </div>
         </div>
         
          <div style="position: relative; left: -700px; margin-top: 30px;">
            <button type="submit" style="background-color: green; border: none; color: white; padding: 8px 15px; cursor: pointer; border-radius: 5px;">저장</button>
          </div>
        </form>
      </div>
    </div>
      
      <div class="listContainer">
         <div class="item">
				<a href="/customer/myPage"><div class="icon">ii &nbsp; 내 정보</div></a> <a
					class="right" href="/customer/myPage"><div>></div></a>
			</div>
         <div class="item">
            <a href="/customer/myreservation"><div class="icon">ii &nbsp; 스케줄</div></a> <a
               class="right" href="/customer/myreservation"><div>></div></a>
         </div>
         <div class="item">
            <a href="/review/reviewList"><div class="icon">ii &nbsp; 리뷰</div></a> <a
               class="right" href="/review/reviewList"><div>></div></a>
         </div>
         <div class="item">
            <a href="/question/questionList"><div class="icon">ii &nbsp; 문의사항</div></a> <a
               class="right" href="/question/questionList"><div>></div></a>
         </div>
         <div class="item">
            <a href="/customer/membershipList"><div class="icon">ii &nbsp; 맴버십 구매</div></a> <a
               class="right" href="/customer/membershipList"><div>></div></a>
         </div>
         
      </div>
      <div class="listContainer">
         
         <div class="item">
            <a href="/customer/delete"><div class="icon">ii &nbsp; 회원탈퇴</div></a> <a
               class="right" href="#"><div>></div></a>
         </div>
      </div>
      <div class="infoContainer">
         <div class="item">

            <div>
               <h3>
                  <a href="/notice/noticeList" class="black">공지사항</a>
               </h3>
            </div>
         </div>

         <div class="item">

            <div>
               <h3>
                  <a href="/customer/home" class="black">홈으로</a>
               </h3>
            </div>
         </div>
      </div>
   </div>
</body>
</html>>