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
	<table width="80%" border="1" cellspacing="0" cellpadding="0"  align="center" >
		<tr>
		<th align="center"><input name="checked" type="checkbox" /></th>
		<th align="center">ID</th>
		<th align="center">Name</th>
		<th align="center">Price</th>
		<th align="center">后台操作</th>
		</tr>
		<c:forEach items="${list}" var="customer">
		<tr>
			<td align="center"><input name="checked" type="checkbox"  value="${customer.id}"/></td>
			<td align="center">${customer.id}</td>
			<td align="center">${customer.flower_name}</td>	
			<td align="center">${customer.flower_price}</td>
			<td align="center">
				<a href="check?id=${customer.id}">确认订单</a>
				<a href="Delete?id=${customer.id}">取消订单</a>						
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>