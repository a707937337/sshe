<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
	var tree;
	$(function(){
		tree=$('#layout_west_menu').tree({
			url:'menuAction!tree.action',
			lines:true,
			onClick:function(node){
				addTab(node);
			}
		});		
	});
</script>
<div class="easyui-accordion" data-options="border:false,fit:true">
	<div title="系统菜单" data-options="isonCls:'icon-save',tools : [ {
				iconCls : 'icon-reload',
				handler : function() {
					tree.tree('reload');
				}
			}, {
				iconCls : 'icon-redo',
				handler : function() {
					var node = tree.tree('getSelected');
					if (node) {
						tree.tree('expandAll', node.target);
					} else {
						tree.tree('expandAll');
					}
				}
			}, {
				iconCls : 'icon-undo',
				handler : function() {
					var node = tree.tree('getSelected');
					if (node) {
						tree.tree('collapseAll', node.target);
					} else {
						tree.tree('collapseAll');
					}
				}
			} ]">
		<ul id="layout_west_menu">
			<li></li>
		</ul>
	</div>
	<div title="其他菜单"></div>
</div>