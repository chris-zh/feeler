<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>"></base>
<title>Feeler</title>

<!-- Bootstrap -->
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/feeler.css" rel="stylesheet">
<link rel="shortcut icon" href="static/favicon.ico" type="image/x-icon" /> 

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<jsp:include page="navbar.html"></jsp:include>
	<jsp:include page="success.html"></jsp:include>
</body>
<script src="static/js/jquery-1.12.3.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
</html>