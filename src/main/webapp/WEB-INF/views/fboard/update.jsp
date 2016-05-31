<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Board</title>
</head>
<body>
<a href="<c:url value='/fboard/list'/>">목록</a>
<form:form commandName="fboard" action="/fboard/update"  method="POST">	
    <p>
        <label>제목</label>
        <form:input path="title" size="50"/><br>
        <label>내용</label>
        <form:input path="content" size="50"/><br>
    </p>
    <input type="submit" value="저장"/> 
</form:form>
</body>
</html>