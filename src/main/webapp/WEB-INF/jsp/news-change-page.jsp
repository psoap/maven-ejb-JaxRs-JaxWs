<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Change news</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<form method="post">
    <table border="1" style="width: 50%; margin: auto;">
        <tr>
            <td>Title</td>
            <td>
                <input name="title" type="text" value="${not empty news?news.title:''}"/>
            </td>
        </tr>
        <tr>
            <td>Date</td>
            <td>
                <input name="changeDate" type="text" value="${not empty news?news.changeDate:''}"/>
            </td>
        </tr>
        <tr>
            <td>Brief</td>
            <td>
                <input name="brief" type="text" value="${not empty news?news.brief:''}"/>
            </td>
        </tr>
        <tr>
            <td>Content</td>
            <td>
                <input name="content" type="text" value="${not empty news?news.content:''}"/>
            </td>
        </tr>
        <tr>
            <td>Uri</td>
            <td>
                <input name="uri" type="text" value="${not empty news?news.uri:''}"/>
            </td>
        </tr>
        <%--<tr>--%>
            <%--<td>Author</td>--%>
            <%--<td>--%>
                <%--<input disabled="true" name="author.username" type="text"/>--%>
            <%--</td>--%>
        <%--</tr>--%>
        <tr>
            <td>
                <c:url var="saveUrl" value="/manage/news/add"/>
                <c:if test="${not empty news.id}">
                    <input type="hidden" name="id" value="${news.id}"/>
                    <input type="hidden" name="author.id" value="123456"/>
                    <c:url var="saveUrl" value="/manage/news/edit"/>
                </c:if>
                <input type="submit" formaction="${saveUrl}" value="Save"/>
            </td>
            <td>
                <input type="submit" formaction="<c:url value="/"/>" value="Cancel"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
