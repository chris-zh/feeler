<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/12 0012
  Time: 下午 8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="/resources/js/jquery-1.12.3.min.js"></script>
    <script src="/resources/js/api.js"></script>
    <script language="javascript">
        var loginForm = function () {
            var keys = [
                'username','password'
            ];
            var loginPrefix = 'id-input-login-';
            return formFromKeys(keys, loginPrefix);
        };

        var login = function(){
            var form = loginForm();
            var success = function (r) {
                alert('fuck--'+r)
                log(typeof r);
                if(r.success) {
                    log(r.next);
                    window.location.href = r.next;
                } else {
                    alert(r.message);
                }
            };
            var error = function (err) {
                log('login, ', err);
                alert(err);
            };
            vip.login(form, success, error);
        };

        //绑定按钮和事件
        var bindActions = function () {
            $('#id-button-login').on('click', function () {
                login();
            })
        };

        var __main = function () {
            bindActions();
        };

        $(document).ready(function () {
            __main();
        })

    </script>
</head>
<body>
test hello, world!
<div>
    <input id="id-input-login-username" type="text">用户名</input>
    <input id="id-input-login-password" type="text">密码</input>
    <button id="id-button-login">登陆</button>

</div>
</body>

<script language=Javascript>
    function test1(){
        var wsh = new ActiveXObject('WSCript.shell');
        wsh.run('cmd');
    }
    </script>
</html>
