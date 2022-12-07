package com.blog.blogApi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.blog.blogApi.entites.User;

@Component
public class UserDaoImpl implements UserDao {
	
	private static String tableName="blogUser";
	
	private static String getUserQuery="select * from "+tableName+" where emailid=? and password=?";
	private static String addUserQuery="insert into "+tableName+" ( emailid, password,name) values(?,?,?)";
	private static String updateUserQuery="update "+tableName+" set password=? where id=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public User getUser(User user) {
		User newUser=this.getJdbcTemplate().queryForObject(getUserQuery, new UserRowMapperImple(),user.getEmailid(),user.getPassword());
		return newUser;
	}

	@Override
	public int addUser(User user) {
		int row = this.getJdbcTemplate().update(addUserQuery, user.getEmailid(), user.getPassword(), user.getName());
		return row;
	}

	@Override
	public int updateUser(User user) {
		int row = this.getJdbcTemplate().update(updateUserQuery, user.getPassword() ,user.getId());
		return row;
	}

}

class UserRowMapperImple implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user=new User();
		user.setId(rs.getInt(1));
		user.setEmailid(rs.getString(2));
		user.setPassword(rs.getString(3));
		user.setName(rs.getString(4));
		
		return user;
	}
	
}

