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
    <!-- Latest compiled and minified CSS -->
</head>

<body>
<jsp:include page="/WEB-INF/view/branch/include/body-upper-layout.jsp"/>
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
                        <li class="active"><a href="#description">지점물품발주</a></li>
                    </ul>
                    <div id="myTabContent" class="tab-content custom-product-edit">
                        <div class="product-tab-list tab-pane fade active in" id="description">
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <div class="review-content-section">
                                        <div id="dropzone1" class="pro-ad addcoursepro">
                                            <form action="/branch/sportsEquipment/order" method="post"
                                                  class="dropzone dropzone-custom needsclick add-professors dz-clickable"
                                                  id="demo1-upload">
                                                <div class="row">
                                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                        <div class="form-group">
                                                            <label>발주자직원번호</label> <%-- 서버 고정값 --%>
                                                            <input name="employeeOrderer"
                                                                   value="${sessionScope.loginEmployee.employeeNo}"
                                                                   type="text"
                                                                   readonly="readonly" class="form-control">
                                                        </div>
                                                        <div>
                                                            <label>발주자 이름</label>
                                                            <input value="${sessionScope.loginEmployee.employeeName}"
                                                                   type="text"
                                                                   readonly="readonly" class="form-control">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>발주지점(번호)</label>
                                                            <input name="branchNo"
                                                                   value="${sessionScope.loginEmployee.branchNo}"
                                                                   type="text" readonly="readonly" class="form-control">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>발주지점</label>
                                                            <input value="${sessionScope.loginEmployee.branchName}"
                                                                   type="text" readonly="readonly" class="form-control">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>발주물품(번호)</label> <%-- 클라이언트 선택, 서버선택지 제공 --%>
                                                            <select id="sportsEquipmentSelectForm"
                                                                    name="sportsEquipmentNo" class="form-control">
                                                                <option value="">선택</option>
                                                            </select>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>수량</label> <%-- 클라이언트 입력--%>
                                                            <input id="quantity" name="quantity" value="1" type="number"
                                                                   class="form-control" placeholder="">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>단가</label> <%-- 발주번호 선택시 자동부여--%>
                                                            <input id="itemPrice" value="0" type="number"
                                                                   class="form-control"
                                                                   placeholder="" readonly="readonly">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>총발주금액</label>
                                                            <input id="totalPrice" value="0" type="number"
                                                                   class="form-control"
                                                                   placeholder=""
                                                                   readonly="readonly">
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                        <div class="form-group">
                                                            <label>승인권자(번호)</label> <%-- 클라이언트 선택, 서버 선택지제공--%>
                                                            <select id="employeeApproverSelectForm"
                                                                    name="employeeApprover" class="form-control">
                                                            </select>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>물품사진</label> <%-- 물품 선택시 갱신--%>
                                                            <br><img id="sportsEquipmentImage" src="/img/about-us.jpg" height="200" width="200">
                                                        </div>

                                                        <div class="form-group edit-ta-resize">
                                                            <label>물품 정보</label> <%-- 물품 선택시 갱신--%>
                                                            <textarea id="note" readonly="readonly"></textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-lg-12">
                                                        <div>
                                                            <c:forEach var="fieldErrorMessage"
                                                                       items="${fieldErrorMessageList}">
                                                                <c:out value="${fieldErrorMessage}"/><br>
                                                            </c:forEach>
                                                            <c:if test="${param.get('serverMessage') eq 'success'}">
                                                                <c:out value="발주가 완료되었습니다."/>
                                                            </c:if>
                                                            <c:if test="${param.get('serverMessage') eq 'fail'}">
                                                                <c:out value="발주가 실패했습니다. 시스템 관리자에게 문의바랍니다"/>
                                                            </c:if>
                                                        </div>
                                                        <div class="payment-adress">
                                                            <button type="submit"
                                                                    class="btn btn-primary waves-effect waves-light">
                                                                발주요청
                                                            </button>
                                                        </div>
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
<jsp:include page="/WEB-INF/view/branch/include/body-lower-layout.jsp"/>
<script>
    /*발주 승인권자 선택지*/
    $.ajax({
        url: '/api/v1/employee?isHeadOffice=true',
        type: 'GET',
        success: function (response) {
            console.log(response);
            $(response).each(function (index, employee) {
                $('#employeeApproverSelectForm')
                    .append('<option value="' + employee.employeeNo + '">' + '(' + employee.employeeNo + ')' + employee.employeeName + '</option>');
            });
        }
    });

    /*물품 선택지*/
    $.ajax({
        url: '/api/v1/sportsEquipment',
        type: 'GET',
        success: function (response) {
            console.log(response);
            $(response).each(function (index, item) {
                $('#sportsEquipmentSelectForm')
                    .append('<option value="' + item.sportsEquipmentNo + '">' + '(' + item.sportsEquipmentNo + ')' + item.itemName + '</option>');
            });
        }
    });

    /*가격 갱신*/
    $('#sportsEquipmentSelectForm').change(function () {
        let selectedItem = $('#sportsEquipmentSelectForm').val();
        $.ajax({
            url: '/api/v1/sportsEquipment/' + selectedItem,
            type: 'GET',
            success: function (response) {
                console.log(response);
                $('#itemPrice').val(response.itemPrice);
                let itemPrice = $('#itemPrice').val();
                let quantity = $('#quantity').val();
                $('#totalPrice').val(itemPrice * quantity);
                $('#note').val(response.note);
            },
            error: function () {
                $('#itemPrice').val(0);
                let itemPrice = $('#itemPrice').val();
                let quantity = $('#quantity').val();
                $('#totalPrice').val(itemPrice * quantity);
                $('#note').val("");
            }
        });
        $.ajax({
            url: '/api/v1/sportsEquipmentImage/' + selectedItem,
            type: 'GET',
            success: function (response) {
                $('#sportsEquipmentImage').attr('src','/upload/equipment/'+response);
            }
        });
    });

    /*총발주금액 갱신*/
    $('#quantity').change(function () {
        let itemPrice = $('#itemPrice').val();
        let quantity = $('#quantity').val();
        $('#totalPrice').val(itemPrice * quantity);
    });
</script>
</body>

</html>