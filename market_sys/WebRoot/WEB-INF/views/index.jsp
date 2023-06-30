<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>校园网上超市系统</title>
<link href="${pageContext.request.contextPath}/static/index/index/css/style.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/static/index/index/css/index.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/static/index/index/css/iconfont/RjdaoIcon.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/index/index/js/jquery.js"></script>
<meta name="renderer" content="webkit"/>
<meta name="force-rendering" content="webkit"/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1"/>

<style>
.logoStyle{
display:block;
width:260px;
height:80px;
float:left;
margin-top:15px;

}

.bodyClass::-webkit-scrollbar {
display: none; /* Chrome Safari */
}

.bodyClass {
scrollbar-width: none; /* firefox */

-ms-overflow-style: none; /* IE 10+ */

overflow-x: hidden;

overflow-y: auto;

}
</style>



</head>
<body   class="bodyClass">

<div class="topnav">
	<div class="con">
		<div class="txt" >欢迎您来到校园网上超市系统</div>
		<ul class="rightnav">
			<c:if test="${login!=null and login.loginType==2}">
				<li><a  data-href="${pageContext.request.contextPath}/index/order_msg" href="javascript:void(0)" onclick="goPage(this)" class="m rightPageHref"><span>待付款订单</span></a></li>
			</c:if>
			<c:if test="${login!=null and login.loginType==2}">
				<li><a  data-href="${pageContext.request.contextPath}/index/cart" href="javascript:void(0)" onclick="goPage(this)" class="m rightPageHref"><span>购物车</span></a></li>
			</c:if>
			<c:if test="${login!=null and login.loginType==2}">
				<li><a  data-href="" href="${pageContext.request.contextPath}/user/index" onclick="" class="m rightPageHref"><span>个人中心</span></a></li>
			</c:if>
			<c:if test="${login!=null and login.loginType==2}">
				<li><a  data-href="" href="${pageContext.request.contextPath}/login/sys_logout" onclick="" class="m rightPageHref"><span>退出</span></a></li>
			</c:if>
			<c:if test="${login==null}">
				<li><a  data-href="" href="${pageContext.request.contextPath}/regist/user_msg_regist" onclick="" class="m rightPageHref"><span>注册</span></a></li>
			</c:if>
			<c:if test="${login==null}">
				<li><a  data-href="" href="${pageContext.request.contextPath}/login/sys_login" onclick="" class="m rightPageHref"><span>登录</span></a></li>
			</c:if>
		</ul>
	</div>
</div>
<header  style="background-image:url('${pageContext.request.contextPath}/static/index/index/bg.png');background-repeat:repeat-x;height:95px">
	<div class="mainso" style="height:95px;">
		<div  class="logoStyle" style="font-size:28px;width:400px;color:white">
			校园网上超市系统
		</div>
	</div>
	<nav class="mainnav">
		<ul>
			<li class="mli l"><a  data-href="${pageContext.request.contextPath}/index/pro_search" href="javascript:void(0)"   onclick="goPage(this)" class="mz clientPageHref">商品搜索</a></li>
		</ul>
	</nav>
</header>
<div>
	<iframe src="${pageContext.request.contextPath}/index/pro_search" id="iframeDom" style="width:100%;min-height:670px"  frameborder="0"></iframe>
</div>
<footer style="border-top:none">
	<div class="innerframe2">
		<div class="tfr">
			<a href="#">关于我们</a>   <em>|</em>   
			<a href="#">联系我们</a>   <em>|</em>   
			<a href="#">友情链接</a>   <em>|</em>   
			<a href="#">隐私政策</a>   <em>|</em>   
			<a href="#">法律声明</a>
		</div>
		<div class="tfr">
			<span>Copyright (c) 2021 - 2025  校园网上超市系统 版权所有</span>  <em>|</em>  
		</div>
	</div>
</footer>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>

<script type="text/javascript">
function goPage(e){
	var dataHref = $(e).attr("data-href");
	goPageAct(dataHref);
}
function goPageAct(dataHref){
	$("#iframeDom").attr("src",dataHref);
}
$(function(){
	var childPageUrl = '${childPageUrl}';
	if(childPageUrl!=null&&childPageUrl!=''&&childPageUrl!='null'){
		childPageUrl = window.atob(childPageUrl);
		goPageAct(childPageUrl);
	}
})

</script>

</body>
</html>

