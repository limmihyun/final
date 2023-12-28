<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<c:set var="path" value="${pageContext.request.contextPath}" /><!-- request.getContextPath 간소화 -->
<header class="header-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="main-menu">
                    <div class="logo">
                        <a href="/customer/home">
                            <img src="/img/logo.png" alt="">
                        </a>
                    </div>
                    <nav class="mobile-menu">
                        <ul>
                            <li><a href="/customer/home">home</a></li>
                            <li><a href="">회사 소개</a></li>
                            <li><a href="/customer/programrs">수업</a></li>
                            <li><a href="">강사</a></li>
                            <li><a href="">notice</a></li>
                            <c:if test="${customerNo eq null}">
                            <li><a href="/customer/login">login</a></li>
                            </c:if>
                            <c:if test="${customerNo ne null}">
                            <li><a href="/customer/logout">logout</a></li>
                            </c:if>
                        </ul>
                    </nav>
                    <div id="mobile-menu-wrap"></div>
                </div>
            </div>
        </div>
    </div>
</header>

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