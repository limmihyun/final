<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: 정인호
  Date: 2024-01-08
  Time: 오전 11:43
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>발주조회</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!------------------- favicon start ------------------>
    <link type="image/png" sizes="32x32" rel="icon" href="/admin/workoutFavicon.png">
    <!------------------- favicon end -------------------->

    <!-- Google Fonts
		============================================ -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900" rel="stylesheet">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/bootstrap.min.css">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/font-awesome.min.css">
    <!-- owl.carousel CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/owl.carousel.css">
    <link rel="stylesheet" href="/admin/css/owl.theme.css">
    <link rel="stylesheet" href="/admin/css/owl.transitions.css">
    <!-- animate CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/animate.css">
    <!-- normalize CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/normalize.css">
    <!-- meanmenu icon CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/meanmenu.min.css">
    <!-- main CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/main.css">
    <!-- educate icon CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/educate-custon-icon.css">
    <!-- morrisjs CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/morrisjs/morris.css">
    <!-- mCustomScrollbar CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/scrollbar/jquery.mCustomScrollbar.min.css">
    <!-- metisMenu CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/metisMenu/metisMenu.min.css">
    <link rel="stylesheet" href="/admin/css/metisMenu/metisMenu-vertical.css">
    <!-- calendar CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/calendar/fullcalendar.min.css">
    <link rel="stylesheet" href="/admin/css/calendar/fullcalendar.print.min.css">
    <!-- style CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/style.css">
    <!-- responsive CSS
		============================================ -->
    <link rel="stylesheet" href="/admin/css/responsive.css">
    <!-- modernizr JS
		============================================ -->
    <script src="/admin/js/vendor/modernizr-2.8.3.min.js"></script>
</head>

<body>

<!---------------------- 사이드바 start --------------------->
<c:import url="/WEB-INF/view/headoffice/include/sideBar.jsp"></c:import>
<!---------------------- 사이드바 end ----------------------->

<!-- Start Welcome area -->
<div class="all-content-wrapper">

    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <h1 style="color:#2E64FE; margin-top:20px;">본사 페이지</h1>
            </div>
        </div>
    </div>


    <div class="header-advance-area">
        <!---------------------- 상단바 start --------------------->
        <c:import url="/WEB-INF/view/headoffice/include/topBar.jsp"></c:import>
        <!---------------------- 상단바 end ----------------------->
    </div>


    <!-- 본문 시작 -->
    <div class="data-table-area mg-t-30">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="sparkline13-list">
                        <div class="sparkline13-hd">
                            <div class="main-sparkline13-hd mg-b-30">
                                <h1>발주조회 <span class="table-project-n"></span></h1>
                            </div>
                        </div>
                        <div class="sparkline13-graph">
                            <div class="datatable-dashv1-list custom-datatable-overright">

                                <div class="bootstrap-table">
                                    <div class="fixed-table-toolbar">
                                        <div class="row">
                                            <div id="toolbar" class="col-lg-3">
                                                <label>발주상태선택</label>
                                                <select id="isOnlyWaitingListSelectFrom" class="form-control dt-tb">
                                                    <option value="${empty param.get("isOnlyWaitingList") ? 'false' :param.get("isOnlyWaitingList")}">${empty param.get("isOnlyWaitingList") ?  '전체발주상태' :param.get("isOnlyWaitingList") eq true ? '미승인건조회' : '전체발주상태'}</option>
                                                    <option value="${empty param.get("isOnlyWaitingList") ? 'true' :! param.get("isOnlyWaitingList")}">${empty param.get("isOnlyWaitingList") ?  '미승인건조회' :param.get("isOnlyWaitingList") eq true ? '전체발주상태' : '미승인건조회'}</option>
                                                </select>
                                            </div>
                                            <div class="col-lg-3">
                                                <label>지점선택</label>
                                                <select id="branchSelectFrom" class="form-control dt-tb">
                                                    <option value="">전체지점</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="fixed-table-container" style="padding-bottom: 0px;">
                                        <div class="fixed-table-header" style="display: none;">
                                            <table></table>
                                        </div>
                                        <div class="fixed-table-body">
                                            <table id="table" data-toggle="table" data-pagination="true"
                                                   data-search="true"
                                                   data-show-columns="true" data-show-pagination-switch="true"
                                                   data-show-refresh="true" data-key-events="true"
                                                   data-show-toggle="true"
                                                   data-resizable="true" data-cookie="true"
                                                   data-cookie-id-table="saveId"
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
                                                        <div class="th-inner ">발주상태<br>(상세보기)</div>
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
                                                        <td>
                                                            (${orderInformation.employeeApprover})${orderInformation.employeeApproverName}</td>
                                                        <td><a href="/headoffice/sportsEquipmentOrderOne?orderNo=${orderInformation.orderNo}"
                                                               class="btn btn-info">${orderInformation.orderStatus.code}</a></td>
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


