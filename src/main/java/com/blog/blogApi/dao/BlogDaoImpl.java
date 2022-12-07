package com.blog.blogApi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.blog.blogApi.entites.Blog;

@Component
public class BlogDaoImpl implements BlogDao {
	
	//@Value("${sql.tableName}")
	private static String tableName="blog";
	
	private static String getAllBlogQuery="select * from "+tableName;
	private static String getBlogByIdQuery="select * from "+tableName+" where id=?";
	private static String getBlogByAutherIdQuery="select * from "+tableName+" where autherId=?";
	private static String addBlogQuery="insert into "+tableName+" ( content, autherId, shortIntro, timeToRead, heading, isPublic, autherName) values(?,?,?,?,?,?,?)";
	private static String updateBlogQuery="update "+tableName+" set heading=?, content=?, shortIntro=?, timeToRead=?, isPublic=? where id=?";
	private static String deleteBlogQuery="delete from "+tableName+" where id=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Blog> getAllBlogs() {
		//String query="select * from blog";
		List<Blog> list = this.getJdbcTemplate().query(getAllBlogQuery, new RowMapperImple());
		return list;
	}

	@Override
	public Blog getBlogById(int id) {
		//String query="select * from blog where id=?";
		Blog blog=this.getJdbcTemplate().queryForObject(getBlogByIdQuery, new RowMapperImple(), id);
		return blog;
	}
	
	@Override
	public List<Blog>getBlogListByAutherId(int autherId){
		List<Blog> list = this.getJdbcTemplate().query(getBlogByAutherIdQuery, new RowMapperImple(),autherId);
		return list;
	}

	@Override
	public int addBlog(Blog blog) {
		//String query="insert into blog values(?,?,?,?,?)";
		int row = this.getJdbcTemplate().update(addBlogQuery ,blog.getContent(), blog.getAuthorId(), 
				blog.getShortIntro(), blog.getTimeToRead(), blog.getHeading(), blog.getIsPublic(), blog.getAutherName());
		return row;
	}

	@Override
	public int updateBlog(Blog blog) {
		
		//String query="update blog set content=?, author=?, shortIntro=?, timeToRead=? where id=?";
		int row = this.getJdbcTemplate().update(updateBlogQuery,blog.getHeading(), blog.getContent(), 
				blog.getShortIntro(), blog.getTimeToRead(), blog.getIsPublic(), blog.getId());
		return row;
	}

	@Override
	public int deleteBlog(int id) {
		//String query="delete from blog where id=?";
		int row = this.getJdbcTemplate().update(deleteBlogQuery, id);
		return row;
	}

}

class RowMapperImple implements RowMapper<Blog> {

	@Override
	public Blog mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Blog blog = new Blog();
		blog.setId(rs.getInt(1));
		blog.setTimeToRead(rs.getInt(2));
		blog.setContent(rs.getString(3));
		blog.setShortIntro(rs.getString(4));
		blog.setHeading(rs.getString(5));
		blog.setAuthorId(rs.getInt(6));
		blog.setPublic(rs.getBoolean(7));
		blog.setAutherName(rs.getString(8));
		
		return blog;
	}
	
}
