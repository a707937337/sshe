<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 注册dialog -->
	<div id="user_regDialog" class="easyui-dialog" style="width:250px"
		data-options="title:'登陆',closed:true,modal:true,buttons:[{
				text:'注册',
				iconCls:'icon-edit',
				handler:function(){
					$('#user_regForm').form('submit',{
						url : 'userAction!reg.action',
						success : function(r) {
							//var obj=eval('('+r+')');// 不推荐,这是原生的转换成json对象的方法
							var obj = jQuery.parseJSON(r);
							if (obj.success) {
								$('#user_regDialog').dialog('close');
							}
							$.messager.show({
								title : '提示',
								msg : obj.msg,
								timeOut : 5000,
								showType : 'slide'
							});
						}
					});
				}
			}]">
		<form method="post" id="user_regForm">
			<table>
				<tr>
					<th>登陆名</th>
					<td><input name="name" class="easyui-validatebox"
						data-options="required:true,missingMessage:'登录名不能为空'" /></td>
				</tr>
				<tr>
					<th>密码</th>
					<td><input name="password" class="easyui-validatebox"
						type="password" data-options="required:true" /></td>
				</tr>
				<tr>
					<th>重复密码</th>
					<td><input name="rePassword" class="easyui-validatebox"
						type="password"
						data-options="required:true,validType:'rePwd[\'#user_regForm input[name=password]\']'" />
					</td>
				</tr>
			</table>
		</form>
	</div>