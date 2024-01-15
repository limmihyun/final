<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<div class="container-fluid">   
       		<h3>물품 목록</h3>
           	<!--------------------- 회원 list start-------------------------->   		  	  				
			    <table class="table table-bordered">
			    	<thead>
			    		<tr>
			    			<th>작성자</th>
			    			<th>물품 이름</th>
			    			<th>물품 가격</th>
			    			<th>비고</th>
			    			<th>활성화 여부</th>
			    			<th>날짜</th>
			    		</tr>
			    	</thead>
			    	<tbody>
			    		<c:forEach var="m" items="${equipmentList}">
			    			<tr>
			    				<td>${m.employeeName}</td>
			    				<td>${m.itemName}</td>
			    				<td>${m.itemPrice}</td>
			    				<td>${m.note}</td>
			    				<c:if test="${m.active == 'Y'}">
			    					<td>활성화</td>
			    				</c:if>
			    				<c:if test="${m.active == 'N'}">
			    					<td>비활성화</td>
			    				</c:if>
		    					<td>${m.createdate}</td>
			    			</tr>
			    		</c:forEach>   
			    	</tbody>
			    </table>
       		        		
            <!--------------------- 회원 list end-------------------------->      
        </div>         
           		<!--------------------- 페이징 start ----------------------------------->     
            <div style="text-align:center;">       	
	             <ul class="pagination">
	             
             	  <c:if test="${currentPage == 1}">
           			<li class="page-item disabled">
            	  		<a class="page-link">처음</a>  	
            	 	</li>	
          		  </c:if>
          		  <c:if test="${currentPage != 1}">
           			<li class="page-item">           	  	
            	  		<a class="page-link pageBtn" data-page="1" href="#">처음</a>
            	 	</li>
           		  </c:if>  
					  
					  <c:if test="${prev}">
					  	<li class="page-item"><a class="page-link pageBtn" data-page="${startPageNum - 1}" href="#">이전</a></li>
					  </c:if>
					  <c:forEach begin="${startPageNum}" end="${endPageNum}" var="pageNum">
					  	<c:if test="${pageNum == currentPage}"> <!-- 페이징 버튼 색 변경o --> 
					  		<li class="page-item active">
						  		<a class="page-link">${pageNum}</a>
						  	</li>
					  	</c:if>
					  	<c:if test="${pageNum != currentPage}"> <!-- 페이징 버튼 색 변경x --> 
					  		<li class="page-item">
						  		<a class="page-link pageBtn" data-page="${pageNum}" href="#">${pageNum}</a>
						  	</li>
					  	</c:if>
					  </c:forEach>
					  <c:if test="${next}">
					  	<li class="page-item"><a class="page-link pageBtn" data-page="${endPageNum + 1}" href="#">다음</a></li>
					  </c:if>	  
					  <c:if test="${currentPage == lastPage}">
					  	<li class="page-item disabled">
					  		<a class="page-link">끝</a>
					  	</li>
					  </c:if>
					  <c:if test="${currentPage != lastPage}">
					  	<li class="page-item">
					  		<a class="page-link pageBtn" data-page="${lastPage}" href="#">끝</a>
					  	</li>
					  </c:if>
				</ul>	  
            </div>
               <!----------------------- 페이징 end ----------------------------> 