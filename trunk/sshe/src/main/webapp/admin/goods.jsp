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
<base href="<%=basePath%>">
<title>My JSP 'index.jsp' starting page</title>
<jsp:include page="../init.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
	var datagrid;
	$(function() {
		var $P = self.parent.$;
		var admin_goods_searchForm=$('#admin_goods_searchForm');
		var admin_goods_editRow=undefined;
		datagrid = $('#datagrid').datagrid({
			url : 'goodsAction!dataGrid.action',//此处返回json
			title : '',
			iconCls : 'icon-sage',
			pagePosition : 'bottom',
			pagination : true, //分页工具条
			pageSize : 10,//页面大小
			pageList : [ 10, 20, 30, 50, 100, 200 ],//可显示的pageSize条数,pageSize必须是pageList包含的,而且pageList是pageSize的倍数
			fit : true,//宽高自适应,适应于父类的框架大小
			fitColumns : true,//是否出现横向滚动,true:没有,false:有,  列不是很多的时候一般用true,很多的时候一般用false
			nowarp : false,//自动折行,如果一行的内容太多了,自定换行,默认是true,如果是false就会自动换行
			border : false,//边框
			idField : 'id',//一个标示,例如 如果第一页选中两个,翻页在选中1个,点删除的时候删除的是3条数据!主要用于跨页删除
			sortName : 'name',//按照什么排序
			sortOrder : 'desc',//排序从高到低还是从低到高
			checkOnSelect : true,
			selectOnCheck : true,
			frozenColumns : [ [ {
				title : '编号',
				field : 'id',
				width : 150,
				sortable : true,
				checkbox:true
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
				field : 'bn',
				width : 100,
				sortable : true,
				editor:{ //开启编辑属性,可编辑
					type:'validatebox',
					options:{
						required:true
					}
				}
			//宽度必须要给,不给可能出不来
			},{
				title : '商品简介',
				field : 'info',
				width : 100,
				editor:{ //开启编辑属性,可编辑
					type:'validatebox',
					options:{
						required:true
					}
				},
				formatter:function(value,row,index){
					var s='<span title='+value+'>'+value+'</span>';
					return s;
				}
			},{
				title : '创建时间',
				field : 'createtime',
				width : 100,
				sortable : true,
				editor:{ //开启编辑属性,可编辑
					type:'datetimebox',
					options:{
						required:true
					}
				}
			},{
				title : '修改时间',
				field : 'modifytime',
				width : 100,
				sortable : true,
				editor:{ //开启编辑属性,可编辑
					type:'datetimebox',
					options:{
						required:true
					}
				}
			} ] ],
			toolbar : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					if(admin_goods_editRow!=undefined){
						datagrid.datagrid('endEdit',admin_goods_editRow);
					}
					if(admin_goods_editRow==undefined){
						datagrid.datagrid('addEditor',{
							field:'bn',//我要改变bn行的可编辑状态,让他能编辑
							editor:{ //开启编辑属性,可编辑
								type:'validatebox',
								options:{
									required:true
								}
							}
						});
						datagrid.datagrid('insertRow',{
							index:0,
							row: {
								id:sy.UUID(),
							}
						});
						datagrid.datagrid('beginEdit',0); //行编辑的索引是从0开始的
						admin_goods_editRow=0;
					}
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					var rows=datagrid.datagrid('getSelections');
					if(rows.length>0){
						$P.messager.confirm('Confirm','您确定要删除当前所有选择的项目吗?',function(r){   
						    if (r){   
						    	var ids=[];
						    	for(var i=0;i<rows.length;i++){
									ids.push(rows[i].id);						    		
						    	}
						        alert(ids.join(','));   
						    }   
						}); 
					}else{  
						//$P('#layout_center_parent').empty();
			            $P('#layout_center_parent').dialog({  
			                modal:true,  
			                width:300,  
			                height:200, 
			                closed: false,
			                resizable:true,
			                //href:'<%=basePath%>admin/goods.jsp',
							content : $('#toolbar').html(),
							toolbar : [ {
								text : 'Edit',
								iconCls : 'icon-edit',
								handler : function() {
									alert('edit');
								}
							}, {
								text : 'Help',
								iconCls : 'icon-help',
								handler : function() {
									alert('help');
								}
							} ],
							buttons : [ {
								text : 'Save',
								handler : function() {
									alert('save');
								}
							}, {
								text : 'Close',
								plain:true,
								handler : function() {
									alert('close');
								}
							} ]

						});
						//$P.messager.alert('提示','请选择要删除的记录','error');
					}
				}
			}, '-', {
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
					var rows = datagrid.datagrid('getSelections');
					if (rows.length == 1) {
						datagrid.datagrid('removeEditor', 'bn');
						if (admin_goods_editRow != undefined) {
							datagrid.datagrid('endEdit', admin_goods_editRow);
						}
						if (admin_goods_editRow == undefined) {
							var index = datagrid.datagrid('getRowIndex', rows[0]);
							datagrid.datagrid('beginEdit', index); //行编辑的索引是从0开始的
							admin_goods_editRow = index;
							datagrid.datagrid('unselectAll');
						}
					} else if (rows.length < 1) {
						$.messager.alert('提示', '请选择需要修改的项目!', 'info');
					} else if (rows.length > 1) {
						$.messager.alert('提示', '同一时间只能编辑一条记录!', 'info');
					}
				}
			}, '-', {
				text : '保存',
				iconCls : 'icon-save',
				handler : function() {
					datagrid.datagrid('endEdit', admin_goods_editRow);
				}
			}, '-', {
				text : '取消编辑',
				iconCls : 'icon-redo',
				handler : function() {
					admin_goods_editRow = undefined;
					datagrid.datagrid('rejectChanges');
				}
			}, '-', {
				text : '取消选中',
				iconCls : 'icon-undo',
				handler : function() {
					datagrid.datagrid('clearSelections');
					datagrid.datagrid('unselectAll');
				}
			}, '-' ],
			onAfterEdit : function(rowIndex, rowData, changes) { //编辑之后执行
				/*
				$.ajax({
					url:'',
					type:'POST',
					datatype:'JSON',
					success:function(){
						$.messager.alert('提示','ok!');
				 */
				admin_goods_editRow = undefined;
				/*
				},
				error:function(){
					
				}
				});
				 */
			},
			onDblClickRow : function(rowIndex, rowData) { //双击编辑
				if (admin_goods_editRow != undefined) {
					datagrid.datagrid('endEdit', admin_goods_editRow);
				}
				if (admin_goods_editRow == undefined) {
					datagrid.datagrid('removeEditor', 'bn');
					datagrid.datagrid('beginEdit', rowIndex); //行编辑的索引是从0开始的
					admin_goods_editRow = rowIndex;
				}
			},
			loadFilter : function(data) {
				for ( var i = 0; i < data.rows.length; i++) {
					var row = data.rows[i];
					if (row.info == '1') {
						row.info = "click!";
					}
				}
				return data;
			}
		});

		admin_goods_search = function() {
			datagrid.datagrid('load', sy.serializeObject(admin_goods_searchForm));
		};
		admin_goods_clear = function() {
			datagrid.datagrid('load', {});
			admin_goods_searchForm.find('input').val('');
		};
		admin_goods_searchTable = $('#admin_goods_searchTable input').bind('keyup', function(event) {
			if (event.keyCode == 13) {
				admin_goods_search();
			}
		});
	});
