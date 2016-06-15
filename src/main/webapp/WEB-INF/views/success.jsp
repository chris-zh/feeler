<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/12 0012
  Time: 下午 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Welcome,  ${user.name}
<form action="change-password-init" method="post">
    <input type="hidden" name="username" value="${user.name}">
    <button type="submit" >修改密码</button>
</form>
</body>
</html>
