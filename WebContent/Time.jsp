<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	var xhr;
	function getTime() {
		//创建ajax对象
		try{
			xhr=new XMLHttpRequest();//0初始化状态
		}catch(e){
			xhr=new ActiveXObject("Microsoft.XMLHTTP");
		}
		//设置状态变化回调函数
		xhr.onreadystatechange=resCallback;
		//设置请求方式和url
		xhr.open("GET","time");//1初始状态
		//发送请求
		xhr.send(null);//2发送状态，收到响应头部信息时状态码3，完全接受时为4
	}
	//状态变化回调函数
	function resCallback() {
		if(xhr.readyState==4&&xhr.status==200){
			var resDiv =document.getElementById("result");
			var old=resDiv.innerHTML;
			resDiv.innerHTML=old+":"+xhr.responseText+"</br>";
		}
	}
</script>
<input type="button" value="获取时间" onclick="getTime()">
<div id="result">
<h3>无刷新技术</h3>
</div>
</body>
</html>