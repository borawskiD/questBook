<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>
<head>
    <title>QuestBook</title>
    <link rel="stylesheet" href="style.css" />
</head>
<body>
<header>
    <h1>GuestBook - send your thoughts!</h1>
</header>
<br/>
<section id="questForm">
    <form method="post" action="saveThoughts">
        <input type="text" name="name" placeholder="Leave your name"/>
        <br />
        <textarea name="context" placeholder="Write something..."></textarea>
        <br />
        <button>Send</button>
    </form>

</section>
<% System.out.println(request.getAttribute("notes"));%>
<container id="noteDisplay">
<c:forEach var="note" items="${requestScope.notes}">

        <section class="test">
            <p class="date">${note.time.toLocalDateTime()}</p>
            <h2>${note.name}</h2>
             <c:out value="${note.context}"/>
        </section>

</c:forEach>
</container>


</body>
</html>