<%@page import="edu.hbuas.entity.Topic"%>
<%@page import="edu.hbuas.entity.News"%>
<%@page import="edu.hbuas.service.impl.TopicServiceImpl"%>
<%@page import="edu.hbuas.service.TopicService"%>
<%@page import="edu.hbuas.service.impl.NewsServiceImpl"%>
<%@page import="edu.hbuas.service.NewsService"%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>新闻中国</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
  <div id="top_login">
    <label> 登录名 </label>
    <input type="text" id="uname" value="" class="login_input" />
    <label> 密&#160;&#160;码 </label>
    <input type="password" id="upwd" value="" class="login_input" />
    <input type="button" class="login_sub" value="登录" onclick="login()"/>
    <label id="error"> </label>
    <img src="Images/friend_logo.gif" alt="Google" id="friend_logo" /> </div>
  <div id="nav">
   
 <img src="Images/ad.gif" alt="" />
 
  </div>
</div>
<div id="container">
新闻详情 
  <!-- 新闻详情 -->
  <%
  request.setCharacterEncoding("utf-8");
  int nid=Integer.parseInt(request.getParameter("nid"));
  NewsService ns=new NewsServiceImpl();
  TopicService ts=new TopicServiceImpl();
  List<Topic> alltopic=ts.getalltopic();
  News news=ns.getnewsbynid(nid);
  String tname="";
  for(int i=0;i<alltopic.size();i++){
		Topic topic=alltopic.get(i);
		if(news.getNtid()==topic.getTid()){
			tname=topic.getTname();
			break;
		}
	}
  %>

  <h3 align="center"><%=news.getNtitle() %></h3>
 
  <h6 align="center">作者：<%=news.getNauthor() %>&nbsp;发布时间：<%=news.getNcreateDate() %></h6>
<div>
<%=news.getNcontent() %>
</div>
</div>
<div id="friend">
  <h1 class="friend_t"> <img src="Images/friend_ico.gif" alt="合作伙伴" /> </h1>
  <div class="friend_list">
    <ul>
      <li> <a href="#">中国政府网</a> </li>
      <li> <a href="#">中国政府网</a> </li>
      <li> <a href="#">中国政府网</a> </li>
      <li> <a href="#">中国政府网</a> </li>
      <li> <a href="#">中国政府网</a> </li>
      <li> <a href="#">中国政府网</a> </li>
      <li> <a href="#">中国政府网</a> </li>
	  <li> <a href="#">中国政府网</a> </li>
      <li> <a href="#">中国政府网</a> </li>
	  <li> <a href="#">中国政府网</a> </li>
      <li> <a href="#">中国政府网</a> </li>
	  <li> <a href="#">中国政府网</a> </li>
      <li> <a href="#">中国政府网</a> </li>
    </ul>
  </div>
</div>
<div id="footer">
  <p class=""> 24小时客户服务热线：010-88888888 &#160;&#160;&#160;&#160; <a href="#">常见问题解答</a> &#160;&#160;&#160;&#160; 新闻热线：010-888888888 <br /> </p>
  <p class="copyright"> Copyright &copy; 1999-2010 News China gov, All Right Reserver <br />
    新闻中心 版权所有 </p>
</div>
</body>
</html>
