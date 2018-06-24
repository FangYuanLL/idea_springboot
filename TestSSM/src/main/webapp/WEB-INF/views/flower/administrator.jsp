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
	<table width="80%" border="0" cellspacing="0" cellpadding="0"  align="center" >
		<tr>
			<th>
				<a href="FindAll">后台管理|</a>
				<a href="Boss">账单管理|</a>
				<a href="addFlower">Add new Flower</a>
			</th>
		</tr>
	</table>
	<table width="80%" border="1" cellspacing="0" cellpadding="0"  align="center" >
		<tr>
		<th ><input name="checked" type="checkbox" /></th>
		<th >ID</th>
		<th >Name</th>
		<th >Price</th>
		<th >number</th>
		<th >Introduction</th>
		<th>后台操作</th>
		</tr>
		<c:forEach items="${list}" var="flower">
		<tr>
			<td ><input name="checked" type="checkbox"  value="${flower.id}"/></td>
			<td >${flower.id}</td>
			<td >${flower.name}</td>	
			<td >${flower.price}</td>
			<td >${flower.number}</td>
			<td >${flower.introduction}</td>
			<td>
				<a href="Delete?id=${flower.id}">删除</a>
				<a href="Update?id=${flower.id}">修改</a>						
			</td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>