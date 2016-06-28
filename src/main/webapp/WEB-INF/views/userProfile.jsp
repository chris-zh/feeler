<%--@elvariable id="user" type="com.qiandaibaobao.pojo.User"--%>
<%--
  Created by IntelliJ IDEA.
  User: chris.zhang
  Date: 16-6-23
  Time: 下午7:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<div class="page-header">
    <img class="img-rounded profile-thumbnail" src="resources/userImage/${user.avatar}">
    <div class="profile-header">
        <h1>${user.name}</h1>
        <p>注册时间 <span class="" data-timestamp="2016-06-23T09:53:40Z" data-format="format('L')" data-refresh="0"
                      style="">2016-06-23</span>.
            上次登录 <span class="" data-timestamp="2016-06-23T11:15:02Z" data-format="fromNow(0)" data-refresh="0"
                       style="">20 小时前</span>.
        </p>
        <p>发布了${user.posts.size()} 帖子</p>
        <p>
            <a class="btn btn-default" href="user/${user.id}/modify   ">修改个人资料</a>
            <a href="/followers/xh">
                关注者: <span class="badge">0</span>
            </a>
            <a href="/followed-by/xh">
                关注了: <span class="badge">0</span>
            </a>
        </p>
    </div>
</div>