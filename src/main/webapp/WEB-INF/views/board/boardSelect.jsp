<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board } Select</h1>
	<p>제목: ${noticeDTO.title }</p>
	<p>작성자: ${noticeDTO.writer }</p>
	<p>내용: ${noticeDTO.contents }</p>
	<p>작성일: ${noticeDTO.reg_date }</p>
	<p>hit: ${noticeDTO.hit }</p>
	
	
	<a href="./${board}List">go Notice List</a>
	<a href="./${board}Update?num=${noticeDTO.num}">Update</a>
	<a href="./${board}Delete?num=${noticeDTO.num}">Delete</a>
</body>
</html>