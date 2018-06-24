<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Java后端WebSocket的Tomcat实现</title>
</head>
<body> 
    <div id=div style='display:block;'>
    <button onclick="connection()">WebSocket连接</button>
    </div>
    <div id=div1 style='display:none;'>
    Welcome<br/><input id="text" type="text"/>
    <button  onclick="send()">发送消息</button>
    <button id="btn2" onclick="closeWebSocket()">关闭WebSocket连接</button><br/>
    <a href="CheckSession">
        <input type=button value="下线">
    </a>
    <c:forEach items="${list}" var="User">
    <p>${User.username}</p>
    </c:forEach>
    </div>
    <div id="message"></div>
         
</body>

<script type="text/javascript">
    var websocket = null;
    var URL="ws://localhost:8080/WebSocket/websocket";
    
    function connection(){
		//判断当前浏览器是否支持WebSocket
	    if ('WebSocket' in window) {
	        websocket = new WebSocket(URL);
	    }
	    else {
	         alert('当前浏览器 Not support websocket')
	    }
	    //连接成功建立的回调方法
	    websocket.onopen = function () {
	       setMessageInnerHTML("WebSocket连接成功");
	    }
	    
	    //连接发生错误的回调方法
	    websocket.onerror = function () {
	        setMessageInnerHTML("WebSocket连接发生错误");
	    };
	    
	    
	
	    //接收到消息的回调方法,接受后台的消息
	    websocket.onmessage = function (event) {
	    	if(event.data==1){location.reload();}
	    	else{
	        setMessageInnerHTML(event.data);
	    	}
	    }
	
	    //连接关闭的回调方法
	    websocket.onclose = function () {
	        setMessageInnerHTML("WebSocket连接关闭");
	    }
	
	    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
	    window.onbeforeunload = function () {
	        closeWebSocket();
	    }
	    document.getElementById('div').style.display='none';
	    document.getElementById('div1').style.display='block';
    }
    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
        document.getElementById('message').innerHTML += innerHTML + '<br/>';
    }

    //关闭WebSocket连接
    function closeWebSocket() {
        websocket.close(); 
        document.getElementById('div').style.display='block';
	    document.getElementById('div1').style.display='none';
    }

    //发送消息
    function send() {
        var message = document.getElementById('text').value;
        websocket.send(message);
    }
</script>
</html>
