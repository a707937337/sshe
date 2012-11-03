<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript"
	src="<%=basePath%>jslib/jquery-easyui-1.3.1/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>jslib/jquery-easyui-1.3.1/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>jslib/jquery-easyui-1.3.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=basePath%>jslib/syUtil.js"></script>
<link rel="stylesheet"
	href="<%=basePath%>jslib/jquery-easyui-1.3.1/themes/default/easyui.css"
	type="text/css"></link>
<link rel="stylesheet" href="<%=basePath%>jslib/jquery-easyui-1.3.1/themes/icon.css"
	type="text/css"></link>
<link rel="stylesheet" href="<%=basePath%>style/syCss.css" type="text/css"></link>
