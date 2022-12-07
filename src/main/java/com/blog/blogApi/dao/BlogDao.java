package com.blog.blogApi.dao;

import java.util.List;

import com.blog.blogApi.entites.Blog;

public interface BlogDao {
	
	public List<Blog> getAllBlogs();
	
	public Blog getBlogById(int id);
	
	public List<Blog>getBlogListByAutherId(int autherId);
	
	public int addBlog(Blog blog);
	
	public int updateBlog(Blog blog);
	
	public int deleteBlog(int id);

}
