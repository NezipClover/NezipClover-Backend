<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- jstl 사용하기 위한 코드 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<div class="col-xl col-lg">
	<div class="card shadow mb-4 h-100">
		<!-- Card Header - Dropdown -->
		<div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
			<a  data-toggle="collapse" href="#main_list"  aria-expanded="false" aria-controls="main_list" class="m-0 font-weight-bold text-primary">관심지역 목록</a>
			<!-- <h6 class="m-0 font-weight-bold text-primary">관심지역 목록</h6>  -->
		</div>
		<!-- Card Body -->
		<div id="main_list" class="card-body collapse show" style="width: 100%; height: 300px; overflow: auto">
			<c:choose> 
				<c:when test="${empty bookmarks}">
					<!-- if: 관심지역이 없다면, -->
					<div class="text-center small " id="info">
						<span class="mr-2"> 
							<i class="fas fa-circle text-secondary"></i>
							관심지역 목록이 존재하지 않습니다.<br> 관심지역을 등록해주세요.
						</span>
					</div>			
				</c:when> 
				<c:otherwise> 
					<!-- else -->
					<table id="bookmark_list" width="100%" class="table">
						<tr>
							<th>시/도</th>
							<th>구/군</th>
							<th>동</th>
							<th>삭제</th>
						</tr>
						<c:forEach items='${bookmarks}' var='bookmark'>
							<tr>
								<td>${bookmark.sidoName}</td>
								<td>${bookmark.gugunName}</td>
								<td>${bookmark.dongName}</td>
								<td>
									<a id="deleteBtn" class="btn btn-secondary btn-sm" href="delete.bookmark?dongCode=${bookmark.dongCode}" role="button">삭제</a>
								<!-- <input type="checkbox" name="bookmark" value="${bookmark.dongCode}">  -->
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
	
