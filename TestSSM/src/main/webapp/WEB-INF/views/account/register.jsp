<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Register" method="post" >
		<label style="width:50px;float:left;text-align:right;">用户名</label>
		<input name="username" type="text"/><br/>
		<label style="width:50px;float:left;text-align:right;">密码</label>
		<input name="password" type="password"/><br/>
		<label style="width:50px;float:left;text-align:right;">电话</label>
		<input name="phone" type="text"/><br/>
		<label style="width:50px;float:left;text-align:right;">地址</label>
		<input name="adress" type="text"/><br/>
		<br>
		<input type="submit" value="登录"/>
	</form>
	<span style="color:red;">${errorMsg}</span>
</body>
</html>