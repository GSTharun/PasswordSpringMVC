package com.ty.password.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ty.password.dto.User;

@Controller
public class UserController {
	
	@RequestMapping("login")
	public ModelAndView login() {
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


}
