<%--@elvariable id="message" type="java.lang.String"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
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
            <%--@elvariable id="posts" type="java.util.List"--%>
            <c:forEach var="post" items="${posts}"><%--@elvariable id="user" type="com.qiandaibaobao.pojo.User"--%>
                <li class="post">
                    <div class="post-thumbnail">
                        <a href="">
                            <img class="img-rounded profile-thumbnail" src="${pageContext.request.contextPath}/resources/userImage/${user.id}/${user.avatarSmall}">
                        </a>
                    </div>
                    <div class="post-content f-wordbreak">
                        <div class="post-date"><span class="" data-timestamp="2016-06-23T09:56:07Z"
                                                     data-format="fromNow(0)" data-refresh="0"
                                                     style="">${post.getStringCreateTime()}</span></div>
                        <div class="post-author"><a href="${pageContext.request.contextPath}/user/${post.authorId}">${user.name}</a> ${post.title}
                        </div>
                        <div class="post-body">
                            <p>${post.content}</p>
                        </div>
                        <div class="post-footer">
                            <a href="post/${post.id}">
                                <span class="label label-default">链接</span>
                            </a>
                            <a href="post/${post.id}/edit">
                                <span class="label label-primary">编辑</span>
                            </a>
                            <a href="post/${post.id}/edit/admin">
                                <span class="label label-danger">编辑 [管理员]</span>
                            </a>
                            <a href="post/${post.id}/comments">
                                 <span class="label label-primary">
                                 ${post.comments.size()} 评论
                                 </span>
                            </a>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>