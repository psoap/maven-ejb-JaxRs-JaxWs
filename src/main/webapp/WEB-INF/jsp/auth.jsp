<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<form method="post">
    <label>username</label><input name="username" type="text"/>
    <label>password</label><input name="password" type="text"/>
    <input type="submit" formaction="<c:url value="/auth"/>" value="log">
    <input type="submit" formaction="<c:url value="/reg"/>" value="reg">
</form>
</body>
</html>