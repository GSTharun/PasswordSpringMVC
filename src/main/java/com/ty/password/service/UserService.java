package com.ty.password.service;

import java.util.List;

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
	
	public ApplicationDto saveApplicationByEmail(ApplicationDto application)
	{
		ApplicationDto receivedApplication = userdao.getApplicationByEmail(application.getEmail());
		if (application.getPassword().equals(receivedApplication.getPassword())) {
			return receivedApplication;
		}
		return null;
	}
	
	public ApplicationDto getByEmail(ApplicationDto application)
	{
		return userdao.getApplicationByEmail(application.getEmail());
	}
	
	public List<ApplicationDto> getListofApplication(int id)
	{
		return userdao.getAllApplication(id);
	}
	
	public User FindById(int id)
	{
		return userdao.findUserByID(id);
	}

	public void updateUser(User user)
	{
		userdao.updateUser(user);
	}
	
	public void deleteUser(int id)
	{
		userdao.deleteUserById(id);
	}
}
