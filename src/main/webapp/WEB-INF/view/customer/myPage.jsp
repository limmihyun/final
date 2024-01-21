<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
			<div class="title">신체 정보</div>
			<div class="status">
			<div class="item">
			<div>
				<div class="number">${info.customerHeight}</div>
				<div class="center">신장</div>
			</div>
			</div>
			<div class="item">
			<div>
				<div class="number">${info.customerWeight}</div>
					<div class="center">체중</div>
			</div>
			</div>
			<div class="item">
			<div>
				<div class="number">${info.customerBmi}</div>
					<div class="center">BMI</div>
			</div>
			</div>
			<div class="item">
			<div>
				<div class="number"></div>
					<div class="center">업데이트</div>
					<div class="">${info.customerUpdatedate}</div>
			</div>
			</div>
			</div>
		</div>
		
		<div class="listContainer">
			<div class="item">
				<a href="#"><div class="icon">ii &nbsp; 내 정보 수정</div></a> <a
					class="right" href="#"><div>></div></a>
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
			<div class="item">
				<a href="/chat/moveChating"><div class="icon">ii &nbsp; 채팅</div></a> <a
					class="right" href="/chat/moveChating?customerId=${sessionScope.customerId}"><div>></div></a>
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
</html>