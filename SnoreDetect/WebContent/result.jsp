<%@ page language="java" contentType="text/html" pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>结果信息</title>
   <style type="text/css">
  	 body{
    		margin: 0px;
    	}
   	.div1{
			background-image: url("images/2.jpg");
			width: 843px;
			height: 568px;
			padding-top: 190px;
			background-size:843px 568px;
			background-repeat:no-repeat;
			color:black;
		}
   </style>
  </head>
  
  <body>
    <div align="center">
    	<div class="div1">
	    	<font color="red" size="12px;" style="font-weight: bold;">
	    		${info}
	    	</font>
	    	<br><br><br><br>
	    	<a href="register.jsp">返回</a>
    	</div>
    </div>
  </body>
</html>
