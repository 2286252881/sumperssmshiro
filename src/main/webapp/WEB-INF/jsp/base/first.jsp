<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${baseurl}jslib/easyui/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${baseurl}jslib/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${baseurl}jslib/easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="${baseurl}jslib/easyui/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="${baseurl}jslib/easyui/themes/icon.css" type="text/css"></link>
<title>Insert title here</title>
</head>
<body class="easyui-layout">   
    <div data-options="region:'north',title:'shiro权限管理系统',split:true" style="height:80px;">
    	<span>欢迎当前用户${activeUser.username}</span>
    	<a href="${base}logout.action">退出登录</a>
    </div>   
    <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>   
    <div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:200px;"></div>
    <div data-options="region:'west',split:true" style="width:180px">   
    	<div class="easyui-panel" data-options="title:'功能菜单',fit:true,border:false">
    		<div class="easyui-accordion" data-options="fit:true,border:false">
    			<c:if test="${activeUser.menus!=null}">
    				<c:forEach items="${activeUser.menus}" var="menu">
							<div title="${menu.menuname}">
								<c:forEach  items="${menu.menus}" var="m2">
									<div style="padding-top:8px;padding-left:25px;">
										<a style="text-decoration: none;font-size: 14px" href=javascript:addTab('${m2.menuname}','${baseurl}${m2.url}')>${m2.menuname}</a>
									</div>
								</c:forEach>
							</div>
					</c:forEach>
    			</c:if>
    		</div>
    	</div>
	</div>  
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,border:false">  
    		<div title="首页" data-options="closable:false">   
		    	欢迎使用本系统
		    </div> 
		</div>  
    </div>
    <script type="text/javascript">
	    addTab=function(name,url){
	    	var ifream='<iframe frameborder="0"  style="border:0;width:100%;height:100%" src="'+url+'"></iframe>'
	    	if($('#tt').tabs('exists',name)){
	    		//如果存在就选中
	    		$('#tt').tabs('select',name);
	    		var currTab = $('#tt').tabs('getSelected');
	    		$('#tt').tabs('update',{
	                 tab:currTab,
	                 options:{
	                	 content:ifream
	                 }
	            })
	    	}else{
	    		$('#tt').tabs('add',{
	    			tabPosition:'left',
	    			title:name,
	    			closable:true,
	    			content:ifream,
	    			tools:[{
						iconCls:'icon-mini-refresh',
						handler:function(){
							$('#tt').tabs('update',{
				                 tab:$('#tt').tabs('getSelected'),
				                 options:{
				                	 content:ifream
				                 }
				            })
						}
					}]
	    		});
	    	}
		};
    </script>  
</body>
	
</html>