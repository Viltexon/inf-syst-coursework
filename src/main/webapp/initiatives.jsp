<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Initiatives</title>
</head>
<body>

    <a href="${pageContext.request.contextPath}/propose">Add Initiative</a><br>
    <a href="${pageContext.request.contextPath}/reports">View Reports</a><br>

    <c:forEach items="${Initiatives}" var="initiative">
        <table border="1">
        <%-- initiative.countVotes() --%>
            <td>${initiative.getName()}</td>
            <td>${initiative.getDescription()}</td>
            <td>${initiative.getUser_id()}</td>
            <td>${initiative.getVoting_days_left()}</td>
            <td>${initiative.getImplem_start_date()}</td>
            <td>${initiative.getBudget()}</td>
            <td>${initiative.getVotes_num()}</td>
            <td>${initiative.getStatus()}</td>
        </table>
    </c:forEach>

</body>
</html>