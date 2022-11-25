package com.ty.password.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ConfigurationPassword extends AbstractAnnotationConfigDispatcherServletInitializer{
	
		@Override
		protected Class<?>[] getRootConfigClasses() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		protected Class<?>[] getServletConfigClasses() {
			// TODO Auto-generated method stub
			return new Class[]{ConfigPass.class};
		}

		@Override
		protected String[] getServletMappings() {
			// TODO Auto-generated method stub
			return new String[]{"/"};
		}

	}

