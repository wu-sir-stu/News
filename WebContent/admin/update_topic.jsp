<%@page import="edu.hbuas.entity.Topic"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>修改主题</title>
<link rel="stylesheet" href="../css/css.css" type="text/css"></link>
</head>
<body background="../pic/ManBgroud.gif">
<%
Topic utopic=(Topic)session.getAttribute("utopic");

%>
	<form action="UpdateTopic" method="post">
	<input type="hidden" name="tid" value="<%=utopic.getTid()%>"/>
	<table class="table2">
		<caption>修改主题</caption>
		
		<tr><td>主题名称</td><td><input name="tname" value="<%=utopic.getTname() %>"/></td></tr>
		<tr><td colspan=2><input type="submit" value="提交"/>
		&nbsp;&nbsp;<input type="reset" value="重置"/>
		</td></tr>
	</table>	
	</form>
</body>
</html>