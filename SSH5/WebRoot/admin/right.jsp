<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'left.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" href="/SSH5/css/common.css" type="text/css"></link>
		<link rel="stylesheet" href="/SSH5/css/index.css" type="text/css"></link>
		<link rel="stylesheet" href="/SSH5/css/foot.css" type="text/css"></link>
		<link rel="stylesheet" href="/SSH5/css/head.css" type="text/css"></link>
	</head>

	<body>

		<div class="span1">
			<div class="admin_index">
				<span class="span2">欢迎<s:property
						value="#session.loginInfo.name" />登陆</span>
				<span class="span2"><a
					href="<%=basePath%>admin/log_out!logout" target="_parent">安全退出</a>
				</span>


			</div>
		</div>

		<center>
			<span class="span5"> 欢迎登陆科研信息管理系统</span>
		</center>
	</body>
</html>
