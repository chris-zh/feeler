<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/12 0012
  Time: 下午 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <title>Title</title>
</head>
<body>
<div id="horizontal-menu">
    <ul id="std-menu-items">
        <li class="pure-menu-selected"><a href="#">Flickr</a></li>
        <li><a href="#">Messenger</a></li>
        <li><a href="#">Sports</a></li>
        <li><a href="#">Finance</a></li>
        <li>
            <a href="#">选项</a>
            <ul>
                <li class="pure-menu-heading">用户资料管理</li>
                <li class="pure-menu-separator"></li>
                <li><a href="#">用户档案</a></li>
                <li><a href="change-password">修改密码</a></li>
                <li><a href="logout">退出登录</a></li>
            </ul>
</li>
</ul>
</div>
<jsp:include page="post.jsp" flush="true"/>
<jsp:include page="userProfile.jsp" flush="true"/>
</body>
</html>

