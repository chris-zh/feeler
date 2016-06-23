<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<div class="container">
    <div class="page-header">
        <div class="alert alert-warning">${message}</div>
    </div>
    <div class="form-group  required">
        <label class="control-label">有什么新鲜事想告诉大家? </label>
        <form action="post" method="post">
            <input type="text" name="title" placeholder="标题"/>
            <textarea name="content" class="form-control" id="content"></textarea>
            <button type="submit" class="btn btn-default">发布</button>
        </form>
    </div>
    <div>
        <ul class="posts">
            <c:forEach var="post" items="${posts}">
                <li class="post">
                    <div class="post-content f-wordbreak">
                        <div class="post-date"><span class="" data-timestamp="2016-06-23T09:56:07Z"
                                                     data-format="fromNow(0)" data-refresh="0"
                                                     style="">${post.getStringCreateTime()}</span></div>
                        <div class="post-author"><a href="user/${post.authorId}">${post.authorId}</a> ${post.title}</div>
                        <div class="post-body">
                            <p>${post.content}</p>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>