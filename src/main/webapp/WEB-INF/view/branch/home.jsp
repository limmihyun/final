<%--
  Created by IntelliJ IDEA.
  User: 정인호
  Date: 2023-12-26
  Time: 오전 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/view/branch/include/debug.jsp"/>
<!doctype html>
<html class="no-js" lang="ko">

<head>
    <jsp:include page="/WEB-INF/view/branch/include/head.jsp"/>
</head>

<body>
    <jsp:include page="/WEB-INF/view/branch/include/body-upper-layout.jsp"/>
        <!-- 본문 시작 -->
        <div class="row mg-t-30">
            <div class="col-lg-3"></div>
            <div class="col-lg-4">
                <h1> &nbsp;&nbsp;지점관리 홈페이지 </h1>
                <h1>   &nbsp;&nbsp;&nbsp;&nbsp; W E L C O M E  </h1>
            </div>
            <div class="col-lg-4"></div>
        </div>
    <div>
        <img width="500" src="/branch/branchHome.png">
        <img width="500" src="/branch/branchHome.png">
    </div>
        <!-- 본문 종료 -->
    <jsp:include page="/WEB-INF/view/branch/include/body-lower-layout.jsp"/>
</body>

</html>