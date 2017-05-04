<%--
  Created by IntelliJ IDEA.
  User: vanki
  Date: 2017/5/2
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/user/login.do" method="post">
    userName:<input type="text" name="userName" value="${user.userName }"/><br/>
    password:<input type="password" name="password" value="${user.password }"><br/>
    <input type="submit" value="login"/><font color="red">${errorMsg }</font>
</form>
</body>
</html>
