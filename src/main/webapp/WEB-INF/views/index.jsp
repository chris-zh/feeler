<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/12 0012
  Time: 下午 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pure-min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/feeler.css"/>
    <link rel="shortcut icon" href="../../resources/img/favicon.ico" type="image/x-icon">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.12.3.min.js"></script>
    <title>欢迎</title>
</head>
<body>

<form action="login" method="post" class="pure-form">
    <div class="f-main">
        <span class="pure-form-message f-message">${message}</span>
        <input type="text" name="username" placeholder="用户名"/>
        <input type="password" name="password" placeholder="密码"/>
        <button type="submit" class="pure-button pure-button-primary">登陆</button>
        <button type="button" class="pure-button pure-button-primary register"><a href="register-init">注册</a></button>
    </div>
</form>
</body>
</html>
