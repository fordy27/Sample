package com.planner.block.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planner.block.dto.UserDto;
import com.planner.block.repository.UserRepository;
import com.planner.block.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	UserRepository userRepo;
	
	/*
	 * 
	 * */
	
	@Override
	public void addUser(UserDto user) {
		
		userRepo.addUser(user);
	}

	@Override
	public Boolean checkIfUserExists(String username) {
		// TODO Auto-generated method stub
		
		UserDto user = new UserDto();
		
		user = userRepo.searchUser(username);
		
		return user != null;
	}



}
