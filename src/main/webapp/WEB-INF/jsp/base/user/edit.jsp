<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="user_addEddForm" method="post">
	<table style="margin:5px auto">
		<tr><th>用户名</th><td><input type="hidden" name="id"/><input name="username" class="easyui-validatebox" data-options="required:true,missingMessage:'请输入用户名！'"/> </td></tr>
		<tr><th>密码</th><td><input name="pwd" type="password" class="easyui-validatebox" data-options="required:true,missingMessage:'请输入密码！'" /> </td></tr>
		<tr><th>重复密码</th><td><input name="eqpwd" type="password" class="easyui-validatebox" data-options="required:true,missingMessage:'请重复输入密码！',validType:'eqPwd[\'#user_addEddForm input[name=pwd]\']'" /></td></tr>
	</table>
</form>