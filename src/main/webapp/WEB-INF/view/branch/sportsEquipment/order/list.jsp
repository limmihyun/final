<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: 정인호
  Date: 2023-12-26
  Time: 오전 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/branch/include/debug.jsp"/>
<!doctype html>
<html class="no-js" lang="ko">

<head>
    <jsp:include page="/WEB-INF/view/branch/include/head.jsp"/>
    <!-- Latest compiled and minified CSS -->
</head>

<body>
<jsp:include page="/WEB-INF/view/branch/include/body-upper-layout.jsp"/>
<!-- 본문 시작 -->
<div class="data-table-area mg-b-15">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="sparkline13-list">
                    <div class="sparkline13-hd">
                        <div class="main-sparkline13-hd">
                            <h1>지점물품발주조회 <span class="table-project-n"></span></h1>
                        </div>
                    </div>
                    <div class="sparkline13-graph">
                        <div class="datatable-dashv1-list custom-datatable-overright">

                            <div class="bootstrap-table">
                                <div class="fixed-table-toolbar">
                                    <div class="bs-bars pull-left">
                                        <div id="toolbar">
                                            <select id="isOnlyWaitingListSelectFrom" class="form-control dt-tb">
                                                <option value="${empty param.get("isOnlyWaitingList") ? 'false' :param.get("isOnlyWaitingList")}">${empty param.get("isOnlyWaitingList") ?  '전체조회' :param.get("isOnlyWaitingList") eq true ? '미승인건조회' : '전체조회'}</option>
                                                <option value="${empty param.get("isOnlyWaitingList") ? 'true' :! param.get("isOnlyWaitingList")}">${empty param.get("isOnlyWaitingList") ?  '미승인건조회' :param.get("isOnlyWaitingList") eq true ? '전체조회' : '미승인건조회'}</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="fixed-table-container" style="padding-bottom: 0px;">
                                    <div class="fixed-table-header" style="display: none;">
                                        <table></table>
                                    </div>
                                    <div class="fixed-table-body">
                                        <table id="table" data-toggle="table" data-pagination="true" data-search="true"
                                               data-show-columns="true" data-show-pagination-switch="true"
                                               data-show-refresh="true" data-key-events="true" data-show-toggle="true"
                                               data-resizable="true" data-cookie="true" data-cookie-id-table="saveId"
                                               data-show-export="true" data-click-to-select="true"
                                               data-toolbar="#toolbar" class="table table-hover JColResizer">
                                            <thead>
                                            <tr>
                                                <th class="" style="width: 10.2%;" data-field="state"
                                                    tabindex="0">
                                                    <div class="th-inner ">날짜
                                                    </div>
                                                    <div class="fht-cell"></div>
                                                </th>
                                                <th style="width: 3.7%;" data-field="" tabindex="0">
                                                    <div class="th-inner ">번호</div>
                                                    <div class="fht-cell"></div>
                                                </th>
                                                <th style="width: 15.7%;" data-field="" tabindex="0">
                                                    <div class="th-inner ">발주자직원(번호)</div>
                                                    <div class="fht-cell"></div>
                                                </th>
                                                <th style="width: 12.1%;" data-field="발주()" tabindex="0">
                                                    <div class="th-inner ">발주지점(번호)</div>
                                                    <div class="fht-cell"></div>
                                                </th>
                                                <th style="width: 15%;" data-field="phone" tabindex="0">
                                                    <div class="th-inner ">발주물품(번호)</div>
                                                    <div class="fht-cell"></div>
                                                </th>
                                                <th style="width: 5.2%;" data-field="complete" tabindex="0">
                                                    <div class="th-inner ">수량</div>
                                                    <div class="fht-cell"></div>
                                                </th>
                                                <th style="width: 10.6%;" data-field="task" tabindex="0">
                                                    <div class="th-inner ">단가</div>
                                                    <div class="fht-cell"></div>
                                                </th>
                                                <th style="width: 10.3%;" data-field="date" tabindex="0">
                                                    <div class="th-inner ">총발주금액</div>
                                                    <div class="fht-cell"></div>
                                                </th>
                                                <th style="width: 9.4%;" data-field="price" tabindex="0">
                                                    <div class="th-inner ">승인권자</div>
                                                    <div class="fht-cell"></div>
                                                </th>
                                                <th style="width: 6.8%;" data-field="action" tabindex="0">
                                                    <div class="th-inner ">발주상태</div>
                                                    <div class="fht-cell"></div>
                                                </th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="orderInformation" items="${orderInformationList}">
                                            <tr>
                                                <td>${orderInformation.createdate}</td>
                                                <td>${orderInformation.orderNo}</td>
                                                <td>(${orderInformation.employeeOrderer})${orderInformation.employeeOrdererName}</td>
                                                <td>(${orderInformation.branchNo})${orderInformation.branchName}</td>
                                                <td>(${orderInformation.sportsEquipmentNo})${orderInformation.itemName}</td>
                                                <td>${orderInformation.quantity}</td>
                                                <td>${orderInformation.itemPrice}</td>
                                                <td>${orderInformation.totalPrice}</td>
                                                <td>(${orderInformation.employeeApprover})${orderInformation.employeeApproverName}</td>
                                                <td>${orderInformation.orderStatus.code}</td>
                                            </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="fixed-table-footer" style="display: none;">
                                        <table>
                                            <tbody>
                                            <tr></tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="fixed-table-pagination">
                                        <div class="pull-left pagination-detail">
                                            10 rows per page
                                        </div>
                                        <div class="pull-right pagination">
                                            <ul class="pagination">
                                                <li class="page-pre"><a href="#">‹</a></li>
                                                <c:forEach var="pageUri" items="${pageUriList}">
                                                    <li class="page-number ${pageUri.page eq requestPage? "active" : null}"><a href="${pageUri.uri}">${pageUri.page}</a></li>
                                                </c:forEach>
                                                <li class="page-next"><a href="#">›</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix"></div>
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
    $('#isOnlyWaitingListSelectFrom').change(function () {
        let isOnlyWaitingListSelect = $('#isOnlyWaitingListSelectFrom').val();
            window.location.replace('/branch/sportsEquipment/order/list?isOnlyWaitingList='+isOnlyWaitingListSelect);
    })
</script>
</body>

</html>