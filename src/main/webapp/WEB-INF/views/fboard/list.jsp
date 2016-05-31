<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board list</title>
</head>
<body>
	<a href="<c:url value='/fboard/addForm'/>">추가</a>
	<table border ="1">
	<tr>
		<th>NUM</th>
		<th>제목</th>
		<th>작성자</th>
		<th>가입일</th>
		<th>추천</th>
		<th>조회</th>
	</tr>
	<c:forEach items="${list}" var="fboard">
		<tr>
		<td>${fboard.num }</td>
		<td><a href="/fboard/${fboard.num}">${fboard.title}</a></td>
		<td>${fboard.id}</td>
		<td>${fboard.register}</td>
		<td>${fboard.recom}</td>
		<td>${fboard.hit}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>