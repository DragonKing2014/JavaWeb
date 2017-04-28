<%@ page language="java" contentType="text/html" pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户注册</title>
    <style type="text/css">
    	body{
    		margin: 0px;
    		color:#000000;
    	}
    	.box1{
    		width: 150px;
    		height: 20px;
    		
    	}
		.div1{
			background-image: url("images/2.jpg");
			width: 843px;
			height: 568px;
			padding-top: 90px;
			background-size:843px 568px;
			background-repeat:no-repeat;
			
		}
	</style>
    <script type="text/javascript">
		function save(){
			var username = document.getElementById("username");
			if(username.value == ""){
				alert("用户名不能为空！");
				return false;
			}
			var password = document.getElementById("password");
			if(password.value == ""){
				alert("密码不能为空！");
				return false;
			}
			var repassword = document.getElementById("repassword");
			if(repassword.value == ""){
				alert("确认密码不能为空！");
				return false;
			}
			if(password.value != repassword.value){
				alert("两次输入密码不一致！");
				return false;
			}
			var age = document.getElementById("age");
			if(age.value == ""){
				alert("年龄不能为空！");
				return false;
			}
			if(isNaN(age.value)){
				alert("年龄为数字！");
				return false;
			}
		}
	</script>
  </head>
  
  <body>
  <div align="center">
  <div class="div1">
  <form action="success" method="post" onsubmit="return save();">
    <table align="center" border="0" cellpadding="3" cellspacing="1" width="500">
    	<h1>用户注册</h1>
    	<br><br><br><br>
    	<tr>
			<td align="right">用户名：</td>
			<td><input id="username" name="username" type="text" class="box1"></td>
		</tr>
		<tr>
			<td align="right">密码：</td>
			<td><input id="password" name="password" type="password" class="box1"></td>
		</tr>
		<tr>
			<td align="right">确认密码：</td>
			<td><input id="repassword" name="repassword" type="password" class="box1"></td>
		</tr>
		<tr>
			<td align="right">年龄：</td>
			<td><input id="age" name="age" type="text" class="box1"></td>
		</tr>
		<tr>
			<td align="right">性别：</td>
			<td>
				<input name="sex" type="radio" value="1" checked="checked">男
				<input name="sex" type="radio" value="0">女
			</td>
		</tr>
		<tr>
			<td align="right">描述：</td>
			<td><textarea name="description" cols="30" rows="5"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center" height="50">
				<input type="submit" value="注 册">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="重 置">
			</td>
		</tr>
    </table>
    </form>
    </div>
    </div>
  </body>
</html>
