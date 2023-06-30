<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>校园网上超市系统-购物车</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/index/res/layui/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/index/res/layui/css/layui.css">
<style>
.textsl{
width:120px;
overflow: hidden;
text-overflow: ellipsis;
}
</style>

<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<body>

<div class="content content-nav-base shopcart-content">
	<div class="cart w1200">
		<div class="cart-table-th">
			<div class="th th-chk">
				<div class="select-all">
					<div class="cart-checkbox">
						<input class="check-all check" id="allCheckked" onclick="allSelect(this)" type="checkbox" value="true">
					</div>
					<label>  全选</label>
				</div>
			</div>
			<div class="th th-item">
				<div class="th-inner">
					商品
				</div>
			</div>
			<div class="th th-price">
				<div class="th-inner">
					价格
				</div>
			</div>
			<div class="th th-amount">
				<div class="th-inner">
					数量
				</div>
			</div>
			<div class="th th-sum">
				<div class="th-inner">
					小计
				</div>
			</div>
			<div class="th th-op">
				<div class="th-inner">
					操作
				</div>
			</div>
		</div>
		<div class="OrderList">
			<div class="order-content" id="list-cont">
				<c:forEach var="item" items="${cartList}">
					<ul class="item-content layui-clear">
						<li class="th th-chk">
							<div class="select-all">
								<div class="cart-checkbox">
									<input class="CheckBoxShop check"
									type="checkbox" num="all" name="selectItem" item-id="${item.id}" onclick="count()" item-num="${item.num}" item-price="${item.cartProPrice}" value="true">
								</div>
							</div>
						</li>
						<li class="th th-item">
							<div class="item-cont">
								<a href="${pageContext.request.contextPath}/index/pro_detail?id=${item.proMsgId}"><img src="${item.cartProImg}" alt=""></a>
									<div class="text">
										<div class="title textsl">${item.cartProTitle}</div>
									</div>
								</div>
							</li>
							<li class="th th-price">
								<span class="th-su">${item.cartProPrice}</span>
							</li>
							<li class="th th-amount">
								<div class="box-btn layui-clear">
									<div onclick="addStock(this)" data-type="2" data-id="${item.id}" class="less layui-btn">-</div>
									<input class="Quantity-input" type="" name="" value="${item.num}"   >
									<div onclick="addStock(this)" data-type="1" data-id="${item.id}" class="add layui-btn">+</div>
								</div>
								<p></p>
							</li>
							<li class="th th-sum">
								<span class="sum">${item.totalAmount}</span>
							</li>
							<li class="th th-op">
								<span class="dele-btn" data-id="${item.id}" onclick="removeThis(this)">删除</span>
							</li>
						</ul>
					</c:forEach>
				</div>
			</div>
			<div class="FloatBarHolder layui-clear">
				<div class="th th-chk">
					<div class="select-all">
						<label>  已选<span class="Selected-pieces" id="totalNum">0</span>件</label>
					</div>
				</div>
				<div class="th batch-deletion">
					<span class="batch-dele-btn" onclick="batchRemoveThis()">批量删除</span>
				</div>
				<div class="th Settlement">
					<button class="layui-btn" onclick="submitData()">结算</button>
				</div>
				<div class="th total">
					<p>应付：<span class="pieces-total" id="jiesuanprice">0</span></p>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-top:200px;"></div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
	
<script type="text/javascript">
function allSelect(e){
	var isCheck = $(e).prop("checked");
	if(isCheck==true||isCheck=='checked'){
		$("input[name='selectItem']").prop("checked",true);
		}else{
		$("input[name='selectItem']").prop("checked",false);
	}
	count();
}
function addStock(e){
	var type=$(e).attr("data-type");
	var id=$(e).attr("data-id");
	$.ajax({
		type : 'get',
		url : "${pageContext.request.contextPath}/index/cart/updateCartNum",
		data : {
			"type":type,
			"id":id
		},
		success : function(result) {
			if(result.code==1){
				location.reload();
			}
		}
	});
}
function removeThis(e){
	var dataId = $(e).attr("data-id");
	$.ajax({
		type : 'get',
		url : "${pageContext.request.contextPath}/index/cart/removeCart",
		data : {
			"id":dataId
		},
		success : function(result) {
			if(result.code==1){
				location.reload();
				}else{
				alert(result.msg);
			}
		}
	});
}
function batchRemoveThis(){
	var items = $("input[name='selectItem']");
	var ids='';
	for(var i=0;i<items.length;i++){
		var isChecked = $(items[i]).prop("checked");
		if(isChecked==true){
			ids+=$(items[i]).attr("item-id")+",";
		}
	}
	$.ajax({
		type : 'get',
		url : "${pageContext.request.contextPath}/index/cart/batchRemoveCart",
		data : {
			"ids":ids
		},
		success : function(result) {
			if(result.code==1){
				location.reload();
				}else{
				alert(result.msg);
			}
		}
	});
}
function count(){
	var items = $("input[name='selectItem']");
	var totalAmount=0.0;
	var totalNum=0;
	for(var i=0;i<items.length;i++){
		var isChecked = $(items[i]).prop("checked");
		if(isChecked==true){
			var itemNum = new Number($(items[i]).attr("item-num"));
			var proPrice = new Number($(items[i]).attr("item-price"));
			totalAmount+=itemNum*proPrice;
			totalNum+=itemNum;
		}
	}
	$("#totalNum").html(totalNum);
	$("#jiesuanprice").html(totalAmount.toFixed(2));
}
function submitData(){
	if($("#totalNum").html() == "0"){
		alert("请选择商品！");
		return ;
	}
	var items = $("input[name='selectItem']");
	var data = '';
	for(var i=0;i<items.length;i++){
		var isChecked = $(items[i]).prop("checked");
		if(isChecked==true){
			var proId = $(items[i]).attr("item-id");
			data+=proId+",";
		}
	}
	$.ajax({
		type : 'get',
		url : "${pageContext.request.contextPath}/index/cart/submitCart",
		data : {
			"ids":data
		},
		success : function(result) {
			if(result.code==1){
				window.location.href="${pageContext.request.contextPath}/index/order_msg";
				}else{
				alert(result.msg);
			}
		}
	});
}

</script>

</body>
</html>

