<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhouyc
  Date: 2017/6/30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<header>
	<div class="container top_bar clearfix">
		<img src="/static/img/logo.png" alt="智游">
		<div id="tele">
			<span>4006-371-555</span>
			<span>0371-88888598</span>
		</div>
	</div>
	<menu>
		<div class="container clearfix">
			<ul class="clearfix f_left">
				<li><a href="/index.do">首页</a></li>
				<li class="menu_active"><a href="/front/user/profile.do?nick_name=${user.nick_name}">个人中心</a></li>
			</ul>
			<div id="user_bar">
				<a href="/front/user/avatar.do?nick_name=${user.nick_name}">
					<c:if test="${empty user.head_url}">
						<img id="avatar" src="/static/img/avatar_lg.png" alt="">
					</c:if>

					<c:if test="${not empty user.head_url}">
						<img id="avatar" src="${user.head_url}" alt="">
					</c:if>

				</a>
				<a href="/front/user/logout.do" id="lay_out">退出</a>
			</div>
		</div>
	</menu>
</header>
