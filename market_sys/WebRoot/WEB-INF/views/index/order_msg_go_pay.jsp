<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/index/pay_act/js/jquery.min.js"></script>
<title>校园网上超市系统-支付</title>
<style type="text/css">
.content{width:80%;margin:200px auto;}
.hide_box{z-index:999;filter:alpha(opacity=50);background:#666;opacity: 0.5;-moz-opacity: 0.5;left:0;top:0;height:99%;width:100%;position:fixed;display:none;}
.shang_box{width:540px;height:540px;padding:10px;background-color:#fff;border-radius:10px;position:fixed;z-index:1000;left:50%;top:50%;margin-left:-280px;margin-top:-280px;border:1px dotted #dedede;display:none;}
.shang_box img{border:none;border-width:0;}
.dashang{display:block;width:100px;margin:5px auto;height:25px;line-height:25px;padding:10px;background-color:#E74851;color:#fff;text-align:center;text-decoration:none;border-radius:10px;font-weight:bold;font-size:16px;transition: all 0.3s;}
.dashang:hover{opacity:0.8;padding:15px;font-size:18px;}
.shang_close{float:right;display:inline-block;}
.shang_logo{display:block;text-align:center;margin:20px auto;}
.shang_tit{width: 100%;height: 75px;text-align: center;line-height: 66px;color: #a3a3a3;font-size: 16px;background: url('${pageContext.request.contextPath}/static/index/pay_act/img/cy-reward-title-bg.jpg');font-family: 'Microsoft YaHei';margin-top: 7px;margin-right:2px;}
.shang_tit p{color:#a3a3a3;text-align:center;font-size:16px;}
.shang_payimg{width:140px;padding:10px;border:6px solid #EA5F00;margin:0 auto;border-radius:3px;height:140px;}
.shang_payimg img{display:block;text-align:center;width:140px;height:140px; }
.pay_explain{text-align:center;margin:10px auto;font-size:12px;color:#545454;}
.radiobox{width: 16px;height: 16px;background: url('${pageContext.request.contextPath}/static/index/pay_act/img/radio2.jpg');display: block;float: left;margin-top: 5px;margin-right: 14px;}
.checked .radiobox{background:url('${pageContext.request.contextPath}/static/index/pay_act/img/radio1.jpg');}
.shang_payselect{text-align:center;margin:0 auto;margin-top:40px;cursor:pointer;height:60px;width:280px;}
.shang_payselect .pay_item{display:inline-block;margin-right:10px;float:left;}
.shang_info{clear:both;}
.shang_info p,.shang_info a{color:#C3C3C3;text-align:center;font-size:12px;text-decoration:none;line-height:2em;}
</style>
</head>
<body>

<div class="content">
	<div class="hide_box"></div>
	<div class="shang_box">
		<div class="shang_tit">
			<p>感谢您的支持，我们会继续努力的!</p>
		</div>
		<div class="shang_payimg">
			<img src="${pageContext.request.contextPath}/static/index/pay_act/img/alipayimg3.jpg" alt="扫一扫" title="扫一扫" />
		</div>
		<div class="pay_explain">扫码支付，支付金额：${totalAmount}元</div>
		<div class="shang_payselect">
			<div class="pay_item checked" data-id="alipay"  style="margin-left:30%">
				<span class="pay_logo" ><img src="${pageContext.request.contextPath}/static/index/pay_act/img/alipay.jpg" alt="支付宝" /></span>
			</div>
		</div>
		<div class="shang_info">
			<p>打开<span id="shang_pay_txt">支付宝</span>扫一扫，即可进行扫码支付</p>
			<p><a href="javascript:void(0)" onclick="paySuccess()"  class="dashang" title="支付">已支付</a></p>
		</div>
	</div>
</div>

<script type="text/javascript">
$(function(){
	$(".hide_box").fadeToggle();
	$(".shang_box").fadeToggle();
});
function paySuccess(){
	$.ajax({
		type : 'get',
		url : "${pageContext.request.contextPath}/index/order_msg/submitOrderMsg",
		data : {
			"oids":"${oids}"
		},
		success : function(result) {
			if(result.code==1){
				window.location.href="${pageContext.request.contextPath}/index/order_msg/paySuccess";
				}else{
				alert(result.msg);
			}
		}
	});
}

</script>

</body>
</html>

