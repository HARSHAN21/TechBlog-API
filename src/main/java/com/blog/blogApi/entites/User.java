package com.blog.blogApi.entites;

public class User {
	
	private int id;
	private String emailid;
	private String password;
	private String name;

	public User(int id, String emailid, String password, String name) {
		this.id = id;
		this.emailid = emailid;
		this.password = password;
		this.name=name;
	}
	
	public User() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", emailid=" + emailid + ", password=" + password + " name= " + name + "]";
	}

}
