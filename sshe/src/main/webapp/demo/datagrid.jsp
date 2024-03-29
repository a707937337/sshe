<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript" charset="utf-8">
	var datagrid;
  	$(function(){
		$('#datagrid').datagrid({
			url:'userAction!test.action',//此处返回json
			title:'',
			iconCls:'icon-sage',
			pagination:true, //分页工具条
			pageSize:10,//页面大小
			pageList:[10,20,30,50,100,200],//可显示的pageSize条数,pageSize必须是pageList包含的,而且pageList是pageSize的倍数
			fit:true,//宽高自适应,适应于父类的框架大小
			fitColumns:true,//是否出现横向滚动,true:没有,false:有,  列不是很多的时候一般用true,很多的时候一般用false
			nowarp:false,//自动折行,如果一行的内容太多了,自定换行,默认是true,如果是false就会自动换行
			border:false,//边框
			idField:'id',//一个标示,例如 如果第一页选中两个,翻页在选中1个,点删除的时候删除的是3条数据!主要用于跨页删除
			sortName:'name',//按照什么排序
			sortOrder:'desc',//排序从高到低还是从低到高
			columns:[[{
				title:'编号',
				field:'id',
				width:100//宽度必须要给,不给可能出不来	
			},{
				title:'姓名',
				field:'name',
				width:100,//宽度必须要给,不给可能出不来
				sortable:true//可以点击的时候排序
			},{
				title:'密码',
				field:'password',
				width:100//宽度必须要给,不给可能出不来
			}]],
			toolbar:[{
				text:'增加',
				iconCls:'icon-add',
				handler:function(){
				}
			},'-',{
				text:'删除',
				iconCls:'icon-remove',
				handler:function(){
				}
			},'-',{
				text:'修改',
				iconCls:'icon-edit',
				handler:function(){
				}
			}]
		});
	});
</script>
	<div title="用户管理" border='false'>
		<table id="datagrid">  
			
		</table>
	</div>
