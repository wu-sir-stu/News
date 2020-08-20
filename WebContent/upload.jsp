<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- enctype="multipart/form-data" -->
<form action="UpLoadFile" method="post" enctype="multipart/form-data">
		<p><input type="file" name="uploadfile1"></p>
		<p><input type="file" name="uploadfile2"></p>
		<p><input type="file" name="uploadfile3"></p>
		<p><input type="text" name="username" value="" /></p>
		<p><input type="submit" value="提交"/>
		&nbsp;&nbsp;<input type="reset" value="重置"/>
		</p>
</form>	
</body>
</html>