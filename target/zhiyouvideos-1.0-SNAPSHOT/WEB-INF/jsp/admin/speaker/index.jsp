<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- created by zhouyanchao on 2017年7月11日 下午5:04:04 --%>    
<!DOCTYPE html>
<html>
<head>
<base href="${BaseContext }">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主讲人列表 - 课程管理</title>
<<<<<<< HEAD
<link href="<c:url value="/static/css/bootstrap.min.css"/>" rel="stylesheet">
=======
<link href="static/css/bootstrap.min.css" rel="stylesheet">
>>>>>>> b2d078bd85813ed6429705882eca18a45c0751ab
</head>
<body>
	<!-- 引入公用的导航信息 -->
	<jsp:include page="../header.jsp">
		<jsp:param value="speaker" name="fromJsp"/>
	</jsp:include>
	<%-- <%@include file="" %> --%>

	<div class="container">
		<div class="jumbotron">
  			<h2>主讲人列表 - 主讲人管理</h2>
		</div>
		<div class="row"><a href="admin/speaker/add.do" class="btn btn-primary">添加主讲人</a>
		<div style="float: right;">
			<form class="form-inline" action="admin/speaker/index.do" method="post">
			  <div class="form-group">
			    <label for="exampleInputName2">名称</label>
			    <input type="text" class="form-control" name="queryName" id="exampleInputName2" value="${queryName }" placeholder="主讲人名称">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputEmail2">职位</label>
			    <input type="text" class="form-control" name="queryJob" id="exampleInputEmail2" value="${queryJob }" placeholder="主讲人职位">
			  </div>
			  <button type="submit" class="btn btn-primary">查询</button>
			</form>
		</div>
		</div>
		<table class="table table-hover">
 			<thead>
 				<tr>
 					<th>序号</th>
 					<th>名称</th>
 					<th>职位</th>
 					<th>简介</th>
 					<th>编辑</th>
 					<th>删除</th>
 				</tr>
 			</thead>
 			<tbody>
<<<<<<< HEAD
 				<c:if test="${not empty list}">
 					<c:forEach items="${list}" var="sp" varStatus="i">
		 				<tr>
		 					<td>${i.index+1 }</td>
		 					<td>${sp.speaker_name}</td>
		 					<td>${sp.speaker_job}</td>
		 					<td>${sp.speaker_descr}</td>
=======
 				<c:if test="${not empty pageInfo }">
 					<c:forEach items="${pageInfo.results }" var="sp" varStatus="i">
		 				<tr>
		 					<td>${i.index+1 }</td>
		 					<td>${sp.speakerName }</td>
		 					<td>${sp.speakerJob }</td>
		 					<td>${sp.speakerDescr}</td>
>>>>>>> b2d078bd85813ed6429705882eca18a45c0751ab
		 					<td><a href="admin/speaker/edit.do?id=${sp.id }"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
		 					<td><a href="admin/speaker/delete.do?id=${sp.id }"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
		 				</tr>
	 				</c:forEach>
 				</c:if>
<<<<<<< HEAD
 				<c:if test="${empty list }">
=======
 				<c:if test="${empty pageInfo }">
>>>>>>> b2d078bd85813ed6429705882eca18a45c0751ab
 					<tr><td>当前查询结果为空!</td></tr>
 				</c:if>
 			</tbody>
		</table>
	
		<jsp:include page="../page.jsp"></jsp:include>
	</div>

	<form id="pageForm" action="admin/speaker/index.do" method="post">
		<input type="hidden" name="queryName" value="${queryName }">
		<input type="hidden" name="queryJob" value="${queryJob }">
		<input type="hidden" name="pageNum" value="${pageNum }" id="queryPage">
	</form>

<<<<<<< HEAD
<script src="<c:url value="/static/js/jquery-1.12.4.min.js"/> "></script>
=======
<script src="static/js/jquery-1.12.4.min.js"></script>
>>>>>>> b2d078bd85813ed6429705882eca18a45c0751ab
<script type="text/javascript">
	//翻页提交
	function queryPage(page){
		$('#queryPage').val(page);
		$('#pageForm').submit();
	}

</script>

</body>
</html>