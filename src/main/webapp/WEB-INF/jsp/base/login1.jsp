<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="index_loginForm" method='post' action="${baseurl}login.action">
	<table style="margin: 30px auto;">
		<%-- <%=request.getAttribute("error")==null?"":request.getAttribute("error")%> --%>
		<tr><th>用户名</th><td><input name="username" class="easyui-validatebox" data-options="required:true,missingMessage:'请输入用户名！'"/> </td></tr>
		<tr><th>密码</th><td><input name="password" type="password" class="easyui-validatebox" data-options="required:true,missingMessage:'请输入密码！'"/> </td></tr>
		<tr>
			<th>验证码：</th>
			<td>
				<input id="randomcode" name="randomcode" size="8" />
			 	<img id="randomcode_img" src="${baseurl}validatecode.jsp" alt="" width="56" height="20" align="absMiddle"> <a href=javascript:randomcode_refresh()>刷新</a>
			 </td>
		</tr>
		<tr><td colspan="2" align="left"><span>记住我</span><input type="checkbox" name="rememberMe" /><input class="easyui-linkbutton" type="submit"/> </td></tr>
	</table>
</form>