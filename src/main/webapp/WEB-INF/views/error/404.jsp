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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="shortcut icon" href="../../resources/img/favicon.ico" type="image/x-icon">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.12.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/feeler.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/yui-min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/success.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/Markdown.Converter.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/Markdown.Sanitizer.min.js"></script>
    <title>Page Not Found</title>
</head>
<body>
<div style="width:250px;margin:auto;">
    <img src="${pageContext.request.contextPath}/resources/img/404.jpg">
</div>
<canvas id="canvas"></canvas>
</body>
<script>
    $(      //画背景
            drawBackground()
    )
    $(
            $(".btn-register").click(function () {
                var form;
                form = $(".form-login");
                form.attr("action", "register")
                form.submit()
            })
    )
</script>
</html>
