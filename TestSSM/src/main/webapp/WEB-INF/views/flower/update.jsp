<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="newUpdate" method="post">
	id:<input type="text" name="id" value="${newflower.id}"><br>
	name:<input type="text" name="name" value="${newflower.name}"><br>
	price<input type="text" name="price" value="${newflower.price}"><br>
	number<input type="text" name="number" value="${newflower.number}"><br>
	instruction<input type="text" name="introduction" value="${newflower.introduction}"><br>
	<input type="submit" value="提交">
	</form>
</body>
</html>