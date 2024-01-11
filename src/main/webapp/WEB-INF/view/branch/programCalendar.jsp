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
                            <h4>주간 프로그램 캘린더 (${sessionScope.loginEmployee.branchName})</h4>
                            <div class="asset-inner">
                                <table>
                                    <tbody><tr>
                                        <th>날짜</th>
                                        <th>날짜명</th>
                                        <th>프로그램</th>
                                        <th>담당트레이너</th>
                                        <th>예약현황</th>
                                    </tr>
                                    <c:forEach var="programDate" items="${calendar.programDateList}">
                                    <tr>
                                        <td name="date" style="width: 200px; ${programDate.isToday?"background: linear-gradient(to top, #93DAFF 100%, transparent 50%); font-weight: bold;" : null}">${programDate.date}</td>
                                        <td>${programDate.dateName} ${programDate.isHoliday eq true ? "(공휴일)" : null}</td>
                                        <td>
                                            <c:if test="${programDate.programName ne null}">
                                            <button class="pd-setting" name="programName">${programDate.programName}</button>
                                            </c:if>
                                        </td>
                                        <td>${programDate.trainerEmployeeNo ne 0? programDate.managerName : null}</td>
                                        <td>${programDate.reservedCount}/${programDate.maxCustomer} 명</td>
                                    </tr>
                                    </c:forEach>
                                    </tbody></table>
                            </div>
                            <div class="custom-pagination">
                                <nav aria-label="Page navigation example">
                                    <ul class="pagination">
                                        <li class="page-item"><a class="page-link" href="/branch/programCalendar/${calendar.previousWeekDate}">Previous</a></li>
                                        <li class="page-item"><a class="page-link" href="/branch/programCalendar/${calendar.nextWeekDate}">Next</a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                        <div class="row mg-t-30">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                                <div class="profile-info-inner">
                                    <div class="profile-img">
                                        <img id="programImage" src="/branch/branchHome.png" alt="" style="width: 500px; height: 500px;" >
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
                                                                    <h5>프로그램 예약고객/ 출석</h5>
                                                                    <div>
                                                                        <table class="table">
                                                                            <thead>
                                                                                <tr>
                                                                                    <th>번호</th>
                                                                                    <th>고객번호</th>
                                                                                    <th>고객이름</th>
                                                                                    <th>예약번호</th>
                                                                                    <th>입실</th>
                                                                                    <th>퇴실</th>
                                                                                </tr>
                                                                            </thead>
                                                                            <tbody id="customerAttendanceTableBody">
                                                                            </tbody>
                                                                        </table>
                                                                    </div>
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
                                                                        <div id="attendanceProgressBar" style="width: 0%;" class="progress-bar progress-green"></div>
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
                                                            <div class="col-lg-4">
                                                            </div>
                                                            <div class="col-lg-4">
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
</div>
<!-- 본문 종료 -->
<jsp:include page="/WEB-INF/view/branch/include/body-lower-layout.jsp"/>
<script>
    const BRANCH_NO = ${sessionScope.loginEmployee.branchNo};
    /*프로그램 상세보기*/
    $('button[name="programName"]').click(function () {
        let date = $(this).closest('tr').find('td[name="date"]').text();
        $.ajax({
            url: '/api/v1/programDate/'+date,
            type: 'GET',
            data: {branchNo : BRANCH_NO},
            success: function (responsePrgram) {
                console.log(responsePrgram);
                $('#date').text("").text(responsePrgram.date);
                $('#employeeName').text("").text(responsePrgram.employeeName);
                $('#address').text("").text(responsePrgram.address);
                $('#endDate').text("").text(responsePrgram.endDate);
                $('#managerName').text("").text(responsePrgram.managerName);
                $('#programImage').attr('src','').attr('src','/upload/program/'+responsePrgram.programImageFile)
                $('#programDetail').text("").text(responsePrgram.programDetail);
                $('#programName').text("").text(responsePrgram.programName);
                $('#managerPhone').text("").text(responsePrgram.managerPhone);
                $('#startDate').text("").text(responsePrgram.startDate);
                let reservedCount = responsePrgram.reservedCount;
                let maxCustomer = responsePrgram.maxCustomer;
                let reservedProgress = reservedCount/maxCustomer *100;
                $('#reservedProgressBar').css('width',reservedProgress+'%');
                $('#mangerChangeProgramDateNo').val("").val(responsePrgram.programDateNo);
                $('#mangerChangeSelectForm').html("");
                $.ajax({
                    url: '/api/v1/employee',
                    type: 'GET',
                    data: {branchNo : BRANCH_NO},
                    success: function (responseManager) {
                        $(responseManager).each(function (index, item) {
                            $('#mangerChangeSelectForm').append('<option value="'+item.employeeNo+'">'+item.employeeName+'</option>');
                        });
                    }
                });
                updateCustomerAttendanceList(responsePrgram.programDateNo);
            }
        });
    });
    /*출석리스트 업데이트*/
    function updateCustomerAttendanceList(programDateNo) {
        $.ajax({
            url: '/api/v1/customerAttendance/'+programDateNo,
            type: 'get',
            data: {branchNo : BRANCH_NO},
            success: function (response){
                let numberOfReservation = response.length;
                let numberOfAttendance = 0;
                response.forEach(function (item){
                    if(item.enterTime != "undefined" && item.enterTime != null && item.enterTime != ""){
                        numberOfAttendance++;
                    }
                });
                console.log(numberOfAttendance,numberOfReservation);
                let attendanceRate = numberOfAttendance/numberOfReservation * 100;
                $('#attendanceProgressBar').css('width','0%').css('width',attendanceRate+'%');

                let list = $('#customerAttendanceTableBody');
                list.html('');
                $(response).each(function (index, item) {
                   list.append(
                       '<tr><td>'+(index+1)+'</td><td name="customerNo">'+item.customerNo+'</td><td>'+item.customerName+'</td><td name="programReservationNo">'+item.programReservationNo+'</td>'+undefinedEnterExitHandler(item.enterTime,item.exitTime)+'</tr>'
                   );
                });
                $("button[name='recordEnterTimeButton']").on("click", function (){
                    let programReservationNo = $(this).closest('tr').find('td[name="programReservationNo"]').text();
                    console.log(programReservationNo);
                    $.ajax({
                        url: '/api/v1/customerAttendance/enter',
                        type: 'GET',
                        data: {programReservationNo : programReservationNo},
                        success: function (response){
                            updateCustomerAttendanceList(programDateNo);
                        }
                    });

                });
                $("button[name='recordExitTimeButton']").on("click", function (){
                    let programReservationNo = $(this).closest('tr').find('td[name="programReservationNo"]').text();
                    console.log(programReservationNo);
                    $.ajax({
                        url: '/api/v1/customerAttendance/exit',
                        type: 'GET',
                        data: {programReservationNo : programReservationNo},
                        success: function (response){
                            updateCustomerAttendanceList(programDateNo);
                        }
                    });

                });
            }
        });
    }

    function undefinedEnterExitHandler(enter, exit){
        let str;
        if(typeof enter == "undefined" || enter == null || enter == "") {
            str = '<td><button name="recordEnterTimeButton" type="button">입실처리</button></td><td>-</td>';
        }else if(typeof exit == "undefined" || exit == null || exit == ""){
            str = '<td>'+enter+'</td><td><button name="recordExitTimeButton" type="button">퇴실처리</button></td>';
        }else {
            str = '<td>'+enter+'</td><td>'+exit+'</td>';
        }
        return str ;
    }


    function undefinedEnterHandler(str){
        if(typeof str == "undefined" || str == null || str == "")
            str = '<button name="recordEnterTimeButton" type="button">입실처리</button>' ;

        return str ;
    }



    /*매니저변경*/
    $('#changeManagerButton').click(function () {
       let programDateNo = $('#mangerChangeProgramDateNo').val();
       let managerNo = $('#mangerChangeSelectForm').val();

       $.ajax({
           url: '/api/v1/programDate/changeManager',
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