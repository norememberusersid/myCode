<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>详情</title>
<link href="${pageContext.request.contextPath}/static/index/index/css/style.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/static/index/index/css/goods.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/static/index/index/css/iconfont/RjdaoIcon.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/index/index/js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/page/myPagination.css" />
<meta name="renderer" content="webkit"/>
<meta name="force-rendering" content="webkit"/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1"/>
<script src="${pageContext.request.contextPath}/static/index/index/js/lyz.delayLoading.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/index/index/js/modernizr-custom-v2.7.1.min.js"></script>
<c:set var="uri" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
var uri='${uri}';

</script>
<style>
.selectClass{
background-color:	red !important;
color:white !important;
}
.labelClass{
background-color:#FFFFFF;
color:black;
padding:5px;
margin-left:5px;
border-width:1px;
border-style:solid
}
.redSpan{
color:red !important
}
</style>




</head>
<body>

<div class="goods-frame">
	<ul class="goods-v">
		<div >
			<div class="main-img"><img src="${proMsgDetail.model.proImg}" style="width:430px;height:430px"></div>
			</div>
			<ol class="info" style="float:left;margin-left:50px;">
				<div class="title"><p style="margin-top:20px;font-size:24px">${proMsgDetail.model.proTitle}</p></div>
				<div  style="margin-top:20px;">
					<span  style="color:white;background-color:	#3CB371;padding:5px;width:100px;height:34px;border:none;margin-left:5px;border-radius:20%;">${proMsgDetail.model.proStockNum}库存量</span>
					<span  style="color:white;background-color:	#FFA500;padding:5px;width:100px;height:34px;border:none;margin-left:5px;border-radius:20%;">${proMsgDetail.model.saleNum}销量</span>
				</div>
				<div style="margin-top:20px;height:18px;margin-bottom:20px;height:50px;"   >
					<span style="font-size:18px;float:left;margin-top:10px;">价格</span> <span style="color:	#FF4500;font-size:28px;float:left;margin-left:15px;">￥${proMsgDetail.model.proPrice}</span>
				</div>
				<div class="fuInfo"  style="height:auto">
					<div class="item" >
						<p class="name">商品简介</p>
						<span>${proMsgDetail.model.proIntro}</span>
					</div>
				</div>
				<div class="fuInfo"  style="height:auto">
					<div class="item">
						<p class="name">商品类型</p>
						<span style="color:#fa550c;">${proMsgDetail.pidT.typeName}</span>
					</div>
				</div>
				<div class="number">
					<p class="name" style="font-size:18px">数量</p>
					<div class="gn-reduce"><img src="${pageContext.request.contextPath}/static/index/index/images/goods/X15.png"></div>
						<form><input class="input" value="1" id="orderNum" ></form>
						<div class="gn-plus"><img src="${pageContext.request.contextPath}/static/index/index/images/goods/16.png"></div>
						</div>
						<div style="margin-top:10px;"><button onClick="submitOrderMsg()"  style="color:white;background-color:red;padding:5px;width:100px;height:34px;border:none">提交订单</button>
							<button onClick="addToCart()"  style="color:white;background-color:#FFD700;padding:5px;width:100px;height:34px;border:none">加入购物车</button>
						</div>
						<div style="margin-top:10px;">
						</div>
					</ol>
				</ul>
			</div>
			<div class="goods-desc">
				<div>
					<!---TAB S--->
					<div id="tabBox">
						<div id="tab_list" style="width:100%">
						</div>
						<div id="tabMenu_content">
							<!--tab内容 S--->
							<div class="list block  tab_div_detail detail_div" style="width:100%">
								<div style="border-style: solid;border-width:1px;padding-left:20px;padding-right:20px;padding-bottom:20px;border-color:#DCDCDC">
									<div style="margin-top:30px;padding:20px;">
										<h1 style="text-align:center;font-size:22px;margin-bottom:8px;">商品详情图</h1>
										<hr>
										</div>
										<div>
											<div >
												<c:forEach var="item4" items="${proMsgDetail.proDetailList}">
													<p style="margin-top:5px;"><img src="${item4}"  style="width:80%;margin-left:10%"></p>
													</c:forEach>
													<c:if test="${proDetailList.size()==0}">
														<p>暂无商品详情图</p>
													</c:if>
												</div>
											</div>
										</div>
									</div>
									<!--tab内容 E--->
									<!--tab内容 S--->
									<div class="list none tab_div_detail eval_div">
									</div>
									<!--tab内容 E--->
									<!--tab内容 S--->
									<div class="list none">
										专享服务内容
									</div>
									<!--tab内容 E--->
								</div>
							</div>
							<!---TAB E--->
						</div>
					</div>
					<div style="margin-top:200px;height:200px;"></div>
					<script>
						function showTab(e){
						$(".show_tab").removeClass("active");
						$(e).addClass("active");
						$(".tab_div_detail").removeClass("none");
						$(".tab_div_detail").removeClass("block");
						$(".tab_div_detail").addClass("none");
						var divName = $(e).attr("div-name");
						$("."+divName+"_div").removeClass("none");
						}
					</script>
					<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
					<script type="text/javascript" src="${pageContext.request.contextPath}/static/page/myPagination.js"></script>
					
<script type="text/javascript">
$(function(){
	$(".gn-reduce").click(function(){
		var num = $(".input").val()
		if(num>1){
			$(".input").val(num-1);
		}
	})
	$(".gn-plus").click(function(){
		var value=parseInt($('.input').val())+1;
		$('.input').val(value);
	})
	javascript:scrollTo(0,0);
});
function submitOrderMsg(){
	if(confirm('确定要提交该订单吗')==false){
		return false;
		}else{
		var orderNum = $("#orderNum").val();
		$.ajax({
			type: 'post',
			url: '${pageContext.request.contextPath}/index/pro_detail/submitOrderMsg',
			data:{
				'orderNum':orderNum,
				"pid":'${proMsgDetail.model.id}'
			},
			success: function(result) {
				if(result.code == 0){
					alert(result.msg);
					}else{
					alert(result.msg);
					window.location.href="${pageContext.request.contextPath}/index/order_msg";
				}
			}
		});
	}
}
function addToCart(){
	var orderNum = $("#orderNum").val();
	$.ajax({
		type: 'post',
		url: '${pageContext.request.contextPath}/index/cart/addToCart',
		data:{
			'num':orderNum,
			"pid":'${proMsgDetail.model.id}'
		},
		success: function(result) {
			alert(result.msg);
		}
	});
}

</script>
					<script>
					</script>

</body>
</html>

