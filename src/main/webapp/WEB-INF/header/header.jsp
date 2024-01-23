<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="header-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="main-menu">
                    <div class="logo">
                        <a href="/customer/home">
                            <br>
                            <H3 style="color: #ebfcff">GDHEALTH</H3>
                        </a>
                    </div>
                    <nav class="mobile-menu">
                        <ul>
                            <li><a href="/customer/home">home</a></li>
                            <li><a href="/customer/programrs">programrs</a></li>
                            <li><a href="/customer/franchiseBranch">branch</a></li>           
                            <li><a href="/question/questionList">q&a</a></li>
                            <li><a href="/notice/noticeList">notice</a></li>
                            <li><a href="/review/reviewList">review</a></li>
                            <li><a href="/customer/membershipList">membership</a></li>
                            <c:if test="${sessionScope.loginEmployee ne null}">
                                <li class="log"><a href="/employee/login">${sessionScope.loginEmployee.employeeName}님 업무페이지</a></li>
                                <li class="log"><a href="/employee/logout?ref=true">직원 로그아웃</a></li>

                            </c:if>
                            <c:if test="${sessionScope.loginEmployee eq null && customerNo eq null}">
                            <li class="log"><a href="/customer/login">login</a></li>
                            
                            </c:if>
                            <c:if test="${customerNo ne null}">
                            <li class="log"><a href="/customer/logout">logout</a></li>
                            <li class="log"><a href="/customer/myPage">mypage</a></li>
                            </c:if>
                            
                             
                        </ul>
                    </nav>
                    <div id="mobile-menu-wrap"></div>
                </div>
            </div>
        </div>
    </div>
</header>