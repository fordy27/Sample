package com.planner.block.service;

import com.planner.block.dto.UserDto;

public interface UserService {
	
	void addUser(UserDto user);
	Boolean checkIfUserExists(String Username);
}
