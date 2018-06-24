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
		<th ><input name="checked" type="checkbox" /></th>
		<th >ID</th>
		<th >Name</th>
		<th >Price</th>
		<th>状态信息(0:未确认订单  1:已确认订单)</th>
		</tr>
		<c:forEach items="${list}" var="customer">
		<tr>
			<td align="center"><input name="checked" type="checkbox"  value="${customer.id}"/></td>
			<td align="center">${customer.id}</td>
			<td align="center">${customer.flower_name}</td>	
			<td align="center">${customer.flower_price}</td>
			<td align="center">${customer.updateStatus}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>