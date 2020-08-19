<%@page import="edu.hbuas.entity.Topic"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>主题列表</title>
<link rel="stylesheet" href="../css/css.css" type="text/css"></link>
</head>
<body background="../pic/ManBgroud.gif">
	<table class="table2">
		<caption>主题列表</caption>
		<tr class="hd"><td>编号</td><td>主题</td><td>操作</td></tr>
		<%
			List<Topic> topics= (List<Topic>) session.getAttribute("alltopics");
			for (int i=0;i<topics.size();i++){
				Topic topic=topics.get(i);
				%>
		<tr>
			<td><%=topic.getTid()%></td>
			<td><%=topic.getTname()%></td>
			<td><a href="DeleteTopic?tid=<%=topic.getTid()%>" onclick="">删除</a>&nbsp;&nbsp;&nbsp;<a href="GetTopicById?tid=<%=topic.getTid()%>">修改</a> </td>
		</tr>


		<%
			}

		%>

	</table>
</body>
</html>