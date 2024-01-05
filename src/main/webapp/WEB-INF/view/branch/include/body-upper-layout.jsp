<%--
  Created by IntelliJ IDEA.
  User: 정인호
  Date: 2023-12-26
  Time: 오전 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Start Left menu area -->
<div class="left-sidebar-pro">
    <nav id="sidebar" class="">
        <div class="sidebar-header">
            <h3 style="color: #0a6aa1"><a href="/branch/home">GD HEALTH</a></h3>
            <h5 style="color: #0a6aa1">${sessionScope.loginEmployee.employeeName} 님 (${sessionScope.loginEmployee.branchName})</h5>
        </div>
        <div class="left-custom-menu-adp-wrap comment-scrollbar mt-3">
            <nav class="sidebar-nav left-sidebar-menu-pro">
                <ul class="metismenu" id="menu1">
                    <li>
                        <a title="Landing Page" href="/branch/program-calendar/home" aria-expanded="false"><span class="educate-icon educate-event icon-wrap sub-icon-mg" aria-hidden="true"></span> <span class="mini-click-non">
                                    주간 프로그램</span></a>
                    </li>
                    <li>
                        <a class="has-arrow" href="all-professors.html" aria-expanded="false"><span class="educate-icon educate-professor icon-wrap"></span> <span class="mini-click-non">
                                    직원관리</span></a>
                        <ul class="submenu-angle" aria-expanded="false">
                            <li><a title="All Professors" href="/branch/employee/home"><span class="mini-sub-pro">지점직원조회</span></a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="has-arrow" href="all-courses.html" aria-expanded="false"><span class="educate-icon educate-course icon-wrap"></span> <span class="mini-click-non">
                                    물품관리</span></a>
                        <ul class="submenu-angle" aria-expanded="false">
                            <li><a title="All Courses" href="/branch/sports-equipment/list"><span class="mini-sub-pro">지점물품발주조회</span></a></li>
                            <li><a title="Add Courses" href="/branch/sports-equipment/order"><span class="mini-sub-pro">지점물품발주</span></a></li>
                        </ul>
                    </li>
                    <li>
                        <a title="Landing Page" href="#" aria-expanded="false"><span class="educate-icon educate-department icon-wrap" aria-hidden="true"></span> <span class="mini-click-non">
                                    고객리뷰</span></a>
                    </li>
                    <li>
                        <a title="Landing Page" href="#" aria-expanded="false"><span class="educate-icon educate-data-table icon-wrap" aria-hidden="true"></span> <span class="mini-click-non">
                                    고객조회</span></a>
                    </li>
                </ul>
            </nav>
        </div>
    </nav>
</div>
<!-- End Left menu area -->
<!-- Start Welcome area -->
<div class="all-content-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <br><br><br>
            </div>
        </div>
    </div>
    <div class="header-advance-area">
        <div class="header-top-area">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="header-top-wraper">
                            <div class="row">
                                <div class="col-lg-1 col-md-0 col-sm-1 col-xs-12">
                                </div>
                                <div class="col-lg-6 col-md-7 col-sm-6 col-xs-12">
                                    <div class="header-top-menu tabl-d-n">
                                        <ul class="nav navbar-nav mai-top-nav">
                                            <li class="nav-item"><a href="/customer/home" class="nav-link">고객 홈</a></li>
                                            <li class="nav-item"><a href="/branch/home" class="nav-link">지점 홈</a></li>
                                            <li class="nav-item"><a href="/notice/noticeList" class="nav-link">공지 게시판</a></li>
                                            <li class="nav-item"><a href="/testLoginEmployee" class="nav-link">직원 테스트로그인</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Mobile Menu start -->
        <!-- Mobile Menu end -->
    </div>
