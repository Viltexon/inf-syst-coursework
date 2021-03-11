<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reports</title>
</head>
<body>

    <c:forEach items="${Reports}" var="report">
        <table border="1">

            <td>${report.getInit_id()}</td>
            <td>${report.getDescription()}</td>
            <td>${report.getImplem_end_date()}</td>
            <td>${report.getEnd_budget()}</td>

        </table>
    </c:forEach>

</body>
</html>