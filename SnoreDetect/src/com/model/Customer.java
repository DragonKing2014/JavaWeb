package com.model;

//模型层model，同时是一个持久化类
//最容易写的层，只需要注意和数据库表中数据的对应关系即可
//同时要注意，这一层有一个hibernate的O/R mapping
public class Customer {
	private Integer id;
	private String username; 
	private String password;
	private Integer age; 
	private boolean sex; 
	private String description; 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
