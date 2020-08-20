<%@page import="edu.hbuas.entity.Users"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>用户登陆</title>
<link rel="stylesheet" href="../css/css.css" type="text/css"></link>
</head>
<body background="../pic/ManBgroud.gif">
	<table class="table2">
		<caption>用户列表</caption>

		<tr class="hd">
			<td>编号</td>
			<td>用户名</td>
			<td>密码</td>
		</tr>
		<c:forEach items="${sessionScope.allusers }" var="user">
		<tr>
			<td>${user.uid }</td>
			<td>${user.uname }</td>
			<td>${user.upwd }</td>
		</tr>
		</c:forEach>



	</table>
</body>
</html>