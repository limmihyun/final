<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<footer class="footer-section set-bg" data-setbg="/img/footer-bg.jpg">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="footer-content">
					<div class="footer-logo">
						<H3 style="color: #ebfcff">GDHEALTH</H3>
					</div>
					<div class="footer-menu">
						<ul>
							<li><a href="/customer/home">home</a></li>
							<li><a href="/customer/programrs">programrs</a></li>
							<li><a href="/customer/franchiseBranch">branch</a></li>
							<li><a href="/question/questionList">q&a</a></li>
							<li><a href="/notice/noticeList">notice</a></li>
							<c:if test="${customerNo eq null}">
								<li><a href="/customer/login">login</a></li>
							</c:if>
							<c:if test="${customerNo ne null}">
								<li><a href="/customer/myPage">mypage</a></li>
								<li><a href="/customer/logout">logout</a></li>
							</c:if>
						</ul>
					</div>

					<div class="footer-icon-img">
						<img src="/img/footer-icon.png" alt="">
					</div>
					<div class="copyright">
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						Copyright &copy;
						<script>
							document.write(new Date().getFullYear());
						</script>
						All rights reserved | This template is made with <i
							class="fa fa-heart-o" aria-hidden="true"></i> by <a
							href="https://colorlib.com" target="_blank">Colorlib</a>
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					</div>
				</div>
			</div>
		</div>
	</div>
</footer>
