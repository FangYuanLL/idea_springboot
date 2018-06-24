<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
<meta name="viewport" content="width=device-width" />
<title>Botany Template</title>
<meta name="keywords" content="botany, responsive, bootstrap, free template, fluid layout, templatemo, html css" />
<meta name="description" content="Botany Template is free responsive template with a fluid background image." />
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="../css/templatemo_style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="../css/flexslider.css" type="text/css" media="screen" />
</head>
<body>
<body class="templatemo_juice_bg">
	<div id="main_container">
		<div class="container" id="home">
			<div class="row col-wrap">			 
				<div id="left_container" class="col col-md-3 col-sm-12">
                	<div class="templatemo_logo">
						<a  href="http://www.cssmoban.com/"><img src="../images/templatemo_logo.png" alt="Botany Theme"></a>
					</div>
					<nav id="main_nav">
						<ul class="nav">
							<li class="active"><a href="ListAllFlower">Home</a></li>
							<li><a href="Login">Login</a></li>
							<li><a href="Register">Register</a></li>
							<li><a href="AdministratorLogin">Administrator</a></li>
							<li><a href="Bill">Trolley</a></li>
						</ul>
					</nav> <!-- nav -->	
					<form  action="Find" method="get" class="navbar-form" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search" id="name" name="name">
						</div>
						<button type="submit" class="btn btn-primary" name="Search">Go</button>
					</form>
					<div>
						<a  href="http://www.facebook.com/templatemo"><img src="../images/facebook.png" alt="Like us on Facebook"></a>
						<a href="#"><img src="../images/twitter.png" alt="Follow us on Twitter"></a>
						<a href="#"><img src="../images/rss.png" alt="RSS feeds"></a>
					</div>
				</div>
				<div id="right_container" class="col col-md-9 col-sm-12">
                
					<div class="row">
                    	<div class="col col-md-12">
                        
                    		<h2>Welcome <a href="#" title="Hdstockphoto from cn.hdstockphoto.com" class="right_container_title"  target="_blank">to</a> Botany</h2> 

                            <div class="flexslider">
                              <ul class="slides">
                                <li><img src="../images/templatemo_slide_1.jpg" alt="slide 1" /></li>
                                <li><img src="../images/templatemo_slide_2.jpg" alt="slide 2" /></li>
                                <li><img src="../images/templatemo_slide_3.jpg" alt="slide 3" /></li>
                              </ul>
                            </div>
                            
        				</div>
                    </div>
					<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >Website Template</a></div>
					 <c:forEach items="${list}" var="flower">
                    <article class="row">
						<div class="col col-md-12">
							<img src="../images/templatemo_tn_1.jpg" alt="Templatemo Pic 1" class="img-thumbnail img-responsive img_left">
                            <h3>${flower.name}</h3> 
                            <p>${flower.price}/束</p>
							<p>介绍:${flower.introduction}</p>
							<p><a  href="ViewMore?id=${flower.id}" class="btn btn-primary" role="button">View More</a></p>
						</div>								            
					</article>
					</c:forEach>       
				</div>
			</div>
			<footer class="row credit">
				<div class="col col-md-12">
					<div id="templatemo_footer">
					</div>
				</div>
			</footer>
		</div>		
	</div>
    
  <!-- jQuery -->
 <!--  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
  <script>window.jQuery || document.write('<script src="js/libs/jquery-1.7.min.js">\x3C/script>')</script>

  FlexSlider -->
  <script defer src="../slider/jquery.flexslider.js"></script>

  <script type="text/javascript">
    $(function(){
      SyntaxHighlighter.all();
    });
    $(window).load(function(){
      $('.flexslider').flexslider({
        animation: "slide",
        start: function(slider){
          $('body').removeClass('loading');
        }
      });
    });
  </script>
  
</body>
<script type='text/javascript' src='../js/logging.js'></script>
</html>