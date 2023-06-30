<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/index/pay_act/js/jquery.min.js"></script>
<title>支付成功</title>
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
			<p>恭喜您，支付成功</p>
		</div>
		<div class="shang_info"><img src="${pageContext.request.contextPath}/static/index/pay_act/img/成功.png"  style="margin-left:40%;width:100px;" alt="扫一扫" title="扫一扫" /></div>
		<p style="text-align:center;">支付成功</p>
		<div class="shang_info">
			<p><a href="javascript:void(0)" onclick="goIndex()"  class="dashang" title="支付">个人中心</a></p>
		</div>
	</div>
</div>

<script type="text/javascript">
$(function(){
	$(".hide_box").fadeToggle();
	$(".shang_box").fadeToggle();
});
function goIndex(){
	parent.location.href="${pageContext.request.contextPath}/user/index";
}

</script>

</body>
</html>

