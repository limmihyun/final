<%--
  Created by IntelliJ IDEA.
  User: 정인호
  Date: 2023-12-26
  Time: 오전 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/view/branch/include/debug.jsp"/>
<!doctype html>
<html class="no-js" lang="ko">

<head>
    <jsp:include page="/WEB-INF/view/branch/include/head.jsp"/>
</head>

<body>
    <jsp:include page="/WEB-INF/view/branch/include/body-upper-layout.jsp"/>
        <!-- 본문 시작 -->
    <div class="row">
        <div class="col-lg-12">
            <div class="product-status mg-b-15">
                <div class="container-fluid">
                    <div class="row mg-t-30">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="product-status-wrap drp-lst">
                                <h4>지점직원조회 (<span id="branchName"></span>)</h4>
                                <div class="asset-inner">
                                    <table>
                                        <tbody><tr>
                                            <th>직원번호</th>
                                            <th>직원이름</th>
                                            <th>성별</th>
                                            <th>아이디</th>
                                            <th>전화번호</th>
                                            <th>이메일</th>
                                            <th>활성여부</th>
                                        </tr>
                                        <c:forEach var="employee" items="${branchEmployeeList}">
                                            <tr>
                                                <td>${employee['employeeNo']}</td>
                                                <td>${employee['employeeName']}</td>
                                                <td>${employee['employeeGender']}</td>
                                                <td>${employee['employeeId']}</td>
                                                <td>${employee['employeePhone']}</td>
                                                <td>${employee['employeeEmail']}</td>
                                                <td>${employee['employeeActive']}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody></table>
                                </div>
                                <div class="custom-pagination">
                                    <nav aria-label="Page navigation example">
                                        <ul class="pagination">
                                            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                                            <li class="page-item"><a class="page-link" href="#">Next</a></li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
        <!-- 본문 종료 -->
    <jsp:include page="/WEB-INF/view/branch/include/body-lower-layout.jsp"/>
<script>
    /*지점정보출력*/
    $.ajax({
        url: '/api/v1/branch/${sessionScope.loginEmployee.branchNo}',
        type: 'GET',
        success: function (response){
            $('#branchName').text(response.branchName + '지점');
        }
    });
</script>
</body>

</html>