<%--
  Created by IntelliJ IDEA.
  User: chris.zhang
  Date: 16-6-13
  Time: 下午2:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>欢迎</title>
</head>
<body>
<form action="/register" method="post">
    用户名：<input type="text" name="username"/><br/>
    密码：<input type="password" name="password"/><br/>
    <button type="submit" value="注册">注册</button>
</form>
</body>
</html>
