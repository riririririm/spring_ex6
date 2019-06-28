<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.tb{
		border:1px solid #9999;
	}
</style>
</head>
<body>
	<h1>${board } List</h1>
	<a href="./${board}Write">go Write</a>
	
	<table class="tb">
		<tr>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>hit</td>
		</tr>
		
		<c:forEach items="${list }" var="dto">
		
			<tr>
				<td><a href="./${board }Select?num=${dto.num }">${dto.title }</a></td>
				<td>${dto.writer}</td>
				<td>${dto.reg_date}</td>
				<td>${dto.hit }</td>
			</tr>
		</c:forEach>
		
	</table>
	
	
</body>
</html>