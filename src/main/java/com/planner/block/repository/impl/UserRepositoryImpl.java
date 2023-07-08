package com.planner.block.repository.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;


import com.planner.block.dto.UserDto;
import com.planner.block.mapper.UserMapper;
import com.planner.block.repository.UserRepository;

@Repository
public class UserRepositoryImpl  extends BaseRepositoryImpl implements UserRepository{
	

	@Override
	public void addUser(UserDto user) {
				
		StringBuilder sql = new StringBuilder();

		sql.append("INSERT INTO student.users ")
		    .append("(username, password, confirm_password, date_created, date_updated, date_deleted) ")
		    .append("VALUES (?, ?, ?, date_format(NOW(), '%Y/%c/%e %T'), date_format(NOW(), '%Y/%c/%e %T'), NULL)");

	
		getJdbcTemplate().update(sql.toString(),
				user.getUsername(),
				user.getPassword(),
				user.getConfirmPassword());
	
	}

	@Override
	public UserDto searchUser(String username) {

		String sql = "SELECT * FROM student.users WHERE username = ?";
		try {
		    return getJdbcTemplate().queryForObject(sql, new Object[]{username}, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
		    return null; // Return null or any other value to indicate no matching rows
		}
		
	}
}