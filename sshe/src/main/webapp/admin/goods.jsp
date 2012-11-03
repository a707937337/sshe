<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../init.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
	var datagrid;
	$(function() {
		var admin_goods_searchForm=$('#admin_goods_searchForm');
		datagrid = $('#datagrid').datagrid({
			url : 'goodsAction!dataGrid.action',//此处返回json
			title : '',
			iconCls : 'icon-sage',
			pagination : true, //分页工具条
			pageSize : 10,//页面大小
			pageList : [ 10, 20, 30, 50, 100, 200 ],//可显示的pageSize条数,pageSize必须是pageList包含的,而且pageList是pageSize的倍数
			fit : true,//宽高自适应,适应于父类的框架大小
			fitColumns : true,//是否出现横向滚动,true:没有,false:有,  列不是很多的时候一般用true,很多的时候一般用false
			nowarp : false,//自动折行,如果一行的内容太多了,自定换行,默认是true,如果是false就会自动换行
			border : false,//边框
			rownumbers : true,
			//idField : 'id',//一个标示,例如 如果第一页选中两个,翻页在选中1个,点删除的时候删除的是3条数据!主要用于跨页删除
			sortName : 'name',//按照什么排序
			sortOrder : 'desc',//排序从高到低还是从低到高
			checkOnSelect : true,
			selectOnCheck : true,
			frozenColumns : [ [ {
				title : '编号',
				field : 'id',
				width : 150,
				sortable : true,
				checkbox : true
			} ] ],
			columns : [ [ {
				title : '名称',
				field : 'name',
				width : 100,//宽度必须要给,不给可能出不来
				sortable : true,
				editor:{ //开启编辑属性,可编辑
					type:'validatebox',
					options:{
						required:true
					}
				}
			//可以点击的时候排序
			}, {
				title : '编号',
				field : 'info',
				width : 100
			//宽度必须要给,不给可能出不来
			}, {
				title : '创建时间',
				field : 'createtime',
				width : 100,
				sortable : true,
			}, {
				title : '修改时间',
				field : 'modifytime',
				width : 100,
				sortable : true,
			}, {
				title : '商品简介',
				field : 'bn',
				width : 100
			} ] ],
			toolbar : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					datagrid.datagrid('appendRow',{
					});
					var rows=datagrid.datagrid('getRows');
					datagrid.datagrid('beginEdit',rows.length-1); //行编辑的索引是从0开始的
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
				}
			}, '-', {
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
				}
			} ]
		});
		
		admin_goods_search=function(){
			datagrid.datagrid('load',sy.serializeObject(admin_goods_searchForm));
		};
		admin_goods_clear=function(){
			datagrid.datagrid('load',{});
			admin_goods_searchForm.find('input').val('');
		};
		admin_goods_searchTable=$('#admin_goods_searchTable input').bind('keyup',function(event){
			if(event.keyCode==13){
				admin_goods_search();
			}
		});
	});
</script>
</head>
<body>
	<div title="用户管理" class="easyui-layout"
		data-options="border:false,fit:true">
		<div data-options="region:'north',title:'查询',border:false" style="height: 105px;overflow: hidden">
			<form id='admin_goods_searchForm'>
				<table class="tableForm datagrid-toolbar" id="admin_goods_searchTable">
					<tr>
						<th>商品名称</th>
						<td><input name='name'/></td>
					</tr>
					<tr>
						<th>创建时间</th>
						<td><input name='createtimeStart' class='easyui-datetimebox' editable='false'/>至<input name='createtimeEnd' class='easyui-datetimebox' editable='false'/></td>
					</tr>
					<tr>
						<th>最后修改时间</th>
						<td><input name='modifytimeStart' class='easyui-datetimebox' editable='false'/>至<input name='modifytimeEnd' class='easyui-datetimebox' editable='false'/>
							<a class='easyui-linkbutton' plain=true href='javascript:void(0)' onclick="admin_goods_search()">查询</a>
							<a class='easyui-linkbutton' plain=true href='javascript:void(0)' onclick="admin_goods_clear()">清空</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'center'">
			<table id="datagrid"></table>
		</div>
		<div id="toolbar"></div>
	</div>
</body>
</html>