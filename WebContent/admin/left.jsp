<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="edu.hbuas.entity.Users" %>

<html>
<head>
<title></title>
<style type="text/css">
body {
	background-image: url(pic/LeftBgroud.gif);
}

</style>
<link rel="stylesheet" href="../css/css.css" type="text/css"></link></head>

<body leftmargin="0" topmargin="0" >
  <table width="170" height="135" align="center" cellpadding="0" cellspacing="0" background="pic/msg.gif">
    <tr>
      <td width="170" height="64" valign="bottom" background="" class="menu_title"><table width="100%" height="21" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="80">&nbsp;</td>
          <td><a href="RemoveSession" target="_parent"><strong>退出系统</strong></a></td>
        </tr>
        
      </table></td>
    </tr>
    <tr>
      <td width="170" align="center"><table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="38%">&nbsp;</td>
          <%
            Users loginusers=(Users) session.getAttribute("loginuser");
          %>
          <td width="62%"><span class="red_9">&nbsp;&nbsp;<%=loginusers.getUname() %></span></td>
        </tr>
        <tr>
          <td width="38%">&nbsp;</td>
          <td>&nbsp;<span class="red_9">&nbsp;&nbsp;1级</span></td>
        </tr>
      </table></td>
    </tr>
  </table>
  <table width="170" align="center" height="25" cellpadding="0" cellspacing="0" >
  <tr align="center">
  	<td background="pic/bar.gif" valign="middle"><a href="GetAllUsers" target="main"><strong>查看用户</strong></a></td>
  </tr>
  </table>
  
  <table width="170" align="center" height="25" cellpadding="0" cellspacing="0" >
  <tr align="center">
  	<td background="pic/bar.gif" valign="middle"><a href="add_topic.jsp" target="main"><strong>添加主题</strong></a></td>
  </tr>
  </table>
  
  <table width="170" align="center" height="25" cellpadding="0" cellspacing="0" >
  <tr align="center">
  	<td background="pic/bar.gif" valign="middle"><a href="GetAllTopic" target="main"><strong>查看主题</strong></a></td>
  </tr>
  </table>
  
  <table width="170" align="center" height="25" cellpadding="0" cellspacing="0" >
  <tr align="center">
  	<td background="pic/bar.gif" valign="middle"><a href="GetAllNews" target="main"><strong>查看新闻</strong></a></td>
  </tr>
  </table>
  
  <table width="170" align="center" height="25" cellpadding="0" cellspacing="0" >
  <tr align="center">
  	<td background="pic/bar.gif" valign="middle"><a href="AddNewsGetTopic" target="main"><strong>添加新闻</strong></a></td>
  </tr>
  </table>
  <table width="170" align="center" height="25" cellpadding="0" cellspacing="0" >
  <tr align="center">
  	<td background="pic/bar.gif" valign="middle"><a href="#"><strong>编辑新闻</strong></a></td>
  </tr>
  </table>

</body>
</html>