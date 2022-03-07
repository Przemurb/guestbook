<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Księga gości</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}\style.css" type="text/css">
</head>
<body>
<h1>Księga gości</h1>
<form method="post" action="">
    <fieldset>
        <legend>Zostaw swój wpis</legend>
        <div>
            <label for="nick">Twój Nick</label>
            <input type="text" name="nick" id="nick" placeholder="Franek Kimono" required>
        </div>
        <div>
            <label for="content">Treść wiadomości</label>
        </div>
        <div>
            <textarea name="content" id="content" placeholder="Napisz coś..." required></textarea>
        </div>
        <button>Wyślij</button>
    </fieldset>
</form>
    <c:if test="${fn:length(requestScope.entries) == 0}">
        <h3>Nie ma jeszcze żadnego wpisu. Dodaj cos od siebie...</h3>
    </c:if>
    <h1>Wasze wpisy</h1>
        <c:forEach var="entry" items="${requestScope.entries}">
            <section class="entry">
                <h3>Autor: <c:out value="${entry.nick}"/></h3>
                <p><c:out value="${entry.content}"/></p>
            </section>
        </c:forEach>
</body>
</html>
