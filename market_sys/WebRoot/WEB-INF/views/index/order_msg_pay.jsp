<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>校园网上超市系统——结算页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/index/order/css/index.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/index/order/css/ziy.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/index/order/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/index/order/js/jquery.SuperSlide.2.1.1.source.js"></script>
</head>
<body>

<!--校园网上超市系统——结算页-->
<div class="beij_center">
	<div class="checkout-tit">
		<span class="tit-txt">填写并核对订单信息</span>
	</div>
	<div class="checkout_steps">
		<div class="step-tit">
			<h3>待付款订单</h3>
		</div>
		<div class="shopping_list">
			<div class="goods_list" style="width:100%">
				<c:forEach var="item" items="${orderMsgList}">
					<div class="goods_list_neik">
						<div class="goods_item">
							<div class="p_img"><a href="${pageContext.request.contextPath}/index/pro_detail?id=${item.proMsgId}"><img style="height:80px" src="${item.proImg}"></a></div>
								<div class="goods_msg">
									<div class="p_name">
										<a href="${pageContext.request.contextPath}/index/pro_detail?id=${item.proMsgId}">${item.proTitle}</a>
									</div>
									<div class="p_price">
										<span class="jq_price">${item.pproPrice}</span>
										<span>x${item.orderNum}</span>
										<span>总共:${item.totalAmount}元</span>
										<span><button onclick="delOrder(this)" data-id="${item.id}">删除</button></span>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<!--收费明细-->
		<div class="order_summary">
			<div class="qianq_mx">
				<div class="jiaq_meih">
					<span class="xiangq_leib">数量：<em class="goumai_ges">${orderMsgList.size()}</em> ，总金额：</span>
					<em class="goum_zongj">￥${totalAmount}</em>
				</div>
			</div>
		</div>
		<div class="trade_foot_detail_com">
			<div class="dsgs">
				<div class="qianq_mx">
					<div class="jiaq_meih">
						<span class="xiangq_leib"> 应付总额：</span>
						<em class="goum_zongj zhongf_jine">￥${totalAmount}</em>
					</div>
				</div>
			</div>
		</div>
		<div class="tij_dingd_ann">
			<a href="javascript:void(0)" onclick="submitOrder()">提交订单</a>
		</div>
	</div>
	<div style="margin-top:200px;"></div>
	
<script type="text/javascript">
function submitOrder(){
	if('${orderMsgList.size()}'=='0'){
		alert("您没有任何待付款订单");
	}
	window.location.href="${pageContext.request.contextPath}/index/order_msg/goPay?oids=${oids}";
}
function delOrder(e){
	var id = $(e).attr("data-id");
	$.ajax({
		type : 'get',
		url : "${pageContext.request.contextPath}/index/order_msg/delOrderMsg?id="+id+"",
		data : {
			"id":id
		},
		success : function(result) {
			if(result.code==1){
				alert(result.msg);
				window.location.reload();
				}else{
				alert(result.msg);
			}
		}
	});
}

</script>

</body>
</html>

