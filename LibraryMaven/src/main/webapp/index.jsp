<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/style1.css" type="text/css" media="all" />
<!--使用EL表达式时一定要写及其重要，不然EL表达式会被忽略-->
<script src="<%=request.getContextPath()%>/js/jquery-3.1.1.min.js"></script>
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function $(obj){return document.getElementById(obj);} 
	function show(objid) {$(objid).style.display='inline';} 
	function hidden(objid) {$(objid).style.display='none';} 
	function doit(){ 
		var sel_val='';
		sel_val=$('option_check').value; 
		if (sel_val=='') {show('a1');hidden('a2');hidden('aa');hidden('a3');hidden('a4');hidden('a5');} 
		if (sel_val=='name_check') {show('a1');hidden('a2');hidden('aa');hidden('a3');hidden('a4');hidden('a5');} 
		if (sel_val=='price_check') {hidden('a1');show('a2');show('aa');show('a3');hidden('a4');hidden('a5');} 
		if (sel_val=='date_check') {hidden('a1');hidden('a2');hidden('aa');hidden('a3');show('a4');hidden('a5');} 
		if (sel_val=='abstract_check') {hidden('a1');hidden('a2');hidden('aa');hidden('a3');hidden('a4');show('a5');} 
	} 
	function cancalBook()
	{
			
		  var obj=document.getElementsByName("checked");
		  var str=[];
		  for (var k=1;k<obj.length;k++)
		   {
		    if(obj[k].checked)
		    {
		    	str.push(obj[k].value);
		    }
		   }
		   if(str.length!=0)
		   {
		 		window.location.href="QueryDeleteServlet?method=service&str="+str;
		   }
		   else
		    {
		    	layer.alert("请选择图书！");
		    } 
	}
</script>
</head>
<body style="text-align: center">
	<div id="header">
		<div class="shell">
			<!-- Logo + Top Nav -->
			<div id="top">
				<h1><a href="#">SpringTime</a></h1>
				<div id="top-navigation">
					<a href="login.jsp">Log out</a>
				</div>
			</div>
		</div>
	</div>
	
	<br/>
	<div id="container">
	<div class="shell">
		<div class="small-nav">
			<a href="Administrator">Administrator</a>
			<span>&gt;</span>
			Current Articles
		</div>
		<br />
		<div id="main">
			<div class="cl">&nbsp;</div>
			<div id="content">
				<div class="box">
					<!-- Box Head -->
					<div class="box-head">
						<h2 class="left">Current Articles</h2>
						<div class="right">
							<form action="SearchServlet">
								<select id="option_check" name="context" onchange="javascript:doit();">
								  <option value ="name_check">书名</option>
								  <option value ="price_check">价格</option>
								  <option value="date_check">出版时间</option>
								  <option value="abstract_check">模糊查询</option>
								</select>
								<input style="height:20px" type="text" name="name_input" id="a1">
								<input style="height:20px;width:40px;display:none" type="text" name="price1_input" id="a2">
								<span style="display:none;" id="aa"> - </span>
								<input style="height:20px;width:40px;display:none" type="text" name="price2_input" id="a3">
								<input style="height:20px;display:none" type="text" name="date_input" id="a4">
								<input style="height:20px;display:none" type="text" name="abstract_input" id="a5">
								<input style="height:20px" type="submit" value="搜索">
								<a href="AddBook.jsp">添加</a>
							</form>
						</div>
					</div>
					<div class="table">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<th width="13"><input name="checked" type="checkbox" value=""/></th>
								<th>ID</th>
								<th>Name</th>
								<th>Price</th>
								<th>PublishTime</th>
								<th>Author</th>
								<th width="110" class="ac">Content Control</th>
							</tr>
							<c:forEach items="${list}" var="Books">
								<tr>
									<td width="13"><input name="checked" type="checkbox"  value="${Books.id}"/></td>
									<td>${Books.id}</td>
									<td>${Books.name}</td>	
									<td>${Books.price}</td>
									<td>${Books.publishTime}</td>
									<td>${Books.author}</td>
									<td>
										<a href="DeleteServlet?id=${Books.id}">删除</a>
										<a href="EditServlet?id=${Books.id}">修改</a>
										
									</td>
								</tr>
							</c:forEach>
						</table>
						<div class="pagging">
							<div class="right">
								<a href="Administrator">首页</a>&nbsp;  
								<a href="Administrator?page=${requestScope.newpage.pageNow-1}">上一页</a>&nbsp;
								<a href="Administrator?page=${newpage.pageNow+1}">下一页</a>
								第${newpage.pageNow}/${total}页&nbsp; 
							</div>
						</div>
					<div class="box-content">
						<a href="AddBook.jsp" class="add-button"><span>Add new Article</span></a>
						<div class="cl">&nbsp;</div>
						
						<p><a  onclick="cancalBook()">Delete Selected</a></p>		
					</div>
					</div>
			<div class="cl">&nbsp;</div>			
		</div>
	</div>
</div>
</div>

</div>
			
			
</body>
</html>