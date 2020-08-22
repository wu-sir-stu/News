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
<input type="button" value="异步加载数据"  id="btnData" />
<div id="result">
	<table id="tb_result" style="width:300px" border:"1px" >
		<tbody>
			<tr><td>编号</td><td>姓名</td><td>性别</td><td>年龄</td></tr>
		</tbody>
	</table>
</div>
<script type="text/javascript">
$(function() {
	$("#btnData").click(function() {
		alert("点击")
		$.ajax({
			url:'data.json',
			type:'post',
			datatype:'json',
			success:function(data,status){
				alert(data.total);
				var row=data.rows;
				var str="";
				for(var i=0;i<row.length;i++){
					str+="<tr><td>"+row[i].u+"</td><td>"+row[i].name+"</td><td>"+row[i].sex+"</td><td>"+row[i].age+"</td></tr>";
					
				}
				$("#tb_result").append(str);
			},
			error:function(xhr,msg){
				alert(xhr+","+msg);
			}
		})
	})
})

</script>
</body>
</html>