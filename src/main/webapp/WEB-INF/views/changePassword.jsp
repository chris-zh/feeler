<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/15 0015
  Time: 上午 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
${username}, 请输入你的新密码!<br/>
<form method="post" action="change-password">
    <input type="hidden" name="username" value="${username}">
    <input type="password" name="newPassword">
    <button type="submit">提交</button>
</form>
</body>
</html>
