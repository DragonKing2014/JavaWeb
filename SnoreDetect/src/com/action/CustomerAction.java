package com.action;
 
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manager.CustomerMng;
import com.model.Customer;
 
 @Controller
 public class CustomerAction {
 
	 public static CustomerMng CM=new CustomerMng();
	 
     /**
      * 1. 使用RequestMapping注解来映射请求的URL
      * 2. 返回值会通过视图解析器解析为实际的物理视图, 对于InternalResourceViewResolver视图解析器，会做如下解析
      * 通过prefix+returnVal+suffix 这样的方式得到实际的物理视图，然后会转发操作
      * "/index.jsp"
      * @return
      */
     @RequestMapping("/register")
     public String hello(){
         System.out.println("请求被转发到index.jsp注册界面！");
         return "register";
     }
     
     @RequestMapping("/success")
     public String getForm(HttpServletRequest request,
 			ModelMap model) throws UnsupportedEncodingException{
    	 
    	//获取用户注册信息
 		String username = new String(request.getParameter("username").getBytes(
 				"ISO-8859-1"), "GBK");
 		String password = request.getParameter("password");
 		String sex = request.getParameter("sex");
 		String age = request.getParameter("age");
 		String desc = new String(request.getParameter("description").getBytes(
 				"ISO-8859-1"), "GBK");
 		System.out.print("插入数据:"+"\n"+username +"\n"+ password 
 				+"\n"+ sex +"\n"+ age +"\n"+ desc+"\n");
 		
 		//后台验证
		if (username != null && password != null) {
 			//实例化持久化类
 			Customer customer = new Customer();
 			//对consumer属性赋值ֵ
 			customer.setUsername(username);
 			customer.setPassword(password);
 			if (sex != null) {
 				customer.setSex(sex.equals("1") ? true : false);
 			}
 			customer.setAge(Integer.parseInt(age));
 			customer.setDescription(desc);
 			//保存consumer到数据库，调用DAO层的方法		
 			CM.insert(customer);
 			request.setAttribute("info", "恭喜您，注册成功！");
 			}
		
 			//转发请求到注册结果界面
 			return "result";
     }
     
}