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
	<div id="role_layout">
		<div data-options='region:"center"'>
			<table id="role_dg"></table>
		</div>
	</div>
	
	
	
	<!-- 显示该角色对应的菜单信息 -->
	<div id="showMenu_2_dialog"></div>
</body>
	<script type="text/javascript">
		var role_layout;
		var role_dg;
		var showMenu_2_dialog;
		$(function(){
			//角色页面查询布局
			role_layout=$("#role_layout");
			role_layout.layout({
				fit:true,
				border:false
			});
			//角色页面数据显示
			role_dg=$('#role_dg');
			role_dg.datagrid({
				border:false,
				url:'${base}queryRoleData.action',
				columns:[[ 
					{field:'rolename',title:'角色名称',width:100,align:'center'},
					{field:'id',title:'权限管理',width:100,align:'center',
						formatter: function(value){
							return "<input type='button' class='easyui-button' value='菜单管理' onclick='toMenu_2("+value+")'/>"
						}		
					}
				    ]]
			});
			//显示该角色对应的菜单信息 
			showMenu_2_dialog=$("#showMenu_2_dialog");
			showMenu_2_dialog.dialog({
				title:'菜单管理',
				href:'',
				width:300,
				height:180,
				closed:true,
				modal:true
			});
		});
		 
		function toMenu_2(id){
			showMenu_2_dialog.dialog('open');
		};
		
		
	</script>
</html>