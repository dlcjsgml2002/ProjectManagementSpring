<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp"%>
		<div class="table-responsive">                        
			<div style="text-align: right;">
				<a href="${pageContext.request.contextPath }/project/register">[새 프로젝트 등록]</a>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>프로젝트 이름</th>
						<th>시작 날짜</th>
						<th>종료 날짜</th>
						<th>상태</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="projectVO" items="${list }">
						<tr>
							<td><a href="${pageContext.request.contextPath }/project/read?serial_number=${projectVO.serial_number}">${projectVO.project_name }</a></td>
							<td><fmt:formatDate value="${projectVO.start_date }" pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${projectVO.end_date }" pattern="yyyy-MM-dd" /></td>
							<td>${projectVO.project_progress }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
<%@ include file="../include/footer.jsp"%>