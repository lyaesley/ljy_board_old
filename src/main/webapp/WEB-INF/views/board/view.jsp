<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board ${board.title }</title>
</head>
<body>
	<table>
	<tr>
		<th>제목: </th> <td> ${board.title }</td>
	</tr>
	<tr>
		<th>작성자: </th><td>${board.id }</td>
		<th>작성일: </th><td>${board.register }</td>
		<th>조회: </th><td>${board.hit }</td>
		<th>추천: </th><td>${board.recom }</td>
	</tr>
	</table>
		<div>
		${board.content }
		</div>
<a href="/board/update/${board.num}">수정</a>
<a href="/board/delete/${board.num}">삭제</a>
</body>
</html>