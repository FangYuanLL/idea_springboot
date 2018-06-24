<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style>
        fieldset{
            background-color: #f1f1f1;
            border: none;
            border-radius: 2px;
            margin-bottom: 12px;
            overflow: hidden;
            padding: 0 .625em;
        }

        label{
            cursor: pointer;
            display: inline-block;
            padding: 3px 6px;
            text-align: right;
            width: 150px;
            vertical-align: top;
        }

        input{
            font-size: inherit;
        }
    </style>
</head>
<body >
	<div align="left">
		<form action="AddServlet" >
			<fieldset>
		        <p>
		            <label for="ID" >ID:</label>
		            <input type="text" id="ID" name="id" align="left">
		        </p>
		        <p>
		            <label for="name">Name:</label>
		            <input type="text" id="name" name="name" align="left">
		        </p>
		        <p>
		            <label for="price">Price:</label>
		            <input id="price" name="price" align="left">
		        </p>
		        <p>
		            <label for="publishTime">PublishTime:</label>
		            <input type="text"id="publishTime" name="publishTime" align="left">
		        </p>
		        <p>
		            <label for="author">Author:</label>
		            <input type="text" id="author" name="author" align="left">
		        </p>
		        <p>
		            <input type="submit" value="提交">
		        </p>
	        </fieldset>
		</form>
	</div>
</body>
</html>