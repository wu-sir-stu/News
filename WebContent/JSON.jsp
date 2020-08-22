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
var jsontext='{"persons":[{"name":"www","sex":"m","age":"22"},{"name":"zzz","sex":"m","age":"33"}]}';
var myjson=eval("("+jsontext+")");
var myjson2=JSON.parse(jsontext);
document.writeln('转换前的json对象：'+jsontext);
document.writeln('转换后的json对象：'+myjson);
document.writeln('转换后的json对象2：'+myjson2);
document.writeln('<br>'+myjson.persons[0].name);
document.writeln('<br>'+myjson2.persons[1].name);
</script>
</body>
</html>