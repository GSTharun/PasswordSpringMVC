package com.ty.password.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.password.dao.Userdao;
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

}
