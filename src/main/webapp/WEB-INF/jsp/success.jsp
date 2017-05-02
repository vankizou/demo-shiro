<%--
  Created by IntelliJ IDEA.
  User: vanki
  Date: 2017/5/2
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>login</title>
</head>
<body>
${info }
欢迎你!
<shiro:hasRole name="admin">
    欢迎有admin角色的用户！<shiro:principal/>
</shiro:hasRole>
<shiro:hasPermission name="student:create">
    欢迎有student:create权限的用户！<shiro:principal/>
</shiro:hasPermission>
</body>
</html>
