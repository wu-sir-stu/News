<%@page import="edu.hbuas.entity.Users"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>用户登陆</title>
<link rel="stylesheet" href="../css/css.css" type="text/css"></link>
</head>
<body background="../pic/ManBgroud.gif">
	<table class="table2">
		<caption>用户列表</caption>

		<tr class="hd"><td>编号</td><td>用户名</td><td>密码</td></tr>

			<%
				List<Users> allusers= (List<Users>) session.getAttribute("allusers");
				for (int i=0;i<allusers.size();i++){
					Users user=allusers.get(i);
					%>
		<tr>
			<td><%=user.getUid()%></td>
			<td><%=user.getUname()%></td>
			<td><%=user.getUpwd()%></td>
		</tr>
		<%
				}
			%>

	</table>		
</body>
</html>