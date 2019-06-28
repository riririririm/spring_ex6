<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board }ice Write</h1>
	<form action="./${board }Write" method="post">
		<p>제목 : <input type="text" id="title" name="title"></p>
		<p>작성자 : <input type="text" id="writer" name="writer"></p>
		<p>내용 : <textarea rows="" cols="" id="contents" name="contents"></textarea></p>
		<button>submit</button>
	</form>
</body>
</html>