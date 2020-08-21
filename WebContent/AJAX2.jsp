<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	font: 16px/22px arial;
}

#txtSearch {
	width: 300px;
	height: 22px;
	line-hight: 22px;
	border: 1px solid #999;
}

.suggest_link {
	padding: 2px 6px 2px 6px;
}

.suggest_link_over {
	background-color: #E8F2FE;
	padding: 2px 6px 2px 6px;
}

#suggest {
	width: 300px;
	margin-top: 1px;
	position: absolute;
	text-align: left;
	border: 1px solid #999;
	display: none;
}
</style>
</head>
<body>
	<script type="text/javascript">
		var xhr;
		function getuers() {
			var username = document.getElementById("txtSearch").value;
			//创建ajax对象
			try {
				xhr = new XMLHttpRequest();//0初始化状态
			} catch (e) {
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			}
			//设置状态变化回调函数
			xhr.onreadystatechange = resCallback;
			//设置请求方式和url
			xhr.open("POST", "GetUsername?keyname=" + username);//1初始状态
			//发送请求
			xhr.send(null);//2发送状态，收到响应头部信息时状态码3，完全接受时为4
		}
		//状态变化回调函数
		function resCallback() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var res = document.getElementById("suggest");
				res.innerHTML="";
				var str=xhr.responseText.split(",");
				var su="";
				if(str.length>0&&str[0].length>0){
					for(i=0;i<str.length;i++){
						su+="<div onmouseover='suggestOver(this)'";
						su+="onmouseout='suggestOut(this)'";
						su+="onclick='setSearch(this.innerHTML)'";
						su+="class='suggest_link'>"+str[i]+"</div>";
					}
					res.innerHTML=su;
					document.getElementById("suggest").style.display="block";
				}else{
					document.getElementById("suggest").style.display="none";
				}
			}
		}
		function suggestOver(obj) {
			obj.className="suggest_link_over";
		}
		function suggestOut(obj) {
			obj.className="suggest_link";
		}
		function setSearch(obj) {
			document.getElementById("txtSearch").value=obj;
			document.getElementById("suggest").style.display="none";
		}
	</script>

	<h3>AJAX自动补全</h3>
	<div style="width: 500px">
		<input type="text" id="txtSearch" name="txtSearch" onkeyup="getuers()">
		<input type="submit" value="搜索">
		<div id="suggest"></div>
	</div>
</body>
</html>