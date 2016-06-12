<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/12 0012
  Time: 下午 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>欢迎</title>
</head>
<body>
${message}
<form action="/login" method="post">
    用户名：<input type="text" name="username"/><br/>
    密码：<input type="password" name="password"/><br/>
    <button type="submit" value="提交">提交</button>
</form>

</body>
</html>
