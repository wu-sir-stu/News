<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-1.12.4.js"></script>
</head>
<body>

<script type="text/javascript">
$(function () {
	$("#username").blur(function () {
		$.get("userexist",{username:$("#username").val()},
				function (data,textStatus) {
					alert(data+":"+textStatus);
					var res =document.getElementById("result");
					res.innerHTML=data+"</br>";
				})
		
	})
	
});
	
</script>
	<form action="Login" method="post">
		<table width="89%" height="99" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="30%" height="30"><div align="right">用户名：</div></td>
				<td width="70%" height="30"><label> <input type="text"
						name="username" id="username" size="15" style="height: 22px" />
				</label><label id="result"></label></td>
			</tr>
			<tr>
				<td height="18"><div align="right">密 码：</div></td>
				<td height="18"><label> <input type="password"
						name="userpwd" size="15" style="height: 22px" />
				</label></td>
			</tr>
			<tr>
				<td height="18"><div align="right">
						<input type="checkbox" name="saveMessage" />
					</div></td>
				<td height="18"><label> <b>两周内自动登陆</b>
				</label></td>
			</tr>
			<tr>
				<td height="50">&nbsp;</td>

				<td height="50" valign="top"><input type="submit" value="提交">
					<input type="reset" value="取消"></td>
			</tr>
		</table>
	</form>
</body>
</html>