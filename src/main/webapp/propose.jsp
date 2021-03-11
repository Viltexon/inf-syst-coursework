<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>java</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/propose" method="post">
        <label for="name">Name: </label>
        <input required type="text" name="name" id="name"><br>

        <label for="description">Description: </label>
        <input required type="text" name="description" id="description"><br>

        <label for="budget">Budget: </label>
        <input required type="number" name="budget" id="budget"><br>

        <input required type="submit" value="Save">
    </form>
</body>
</html>
