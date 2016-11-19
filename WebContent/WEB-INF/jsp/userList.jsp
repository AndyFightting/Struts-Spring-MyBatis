<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--用Struts的 s 标签要添加这个引用  -->
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<s:iterator var="user" value="userList">
			<s:property value="#user.name" />
			<br />
			<br />
		</s:iterator> 从数据库获取的user共：<s:property value="userList.size()" />条数据
	</div>
	<div>
		<label>${message}</label>
		<s:property value="user.name" />
		<s:property value="getA()" />

		<s:if test="null != errMap.get('msg')">
			<p>
				<s:property value="errMap.get('msg')" />
			</p>
		</s:if>
	</div>
</body>
</html>