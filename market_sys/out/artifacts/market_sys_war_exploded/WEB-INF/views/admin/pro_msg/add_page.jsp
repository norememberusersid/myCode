<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">

<title>新增-商品</title>
<meta name="keywords" content="新增-商品">
<meta name="description" content="新增-商品">

<link href="${pageContext.request.contextPath}/static/admin/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/admin/font-awesome/css/font-awesome.css?v=4.3.0" rel="stylesheet">

<!-- Morris -->
<link href="${pageContext.request.contextPath}/static/admin/css/plugins/morris/morris-0.4.3.min.css?t=322" rel="stylesheet">

<!-- Gritter -->
<link href="${pageContext.request.contextPath}/static/admin/js/plugins/gritter/jquery.gritter.css?t=322" rel="stylesheet">

<link href="${pageContext.request.contextPath}/static/admin/css/animate.css?t=322" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/admin/css/style.css?v=2.2.0" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/imgupload/css/dropzone.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/selectsearch/jquery.searchableSelect.css" />

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
		<h2>新增-商品 </h2>
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
							<div class="form-group" id="proTitleParentContent">
								<label>商品标题<span style="color:red">(*必填)</span></label>
								<input type="text" value="" placeholder="请输入商品标题" id="proTitle" class="form-control">
							</div>
							<div class="form-group" id="proImgParentContent">
								<label>商品大图<span style="color:red">(*必填)</span></label>
								<div id="proImg" class="dropzone" data-id="proImg" max-num="1" file-type="1" max-size="1000" init-val=""></div>
							</div>
							<div class="form-group" id="pidParentContent">
								<label>商品类型<span style="color:red">(*必填)</span></label>
								<select  id="pid"   >
									<c:forEach items="${proTypeList}" var="item">
										<option value="${item.id}">${item.name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group" id="proPriceParentContent">
								<label>价格<span style="color:red">(*必填)</span></label>
								<input type="text" value="" placeholder="请输入价格(请输入数字)" id="proPrice" class="form-control">
							</div>
							<div class="form-group" id="proStockNumParentContent">
								<label>库存数量<span style="color:red">(*必填)</span></label>
								<input type="text" value="" placeholder="请输入库存数量(请输入数字)" id="proStockNum" class="form-control">
							</div>
							<div class="form-group" id="proIntroParentContent">
								<label>商品简介<span style="color:red">(*必填)</span></label>
								<textarea class="form-control"  placeholder="请输入商品简介"  id="proIntro"  rows="4" ></textarea>
							</div>
							<div class="form-group" id="proDetailParentContent">
								<label>商品详情图<span style="color:red">(*必填)</span></label>
								<div id="proDetail" class="dropzone" data-id="proDetail" max-num="5" file-type="1" max-size="1000" init-val=""></div>
							</div>
							<div class="form-group" id="isUpParentContent">
								<label>是否上架<span style="color:red">(*必填)</span></label>
								<select id="isUp"  class="form-control">
									<c:forEach items="${isUpList}" var="item">
										<option value="${item.id}">${item.name}</option>
									</c:forEach>
								</select>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/static/imgupload/js/dropzone.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/imgupload/js/imgupload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/selectsearch/jquery.searchableSelect.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=8119"></script>

<script>
$(function(){
	initAllDrop();
	$('#pid').next().remove();
	$('#pid').searchableSelect();
	$(".searchable-select").css("width","100%");
	$(".searchable-select").css("height","35px");
	$(".searchable-select-holder").css("min-height","20px");
	$(".searchable-select-holder").css("height","35px");
	$(".searchable-select").css("min-width","40px");
})
function submitData(){
	var proTitle= $('#proTitle').val();
	var proImg=getFileVal2('proImg');
	var pid=$('#pid').val()
	var pid= $('#pid').val();
	var proPrice= $('#proPrice').val();
	var proStockNum= $('#proStockNum').val();
	var proIntro= $('#proIntro').val();
	var proDetail=getFileVal2('proDetail');
	var isUp= $('#isUp').val();
	if(proPrice!=''){
		if(isNum(proPrice)==false){
			alert("价格必须填入数字");
			return;
		}
	}
	if(proStockNum!=''){
		if(isIntNum(proStockNum)==false){
			alert("库存数量必须填入整数");
			return;
		}
	}
	$.ajax({
		type: 'post',
		url: '${pageContext.request.contextPath}/admin/pro_msg/add_submit',
		data:{
			"proTitle":proTitle,
			"proImg":proImg,
			"pid":pid,
			"proPrice":proPrice,
			"proStockNum":proStockNum,
			"proIntro":proIntro,
			"proDetail":proDetail,
			"isUp":isUp
		},
		success: function(result) {
			if(result.code == 0){
				alert(result.msg);
				}else{
				alert(result.msg);
				window.location.href="${pageContext.request.contextPath}/admin/pro_msg";
			}
		}
	});
}

</script>

</body>

</html>

