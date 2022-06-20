package com.ezen.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 로그아웃
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("login");
		
		return modelView;
		
	}

}
