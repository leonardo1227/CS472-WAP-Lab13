<%--
  Created by IntelliJ IDEA.
  User: Leonardo Samuel T C
  Date: 7/12/2018
  Time: 12:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value='/resource/css/styles.css'/>" rel="stylesheet"/>
    <title>Login Page</title>
</head>
<body>
<form method="post">
    <div id="loginBox-div">
        <div>
            <label><c:out value="Username:"/></label>
            <label><c:out value="Password:"/></label>
            <input type="text" name="username"/>
            <input type="password" name="password"/>
        </div>
        <button type="submit">Log In</button>
    </div>
</form>


</body>
</html>
