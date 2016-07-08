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
<body>   
    <div id="index_login">
		<jsp:include page="login1.jsp"></jsp:include>
	</div>   
</body>
	<script type="text/javascript">
		$(function(){
			var index_login=$("#index_login");
			index_login.dialog({    
			    title: '登录',    
			    width: 300,    
			    height: 215,
			    closable:false
			}); 
		});
		//刷新验证码
		//实现思路，重新给图片的src赋值，后边加时间，防止缓存 
		function randomcode_refresh() {
			$("#randomcode_img").attr('src',
					'${baseurl}validatecode.jsp?time' + new Date().getTime());
		}
	</script>
</html>