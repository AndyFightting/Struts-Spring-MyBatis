<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--用Struts的 s 标签要添加这个引用  -->	
<%@ taglib prefix="s" uri="/struts-tags"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World</title>
</head>
<body>
	<form id="form" method="post" action="/TestDynamicWeb/web/addUser">
		<p>
			<label>name</label><input name="loginName" class="text-input"
				type="text" id="loginName" required="true"/>
		</p>
		<p>
			<label>password</label> <input name="password" class="text-input"
				type="password" id="loginName" required="true"/>
		</p>

		<input class="button" type="submit" value="添加用户" /> <input
			class="button" type="button" value="查看列表"
			onclick="location.href='/TestDynamicWeb/web/list'" />
	</form>
</body>
</html>