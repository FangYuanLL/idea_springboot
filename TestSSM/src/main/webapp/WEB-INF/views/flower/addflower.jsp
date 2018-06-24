<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="FlowerInformation" method="post" >
		<label style="width:50px;float:left;text-align:right;">花名</label>
		<input name="name" type="text"/><br/>
		<label style="width:50px;float:left;text-align:right;">价格</label>
		<input name="price" type="text"/><br/>
		<label style="width:50px;float:left;text-align:right;">数量</label>
		<input name="number" type="text"/><br/>
		<label style="width:50px;float:left;text-align:right;">介绍</label>
		<input name="introduction" type="text"/><br/>
		<br>
		<input type="submit" value="登录"/>
	</form>
	<span style="color:red;">${errorMsg}</span>
</body>
</html>