<%@page import="edu.hbuas.dao.impl.NewsDaoImpl"%>
<%@page import="edu.hbuas.dao.NewsDao"%>
<%@page import="edu.hbuas.entity.News"%>
<%@page import="edu.hbuas.service.impl.NewsServiceImpl"%>
<%@page import="edu.hbuas.service.NewsService"%>
<%@page import="edu.hbuas.entity.Topic"%>
<%@page import="edu.hbuas.service.impl.TopicServiceImpl"%>
<%@page import="edu.hbuas.service.TopicService"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
  <div class="sidebar">
    <h1> <img src="Images/title_1.gif" alt="国内新闻" /> </h1>
    <div class="side_list">
      <ul>
      <!-- 国内新闻 -->
      <%
      NewsDao nd=new NewsDaoImpl();
      List<News> getnews1=nd.getnewsbyntid(16);
      for(News n:getnews1){
    	  %>
    	 <li><a href="newsinfo.jsp?nid=<%=n.getNid()%>"><%=n.getNtitle() %></a><span><%=n.getNcreateDate() %></span></li>
    	  <%
      }
      %>
      </ul>
    </div>
    <h1> <img src="Images/title_2.gif" alt="国际新闻" /> </h1>
    <div class="side_list">
      <ul>
       <!-- 国际新闻 -->
       <%
       List<News> getnews2=nd.getnewsbyntid(17);
       for(News n:getnews2){
     	  %>
     	 <li><a href="newsinfo.jsp?nid=<%=n.getNid()%>"><%=n.getNtitle() %></a><span><%=n.getNcreateDate() %></span></li>
     	  <%
       }
       %>
      </ul>
    </div>
    <h1> <img src="Images/title_3.gif" alt="娱乐新闻" /> </h1>
    <div class="side_list">
      <ul>
        <!-- 娱乐新闻 -->
        <%
        List<News> getnews3=nd.getnewsbyntid(18);
        for(News n:getnews3){
      	  %>
      	 <li><a href="newsinfo.jsp?nid=<%=n.getNid()%>"><%=n.getNtitle() %></a><span><%=n.getNcreateDate() %></span></li>
      	  <%
        }
        %>
      </ul>
    </div>
  </div>
  <div class="main">
    <div class="class_type"> <img src="Images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
      <ul class="class_date">
        <li id='class_month'>
        	<!-- 新闻主题（类型） -->
        	<%
        	//调用业务层
        	TopicService ts=new TopicServiceImpl();
        	List<Topic> alltopic=ts.getalltopic();
        	for(Topic t:alltopic){
        		%>
        		<a href="#"><%=t.getTname() %></a>
        		<%
        	}
        	%>
        </li>
      </ul>
      <ul class="classlist">
      
      <!-- 新闻列表 -->
      <%
      NewsService ns=new NewsServiceImpl();
      List<News> allnews=ns.getallnews();
      for(News n:allnews){
    	  %>
    	  <li><a href="newsinfo.jsp?nid=<%=n.getNid()%>"><%=n.getNtitle() %></a><span><%=n.getNcreateDate() %></span></li>
    	  <%
      }
      %>
      
      </ul>
    </div>
    <div class="picnews">
      <ul>
        <li> <a href="#"><img src="Images/Picture1.jpg" width="249" alt="" /> </a><a href="#">伦敦骚乱情景堪比二战空袭</a> </li>
        <li> <a href="#"><img src="Images/Picture2.jpg" width="249" alt="" /> </a><a href="#">故事：贫困生的大学梦</a> </li>
        <li> <a href="#"><img src="Images/Picture3.jpg" width="249" alt="" /> </a><a href="#">北京暴雨地铁13号线中断</a> </li>
        <li> <a href="#"><img src="Images/Picture4.jpg" width="249" alt="" /> </a><a href="#">斯杯决赛宝贝争与球员合影</a> </li>
      </ul>
    </div>
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
