<%@page import="edu.hbuas.entity.News"%>
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
<form action="UpdateNews" method="post" >
<%
News getnews=(News)session.getAttribute("getnews");
%>
<input type="hidden" name="nid" value="<%=getnews.getNid()%>"/>
	<table class="table1">
		<caption>新闻发布</caption>
		<tr><td>主题<select name="ntid">
				<%
				 
				List<Topic> alltopics2=(List<Topic>)session.getAttribute("alltopics2");
				for(Topic t:alltopics2){
					if(t.getTid()==getnews.getNtid()){
					
					%>
					<option value="<%=t.getTid()%>" selected="selected"><%=t.getTname() %></option>
					<%
					}else{
						%>
						<option value="<%=t.getTid()%>"><%=t.getTname() %></option>
						<%	
					}
				}
				%>
			</select>
		</td></tr>
		
		<tr><td>标题<input name="ntitle" value="<%=getnews.getNtitle()%>"/></td></tr>
		<tr><td>作者<input name="nauthor" value="<%=getnews.getNauthor()%>"/></td></tr>
		<tr><td>摘要<textarea name="nsummary" cols="25" rows="3" ><%=getnews.getNsummary()%></textarea></td></tr>
		<tr><td>内容<textarea name="ncontent" cols="50" rows="10" ><%=getnews.getNcontent()%></textarea></td></tr>
		
		<tr><td colspan=2 align="center"><input type="submit" value="提交"/>
		&nbsp;&nbsp;<input type="reset" value="重置"/>
		</td></tr>
	</table>	
</form>	
</body>
</html>