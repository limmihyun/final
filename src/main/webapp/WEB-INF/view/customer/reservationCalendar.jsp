<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GD HEALTH</title>
</head>
<body>

		<input type="hidden" id="targetYear" value="${calendarMap.targetYear}">
	 	<input type="hidden" id="targetMonth" value="${calendarMap.targetMonth}">
		<input type="hidden" id="targetDay" value="${calendarMap.targetDay}">

		<div align="center">
			<h1> ${calendarMap.targetMonth + 1} 월</h1>
		</div>
		<div style="text-align: left; position: relative;">
		    <p style="margin-top:50px;">${calendarMap.targetYear} 년</p>
		    <div style="position: absolute; left: 50%; transform: translateX(-50%);" class="d-flex justify-content-center" align="center" id="calBtn">
		    	<a class="btn btn-primary" href="${pageContext.request.contextPath}/customer/programrs?targetYear=${calendarMap.targetYear}&targetMonth=${calendarMap.targetMonth - 1}">&#60;&nbsp;이전달</a>&nbsp;
		        <a class="btn btn-primary" href="#"  onclick="nextMonth(${calendarMap.targetYear}, ${calendarMap.targetMonth}, ${calendarMap.targetDay})">다음달&nbsp;&#62;</a>	
		    </div>
		</div>
		

		
	
		<br>
		<br>
		<table class="table table-bordered">
			<tr>
				<th style="text-align:center;">SUN</th> 
				<th style="text-align:center;">MON</th>
				<th style="text-align:center;">TUE</th>
				<th style="text-align:center;">WED</th>
				<th style="text-align:center;">THU</th>
				<th style="text-align:center;">FRI</th>
				<th style="text-align:center;">SAT</th>
			</tr>
			<tr>
				<c:forEach var="i" begin="1" end="${calendarMap.totalTd}">
					<c:set var="d" value="${i - calendarMap.beginBlank}"></c:set>
					<td style="width:129.5px; height:82.164px;">
						<c:if test="${d < 1 || d > calendarMap.lastDate}">
							&nbsp;
						</c:if>
						<c:if test="${!(d < 1 || d > calendarMap.lastDate)}">
							<c:if test="${(i%7-1)==0}">
							  <a class="text-danger">${d}</a>
							  <!-- 이번년도가 캘린더의 년도보다 클 경우 -->
							  	 <c:if test="${calendarMap.targetYear < calendarMap.thisYear}">
								 	&nbsp;
								  </c:if>
								  <!-- 이번년도가 캘린더의 년도보다 클 경우의 반대 경우 --> 
								 <c:if test="${!(calendarMap.targetYear < calendarMap.thisYear)}">
								 	 <!-- 이번월이 캘린더의 월보다 클 경우 -->
								  	<c:if test="${calendarMap.targetMonth + 1 < calendarMap.thisMonth}">
								  		&nbsp;
								  	</c:if>							  
								  	<!-- 이번월이 캘린더의 월보다 클 경우의 반대 -->		  								  	
								  	<c:if test="${!(calendarMap.targetMonth + 1 < calendarMap.thisMonth)}">	
								  		<!-- 일이 오늘보다 작을 경우 -->
								  		<c:if test="${d < calendarMap.thisDay}">
								  			&nbsp;
								  		</c:if>			
								  		<!-- 일이 오늘보다 작을 경우의 반대 -->	  	
								  		<c:if test="${!(d < calendarMap.thisDay)}">
										 <c:forEach var="l" items="${resultList}">
										 	<c:set var="sum" value="0"></c:set>		 
										 	<c:if test="${d == l.day}">
										 		<!-- 프로그램 최대 인원수와 예약자수가 같을 경우 -->
									 			<c:if test="${l.cnt == l.programMaxCustomer}">
										 			<a style="color:gray">${l.programName}</a>
										 			<p style="color:gray">${l.cnt} / ${l.programMaxCustomer}</p>
										 		</c:if>
										 		<c:if test="${l.cnt != l.programMaxCustomer}">								 		
												 	<c:forEach var="my" items="${myCalendarList}">
											 			<c:if test="${d == my.day }">
										   					<c:set var="sum" value="1"></c:set>		 
											 			</c:if>
											 			<c:set var="myempty" value="true"></c:set> 								 			
											 		</c:forEach>
											 		
											 		<c:if test="${sum > 0}">
											 			<a style="color:gray">${l.programName}</a>
												 		<p style="color:gray">${l.cnt} / ${l.programMaxCustomer}</p>
											 		</c:if>
											 		
											 		<c:if test="${sum == 0 and myempty}">
											 			<a href="${pageContext.request.contextPath}/customer/prorsone?year=${l.year}&month=${l.month}&day=${l.day}&programName=${l.programName}">${l.programName}</a>
											 			<p>${l.cnt} / ${l.programMaxCustomer}</p>
											 		</c:if>
												 	<c:if test="${l.cnt != l.programMaxCustomer and not myempty}">
												 		<a href="${pageContext.request.contextPath}/customer/prorsone?year=${l.year}&month=${l.month}&day=${l.day}&programName=${l.programName}">${l.programName}</a>
												 		<p>${l.cnt} / ${l.programMaxCustomer}</p>
										 			</c:if>
										 		</c:if>
										 	</c:if>
										  </c:forEach> 
										 </c:if>
									 </c:if>
								</c:if>
							</c:if>
							<c:if test="${!((i%7-1)==0)}">
								${d}
								  <c:if test="${calendarMap.targetYear < calendarMap.thisYear}">
								 		&nbsp;
								  </c:if>
								  <c:if test="${!(calendarMap.targetYear < calendarMap.thisYear)}">
								  	<c:if test="${calendarMap.targetMonth + 1 < calendarMap.thisMonth}">
								  		&nbsp;
								  	</c:if>							  
								  	<c:if test="${calendarMap.targetMonth + 1 == calendarMap.thisMonth}">	
								  		<c:if test="${d < calendarMap.thisDay}">
								  			&nbsp;
								  		</c:if>					  	
								  		<c:if test="${!(d < calendarMap.thisDay)}">
										 <c:forEach var="l" items="${resultList}">
										   <c:set var="sum" value="0"></c:set>		 
										 	<c:if test="${d == l.day}">
									 			<c:if test="${l.cnt == l.programMaxCustomer}">
										 			<a style="color:gray">${l.programName}</a>
										 			<p style="color:gray">${l.cnt} / ${l.programMaxCustomer}</p>
										 		</c:if>
										 		<c:if test="${l.cnt != l.programMaxCustomer}">								 		
												 	<c:forEach var="my" items="${myCalendarList}">
											 			<c:if test="${d == my.day && l.programDateNo == my.programDateNo}">
										   					<c:set var="sum" value="1"></c:set>		 
											 			</c:if>
											 			<c:set var="myempty" value="true"></c:set> 								 			
											 		</c:forEach>
											 		
											 		<c:if test="${sum > 0}">
											 			<a style="color:gray">${l.programName}</a>
												 		<p style="color:gray">${l.cnt} / ${l.programMaxCustomer}</p>
											 		</c:if>
											 		
											 		<c:if test="${sum == 0 and myempty}">
											 			<a href="${pageContext.request.contextPath}/customer/prorsone?year=${l.year}&month=${l.month}&day=${l.day}&programName=${l.programName}">${l.programName}</a>
											 			<p>${l.cnt} / ${l.programMaxCustomer}</p>
											 		</c:if>
											 		
											 		
											 		<!-- 그달에 예약된게 하나도 없는 경우  -->
											 		<c:if test="${l.cnt != l.programMaxCustomer and not myempty}">
											 			<a href="${pageContext.request.contextPath}/customer/prorsone?year=${l.year}&month=${l.month}&day=${l.day}&programName=${l.programName}">${l.programName}</a>
											 			<p>${l.cnt} / ${l.programMaxCustomer}</p>
									 				</c:if>
										 	 </c:if>
										 	</c:if>
										  </c:forEach> 
										 </c:if>
									 </c:if>
									 <c:if test="${calendarMap.targetMonth + 1 > calendarMap.thisMonth}">
										 <c:forEach var="l" items="${resultList}">
										 <c:set var="sum" value="0"></c:set>		 
											 	<c:if test="${d == l.day}">
										 			<c:if test="${l.cnt == l.programMaxCustomer}">
											 			<a style="color:gray">${l.programName}</a>
											 			<p style="color:gray">${l.cnt} / ${l.programMaxCustomer}</p>
											 		</c:if>
											 		<c:if test="${l.cnt != l.programMaxCustomer}">								 		
												 	<c:forEach var="my" items="${myCalendarList}">
											 			<c:if test="${d == my.day}">
										   					<c:set var="sum" value="1"></c:set>		 
											 			</c:if>
											 			<c:set var="myempty" value="true"></c:set> 								 			
											 		</c:forEach>
											 		
											 		<c:if test="${sum > 0}">
											 			<a style="color:gray">${l.programName}</a>
												 		<p style="color:gray">${l.cnt} / ${l.programMaxCustomer}</p>
											 		</c:if>
											 		
											 		<c:if test="${sum == 0 and myempty}">
											 			<a href="${pageContext.request.contextPath}/customer/prorsone?year=${l.year}&month=${l.month}&day=${l.day}&programName=${l.programName}">${l.programName}</a>
											 			<p>${l.cnt} / ${l.programMaxCustomer}</p>
											 		</c:if>
											 		
												 	<c:if test="${l.cnt != l.programMaxCustomer and not myempty}">
												 		<a href="${pageContext.request.contextPath}/customer/prorsone?year=${l.year}&month=${l.month}&day=${l.day}&programName=${l.programName}">${l.programName}</a>
												 		<p>${l.cnt} / ${l.programMaxCustomer}</p>
										 			</c:if>
											 		</c:if>
											 	</c:if>
											  </c:forEach> 
									 </c:if>
								</c:if>
							</c:if>
						</c:if>
						
						<!-- 한행에 7열씩.. -->
						<c:if test="${i < calendarMap.totalTd && i%7 == 0}">
							</tr><tr>
						</c:if>
					</td>
		         </c:forEach>
			</tr>
		</table>
		
		
</body>


</html>