<%--@elvariable id="username" type="java.lang.String"--%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/15 0015
  Time: 上午 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<label class="control-label" >${username}，请输入新密码</label>
<form method="post" action="change-password">
    <input type="hidden" name="username" value="${username}">
    <input type="password" name="newPassword" placeholder="新密码">
    <button type="submit">提交</button>
</form>
