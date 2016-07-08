<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../tag.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${baseurl}jslib/easyui/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${baseurl}jslib/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${baseurl}jslib/easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="${baseurl}jslib/easyui/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="${baseurl}jslib/easyui/themes/icon.css" type="text/css"></link>
<script type="text/javascript" src="${baseurl}jslib/js/utils.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div id="user_layout">
		<div data-options='region:"north",border:false' title="查询条件" style="height:53px">
			<shiro:hasPermission name="user:search">
				<form id="user_searchForm">
					查询：<input name="username">
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun1();">查询</a>
					<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="clearFun1();">清空</a>
			</form>
			</shiro:hasPermission>
		</div>
		<div data-options='region:"center"'>
			<table id="user_dg"></table>
		</div>
	</div>
	<div id="user_toolbar">
		<shiro:hasPermission name="user:add">
			<div class="datagrid-btn-separator"></div>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" style="float:left" onclick="addFun1()">新增</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="user:update">
			<div class="datagrid-btn-separator"></div>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" style="float:left">修改</a>
		</shiro:hasPermission>
		<shiro:hasPermission name="user:delete">
			<div class="datagrid-btn-separator"></div>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" style="float:left">删除</a>
			<div class="datagrid-btn-separator"></div>
		</shiro:hasPermission>
	</div>
	<!-- 添加用户信息 -->
	<div id="user_dialog"></div>
</body>
<script type="text/javascript">
	var user_layout;
	var user_dg;
	var user_searchForm;
	var user_dialog;
	$(function(){
		//用户页面查询布局
		user_layout=$("#user_layout");
		user_layout.layout({
			fit:true,
			border:false
		}); 
		//用户页面数据显示
		user_dg=$('#user_dg');
		user_dg.datagrid({    
		    url:'${base}queryData.action',
		    border:false,
		    toolbar:"#user_toolbar",
		    pagination:true,
		    fitColumns:true,//列自适应
		    pageSize:10,
		    pageList:[5,10,20,30],
		    columns:[[    
		        {field:'id',title:'用户编号',width:100,align:'center'
		        },    
		        {field:'username',title:'登录名',width:100,align:'center'},    
		        {field:'pwd',title:'用户密码',width:100,
		        	formatter: function(value,row,index){
						return "*****"
					}
		        ,align:'center'
		        },  
		        {field:'locked',title:'用户状态',width:100,align:'center',
		        	formatter: function(value){
						if(value==1){
							return "<input type='button' value='禁用'/>"
						}
						if(value==0){
							return "<input type='button' value='启用'/>"
						}
					}	
		        }, 
		    ]]    
		});
		//添加用户信息面板显示
		user_dialog=$("#user_dialog");
		user_dialog.dialog({
			title:'添加用户',
			width:300,
			href:'${base}toAddUser.action',
			height:180,
			closed:true,
			modal:true,
			buttons:[{
				text:'添加',
				handler:function(){
					$("#user_addEddForm").form('submit',{
						url:'${base}doAddUser.action',
						success:function(data){ 	
							var obj=jQuery.parseJSON(data);
							if(obj==null){
								$.messager.show({
		    			        	title:'提示',
		    			        	msg:'该用户已存在!'
		    			        });
							};
							if(obj.username!=null){
								user_dialog.dialog("close");
								user_dg.datagrid('insertRow',{index:0,row:obj});
								user_dg.datagrid('selectRow',0);
							}
						}
					});
				}
				
			},{
				text:'取消',
				handler:function(){
					user_dialog.dialog("close");
				}
			}]
		});
	});
	function searchFun1(){
		user_searchForm=$("#user_searchForm");
		user_dg.datagrid('load',serializeObject(user_searchForm));
	}
	function clearFun1(){
		$("#user_layout input[name=username]").val('');
		user_dg.datagrid('load',{});
	}
	function addFun1(){
		user_dialog.dialog('open');
	}
</script>
</html>