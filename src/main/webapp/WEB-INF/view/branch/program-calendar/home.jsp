<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 정인호
  Date: 2023-12-26
  Time: 오전 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
                            <div class="add-product">
                                <a href="add-department.html">Add Departments</a>
                            </div>
                            <div class="asset-inner">
                                <table>
                                    <tbody><tr>
                                        <th>날짜</th>
                                        <th>날짜명</th>
                                        <th>프로그램</th>
                                        <th>담당트레이너</th>
                                        <th>예약현황</th>
                                        <th>출석현황</th>
                                        <th>No. of Students</th>
                                        <th>Setting</th>
                                    </tr>
                                    <c:forEach var="branchDate" items="${calendar.branchDateList}">
                                    <tr>
                                        <td name="date">${branchDate.date}</td>
                                        <td>${branchDate.dateName} ${branchDate.isHoliday eq true ? "(공휴일)" : null}</td>
                                        <td>
                                            <c:if test="${branchDate.programName ne null}">
                                            <button class="pd-setting" name="programName">${branchDate.programName}</button>
                                            </c:if>
                                        </td>
                                        <td>(${branchDate.managerNo}) ${branchDate.managerName}</td>
                                        <td>${branchDate.reservedCount}/${branchDate.maxCustomer} 명</td>
                                        <td>20/30 명</td>
                                        <td>1500</td>
                                        <td>
                                            <button data-toggle="tooltip" title="" class="pd-setting-ed" data-original-title="Edit"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>
                                            <button data-toggle="tooltip" title="" class="pd-setting-ed" data-original-title="Trash"><i class="fa fa-trash-o" aria-hidden="true"></i></button>
                                        </td>
                                    </tr>
                                    </c:forEach>
                                    </tbody></table>
                            </div>
                            <div class="custom-pagination">
                                <nav aria-label="Page navigation example">
                                    <ul class="pagination">
                                        <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                                        <li class="page-item"><a class="page-link" href="#">Next</a></li>
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
                                                    <p><b>시작일</b><br> <span id="startDate">2023-01-01</span></p>
                                                </div>
                                            </div>
                                            <div class="col-lg-6 col-md-12 col-sm-12 col-xs-6">
                                                <div class="address-hr tb-sm-res-d-n dps-tb-ntn">
                                                    <p><b>종료일</b><br><span id="endDate">2023-01-01</span></p>
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
                                        <div class="row">
                                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                                <div class="address-hr">
                                                    <a href="#">지점 총 예약</a>
                                                    <h3>500</h3>
                                                </div>
                                            </div>
                                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                                <div class="address-hr">
                                                    <a href="#">전국 총 예약</a>
                                                    <h3>900</h3>
                                                </div>
                                            </div>
                                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                                <div class="address-hr">
                                                    <a href="#">인기도</a>
                                                    <h3>600</h3>
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
                                                                    <p><b>지점장</b><br>가산지점장이름</p>
                                                                </div>
                                                            </div>
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
                                                                    <p><b>지점주소</b><br> <span id="address">가산로1길39 km 타워 2층 201호</span></p>
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
                                                                        <div style="width: 90%;" class="progress-bar progress-yellow"></div>
                                                                    </div>
                                                                </div>
                                                                <div class="progress-skill">
                                                                    <h2>출석현황</h2>
                                                                    <div class="progress progress-mini">
                                                                        <div style="width: 80%;" class="progress-bar progress-green"></div>
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
    </div>
</div>
<!-- 본문 종료 -->
<jsp:include page="/WEB-INF/view/branch/include/body-lower-layout.jsp"/>
<script>
    $.ajax({
        url: '/api/v1/branch/${calendar.branchNo}',
        type: 'GET',
        success: function (response){
            $('#branchName').html(response.branchName + '지점');
        }
    });

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
                $('#date').text(response.date);
                $('#employeeName').text(response.employeeName);
                $('#address').text(response.address);
                $('#endDate').text(response.endDate);
                $('#managerName').text(response.managerName);
                $('#programDetail').text(response.programDetail);
                $('#programName').text(response.programName);
                $('#managerPhone').text(response.managerPhone);
                $('#startDate').text(response.startDate);
            }
        });
    });

</script>
</body>

</html>