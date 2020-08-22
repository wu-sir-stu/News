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

<script src="js/jquery-1.12.4.js"></script>
</head>
<body>
	<script type="text/javascript">
	$(function () {
		$("#txtSearch").keyup(function () {
			$.post("GetUsername",{keyname:$("#txtSearch").val()},resCallback)
			
		})
		
	})
	
		//状态变化回调函数
		function resCallback(data) {
			
				var res = $("#suggest");
				res.innerHTML="";
				var str=data.split(",");
				var su="";
				if(str.length>0&&str[0].length>0){
					for(i=0;i<str.length;i++){
						su+="<div onmouseover='suggestOver(this)'";
						su+="onmouseout='suggestOut(this)'";
						su+="onclick='setSearch(this.innerHTML)'";
						su+="class='suggest_link'>"+str[i]+"</div>";
					}
					res.html(su).css("display","block");
					
				}else{
					res.css("display","none");
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
		<input type="text" id="txtSearch" name="txtSearch" >
		<input type="submit" value="搜索">
		<div id="suggest"></div>
	</div>
</body>
</html>