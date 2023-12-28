<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<c:set var="path" value="${pageContext.request.contextPath}" /><!-- request.getContextPath 간소화 -->
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Login</title>
    <!-- 부트스트랩 CSS 링크 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- 추가적인 스타일링을 위한 CSS 파일 -->
    <link rel="stylesheet" th:href="@{/css/customerLogin.css}">
</head>

<script>
    $(document).ready(function() {
        var msg = "${msg}";
        if (msg.trim() !== "") {
            alert(msg);
        }
    });
</script>

<body class="bg-light">

<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-md-6">
            <div class="card shadow">
                <div class="card-header bg-primary text-white">
                    <h2 class="text-center">Login</h2>
                </div>
                <div class="card-body">
                    <form action="${path}/customer/login" method="post">
                        <div class="form-group">
                            <label for="username">Username</label>
                            <input type="text" id="customerId" name="customerId" class="form-control" required autofocus>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" id="customerPw" name="customerPw" class="form-control" required>
                        </div>
                        <button type="submit" class="btn btn-info btn-block">Login</button>
                        
                        <a href="${path}/customer/signup" class="btn btn-success btn-block">회원가입</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 부트스트랩 JS 및 jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>