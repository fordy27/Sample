package com.planner.block.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.planner.block.dto.UserDto;


//THIS IS THE MAP OF THE TABLE USER
public class UserMapper implements RowMapper<UserDto> {

	@Override
	public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		UserDto user = new UserDto();
		
		user.setUser_id(rs.getInt("user_id"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setConfirmPassword(rs.getString("confirm_password"));
		user.setDateCreated(rs.getDate("date_created"));
		user.setDateUpdated(rs.getDate("date_updated"));
		user.setDateDeleted(rs.getDate("date_deleted"));	
		
		return user;
	}
	
	

}
