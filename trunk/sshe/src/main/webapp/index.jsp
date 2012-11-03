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
<jsp:include page="init.jsp"></jsp:include>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',title:'center',href:'<%=basePath%>layout/center.jsp'"></div>
	<div data-options="region:'north',href:'<%=basePath%>layout/north.jsp'" style="height: 60px"></div>
	<div data-options="region:'south',href:'<%=basePath%>layout/south.jsp'" style="height: 30px"></div>
	<div data-options="region:'west',split:true" style="width: 200px">
		<div id="index_westPanel" class="easyui-panel" data-options="title:'west',border:false,fit:true,href:'<%=basePath %>layout/west.jsp'">
		</div>
	</div>
	<div data-options="region:'east',title:'east',href:'<%=basePath%>layout/south.jsp'" style="width: 200px"></div>
	<!-- 登陆页 -->
	<jsp:include page="user/login.jsp"></jsp:include>
	<!-- 注册页 -->
	<jsp:include page="user/reg.jsp"></jsp:include>
</body>
</html>
