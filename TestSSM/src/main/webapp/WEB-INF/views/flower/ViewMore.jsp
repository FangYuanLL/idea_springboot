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
          <article class="row">
		     <div class="col col-md-12">
				 <img src="../images/templatemo_tn_1.jpg" alt="Templatemo Pic 1" class="img-thumbnail img-responsive img_left">
	             <h3>${newflower.name}</h3> 
	             <p>${newflower.price}/束</p>
	              <p>${newflower.number}</p>
				 <p>介绍:${newflower.introduction}</p>
			     <p><a  href="Customer?id=${newflower.id}" class="btn btn-primary" role="button">Purchase</a></p>
			 </div>								            
		  </article>
</body>
</html>