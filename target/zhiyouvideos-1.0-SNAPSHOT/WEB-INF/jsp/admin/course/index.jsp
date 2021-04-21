<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- created by zhouyanchao on 2017年7月11日 下午5:04:04 --%>    
<!DOCTYPE html>
<html>
<head>
<base href="${BaseContext }">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程列表 - 课程管理</title>
<<<<<<< HEAD
<link href="<c:url value="/static/css/bootstrap.min.css"/>" rel="stylesheet">
<script src="<c:url value="/static/js/bootstrap.min.js"/>"></script>
=======
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<script src="static/js/bootstrap.min.js"></script>
>>>>>>> b2d078bd85813ed6429705882eca18a45c0751ab
</head>
<body>

	<!-- 引入公用的导航信息 -->
	<jsp:include page="../header.jsp">
		<jsp:param value="course" name="fromJsp"/>
	</jsp:include>

	<div class="container">
		<div class="jumbotron">
  			<h2>课程列表 - 课程管理</h2>
		</div>
<<<<<<< HEAD
		<div class="row"><a href="/course/add.do" class="btn btn-primary">添加课程</a></div>
=======
		<div class="row"><a href="admin/course/add.do" class="btn btn-primary">添加课程</a></div>
>>>>>>> b2d078bd85813ed6429705882eca18a45c0751ab
		<table class="table table-hover">
 			<thead>
 				<tr>
 					<th>序号</th>
 					<th>标题</th>
 					<th>学科</th>
 					<th>简介</th>
 					<th>编辑</th>
 					<th>删除</th>
 				</tr>
 			</thead>
 			<tbody>
<<<<<<< HEAD
 			<c:forEach items="${results}" var="co" varStatus="i">
 				<tr>
 					<td>${i.index+1 }</td>
 					<td>${co.course_name }</td>
 					<td>${co.subject_name }</td>
 					<td>${co.course_descr }</td>
=======
 			<c:forEach items="${results }" var="co" varStatus="i">
 				<tr>
 					<td>${i.index+1 }</td>
 					<td>${co.courseName }</td>
 					<td>${co.subjectName }</td>
 					<td>${co.courseDescr }</td>
>>>>>>> b2d078bd85813ed6429705882eca18a45c0751ab
 					<td><a href="admin/course/edit.do?id=${co.id }"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
 					<td><a href="admin/course/delete.do?id=${co.id }"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
 				</tr>
 			</c:forEach>	
 			</tbody>
		</table>
	
	</div>




</body>
</html>