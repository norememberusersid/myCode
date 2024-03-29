<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<title>校园网上超市系统-登录</title>
<link href="${pageContext.request.contextPath}/static/login/css/login.css?t=400" rel="stylesheet" type="text/css" />

</head>

<body  style="background:transparent;background-image:url(${pageContext.request.contextPath}/static/login_bg.jpg);background-size:100% 100%">

<div class="login_box" style="verflow-y:auto;margin-left:5%">
	<div class="login" >
		<div class="login_name">
			<p>校园网上超市系统-登录</p>
		</div>
		<div>
			<div>
				登录名<input id="name" name="name" type="text" placeholder="请输入登录名"  class="">
			</div>
			<div>
				密码<input id="password" name="password" type="password" placeholder="请输入密码"  class="">
			</div>
			<div style="min-height:40px;margin-top:18px">
				<p>图片验证码</p>
				<input  id="imgCode" name="imgCode" type="text" placeholder="验证码"  style="width:65%">
				<img id="codeImg1"  name="codeImg" alt="点击更换" title="点击更换" style="height:30px;width:120px;float:right">
				</div>
				<div style="min-height:40px;margin-top:12px">
					登录角色
					<input name="loginType" type="radio" value="1" id="loginType1" style="margin-left:10px;"/>
					<label for="loginType1">管理员</label>
					<input name="loginType" type="radio" value="2" id="loginType2" style="margin-left:10px;"/>
					<label for="loginType2">会员</label>
				</div>
				<a  style="margin-left:10px;" href="${pageContext.request.contextPath}/regist/user_msg_regist" onclick="" >注册会员</a>
				<input value="登录" style="width:100%;margin-top:12px;" type="button" onclick="submitForm()">
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=26573"></script>
	
<script>
$(document).ready(function(e) {
	changeCode();
	$("#codeImg1").bind("click",changeCode);
});
function genTimestamp(){
	var time = new Date();
	return time.getTime();
}
function changeCode(){
	$("img[name='codeImg']").attr("src","${pageContext.request.contextPath}/validCode/code?t="+genTimestamp());
}
function submitForm(){
	$.ajax({
		type: 'post',
		url: '${pageContext.request.contextPath}/login/sysSubmit',
		data: {
			'imgCode':$('#imgCode').val(),
			'name':$("#name").val(),
			'password':$("#password").val(),
			'loginType':getCheckBoxVal('loginType')
		},
		success: function(result) {
			if(result.code==1){
				var lt = getCheckBoxVal('loginType');
				if(lt=='1'){
					window.location.href="${pageContext.request.contextPath}/admin/index";
				}
				if(lt=='2'){
					window.location.href="${pageContext.request.contextPath}/index";
				}
				}else{
				alert(result.msg);
			}
		}
	});
}
$(function(){
})

</script>

</body>
</html>

