package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.model.Customer;;

//DAO层，提供访问数据库的方法
//此DAO层和model层的耦合：仅有DAO层的方法使用model类型的参数
public class CustomerDAO {
	private SessionFactory sessionFactory; //定义SessionFactory属性

	//向数据库插入用户信息的方法
	public void insert(Customer customer) {
		System.out.println("insert方法即将执行");
		this.getSession().save(customer);
		System.out.println("insert方法执行结束");
	}

	/**
	 * 获取session对象
	 */
	protected Session getSession() {
		return sessionFactory.openSession();
	}
	
	//getter和setter方法
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
