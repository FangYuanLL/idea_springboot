<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" type="text/css" href="./css/fallback.css" />
 <link rel="stylesheet" type="text/css" href="./css/style.css" />
 <script type="text/javascript" src="./js/jquery-1.7.1.min.js"></script>
  <script type="text/javascript" src="./js/selectivizr.js"></script>
<title>Insert title here</title>
</head>
<body>
		<div id="container">
			<form action="LoginServlet">
				<div class="login">LOGIN</div>
				<div class="username-text">Username:</div>
				<div class="password-text">Password:</div>
				<div class="username-field">
					<input type="text" name="username"  />
				</div>
				<div class="password-field">
					<input type="password" name="password"  />
				</div>
				<input type="checkbox" name="remember-me" id="remember-me" /><label for="remember-me">Remember me</label>
				<div class="forgot-usr-pwd">Goto <a href="register.jsp">Register</a> </div>
				<input type="submit"  value="GO" />
			</form>
		</div>
	</body>
</html>