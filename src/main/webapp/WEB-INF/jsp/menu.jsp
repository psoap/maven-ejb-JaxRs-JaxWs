<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul>
    <li><a href="<c:url value="/"/>">Home</a></li>
    <c:choose>
        <c:when test="${authorSession.currentAuthor.isPresent()}">
            <li>${authorSession.currentAuthor.get().username}</li>
            <li><a href="<c:url value="/logout"/>">Logout</a></li>
            <li><a href="<c:url value="/manage/news/add"/>">Add news</a></li>
        </c:when>
        <c:otherwise>
            <li><a href="<c:url value="/auth"/>">Login/Reg</a></li>
        </c:otherwise>
    </c:choose>
</ul>
