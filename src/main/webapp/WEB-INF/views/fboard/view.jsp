<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board ${fboard.title }</title>
</head>
<body>
	<table>
	<tr>
		<th>제목: </th> <td> ${fboard.title }</td>
	</tr>
	<tr>
		<th>작성자: </th><td>${fboard.id }</td>
		<th>작성일: </th><td>${fboard.register }</td>
		<th>조회: </th><td>${fboard.hit }</td>
		<th>추천: </th><td>${fboard.recom }</td>
	</tr>
	</table>
		<div>
		${fboard.content }
		</div>
<a href="/fboard/update/${fboard.num}">수정</a>
<a href="/fboard/delete/${fboard.num}">삭제</a>
</body>
</html>