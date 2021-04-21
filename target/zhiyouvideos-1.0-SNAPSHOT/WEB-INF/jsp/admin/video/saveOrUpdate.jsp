<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- created by zhouyanchao on 2017年7月11日 下午5:04:12 --%>    
<!DOCTYPE html>
<html>
<head>
<base href="${BaseContext }">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>视频添加 - 视频管理</title>
<link href="<c:url value="/static/css/bootstrap.min.css"/> " rel="stylesheet">
<script src="<c:url value="/static/js/bootstrap.min.js"/>"></script>
</head>
<body>

	<jsp:include page="../header.jsp">
		<jsp:param value="video" name="fromJsp"/>
	</jsp:include> 
	<div class="container">
		<div class="jumbotron">
  			<h2>编辑视频信息 - 视频管理</h2>
		</div>
		<div class="row">${message }</div>
<c:if test="${not empty video }">		
<form class="form-horizontal" action="/video/edit.do" method="post">
		<input type="hidden" name="id" value="${video.id }">
</c:if>
<c:if test="${empty video}">
<form class="form-horizontal" action="/video/add.do" method="post">
    </c:if>
  <div class="form-group">
    <label for="${video.video_title}" class="col-sm-2 control-label">视频标题</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="video_title" id="speakerName" value="${video.video_title }" placeholder="视频标题">
    </div>
  </div>
   <div class="form-group">
   <label for="speakerId" class="col-sm-2 control-label">主讲人</label>
   <div class="col-sm-10">
    <select name="speaker_id" id="speakerId"  class="form-control">
    	<option value="0">请选择主讲人</option>
    	<c:forEach items="${speakers}" var="sp">
    		<option <c:if test="${video.speaker_id==sp.id }">selected</c:if> value="${sp.id }">${sp.speaker_name }</option>
    	</c:forEach>
    </select>
    </div>
  </div>
  
  <div class="form-group">
  <label for="courseId" class="col-sm-2 control-label">所属课程</label>
  <div class="col-sm-10">
    <select name="course_id"  id="courseId" class="form-control">
    	<option value="0">请选择课程</option>
    	<c:forEach items="${courses}" var="c">
    		<option  <c:if test="${video.course_id==c.id }">selected</c:if>  value="${c.id }">${c.course_name }</option>
    	</c:forEach>
    </select>
    </div>
  </div>
  <div class="form-group">
    <label for="videoLength" class="col-sm-2 control-label">视频时长</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" name="video_length" id="videoLength" value="${video.video_length }" placeholder="视频时长(秒)">
    </div>
  </div>
  <div class="form-group">
    <label for="videoImageUrl" class="col-sm-2 control-label">封面图片</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="video_image_url" id="videoImageUrl" value="${video.video_image_url }" placeholder="视频封面图片地址，网络图片">
    </div>
  </div>
  <div class="form-group">
    <label for="videoUrl" class="col-sm-2 control-label">视频播放地址</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="video_url" id="videoUrl" value="${video.video_url }" placeholder="视频播放地址，网络地址">
    </div>
  </div>
  <div class="form-group">
    <label for="videoDescr" class="col-sm-2 control-label">视频简介</label>
    <div class="col-sm-10">
      <textarea class="form-control" name="video_descr" id="videoDescr" rows="3">${video.video_descr }</textarea>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn  btn-primary">保存</button>
      <a href="/video/list.do" class="btn btn-default">返回列表</a>
    </div>
  </div>
</form>
	
	</div>


</body>
</html>