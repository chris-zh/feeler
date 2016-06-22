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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pure-min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/feeler.css"/>
    <link rel="shortcut icon" href="../../resources/img/favicon.ico" type="image/x-icon">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.12.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/feeler.js"></script>
    <title>Title</title>
</head>
<body>
<div class="f-main">
<form action="change-password-init" method="post" id="form" class="pure-form">
    <input type="hidden" name="username" value="${user.name}">
    <span class="pure-form-message f-message">Welcome,  ${user.name}</span>
    <button type="submit" class="pure-button pure-button-primary">修改密码</button>
    <button type="button" id="exit" class="pure-button pure-button-primary">退出</button>
</form>
</div>
<script>
    $("#exit").click(function () {
        var form = $("#form");
        form.attr("action", "logout");
        form.submit();
    })
</script>
</body>
</html>
