<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                            <li><a href="/customer/programrs">programrs</a></li>
                            <li><a href="/customer/franchiseBranch">branch</a></li>
                            <li><a href="">BLANK</a></li>
                            <li><a href="/notice/noticeList">notice</a></li>
                            <c:if test="${customerNo eq null && employeeNo eq null}">
                            <li><a href="/customer/login">login</a></li>
                            </c:if>
                            <c:if test="${customerNo ne null}">
                            <li><a href="/customer/logout">logout</a></li>
                            </c:if>
                            <li><i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</i></li>
                            <c:if test="${customerNo eq null && employeeNo eq null}">
                            <li><a href="/employee/login">employee login</a></li>
                            </c:if>
                            <c:if test="${employeeNo ne null}">
                            <li><a href="/employee/logout">employee logout</a></li>
                            <li><a href="/branch/home">branch home</a></li>
                            </c:if>
                        </ul>
                    </nav>
                    <div id="mobile-menu-wrap"></div>
                </div>
            </div>
        </div>
    </div>
</header>