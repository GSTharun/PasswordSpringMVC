package com.ty.password.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ty.password.dao.Userdao;
import com.ty.password.dto.ApplicationDto;
import com.ty.password.dto.User;

@Service
public class UserService {
	
	@Autowired
	Userdao userdao;
	
	
	public User saveUser(User user)
	{
		userdao.saveUser(user);
		return user;
	}
	
	public User saveUserByEmail(User user)
	{
		User receivedUser=userdao.getUserByEmail(user.getEmail());
		if(user.getPassword().equals(receivedUser.getPassword())) {
			return receivedUser;
		}
		return null;
	}
	
	public ApplicationDto saveApplication(ApplicationDto applicationDto) {
		userdao.saveApplication(applicationDto);
		return applicationDto;
	}

}
