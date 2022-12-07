package com.blog.blogApi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blogApi.entites.User;
import com.blog.blogApi.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/login/{emailid}/{password}")
	public ResponseEntity<User> login(@PathVariable Map<String,String>pathVars) {
		User user=new User();
		user.setEmailid(pathVars.get("emailid"));
		user.setPassword(pathVars.get("password"));
		User newUser=userService.getUser(user);
		if( newUser.getEmailid().equals(user.getEmailid()) && newUser.getPassword().equals(user.getPassword()) ) {
			return new ResponseEntity<User>(newUser,HttpStatus.OK);
		}
		return new ResponseEntity<User>(newUser,HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Boolean> registerUser(@RequestBody User user){
		
		boolean flag=userService.addUser(user);
		if(flag==false) {
			return new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Boolean>(true,HttpStatus.CREATED);
	}
	
	@PutMapping("/user")
	public ResponseEntity<Boolean> updateBlog(@RequestBody User user){
		
		boolean flag=userService.updateUser(user);
		if(flag==false) {
			return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}

}
