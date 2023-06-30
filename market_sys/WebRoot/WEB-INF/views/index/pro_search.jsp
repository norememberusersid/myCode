<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>校园网上超市系统</title>
<link href="${pageContext.request.contextPath}/static/index/index/css/style.css?t=444" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/static/index/index/css/goods.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/static/index/index/css/index.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/static/index/index/css/iconfont/RjdaoIcon.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/index/index/js/jquery.js"></script>
<meta name="renderer" content="webkit"/>
<meta name="force-rendering" content="webkit"/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1"/>
<script src="${pageContext.request.contextPath}/static/index/index/js/lyz.delayLoading.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/page/myPagination.css" />
<style>
.search-kkk{
width:560px;
height:80px;
float:left;
margin:15px 0 0 50px;
}
.info2{
display:block;
width:288px;

position:absolute;
bottom:0px;
left:0px;
z-index:10;
background-color:#f0efef;
/* 	transition-duration:0.4s; */
}
</style>
<script type="text/javascript">

</script>



</head>
<body style="min-width:700px;overflow-x:hidden">

<div style="width:90%;margin-left:5%">
	<div class="search-t"  style="float:right;margin-right:5%">
		<div class="soo">
			<input type="text" name="key"  id="proTitle"  class="inkey" placeholder="请输入商品标题搜索" autocomplete="off">
			<input type="button" class="sobut" value="查询" onclick="queryProMsgList(1)">
		</div>
	</div>
	<div style="height:80px;"></div>
	<div class="porselect" style="width:90%">
		<div class="list bb">
			<span> 商品类型：</span>
			<a href="javascript:void(0)" onclick="pid(this)"  data-id="" class="choose pidClass">全部</a>
			<c:forEach var="item" items="${tableProTypeList}">
				<a href="javascript:void(0)" onclick="pid(this)"  data-id="${item.id}" class="choose pidClass">${item.typeName}</a>
			</c:forEach>
		</div>
	</div>
	<h1  style="width:90%;margin-top:10px;margin-left:45%;font-size:24px;">商品</h1>
	<div class="mslist"  style="width:90%;padding:20px;border: 1px solid #ccc; border-radius: 16px;">
		<div class="porlist"  id="dataQl"   style="width:90%;float:left;margin-left:5%">
		</div>
	</div>
	<div style="text-align:center">
		<div id="qlBar" class="pagination" style="margin-top:20px;"></div>
	</div>
</div>
<div style="margin-top:200px;"></div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/index/index/js/slider.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/page/myPagination.js"></script>

<script type="text/javascript">



</script>
<script>
	function pid(e){
	$(".pidClass").removeClass("choose-cur");
	$(e).addClass("choose-cur");
	queryProMsgList(1);
	}
	function queryProMsgList(page) {
	var  proTitle= $("#proTitle").val();
	var  pid= null;
	var pidDiv = $(".pidClass");
	for(var k=0;k<pidDiv.length;k++){
		if($(pidDiv[k]).hasClass("choose-cur")==true){
		pid = $(pidDiv[k]).attr("data-id");
		break;
		}
		}
		$.ajax({
		type : 'get',
		url : "${pageContext.request.contextPath}/index/pro_search/queryProMsgList",
		async:false,
		data : {
		'proTitle':proTitle,
		'pid':pid,
		'page':page
		},
		success : function(result) {
		var html = '';
		var count = result.count;
		var totalPage = result.totalPage;
		var pageSize = result.pageSize;
		for(var i=0;i<result.list.length;i++){
			html+='<div class="item" style="height:340px;">';
				html+='<a href="${pageContext.request.contextPath}/index/pro_detail?id='+result.list[i].model.id+'" class="mask mf1"></a>';
				html+='<a class="pci"><img src="'+result.list[i].model.proImg+'" style="width:288px;height:240px;"></a>';
					html+='<div  class="info2" style="padding-bottom:20px;">';
						html+='<h2 style="display:block;font-size:24px;	text-align:center;margin-top:5px;">'+result.list[i].model.proTitle+'</h2>';
						html+='<p  style="display:block;font-size:16px;;color:red;	text-align:center;margin-top:10px;">￥'+result.list[i].model.proPrice+'</p>';
						html+='<p  style="display:block;margin-top:10px;">';
							html+='<span style="float:left;color:gray;margin-left:8px">'+result.list[i].pid+'</span>';
							html+='<span style="float:right;color:gray;margin-right:8px">'+result.list[i].model.saleNum+'销量</span>';
						html+='</p>';
					html+='</div>';
				html+='</div>';
				}
				if(result.list.length==0){
				html+='<h2 style="color:gray;text-align:center">暂无商品数据</h2>';
				}
				$("#dataQl").html(html);
				new myPagination({
				id: 'qlBar',
				curPage:page, //初始页码
				pageTotal:totalPage, //总页数
				pageAmount: pageSize,  //每页多少条
				dataTotal: count, //总共多少条数据
				pageSize: pageSize, //可选,分页个数
				showPageTotalFlag:true, //是否显示数据统计
				showSkipInputFlag:false, //是否支持跳转
				getPage: function (page) {
				queryProMsgList(page);
				}
				})
				}
				});
				}
				$(function(){
				queryProMsgList(1);
				javascript:scrollTo(0,0);
				})
			</script>

</body>
</html>

