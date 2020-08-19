<%@page import="edu.hbuas.entity.Topic"%>
<%@page import="edu.hbuas.entity.News"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>新闻列表</title>
<link rel="stylesheet" href="../css/css.css" type="text/css"></link>
<style type="text/css">
table{
width:700px;
table-layout: fixed;
}
td{
text-align:center;

width: 100px;

overflow:hidden;
white-space: nowrap;
text-overflow: ellipsis;
}
</style>
</head>
<body background="../pic/ManBgroud.gif">
	<table class="table2">
		<caption>新闻列表</caption>
		
		<tr class="hd">
		<td>编号</td>
		<td>主题</td>
		<td>标题</td>
		<td>作者</td>
		
		<td>内容</td>
		
		<td>概要</td>
		<td>操作</td>
		</tr>
		<%
		List<News> allnews=(List<News>)session.getAttribute("allnews");
		List<Topic> alltopic=(List<Topic>)session.getAttribute("alltopic");
		for(News n:allnews){
			//根据tid获取tname
			String tname="";
			for(int i=0;i<alltopic.size();i++){
				Topic topic=alltopic.get(i);
				if(n.getNtid()==topic.getTid()){
					tname=topic.getTname();
					break;
				}
			}
			%>
			<tr>
			<td><%=n.getNid() %></td>
			<td><%=tname %></td>
			<td><%=n.getNauthor() %></td>
			<td><%=n.getNtitle() %></td>
			
			<td><%=n.getNcontent() %></td>
			
			<td><%=n.getNsummary() %></td>
			<td><a href="DeleteNewsByNid?nid=<%=n.getNid() %>" onclick="return confirm('确认删除吗？')">删除</a>&nbsp;&nbsp;&nbsp;<a href="GetNewsBynid?nid=<%=n.getNid() %>">修改</a></td>
			</tr>
			<%
		}
		%>
	</table>	
</body>
</html>