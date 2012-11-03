<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!-- 登陆按钮 -->
<script>
	$(function(){
		$('#user_login_loginForm').form({
			url:'userAction!login.action',
			success:function(r){
				var json = jQuery.parseJSON(r);
				if(json.success){
					$('#user_loginDialog').dialog('close');
				}else{
					$('#user_login_warn').html('&nbsp&nbsp用户名或密码错误,请重输!');
				}
				$.messager.show({
					title:'提醒',
					msg:json.msg,
					timeOut : 5000,
					showType : 'slide'
				});
			}
		});
		$('#user_login_loginForm input').bind('keyup',function(event){
			if(event.keyCode==13){
				$('#user_login_loginForm').submit();
			}
		});
		window.setTimeout(function(){
			$('#user_login_loginForm input[name=name]').focus();
		},0);
	});
	
</script>
<div class="easyui-dialog" id='user_loginDialog'
	data-options="title:'登陆',modal:true,closable:false,buttons:[{
				text:'注册',
				iconCls:'icon-edit',
				handler:function(){
					$('#user_regDialog input').val('');
					$('#user_regDialog').dialog('open');
				}
			},{
				text:'登陆',
				iconCls:'icon-help',
				handler:function(){
					$('#user_login_loginForm').submit();
				}
			}]">
	<div class="info">
				<div class="tip icon-tip"></div>
				<div id='user_login_warn'>&nbsp&nbsp请输入用户名和密码!</div>
	</div>
	<form id='user_login_loginForm' method="post">
		<table>
			<tr>
				<th>登陆名</th>
				<td><input name="name" class="easyui-validatebox"
					data-options="required:true,missingMessage:'请输入用户名'" /></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input name='password' class="easyui-validatebox"
					type="password" data-options="required:true,missingMessage:'请输入密码'" />
				</td>
			</tr>
		</table>
	</form>
</div>