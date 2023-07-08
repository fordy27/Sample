package com.planner.block.repository;

import com.planner.block.dto.UserDto;

public interface UserRepository {
	
	void addUser(UserDto user);
	UserDto searchUser(String username);
}

