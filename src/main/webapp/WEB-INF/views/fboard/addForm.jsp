<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Board</title>
</head>
<body>
	<a href="<c:url value='/fboard/list'/>">List</a>
	<form:form commandName="fboard" action="/fboard" method="POST">
		<label>제목</label>
		<form:input path="title"/>
		<label>아이디</label>
		<form:input path="id"/>
		<label>비밀번호</label>
		<form:input path="password"/>
		<label>내용</label>
		<form:input path="content"/>
		<input type="submit" value="등록" />
	</form:form>
</body>
</html>