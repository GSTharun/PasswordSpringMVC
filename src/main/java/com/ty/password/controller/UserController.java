package com.ty.password.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.password.dto.ApplicationDto;
import com.ty.password.dto.User;
import com.ty.password.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("login")
	public ModelAndView login(User user)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login.jsp");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
	
	@RequestMapping("signup")
	public ModelAndView signup(User user)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("signup.jsp");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
	
	@RequestMapping("saveuser")
	public ModelAndView saveUser(User user)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login.jsp");
		userService.saveUser(user);
		modelAndView.addObject("user", new User());
		return modelAndView;
		
	}
	User user2;
	@RequestMapping("loginuser")
	public ModelAndView loginUser(@ModelAttribute User user, ApplicationDto application)
	{
		ModelAndView modelAndView = new ModelAndView();
		user2=userService.saveUserByEmail(user);
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
	public ModelAndView loginUser(ApplicationDto application,User user)
	{
		application.setUser(user2);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("application.jsp");
		userService.saveApplication(application);
		modelAndView.addObject("application", new ApplicationDto());
		return modelAndView;
		
	}
	
	@RequestMapping("applogin")
	public ModelAndView appBack(ApplicationDto application)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loginapp.jsp");
		modelAndView.addObject("application", new ApplicationDto());
		return modelAndView;
	}
	
	ApplicationDto application1;
	@RequestMapping("loginapp")
	public ModelAndView loginApplication(@ModelAttribute ApplicationDto application)
	{
		ModelAndView modelAndView = new ModelAndView();
		 application1 = userService.getByEmail(application);
		User user=application1.getUser();
		modelAndView.addObject("user", user);
		if(application1.getPassword().equals(application.getPassword()))
		{
			modelAndView.setViewName("view.jsp");
			return modelAndView;
		}
		else{
			modelAndView.setViewName("loginapp.jsp");
			return modelAndView;
		}	
	
	}
	
	@RequestMapping("view")
	public ModelAndView getUser()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", application1.getId());
		modelAndView.setViewName("abc.jsp");
		return modelAndView;
		
	}
	
	@RequestMapping("edit")
	public ModelAndView editStudent(@RequestParam int id)
	{
		User user=userService.FindById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("edit.jsp");
		return modelAndView;
	}
	
	@RequestMapping("updateuser")
	public void updateStudent(@ModelAttribute User user,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		userService.updateUser(user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("loginapp");
		dispatcher.forward(request, response);
	}
	
	@RequestMapping("delete")
	public void deleteStudent(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		userService.deleteUser(Integer.parseInt(request.getParameter("id")));
		RequestDispatcher dispatcher= request.getRequestDispatcher("loginapp");
		dispatcher.forward(request, response);
	}
	
	
	
	
	
}