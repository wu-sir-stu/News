<%@page import="edu.hbuas.entity.Topic"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>新闻发布</title>
<link rel="stylesheet" href="../css/css.css" type="text/css"></link>

</head>
<body background="../pic/ManBgroud.gif">
<!-- enctype="multipart/form-data" -->
<form action="AddNews" method="post" >
	<table class="table1">
		<caption>新闻发布</caption>
		<tr><td>主题<select name="ntname">
				<%
				List<Topic> addnewstopic=(List<Topic>)session.getAttribute("addnewstopic");
				for(Topic t:addnewstopic){
					%>
					<option><%=t.getTname() %></option>
					<%
				}
				%>
			</select>
		</td></tr>
		
		<tr><td>标题<input name="ntitle"/></td></tr>
		<tr><td>作者<input name="nauthor"/></td></tr>
		<tr><td>摘要<textarea name="nsummary" cols="25" rows="3"></textarea></td></tr>
		<tr><td>内容<textarea name="ncontent" cols="50" rows="10"></textarea></td></tr>
		
		<tr><td colspan=2 align="center"><input type="submit" value="提交"/>
		&nbsp;&nbsp;<input type="reset" value="重置"/>
		</td></tr>
	</table>	
</form>	
</body>
</html>