</div>

<!-- jquery
    ============================================ -->
<script src="/admin/js/vendor/jquery-1.12.4.min.js"></script>
<!-- bootstrap JS
    ============================================ -->
<script src="/admin/js/bootstrap.min.js"></script>
<!-- wow JS
    ============================================ -->
<script src="/admin/js/wow.min.js"></script>
<!-- price-slider JS
    ============================================ -->
<script src="/admin/js/jquery-price-slider.js"></script>
<!-- meanmenu JS
    ============================================ -->
<script src="/admin/js/jquery.meanmenu.js"></script>
<!-- owl.carousel JS
    ============================================ -->
<script src="/admin/js/owl.carousel.min.js"></script>
<!-- sticky JS
    ============================================ -->
<script src="/admin/js/jquery.sticky.js"></script>
<!-- scrollUp JS
    ============================================ -->
<script src="/admin/js/jquery.scrollUp.min.js"></script>
<!-- mCustomScrollbar JS
    ============================================ -->
<script src="/admin/js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="/admin/js/scrollbar/mCustomScrollbar-active.js"></script>
<!-- metisMenu JS
    ============================================ -->
<script src="/admin/js/metisMenu/metisMenu.min.js"></script>
<script src="/admin/js/metisMenu/metisMenu-active.js"></script>
<!-- morrisjs JS
    ============================================ -->
<script src="/admin/js/sparkline/jquery.sparkline.min.js"></script>
<script src="/admin/js/sparkline/jquery.charts-sparkline.js"></script>
<script src="/admin/js/sparkline/sparkline-active.js"></script>
<!-- calendar JS
    ============================================ -->
<script src="/admin/js/calendar/moment.min.js"></script>
<script src="/admin/js/calendar/fullcalendar.min.js"></script>
<script src="/admin/js/calendar/fullcalendar-active.js"></script>
<!-- plugins JS
    ============================================ -->
<script src="/admin/js/plugins.js"></script>
<!-- main JS
    ============================================ -->
<script src="/admin/js/main.js"></script>


<script>
    /*지점리스트를 가져옵니다*/
    $.ajax({
        url: '/api/v1/branch',
        type: 'get',
        success: function (response){
            let currentUri = window.location.href;
            let url = new URL(currentUri);
            $('#branchSelectFrom').html('<option value="">전체지점</option>');
            $(response).each(function (index, item){
                $('#branchSelectFrom').append('<option value="' + item.branchNo + '">' + item.branchName + '</option>');
            });
            if(url.searchParams.get('branchNo') !== ''){
                $('#branchSelectFrom').val(url.searchParams.get('branchNo'));
            }
        }
    });

    /*isOnlyWaitingListSelectFrom 변경시 이동합니다.*/
    $('#isOnlyWaitingListSelectFrom').change(function () {
        let isOnlyWaitingListSelect = $('#isOnlyWaitingListSelectFrom').val();
        let currentUri = window.location.href;
        let url = new URL(currentUri);
        url.searchParams.set('isOnlyWaitingList', isOnlyWaitingListSelect);
        window.location.href = url.toString();
    });

    /*branchSelectFrom 변경시 이동합니다.*/
    $('#branchSelectFrom').change(function () {
        let branchSelect = $('#branchSelectFrom').val();
        let currentUri = window.location.href;
        let url = new URL(currentUri);
        url.searchParams.set('branchNo', branchSelect);
        window.location.href = url.toString();
    });
</script>
</script>

</body>

</html>