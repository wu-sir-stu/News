<%@page import="edu.hbuas.dbutil.PageUtil"%>
<%@page import="edu.hbuas.entity.Topic"%>
<%@page import="edu.hbuas.entity.News"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>新闻列表</title>
<link rel="stylesheet" href="../css/css.css" type="text/css"></link>
<style type="text/css">
table {
	width: 700px;
	table-layout: fixed;
}

td {
	text-align: center;
	width: 100px;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}
</style>
</head>
<body background="../pic/ManBgroud.gif">
	<input type="hidden" name="nid" value="${sessionScope.pageIndex }" />
	<input type="hidden" name="nid" value="${sessionScope.totalPages }" />
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
		<c:forEach items="${sessionScope.pagenews }" var="news">
			<c:forEach items="${sessionScope.alltopic }" var="topics">
				<c:if test="${news.ntid eq topics.tid }">
					<c:set var="tname" value="${topics.tname }" scope="request"></c:set>

				</c:if>

			</c:forEach>
			<tr>
				<td>${news.nid }</td>
				<td><c:out value="${tname }"></c:out></td>
				<td>${news.ntitle }</td>
				<td>${news.nauthor }</td>

				<td>${news.ncontent }</td>

				<td>${news.nsummary }</td>
				<td><a href="DeleteNewsByNid?nid=${news.nid }"
					onclick="return confirm('确认删除吗？')">删除</a>&nbsp;&nbsp;&nbsp;<a
					href="GetNewsBynid?nid=${news.nid }">修改</a></td>
			</tr>
		</c:forEach>

		<tr>
			<!-- 分页链接 -->
			<td colspan="7" align="right"><a href="GetAllNews?pageIndex=1">首页</a>
				<a href="GetAllNews?pageIndex=${sessionScope.pageIndex+1 }">下一页</a>
				<a href="GetAllNews?pageIndex=${sessionScope.pageIndex-1 }">上一页</a>
				<a href="GetAllNews?pageIndex=${sessionScope.totalPages }">尾页</a> <a>当前页:${sessionScope.pageIndex }/${sessionScope.totalPages }</a>
				跳转到:<input type="text" id="pageIndex" size="10" />页 <input
				type="button" value="GO" onclick="go()" /> <script
					type="text/javascript">
					function go() {
						var pageIndex = document.getElementById("pageIndex").value;

						if (pageIndex == "") {
							alert("页码不能为空！");
							pageIndex = "-1";
						}
						location.href = "GetAllNews?pageIndex=" + pageIndex;
					}
				</script></td>

		</tr>
	</table>
</body>
</html>