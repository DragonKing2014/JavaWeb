package com.manager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.dao.CustomerDAO;
import com.model.Customer;

@Service
public class CustomerMng {

	//向数据库插入用户信息的方法
	public void insert(Customer customer) {
		//获取配置文件
        ApplicationContext factory =
        		new ClassPathXmlApplicationContext("com/common/applicationContext.xml");
        //获取UserDAO
        CustomerDAO cDao = (CustomerDAO)factory.getBean("customerDAO");
        cDao.insert(customer);	//执行添加用户方法
        System.out.println("添加新用户成功！");
	}
}