</script>
</head>
<body>
	<div title="用户管理" class="easyui-layout"
		data-options="border:false,fit:true">
		<div data-options="region:'north',title:'查询',border:false"
			style="height: 105px;overflow: hidden">
			<form id='admin_goods_searchForm'>
				<table class="tableForm datagrid-toolbar"
					id="admin_goods_searchTable">
					<tr>
						<th>商品名称</th>
						<td><input name='name' />
						</td>
					</tr>
					<tr>
						<th>创建时间</th>
						<td><input name='createtimeStart' class='easyui-datetimebox'
							editable='false' />至<input name='createtimeEnd'
							class='easyui-datetimebox' editable='false' />
						</td>
					</tr>
					<tr>
						<th>最后修改时间</th>
						<td><input name='modifytimeStart' class='easyui-datetimebox'
							editable='false' />至<input name='modifytimeEnd'
							class='easyui-datetimebox' editable='false' /> <a
							class='easyui-linkbutton' plain='true' href='javascript:void(0)'
							onclick="admin_goods_search()">查询</a> <a
							class='easyui-linkbutton' plain='true' href='javascript:void(0)'
							onclick="admin_goods_clear()">清空</a></td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'center',fit:true" style="overflow: hidden">
			<table id="datagrid" data-options="fit:true"></table>
		</div>
		<div id="toolbar" style="display: none">12312312312312</div>
	</div>
</body>