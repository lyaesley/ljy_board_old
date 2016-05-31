<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User ${user.name }</title>
</head>
<body>
${user.num } | ${user.id } | ${user.password } | ${user.name } |${user.register }
<a href="/user/update/${user.num}">Update</a>
<a href="/user/delete/${user.num}">Delete</a>
</body>
</html>