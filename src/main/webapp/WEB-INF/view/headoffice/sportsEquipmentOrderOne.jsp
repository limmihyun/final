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
    <div class="breadcome-area">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="breadcome-list single-page-breadcome">
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                <div class="breadcome-heading">
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="single-pro-review-area mt-t-50 mg-b-15">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="product-payment-inner-st">
                        <ul id="myTabedu1" class="tab-review-design">
                            <li class="active"><a href="#description">발주상세조회</a></li>
                        </ul>
                        <div id="myTabContent" class="tab-content custom-product-edit">
                            <div class="product-tab-list tab-pane fade active in" id="description">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="review-content-section">
                                            <div id="dropzone1" class="pro-ad addcoursepro">
                                                <form action="/headoffice/sportsEquipmentOrderOne" method="post"
                                                      class="dropzone dropzone-custom needsclick add-professors dz-clickable"
                                                      id="demo1-upload">
                                                    <div class="row">
                                                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                            <div class="form-group">
                                                                <label>발주 번호</label>
                                                                <input class="form-control" name="orderNo" value="${orderOne.orderNo}" readonly="readonly">
                                                            </div>
                                                            <div class="form-group">
                                                                <label>발주 상태</label>
                                                                <input class="form-control" value="${orderOne.orderStatus}" readonly="readonly">
                                                            </div>
                                                            <div class="form-group">
                                                                <label>발주자직원번호</label>
                                                                <input class="form-control" value="${orderOne.employeeOrderer}" readonly="readonly">
                                                            </div>
                                                            <div>
                                                                <label>발주자 이름</label>
                                                                <input class="form-control" value="${orderOne.employeeOrdererName}" readonly="readonly">
                                                            </div>
                                                            <div class="form-group">
                                                                <label>발주지점(번호)</label>
                                                                <input class="form-control" value="${orderOne.branchNo}" readonly="readonly">
                                                            </div>
                                                            <div class="form-group">
                                                                <label>발주지점</label>
                                                                <input class="form-control" value="${orderOne.branchName}" readonly="readonly">
                                                            </div>
                                                            <div class="form-group">
                                                                <label>발주물품(번호)</label>
                                                                <input class="form-control" value="${orderOne.sportsEquipmentNo} ${orderOne.itemName}" readonly="readonly">
                                                                </select>
                                                            </div>
                                                            <div class="form-group">
                                                                <label>수량</label>
                                                                <input class="form-control" value="${orderOne.quantity}" readonly="readonly">
                                                            </div>
                                                            <div class="form-group">
                                                                <label>단가</label>
                                                                <input class="form-control" value="${orderOne.itemPrice}" readonly="readonly">
                                                            </div>
                                                            <div class="form-group">
                                                                <label>총발주금액</label>
                                                                <input class="form-control" value="${orderOne.totalPrice}" readonly="readonly">
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                            <div class="form-group">
                                                                <label>승인권자(번호)</label>
                                                                <input class="form-control" value="${orderOne.employeeApprover} ${orderOne.employeeApproverName}" readonly="readonly">
                                                            </div>
                                                            <div class="form-group">
                                                                <label>물품사진</label> <%-- 물품 선택시 갱신--%>
                                                                <br><img src="/img/about-us.jpg" height="200" width="200">
                                                            </div>

                                                            <div class="form-group edit-ta-resize">
                                                                <label>물품 정보</label> <%-- 물품 선택시 갱신--%>
                                                                <textarea id="note" readonly="readonly">${orderOne.note}</textarea>
                                                            </div>
                                                            <label>발주상태변경</label>
                                                            <select name="changeOrderStatus" class="form-control">
                                                                <option value="대기">대기</option>
                                                                <option value="승인">승인</option>
                                                                <option value="거부">거부</option>
                                                            </select>
                                                            <div class="mg-t-15">
                                                                <button type="submit"
                                                                        class="btn btn-primary btn-block">
                                                                    발주상태변경
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-lg-6">

                                                        </div>
                                                        <div class="col-lg-6">

                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
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
        url: '/api/v1/branch/list',
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