<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="<%=request.getContextPath()%>/js/jquery-3.1.1.min.js"></script>
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="UpdateServlet">
		<c:forEach items="${list}" var="books">
			id:<input type="text" name="id" value="${books.id}"><br>
			name:<input type="text" name="name" value="${books.name}"><br>
			price:<input type="text" name="price" value="${books.price}"><br>
			publishTime:<input type="text" name="publishTime" value="${books.publishTime}"><br>
			author:<input type="text" name="author" value="${books.author}">
		</c:forEach>
			<input type="submit" value="提交">
	</form>
</body>
</html>