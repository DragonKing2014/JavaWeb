package com.action;


//控制层(传统方法，已弃用)
//和视图层耦合相对比较多，和DAO层的关系则只是调用DAO层类中的一个(或多个)方法，
//进行数据传送操作
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.CustomerDAO;
import com.manager.CustomerMng;
import com.model.Customer;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	
	public static CustomerMng CM=new CustomerMng();
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

	
	//测试使用的main方法
//	public static void main(String[] args) {
//	
//		Customer c=new Customer();
//		c.setUsername("赵");
//		c.setPassword("56788");
//		c.setAge(41);
//		c.setSex(true);
//		c.setDescription("长坂坡七进七出");
//		
//		CM.insert(c);
//		
//	}
}
