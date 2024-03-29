<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">

<title>个人中心</title>
<meta name="keywords" content="个人中心">
<meta name="description" content="个人中心">

<link href="${pageContext.request.contextPath}/static/admin/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/admin/font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet">

<!-- Morris -->
<link href="${pageContext.request.contextPath}/static/admin/css/plugins/morris/morris-0.4.3.min.css?t=322" rel="stylesheet">

<!-- Gritter -->
<link href="${pageContext.request.contextPath}/static/admin/js/plugins/gritter/jquery.gritter.css?t=322" rel="stylesheet">

<link href="${pageContext.request.contextPath}/static/admin/css/animate.css?t=322" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/admin/css/style.css?v=2.2.0" rel="stylesheet">

<c:set var="uri" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
var uri='${uri}';
</script>
<style>
.bodyClass::-webkit-scrollbar {
display: none; /* Chrome Safari */
}
.bodyClass {
scrollbar-width: none; /* firefox */
-ms-overflow-style: none; /* IE 10+ */
overflow-x: hidden;
overflow-y: auto;
}


td >div{
display:inline
}

#batchUpdate{
width:40%
}
video{
width:200px !important;
}
audio{
width:200px !important;
}
</style>
</head>

<body class="bodyClass"  style="background-color:#f3f3f4">

<div class="modal inmodal"  id="bodyModal" tabindex="-1" role="dialog" aria-hidden="true" style="top:80px;left:-200px;">
	<div class="modal-dialog">
		<div class="modal-content animated bounceInRight">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">关闭</span>
				</button>
				<h4 class="modal-title"  id="bodyModalTile"></h4>
			</div>
			<div class="modal-body"  id="bodyModalContent">
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>个人中心</h2>
	</div>
	<div class="col-lg-2">
	</div>
</div>
<div class="gray-bg dashbard-1" style="height:758px">
	<div class="row">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<div class="ibox-tools">
					</div>
				</div>
				<div class="ibox-content">
					<div style="width:80%;margin-left:10%">
						<div class="table-responsive">
							<table class="table  table-striped table-bordered  table-hover">
								<thead>
								</thead>
								<tbody id="detailBody">
									<tr>
										<th width="10%">登录名</th>
										<th width="90%"  >${detail.userMsg.loginName}</th>
									</tr>
									<tr>
										<th width="10%">姓名</th>
										<th width="90%"  >${detail.userMsg.realName}</th>
									</tr>
									<tr>
										<th width="10%">联系电话</th>
										<th width="90%"  >${detail.userMsg.celPhone}</th>
									</tr>
									<tr>
										<th width="10%">生日</th>
										<th width="90%"  >${detail.userMsg.birthday}</th>
									</tr>
									<tr>
										<th width="10%">性别</th>
										<th width="90%"  >${detail.sexStr}</th>
									</tr>
									<tr>
										<th width="10%">地址</th>
										<th width="90%"  >${detail.userMsg.address}</th>
									</tr>
									<tr>
										<th width="10%">用户积分</th>
										<th width="90%"  >${detail.userMsg.userScore}</th>
									</tr>
									<tr>
										<th width="10%">注册时间</th>
										<th width="90%"  >${detail.userMsg.createTime}</th>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="row"  style="margin-top:5px;margin-left:10%">
							<a href="${pageContext.request.contextPath}/user/user_msg/update1?id=${detail.userMsg.id}" class="btn btn-success">修改</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Mainly scripts -->
<script src="${pageContext.request.contextPath}/static/admin/js/jquery-2.1.1.min.js?t=322"></script>
<script src="${pageContext.request.contextPath}/static/admin/js/bootstrap.min.js?v=3.4.0"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v="></script>

<script type="text/javascript">
$(function(){
})

</script>

</body>

</html>

