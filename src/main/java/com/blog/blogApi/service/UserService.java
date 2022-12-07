package com.blog.blogApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.blog.blogApi.dao.UserDao;
import com.blog.blogApi.entites.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userdao;

	public UserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	
	public User getUser(User user) {
		User newUser;
		try {
			newUser=this.getUserdao().getUser(user);
			return newUser;
		} catch (EmptyResultDataAccessException e) {
			return new User(-1,"","","");
		}
	}
	
	public boolean addUser(User user) {
		
		int row=this.getUserdao().addUser(user);
		if(row == 0) {
			return false;
		}
		return true;
	}
	
	public boolean updateUser(User user) {
		
		int row=this.getUserdao().updateUser(user);
		System.out.println("no of row updated : "+row);
		if(row==0) {
			return false;
		}
		return true;
	}
}
