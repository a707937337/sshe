<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'index.jsp' starting page</title>

<script type="text/javascript"
	src="jslib/jquery-easyui-1.3.1/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="jslib/jquery-easyui-1.3.1/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="jslib/jquery-easyui-1.3.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="jslib/syUtil.js"></script>
<link rel="stylesheet"
	href="jslib/jquery-easyui-1.3.1/themes/default/easyui.css"
	type="text/css"></link>
<link rel="stylesheet" href="jslib/jquery-easyui-1.3.1/themes/icon.css"
	type="text/css"></link>
<link rel="stylesheet" href="style/syCss.css" type="text/css"></link>
<script type="text/javascript">
	$(function() {
		/**
		$('#index_regDialog').dialog({
			title : '登陆',
			//closed:true,
			modal : true,
			buttons : [ {
				text : '注册',
				iconCls : 'icon-edit',
				handler : function() {
					alert('注册');
				}
			} ]
		}).dialog('close');
		 */

	});
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',title:'center'"></div>
	<div data-options="region:'north'" style="height: 60px"></div>
	<div data-options="region:'south'" style="height: 30px"></div>
	<div data-options="region:'west',split:true" style="width: 200px">
		<div class="easyui-panel" data-options="title:'west',border:false,fit:true"></div>
	</div>
	<div data-options="region:'east',title:'east'" style="width: 200px"></div>
	<!-- 登陆页 -->
	<jsp:include page="user/login.jsp"></jsp:include>
	<!-- 注册页 -->
	<jsp:include page="user/reg.jsp"></jsp:include>
</body>
</html>
