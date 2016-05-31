<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<c:url value='/user/addForm'/>">추가</a>
	<table border ="1">
	<tr>
		<th>NUM</th>
		<th>ID</th>
		<th>이름</th>
		<th>가입일</th>
	</tr>
	<c:forEach items="${list}" var="user">
		<tr>
		<td><a href="/user/${user.num}">${user.num }</a></td>
		<td>${user.id}</td>
		<td>${user.name}</td>
		<td>${user.register}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>