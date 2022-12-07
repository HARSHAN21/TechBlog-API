package com.blog.blogApi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.blog.blogApi.dao.BlogDaoImpl;
import com.blog.blogApi.entites.Blog;

@Service
public class BlogService {
	
	@Autowired
	private BlogDaoImpl blogDaoImpl;
	
	public BlogDaoImpl getBlogDaoImpl() {
		return blogDaoImpl;
	}

	public void setBlogDaoImpl(BlogDaoImpl blogDaoImpl) {
		this.blogDaoImpl = blogDaoImpl;
	}

	public List<Blog> getAllBlogs(){
		
		return this.getBlogDaoImpl().getAllBlogs();
	}
	
	public Blog getBlogById(int id) {
		
		Blog blog=new Blog();
		try {
			blog=this.getBlogDaoImpl().getBlogById(id);
			return blog;
		} catch (EmptyResultDataAccessException e) {
			blog.setId(-1);
			return blog;
		}
		
	}
	
	public List<Blog>getBlogListByAutherId(int autherId){
		
		List<Blog> blogsByAutherId=new ArrayList<Blog>();
		
		try {
			blogsByAutherId=this.getBlogDaoImpl().getBlogListByAutherId(autherId);
			return blogsByAutherId;
		} catch (EmptyResultDataAccessException e) {
			return blogsByAutherId;
		}
		
	}
	
	public Boolean addBlog(Blog blog) {
		
		int row=this.getBlogDaoImpl().addBlog(blog);
		System.out.println("no of row inserted : "+row);
		if(row==0) {
			return false;
		}
		return true;
	}
	
	public Boolean updateBlog(Blog blog) {
		
		int row=this.getBlogDaoImpl().updateBlog(blog);
		System.out.println("no of row updated : "+row);
		if(row==0) {
			return false;
		}
		return true;
	}
	
	public Boolean deleteBlog(int id) {
		
		int row=this.getBlogDaoImpl().deleteBlog(id);
		System.out.println("no of row deleted : "+row);
		if(row==0) {
			return false;
		}
		return true;
	}

}
