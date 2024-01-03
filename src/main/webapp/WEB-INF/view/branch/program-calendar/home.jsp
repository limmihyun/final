<%--
  Created by IntelliJ IDEA.
  User: 정인호
  Date: 2023-12-26
  Time: 오전 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
                            <h4>주간 프로그램 캘린더 (<span id="branchName"></span>)</h4>
                            <div class="asset-inner">
                                <table>
                                    <tbody><tr>
                                        <th>날짜</th>
                                        <th>날짜명</th>
                                        <th>프로그램</th>
                                        <th>담당트레이너</th>
                                        <th>예약</th>
                                    </tr>
                                    <c:forEach var="branchDate" items="${calendar.branchDateList}">
                                    <tr>
                                        <td name="date" style="${branchDate.isToday?"background: linear-gradient(to top, #ccd0f0 100%, transparent 50%);" : null}">${branchDate.date}</td>
                                        <td>${branchDate.dateName} ${branchDate.isHoliday eq true ? "(공휴일)" : null}</td>
                                        <td>
                                            <c:if test="${branchDate.programName ne null}">
                                            <button class="pd-setting" name="programName">${branchDate.programName}</button>
                                            </c:if>
                                        </td>
                                        <td>${branchDate.managerNo ne 0? branchDate.managerName : null}</td>
                                        <td>${branchDate.reservedCount}/${branchDate.maxCustomer} 명</td>
                                    </tr>
                                    </c:forEach>
                                    </tbody></table>
                            </div>
                            <div class="custom-pagination">
                                <nav aria-label="Page navigation example">
                                    <ul class="pagination">
                                        <li class="page-item"><a class="page-link" href="/branch/program-calendar/${calendar.previousWeekDate}">Previous</a></li>
                                        <li class="page-item"><a class="page-link" href="/branch/program-calendar/${calendar.nextWeekDate}">Next</a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                        <div class="row mg-t-30">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                                <div class="profile-info-inner">
                                    <div class="profile-img">
                                        <img src="/branch/img/profile/1.jpg" alt="">
                                    </div>
                                    <div class="profile-details-hr">
                                        <div class="row">
                                            <div class="col-lg-6 col-md-12 col-sm-12 col-xs-6">
                                                <div class="address-hr">
                                                    <p><b>프로그램제목</b><br> <span id="programName"></span></p>
                                                </div>
                                            </div>
                                            <div class="col-lg-6 col-md-12 col-sm-12 col-xs-6">
                                                <div class="address-hr tb-sm-res-d-n dps-tb-ntn">
                                                    <p><b>프로그램작성자</b><br><span id="employeeName"></span></p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-6 col-md-12 col-sm-12 col-xs-6">
                                                <div class="address-hr">
                                                    <p><b>시작일</b><br> <span id="startDate"></span></p>
                                                </div>
                                            </div>
                                            <div class="col-lg-6 col-md-12 col-sm-12 col-xs-6">
                                                <div class="address-hr tb-sm-res-d-n dps-tb-ntn">
                                                    <p><b>종료일</b><br><span id="endDate"></span></p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <div class="address-hr">
                                                    <p><b>프로그램 설명</b><br> <span id="programDetail"></span><p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
                                <div class="product-payment-inner-st res-mg-t-30 analysis-progrebar-ctn">
                                    <h1><span class="about-text" id="date"></span><br>지점 프로그램 상세</h1>
                                    <div id="myTabContent" class="tab-content custom-product-edit st-prf-pro">
                                        <div class="product-tab-list tab-pane fade active in" id="description">
                                            <div class="row">
                                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                    <div class="review-content-section">
                                                        <div class="row">
                                                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                                                                <div class="address-hr biography">
                                                                    <p><b>담당 트레이너</b><br><span id="managerName"></span></p>
                                                                </div>
                                                            </div>
                                                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                                                                <div class="address-hr biography">
                                                                    <p><b>phone</b><br><span id="managerPhone"></span></p>
                                                                </div>
                                                            </div>
                                                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                                                                <div class="address-hr biography">
                                                                    <p><b>지점주소</b><br> <span id="address"></span></p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-lg-12">
                                                                <div class="content-profile">
                                                                    <h5>프로그램 예약고객</h5>
                                                                    <h5>고객 출석현황</h5>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row mg-b-15">
                                                            <div class="col-lg-12">
                                                                <div class="row">
                                                                    <div class="col-lg-12">
                                                                        <div class="skill-title">
                                                                            <hr>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="progress-skill">
                                                                    <h2>예약현황</h2>
                                                                    <div class="progress progress-mini">
                                                                        <div id="reservedProgressBar" style="width: 0%;" class="progress-bar progress-yellow"></div>
                                                                    </div>
                                                                </div>
                                                                <div class="progress-skill">
                                                                    <h2>출석현황</h2>
                                                                    <div class="progress progress-mini">
                                                                        <div style="width: 0%;" class="progress-bar progress-green"></div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row mg-t-30">
                                                        <div class="col-lg-4">
                                                            <form id="managerChangeForm">
                                                                <h4>담당트레이너 변경</h4>
                                                                <input id="mangerChangeProgramDateNo" name="programDateNo" value="" readonly="readonly" hidden="true">
                                                                <select id="mangerChangeSelectForm" name="managerNo" class="form-control">
                                                                </select>
                                                                <button class="form-control" id="changeManagerButton" type="button">변경</button>
                                                            </form>
                                                        </div>
                                                            <div class="col-lg-8"></div>
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
            </div>
        </div>
    </div>
</div>
<!-- 본문 종료 -->
<jsp:include page="/WEB-INF/view/branch/include/body-lower-layout.jsp"/>
<script>
    /*지점정보출력*/
    $.ajax({
        url: '/api/v1/branch/${calendar.branchNo}',
        type: 'GET',
        success: function (response){
            $('#branchName').html(response.branchName + '지점');
        }
    });

    /*프로그램 상세보기*/
    $('button[name="programName"]').click(function () {
        console.log($(this).html());
        let date = $(this).closest('tr').find('td[name="date"]').html();
        console.log(date);

        $.ajax({
            url: '/api/v1/BranchProgramDate/'+date,
            type: 'GET',
            data: {branchNo : ${calendar.branchNo}},
            success: function (response) {
                console.log(response);
                $('#date').text("").text(response.date);
                $('#employeeName').text("").text(response.employeeName);
                $('#address').text("").text(response.address);
                $('#endDate').text("").text(response.endDate);
                $('#managerName').text("").text(response.managerName);
                $('#programDetail').text("").text(response.programDetail);
                $('#programName').text("").text(response.programName);
                $('#managerPhone').text("").text(response.managerPhone);
                $('#startDate').text("").text(response.startDate);
                let reservedCount = response.reservedCount;
                let maxCustomer = response.maxCustomer;
                let reservedProgress = reservedCount/maxCustomer *100;
                $('#reservedProgressBar').css('width',reservedProgress+'%');
                $('#mangerChangeProgramDateNo').val("").val(response.programDateNo);
                $('#mangerChangeSelectForm').html("");
                $.ajax({
                    url: '/api/v1/employee',
                    type: 'GET',
                    data: {branchNo : ${calendar.branchNo}},
                    success: function (response2) {
                        $(response2).each(function (index, item) {
                            $('#mangerChangeSelectForm').append('<option value="'+item.employeeNo+'">'+item.employeeName+'</option>');
                        });
                    }
                });
            }
        });
    });

    /*매니저변경*/
    $('#changeManagerButton').click(function () {
       let programDateNo = $('#mangerChangeProgramDateNo').val();
       let managerNo = $('#mangerChangeSelectForm').val();

       $.ajax({
           url: '/api/v1/BranchProgramDate/changeManager',
           type: 'POST',
           contentType : 'application/json',
           data: JSON.stringify({"programDateNo": programDateNo, "managerNo" : managerNo}),
           success: function (response) {
               window.location.reload();
           }
       });
    });

</script>
</body>

</html>