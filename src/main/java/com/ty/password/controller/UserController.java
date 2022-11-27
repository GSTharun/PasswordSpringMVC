package com.ty.password.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ty.password.dto.ApplicationDto;
import com.ty.password.dto.User;
import com.ty.password.service.UserService;


@Controller
public class UserController {
	@Autowired
	UserService service;
	
	@RequestMapping("login")
	public ModelAndView login(User user) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("login.jsp");
		return modelAndView;
	}
	
	@RequestMapping("signup")
	public ModelAndView signup() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("signup.jsp");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
	
	@RequestMapping("saveuser")
	public ModelAndView saveUser(@ModelAttribute User user) {
		service.saveUser(user);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("login.jsp");
		System.out.println(user);
		return modelAndView;

	}
	
	@RequestMapping("loginuser")
	public ModelAndView loginUser(User user, ApplicationDto application)
	{
		ModelAndView modelAndView = new ModelAndView();
		User user2=service.saveUserByEmail(user);
		modelAndView.addObject("user", new User());
		if(user2!=null)
		{
			modelAndView.addObject("application", new ApplicationDto());
			modelAndView.setViewName("application.jsp");
			
		}
		else{
			modelAndView.setViewName("login.jsp");
		}
		return modelAndView;
	}
	
	@RequestMapping("saveapplication")
	public ModelAndView loginUser(ApplicationDto application)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("application.jsp");
		service.saveApplication(application);
		modelAndView.addObject("application", new ApplicationDto());
		return modelAndView;
		
	}

	@RequestMapping("applicationlogin")
	public ModelAndView applicationLogin(User user, ApplicationDto application)
	{
		ModelAndView modelAndView = new ModelAndView();
		User user3=service.saveUserByEmail(user);
		modelAndView.addObject("user", new User());
		if(user3!=null)
		{
			modelAndView.addObject("application", new ApplicationDto());
			modelAndView.setViewName("applicationlogin.jsp");
		}
		else{
			modelAndView.setViewName("login.jsp");
		}
		return modelAndView;
	}
	


}
