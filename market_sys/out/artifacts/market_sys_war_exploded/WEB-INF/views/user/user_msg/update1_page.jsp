<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">

<title>修改-会员</title>
<meta name="keywords" content="修改-会员">
<meta name="description" content="修改-会员">

<link href="${pageContext.request.contextPath}/static/admin/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/admin/font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet">

<!-- Morris -->
<link href="${pageContext.request.contextPath}/static/admin/css/plugins/morris/morris-0.4.3.min.css?t=322" rel="stylesheet">

<!-- Gritter -->
<link href="${pageContext.request.contextPath}/static/admin/js/plugins/gritter/jquery.gritter.css?t=322" rel="stylesheet">

<link href="${pageContext.request.contextPath}/static/admin/css/animate.css?t=322" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/admin/css/style.css?v=2.2.0" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/datetime/4.8/skin/WdatePicker.css"></script>

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

.dz-image>img{
width:120px;
height:120px;
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
		<h2>修改-会员 </h2>
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
					<div class="row"   style="width:80%;margin-left:10%">
						<div class="col-lg-6">
							<div class="form-group" id="realNameParentContent">
								<label>姓名<span style="color:red">(*必填)</span></label>
								<input type="text" value="${data.realName}" placeholder="请输入姓名" id="realName" class="form-control">
							</div>
							<div class="form-group" id="celPhoneParentContent">
								<label>联系电话<span style="color:red">(*必填)</span></label>
								<input type="text" value="${data.celPhone}" placeholder="请输入联系电话" id="celPhone" class="form-control">
							</div>
							<div class="form-group" id="birthdayParentContent">
								<label>生日<span style="color:red">(*必填)</span></label>
								<input type="text" class="form-control Wdate"  readonly="readonly"  value="${data.birthday}"  onFocus="WdatePicker({startDate: '%y-%M-%d' ,dateFmt:'yyyy-MM-dd',alwaysUseStartDate: true })"  placeholder="请输入生日" id="birthday">
							</div>
							<div class="form-group" id="sexParentContent">
								<label>性别<span style="color:red">(*必填)</span></label>
								<select id="sex"  class="form-control">
									<c:forEach items="${sexList}" var="item">
										<c:if test="${item.id==data.sex}">
											<option value="${item.id}" selected>${item.name}</option>
										</c:if>
										<c:if test="${item.id!=data.sex}">
											<option value="${item.id}">${item.name}</option>
										</c:if>
									</c:forEach>
								</select>
							</div>
							<div class="form-group" id="addressParentContent">
								<label>地址<span style="color:red">(*必填)</span></label>
								<input type="text" value="${data.address}" placeholder="请输入地址" id="address" class="form-control">
							</div>
							<div class="form-group">
								<button type="button" onclick="submitData();" class="btn btn-primary">提交</button>
								<button type="button"   onclick="javascript:history.back(-1);" class="btn btn-light">返回</button>
							</div>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/static/datetime/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=3321"></script>

<script>
$(function(){
})
function submitData(){
	var realName= $('#realName').val();
	var celPhone= $('#celPhone').val();
	var birthday= $('#birthday').val();
	var sex= $('#sex').val();
	var address= $('#address').val();
	$.ajax({
		type: 'post',
		url: '${pageContext.request.contextPath}/user/user_msg/update1_submit',
		data:{
			"id":'${data.id}',
			"realName":realName,
			"celPhone":celPhone,
			"birthday":birthday,
			"sex":sex,
			"address":address
		},
		success: function(result) {
			if(result.code == 0){
				alert(result.msg);
				}else{
				alert(result.msg);
				window.location.href="${pageContext.request.contextPath}/user/user_msg/detail";
			}
		}
	});
}

</script>

</body>

</html>

