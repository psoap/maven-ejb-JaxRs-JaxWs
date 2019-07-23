<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><c:out value="${news.title}"/></title>
</head>
<body>
<jsp:include page="menu.jsp"/>

<table border="1" style="width: 50%; margin: auto;">
    <tr>
        <td>Title</td>
        <td><c:out value="${news.title}"/></td>
    </tr>
    <tr>
        <td>Date</td>
        <td><c:out value="${news.changeDate}"/></td>
    </tr>
    <tr>
        <td>Brief</td>
        <td><c:out value="${news.brief}"/></td>
    </tr>
    <tr>
        <td>Content</td>
        <td><c:out value="${news.content}"/></td>
    </tr>
    <tr>
        <td>Author</td>
        <td>
            <c:out value="${news.author.username}"/>
        </td>
    </tr>
    <tr>
        <td>
            <a href="<c:url value="/manage/news/edit?id=${news.id}"/>">
                <button>Edit</button>
            </a>
        </td>
        <td>
            <form action="<c:url value="/manage/news/remove"/>" method="post">
                <input type="hidden" name="id" value="${news.id}">
                <button>Delete</button>
            </form>
        </td>
    </tr>
</table>
</body>
</html>