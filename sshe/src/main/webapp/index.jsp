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
		 
		$('#index_regForm').form({
			url : '${pageContext.request.contextPath}/userAction!reg.action',
			success : function(r) {
				//var obj=eval("("+r+")");// 不推荐,这是原生的转换成json对象的方法
				var obj=jQuery.parseJSON(r);
				if(obj.success){
					$("#index_regDialog").dialog("close");
				}
				$.messager.show({
					title:'提示',
					msg:obj.msg,
					timeOut:5000,
					showType:'slide'
				});
			}
		});
	});
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',title:'center'"></div>
	<div data-options="region:'north'" style="height: 60px"></div>
	<div data-options="region:'south'" style="height: 30px"></div>
	<div data-options="region:'west',split:true" style="width: 200px">
		<div class="easyui-panel"
			data-options="title:'west',border:false,fit:true"></div>
	</div>
	<div data-options="region:'east',title:'east'" style="width: 200px"></div>
	<!-- 登陆按钮 -->
	<div class="easyui-dialog"
		data-options="title:'登陆',modal:true,closable:false,buttons:[{
				text:'注册',
				iconCls:'icon-edit',
				handler:function(){
					$('#index_regDialog input').val('');
					$('#index_regDialog').dialog('open');
				}
			},{
				text:'登陆',
				iconCls:'icon-help',
				handler:function(){
					alert('登陆')	
				}
			
			}]">
		<table>
			<tr>
				<th>登陆名</th>
				<td><input /></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input /></td>
			</tr>
		</table>
	</div>
	<!-- 注册dialog -->
	<div id="index_regDialog" class="easyui-dialog" style="width:250px"
		data-options="title:'登陆',closed:true,modal:true,buttons:[{
				text:'注册',
				iconCls:'icon-edit',
				handler:function(){
					$('#index_regForm').submit();
				}
			}]">
		<form method="post" id="index_regForm">
			<table>
				<tr>
					<th>登陆名</th>
					<td><input name="name" class="easyui-validatebox"
						data-options="required:true,missingMessage:'登录名不能为空'" />
					</td>
				</tr>
				<tr>
					<th>密码</th>
					<td><input name="password" class="easyui-validatebox"
						type="password" data-options="required:true" />
					</td>
				</tr>
				<tr>
					<th>重复密码</th>
					<td><input name="rePassword" class="easyui-validatebox"
						type="password"
						data-options="required:true,validType:'rePwd[\'#index_regForm input[name=password]\']'" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
