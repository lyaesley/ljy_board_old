
<%@ page language= "java" contentType ="text/html; charset=UTF-8" pageEncoding ="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>Hello world!</h1>
    <h2>${model.sMessage}</h2>
    <P>The time on the server is ${model.serverTime}.</P>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>이름</th>
            <th>가입일</th>
        </tr>
        <c:forEach var="m" items="${model.rs}">
            <tr>
                <td><c:out value="${m.id}"/></td>
                <td><c:out value="${m.name}"/></td>
                <td><c:out value="${m.register}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>