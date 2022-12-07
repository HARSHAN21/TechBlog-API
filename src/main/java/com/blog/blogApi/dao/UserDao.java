package com.blog.blogApi.dao;

import com.blog.blogApi.entites.User;

public interface UserDao {
	
	public User getUser(User user);
	
	public int addUser(User user);
	
	public int updateUser(User user);

}
