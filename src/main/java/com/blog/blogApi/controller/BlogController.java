package com.blog.blogApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blogApi.entites.Blog;
import com.blog.blogApi.service.BlogService;

@RestController
@CrossOrigin()
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@GetMapping("/blogs")
	public ResponseEntity<List<Blog>> getAllBlogs(){
		List<Blog> list=this.blogService.getAllBlogs();
		if(list.size()==0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return new ResponseEntity<List<Blog>>(list,HttpStatus.OK);
		//return this.blogService.getAllBlogs();
	}
	
	@GetMapping("/blog/{id}")
	public ResponseEntity<Blog> getBlogByBlogId(@PathVariable("id")int id) {
		System.out.println("get blog by blog id");
		Blog blog=this.blogService.getBlogById(id);
		if(blog.getId()==-1) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
		}
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	
	@GetMapping("/blogs/autherId={autherId}")
	public ResponseEntity<List<Blog>> getBlogListByAutherId(@PathVariable("autherId") int autherId) {
		
		List<Blog> list=this.blogService.getBlogListByAutherId(autherId);
		if(list.size()==0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return new ResponseEntity<List<Blog>>(list,HttpStatus.OK);
	}
	
	@PostMapping("/blog")
	public ResponseEntity<Boolean> addBlog(@RequestBody Blog  blog) {
		
		Boolean flag = this.blogService.addBlog(blog);
		if(flag==false) {
			return new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
			//return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
		}
		return new ResponseEntity<Boolean>(true,HttpStatus.CREATED);
	}
	
	@PutMapping("/blog")
	public ResponseEntity<Boolean> updateBlog(@RequestBody Blog blog) {
		
		Boolean flag = this.blogService.updateBlog(blog);
		if(flag == false) {
			return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}
	
	@DeleteMapping("/blog/{id}")
	public ResponseEntity<Boolean> deleteBlog(@PathVariable("id")int id) {
		
		Boolean flag = this.blogService.deleteBlog(id);
		if(flag == false) {
			return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true,HttpStatus.NO_CONTENT);
	}

}
